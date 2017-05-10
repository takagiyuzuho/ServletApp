import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
    	req.setCharacterEncoding("UTF-8");

    	String id = req.getParameter("id");

    	HttpSession session = req.getSession();
    	session.setAttribute("DELETE_ID", id);

    	try {
    		//DBへデータを探しにいく
    		System.out.println("DB参照");
			DbDao.delete(req,res);

			//select.jspに遷移
	        req.getRequestDispatcher("user.jsp").forward(req, res);

		} catch (SQLException e) {
			//登録できなかった場合
			String canNotLogin = "削除できませんでした。";
			req.setAttribute("canNotLogin", canNotLogin);
			req.getRequestDispatcher("user.jsp").forward(req, res);
			e.printStackTrace();
		}
    }
}