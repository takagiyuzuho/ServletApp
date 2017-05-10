import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
    	req.setCharacterEncoding("UTF-8");

    	String mailaddress = req.getParameter("mailaddress");
    	String password = req.getParameter("password");

    	HttpSession session = req.getSession();
    	session.setAttribute("LOGIN_MAIL", mailaddress);
    	session.setAttribute("LOGIN_PASS", password);

    	try {
    		//DBへデータを探しにいく
    		System.out.println("DB参照");
			DbDao.readLogin(req,res);

			//menu.jspに送る
	        req.getRequestDispatcher("menu.jsp").forward(req, res);

		} catch (SQLException e) {
			//ログインできなかった場合
			String canNotLogin = "ログインできませんでした。";
			req.setAttribute("canNotLogin", canNotLogin);
			req.getRequestDispatcher("login.jsp").forward(req, res);
			e.printStackTrace();
		}
    }
}
