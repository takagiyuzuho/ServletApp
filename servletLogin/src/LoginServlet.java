import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
    	req.setCharacterEncoding("UTF-8");

    	String mailaddress = req.getParameter("mailadress");
    	String password = req.getParameter("password");

    	String name = null;

    	try {
			DbDao.selectLogin(mailaddress, password);
			EmployeeDto emp = new EmployeeDto();
			name = emp.getName();
			System.out.println(name);
	        req.setAttribute("servlet-name", name);
	        req.getRequestDispatcher("menu.jsp").forward(req, res);

		} catch (SQLException e) {
//			String canNotLogin = "ログインできませんでした。";
//			req.setAttribute("canNotLogin", canNotLogin);
//			req.getRequestDispatcher("input.jsp").forward(req, res);
			e.printStackTrace();
		}
    }
}