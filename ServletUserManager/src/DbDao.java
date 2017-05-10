import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DbDao {
	public static void main(String[] args) {
	}
	/**
	 * ログイン
	 */
	public static void readLogin(HttpServletRequest req, HttpServletResponse res) throws SQLException {
		// JDBCの読み込み
		Connection con = DbUtil.connectDB();
		// SQLの生成
		String sql = "SELECT * FROM employee WHERE mail_address = ? AND password = ?";
		// Statementの生成
		PreparedStatement stmt = con.prepareStatement(sql);

		//セッションで値を渡す
	   	HttpSession session = req.getSession();
		String mailaddress = (String) session.getAttribute("LOGIN_MAIL");
		String password = (String) session.getAttribute("LOGIN_PASS");
		System.out.println(mailaddress);
		System.out.println(password);

		//パラメータの作成
		stmt.setString(1, mailaddress);
		stmt.setString(2, password);
		// SQLの実行
		ResultSet rs = stmt.executeQuery();

		//名前をset

		while (rs.next()) {
			EmployeeDto emp = new EmployeeDto();
			emp.setName(rs.getString("nm_employee"));
			System.out.println(emp.getName());

			session.setAttribute("LOGIN_NAME",rs.getString("nm_employee"));
		}

		// Statement、Connectionの切断
		DbUtil.closeDB(stmt, con);
	}


	/**
	 * 登録
	 */
	public static void create(HttpServletRequest req, HttpServletResponse res) throws SQLException {
		//セッションで値を渡す
	   	HttpSession session = req.getSession();
		String name = (String) session.getAttribute("SIGNUP_NAME");
		String furigana = (String) session.getAttribute("SIGNUP_FURIGANA");
		String mailaddress = (String) session.getAttribute("SIGNUP_MAIL");
		String password = (String) session.getAttribute("SIGNUP_PASS");
		int department = Integer.parseInt((String)session.getAttribute("SIGNUP_DEPARTMENT"));

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
	 * 更新
	 */
	public static void update(HttpServletRequest req, HttpServletResponse res) throws SQLException {
		//セッションで値を渡す
	   	HttpSession session = req.getSession();
	   	int id = Integer.parseInt((String)session.getAttribute("UPDATE_ID"));
		String name = (String) session.getAttribute("UPDATE_NAME");
		String furigana = (String) session.getAttribute("UPDATE_FURIGANA");
		String mailaddress = (String) session.getAttribute("UPDATE_MAIL");
		String password = (String) session.getAttribute("UPDATE_PASS");
		int department_id = Integer.parseInt((String)session.getAttribute("UPDATE_DEPARTMENT"));

		System.out.println(name);
		System.out.println(furigana);
		System.out.println(mailaddress);
		System.out.println(password);
		System.out.println(department_id);

		// JDBCの読み込み
		Connection con = DbUtil.connectDB();
		// SQLの生成
		String sql =
		"update employee set nm_employee = ?, kn_employee = ?,mail_address = ?,password = ?,id_department = ? where id_employee = ?";
		// Statementの生成
		PreparedStatement stmt = con.prepareStatement(sql);

		// パラメータ指定
		stmt.setString(1, name);
		stmt.setString(2, furigana);
		stmt.setString(3, mailaddress);
		stmt.setString(4, password);
		stmt.setInt(5, department_id);
		stmt.setInt(6, id);

		// SQLの実行
		int rs = stmt.executeUpdate();

		// Statement、Connectionの切断
		DbUtil.closeDB(stmt, con);
	}


	/**
	 * 削除
	 */
	public static void delete(HttpServletRequest req, HttpServletResponse res) throws SQLException {
		//セッションで値を渡す
	   	HttpSession session = req.getSession();
		int id = Integer.parseInt((String)session.getAttribute("DELETE_ID"));

		System.out.println(id);

		// JDBCの読み込み
		Connection con = DbUtil.connectDB();
		// SQLの生成
		String sql = "delete from employee where id_employee = ?";
		// Statementの生成
		PreparedStatement stmt = con.prepareStatement(sql);

		// パラメータ指定
		stmt.setInt(1, id);

		// SQLの実行
		int rs = stmt.executeUpdate();

		// Statement、Connectionの切断
		DbUtil.closeDB(stmt, con);
	}

	/**
	 * 検索
	 */
	public static void select(HttpServletRequest req, HttpServletResponse res) throws SQLException {
		//セッションで値を渡す

		int id = 0;
		String name = null;
		String furigana = null;
		String mailaddress = null;
		int department_id = 0;

	   	HttpSession session = req.getSession();
	   	id = Integer.parseInt((String)session.getAttribute("SELECT_ID"));
		name = (String) session.getAttribute("SELECT_NAME");
		furigana = (String) session.getAttribute("SELECT_FURIGANA");
		mailaddress = (String) session.getAttribute("SELECT_MAIL");
		department_id = Integer.parseInt((String)session.getAttribute("SELECT_DEPARTMENT"));

		System.out.println(id);
		System.out.println(name);
		System.out.println(furigana);
		System.out.println(mailaddress);
		System.out.println(department_id);

		// JDBCの読み込み
		Connection con = DbUtil.connectDB();
		// SQLの生成
		String sql = "SELECT * FROM employee WHERE id_employee = ? OR nm_employee = ? OR kn_employee= ? OR mail_address = ? OR id_department = ?";
		// Statementの生成
		PreparedStatement stmt = con.prepareStatement(sql);

		// パラメータ指定
		stmt.setInt(1, id);
		stmt.setString(2, "%" + name + "%");
		stmt.setString(3, "%" + furigana + "%");
		stmt.setString(4,"%" + mailaddress + "%");
		stmt.setInt(5,department_id);

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

		    // 値の表示
		    System.out.println(emp.getId() + "\t" + emp.getName() + "\t" + emp.getKana() + "\t"
			+ emp.getEmail() + "\t" + emp.getPass() + "\t" + emp.getIdDep());
		}

		// Statement、Connectionの切断
		DbUtil.closeDB(stmt, con);
	}

	/**
	 * 検索
	 */
	public static ArrayList<String> selectAll(HttpServletRequest req, HttpServletResponse res) throws SQLException {
		// JDBCの読み込み
		Connection con = DbUtil.connectDB();
		// SQLの生成
		String sql = "SELECT * FROM employee";
		// Statementの生成
		PreparedStatement stmt = con.prepareStatement(sql);
		// SQLの実行
		ResultSet rs = stmt.executeQuery();

		// 実行結果の取得と表示
		ArrayList<String> emplist = new ArrayList<String>();
		while (rs.next()) {
		    // 値の取得
			EmployeeDto emp = new EmployeeDto();
			emp.setId(rs.getInt("id_employee"));
			emp.setName(rs.getString("nm_employee"));
			emp.setKana(rs.getString("kn_employee"));
			emp.setEmail(rs.getString("mail_address"));
			emp.setPass(rs.getString("password"));
			emp.setId(rs.getInt("id_department"));

			emplist.add(String.valueOf(rs.getInt("id_employee")));
			emplist.add(rs.getString("nm_employee"));
			emplist.add(rs.getString("kn_employee"));
			emplist.add(rs.getString("mail_address"));
			emplist.add(rs.getString("password"));
			emplist.add(String.valueOf(rs.getInt("id_department")));

		    // 値の表示
		    System.out.println(emp.getId() + "\t" + emp.getName() + "\t" + emp.getKana() + "\t"
			+ emp.getEmail() + "\t" + emp.getPass() + "\t" + emp.getIdDep());
		}
		// Statement、Connectionの切断
		DbUtil.closeDB(stmt, con);

		return emplist;

	}
}
