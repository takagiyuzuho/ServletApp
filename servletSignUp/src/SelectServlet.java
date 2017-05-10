import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SelectServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
    	req.setCharacterEncoding("UTF-8");

    	String search_name = req.getParameter("search_name");

    	HttpSession session = req.getSession();
    	session.setAttribute("SEARCH_NAME", search_name);

    	try {
    		//DBへデータを探しにいく
    		System.out.println("DB参照");
			DbDao.searchEmployee(req,res);

			//select.jspに遷移
	        req.getRequestDispatcher("selectResult.jsp").forward(req, res);

		} catch (SQLException e) {
			//検索していなかった場合
			String canNotLogin = "登録されていません";
			req.setAttribute("canNotSearch", canNotLogin);
			req.getRequestDispatcher("select.jsp").forward(req, res);
			e.printStackTrace();
		}
    }
}