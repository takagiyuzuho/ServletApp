import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InsertServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
    	req.setCharacterEncoding("UTF-8");

    	String name = req.getParameter("name");
    	String furigana = req.getParameter("furigana");
    	String mailaddress = req.getParameter("mailaddress");
    	String password = req.getParameter("password");
    	String department = req.getParameter("department");

    	HttpSession session = req.getSession();
    	session.setAttribute("SIGNUP_NAME", name);
    	session.setAttribute("SIGNUP_FURIGANA", furigana);
    	session.setAttribute("SIGNUP_MAIL", mailaddress);
    	session.setAttribute("SIGNUP_PASS", password);
    	session.setAttribute("SIGNUP_DEPARTMENT",department);

    	try {
    		//DBへデータを探しにいく
    		System.out.println("DB参照");
			DbDao.create(req,res);

			//select.jspに遷移
	        req.getRequestDispatcher("user.jsp").forward(req, res);

		} catch (SQLException e) {
			//登録できなかった場合
			String canNotLogin = "登録できませんでした。";
			req.setAttribute("canNotLogin", canNotLogin);
			req.getRequestDispatcher("user.jsp").forward(req, res);
			e.printStackTrace();
		}
    }
}