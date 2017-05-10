import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchAllServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
    	req.setCharacterEncoding("UTF-8");

    	String id = req.getParameter("id");
    	String name = req.getParameter("name");
    	String furigana = req.getParameter("furigana");
    	String mailaddress = req.getParameter("mailaddress");
    	String department_id = req.getParameter("department_id");

    	HttpSession session = req.getSession();
    	session.setAttribute("SELECT_ID", id);
    	session.setAttribute("SELECT_NAME", name);
    	session.setAttribute("SELECT_FURIGANA", furigana);
    	session.setAttribute("SELECT_MAIL", mailaddress);
    	session.setAttribute("SELECT_DEPARTMENT",department_id);

    	try {
    		//DBへデータを探しにいく
    		System.out.println("DB参照");
			DbDao.select(req,res);

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