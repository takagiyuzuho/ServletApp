import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DbDao {
	/**
	 * 1:検索 -> 1:全検索
	 */
	public static void selectAll() throws SQLException {
		// JDBCの読み込み
		Connection con = DbUtil.connectDB();

		// 入力
		System.out.println("名前を入力してください");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();

		// SQLの生成
		String sql = "SELECT * FROM employee WHERE nm_employee = ?";
		// Statementの生成
		PreparedStatement stmt = con.prepareStatement(sql);
		//パラメータの作成
		stmt.setString(1, line);
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
	 * 1:検索 -> 2:部分検索
	 */
	public static void selectPart() throws SQLException {
		// JDBCの読み込み
		Connection con = DbUtil.connectDB();

		//入力
		System.out.println("名前を入力してください");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();

		// SQLの生成
		String sql = "SELECT * FROM employee WHERE nm_employee like ?";
		// Statementの生成
		PreparedStatement stmt = con.prepareStatement(sql);
		//パラメータの作成
		stmt.setString(1, "%" + line + "%");
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
	 * 2:挿入
	 */
	public static void insert() throws SQLException {
		// JDBCの読み込み
		Connection con = DbUtil.connectDB();

		//入力
		System.out.println("名前（漢字）を入力してください");
		Scanner sc2 = new Scanner(System.in);
		String inputName = sc2.nextLine();

		System.out.println("ふりがな（ひらがな）を入力してください");
		Scanner sc3 = new Scanner(System.in);
		String inputFurigana = sc3.nextLine();

		System.out.println("メールアドレスを入力してください");
		Scanner sc4 = new Scanner(System.in);
		String inputMail = sc4.nextLine();

		System.out.println("パスワードを入力してください");
		Scanner sc5 = new Scanner(System.in);
		String inputPass = sc5.nextLine();

		System.out.println("部署ID（数字）を入力してください");
		Scanner sc6 = new Scanner(System.in);
		int inputDepartment = sc6.nextInt();

		// SQLの生成
		String sql = "insert into employee(nm_employee, kn_employee, mail_address, password, id_department)values(?,?,?,?,?)";
		// Statementの生成
		PreparedStatement stmt = con.prepareStatement(sql);

		// パラメータ指定
		stmt.setString(1, inputName);
		stmt.setString(2, inputFurigana);
		stmt.setString(3, inputMail);
		stmt.setString(4, inputPass);
		stmt.setInt(5, inputDepartment);

		// SQLの実行
		int rs = stmt.executeUpdate();

		System.out.println("挿入しました");

		// Statement、Connectionの切断
		DbUtil.closeDB(stmt, con);

	}

	/**
	 * 3:更新
	 */
	public static void update() throws SQLException {
		// JDBCの読み込み
		Connection con = DbUtil.connectDB();

		//入力
		System.out.println("更新したいidを入力してください");
		Scanner sc = new Scanner(System.in);
		int inputId = sc.nextInt();

		//本当に更新するかどうか
		System.out.println("本当にこのidの情報を更新しますか？ 1:はい 2:いいえ");
		Scanner sc7 = new Scanner(System.in);
		int inputAnswer = sc7.nextInt();

		if(inputAnswer == 1) {
			System.out.println("名前（漢字）を入力してください");
			Scanner sc2 = new Scanner(System.in);
			String inputName = sc2.nextLine();

			System.out.println("ふりがな（ひらがな）を入力してください");
			Scanner sc3 = new Scanner(System.in);
			String inputFurigana = sc3.nextLine();

			System.out.println("メールアドレスを入力してください");
			Scanner sc4 = new Scanner(System.in);
			String inputMail = sc4.nextLine();

			System.out.println("パスワードを入力してください");
			Scanner sc5 = new Scanner(System.in);
			String inputPass = sc5.nextLine();

			System.out.println("部署ID（数字）を入力してください");
			Scanner sc6 = new Scanner(System.in);
			int inputDepartment = sc6.nextInt();

			// SQLの生成
			String sql = "update employee set nm_employee = ?, kn_employee = ?,mail_address = ?,password = ?,id_department = ? where id_employee = ?";

			// Statementの生成
			PreparedStatement stmt = con.prepareStatement(sql);

			// パラメータ指定
			stmt.setString(1, inputName);
			stmt.setString(2, inputFurigana);
			stmt.setString(3, inputMail);
			stmt.setString(4, inputPass);
			stmt.setInt(5, inputDepartment);
			stmt.setInt(6, inputId);

			// SQLの実行
			int rs = stmt.executeUpdate();

			System.out.println("更新しました");

			// Statement、Connectionの切断
			DbUtil.closeDB(stmt, con);
		}
	}

	/**
	 * 4:削除
	 */
	public static void delete() throws SQLException {
		// JDBCの読み込み
		Connection con = DbUtil.connectDB();

		//入力
		System.out.println("削除したいidを入力してください");
		Scanner sc = new Scanner(System.in);
		int inputId = sc.nextInt();

		//本当に削除するかどうか
		System.out.println("本当に削除しますか？ 1:はい 2:いいえ");
		Scanner sc2 = new Scanner(System.in);
		int inputAnswer = sc2.nextInt();

		if(inputAnswer == 1) {
			// SQLの生成
			String sql = "delete from employee where id_employee = " + inputId + ";";
			// Statementの生成
			Statement stmt = con.createStatement();
			// SQLの実行
			stmt.executeUpdate(sql);

			System.out.println("削除しました");

			// Statement、Connectionの切断
			DbUtil.closeDB(stmt, con);
		}
	}


	/**
	 * ログイン
	 */
	public static void selectLogin(String mailaddress, String password) throws SQLException {
		// JDBCの読み込み
		Connection con = DbUtil.connectDB();
		// SQLの生成
		String sql = "SELECT * FROM employee WHERE mail_address = ? AND password = ? ";
		// Statementの生成
		PreparedStatement stmt = con.prepareStatement(sql);
		//パラメータの作成
		stmt.setString(1, mailaddress);
		stmt.setString(2, password);
		// SQLの実行
		ResultSet rs = stmt.executeQuery();

		//名前をset
		EmployeeDto emp = new EmployeeDto();
		emp.setName(rs.getString("nm_employee"));

		String name = emp.getName();
		System.out.println(name);

		// Statement、Connectionの切断
		DbUtil.closeDB(stmt, con);
	}

	public static void main(String[] args) {

	}
}
