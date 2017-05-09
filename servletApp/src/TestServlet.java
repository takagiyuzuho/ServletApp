import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
//        res.setContentType("text/html; charset=UTF-8");
//        PrintWriter out = res.getWriter();
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Servlet</title>");
//        out.println("</head>");
//        out.println("<body><h1>Hello, Servlet</h1></body>");
//        out.println("</html>");

    	req.setCharacterEncoding("UTF-8");

    	String id = req.getParameter("id");
    	String pass = req.getParameter("pass");

    	HttpSession session = req.getSession();
    	session.setAttribute("LOGIN_USER", "山田太郎");
    	session.setAttribute("LOGIN_ID", "10000");

        if(id.equals("10000") && pass.equals("aaa")) {
        	req.setAttribute("servlet-id", "格納したい値");
        	req.setAttribute("servlet-pass", "hogehoge");
        	req.getRequestDispatcher("menu.jsp").forward(req, res);
        } else {
        	req.getRequestDispatcher("login.jsp").forward(req, res);
        }
    }
}