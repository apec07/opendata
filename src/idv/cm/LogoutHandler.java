package idv.cm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutHandler
 */
@WebServlet("/LogoutHandler")
public class LogoutHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		idv.cm.listener.LoginHttpSessionListener listener = new idv.cm.listener.LoginHttpSessionListener(session.getServletContext());
//		session.setAttribute("bindLogoutListener", listener);
		session.removeAttribute("account");
		session.removeAttribute("password");
		session.setAttribute("bindLogoutListener", listener);
		out.println("<HTML><HEAD><TITLE>Access Logout</TITLE></HEAD>");
		out.println("<BODY>你的帳號已成功登出!<BR>");
		out.println("請按此重新登入 <A HREF="+request.getContextPath()+"/login.html>重新登入</A>");
		out.println("</BODY></HTML>");
		
	}

}
