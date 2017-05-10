import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DbDao {
	/**
	 * 登録
	 */
	public static void insertSignUp(HttpServletRequest req, HttpServletResponse res) throws SQLException {
		//セッションで値を渡す
	   	HttpSession session = req.getSession();
		String name = (String) session.getAttribute("SIGNUP_NAME");
		String furigana = (String) session.getAttribute("SIGNUP_FURIGANA");
		String mailaddress = (String) session.getAttribute("SIGNUP_MAIL");
		String password = (String) session.getAttribute("SIGNUP_PASS");
		int department = Integer.parseInt((String) session.getAttribute("SIGNUP_DEPARTMENT"));

		System.out.println(name);
		System.out.println(furigana);
		System.out.println(mailaddress);
		System.out.println(password);
		System.out.println(department);

		// JDBCの読み込み
		Connection con = DbUtil.connectDB();
		// SQLの生成
		String sql =
		"insert into employee(nm_employee, kn_employee, mail_address, password, id_department)values(?,?,?,?,?)";
		// Statementの生成
		PreparedStatement stmt = con.prepareStatement(sql);

		// パラメータ指定
		stmt.setString(1, name);
		stmt.setString(2, furigana);
		stmt.setString(3, mailaddress);
		stmt.setString(4, password);
		stmt.setInt(5, department);

		// SQLの実行
		int rs = stmt.executeUpdate();

		// Statement、Connectionの切断
		DbUtil.closeDB(stmt, con);
	}


	/**
	 * 登録者検索
	 */
	public static void searchEmployee(HttpServletRequest req, HttpServletResponse res) throws SQLException {
		//セッションで値を渡す
	   	HttpSession session = req.getSession();
		String search_name = (String) session.getAttribute("SEARCH_NAME");

		System.out.println(search_name);

		// JDBCの読み込み
		Connection con = DbUtil.connectDB();
		// SQLの生成
		String sql = "SELECT * FROM employee WHERE nm_employee like ?";
		// Statementの生成
		PreparedStatement stmt = con.prepareStatement(sql);
		//パラメータの作成
		stmt.setString(1, "%" + search_name + "%");
		// SQLの実行
		ResultSet rs = stmt.executeQuery();

		// 実行結果の取得と表示
		while (rs.next()) {
		    // 値の取得
			EmployeeDto emp = new EmployeeDto();
			emp.setId(rs.getInt("id_employee"));
			emp.setName(rs.getString("nm_employee"));
			emp.setKana(rs.getString("kn_employee"));
			emp.setEmail(rs.getString("mail_address"));
			emp.setPass(rs.getString("password"));
			emp.setId(rs.getInt("id_department"));

	    	HttpSession session2 = req.getSession();
	    	session2.setAttribute("SIGNUP_ID", rs.getInt("id_employee"));
	    	session2.setAttribute("SIGNUP_NAME", rs.getString("nm_employee"));
	    	session2.setAttribute("SIGNUP_FURIGANA", rs.getString("kn_employee"));
	    	session2.setAttribute("SIGNUP_MAIL", rs.getString("mail_address"));
	    	session2.setAttribute("SIGNUP_PASS", rs.getString("password"));
	    	session2.setAttribute("SIGNUP_DEPARTMENT", rs.getString("id_department"));

		    // 値の表示
		    System.out.println(emp.getId() + "\t" + emp.getName() + "\t" + emp.getKana() + "\t"
			+ emp.getEmail() + "\t" + emp.getPass() + "\t" + emp.getIdDep());
		}

		// Statement、Connectionの切断
		DbUtil.closeDB(stmt, con);
	}
}
