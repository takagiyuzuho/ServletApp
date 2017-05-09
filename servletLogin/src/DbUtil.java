import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {
	public static void main(String[] args) {
	}

	/**
	 * JDBCでDBを読み込みます
	 * @return	con
	 */
	public static Connection connectDB() {
		Connection con = null;

		try {
			// JDBCの読み込み
			Class.forName("com.mysql.jdbc.Driver");
			// Connectionの生成
			con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/resodb?useSSL=false" // データベース
					,"root" // ユーザ
					,"root" // パスワード
			);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQLが読み込めません");
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * Statement、Connectionの切断をします
	 * @param Statement stmt
	 * @param Connection con
	 */
	public static void closeDB(Statement stmt, Connection con) throws SQLException {
		// Statement、Connectionの切断
		stmt.close();
		con.close();
	}
}
