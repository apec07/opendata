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
 * Servlet implementation class Login
 */
@WebServlet("/LoginHandler")
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected boolean allowUser(String account,String password) {
		
		return account.equals("root") && password.equals("1234");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		System.out.println("account "+account);
		System.out.println("password "+password);
		//call sessionBindingEvent
		idv.cm.listener.LoginHttpSessionListener listener = new idv.cm.listener.LoginHttpSessionListener(session.getServletContext());
		
		if(!allowUser(account,password)) {
			//account & password are incorrect
		    out.println("<HTML><HEAD><TITLE>Access Denied</TITLE></HEAD>");
		    out.println("<BODY>你的帳號 , 密碼無效!<BR>");
		    out.println("請按此重新登入 <A HREF="+request.getContextPath()+"/login.html>重新登入</A>");
		    out.println("</BODY></HTML>");
		}else {
			//account & password are correct
			session.setAttribute("account",request.getParameter("account"));
			session.setAttribute("password",request.getParameter("password"));
			StringBuffer location = (StringBuffer) session.getAttribute("location");
			if(location!=null) {
				System.out.println("location - "+location.toString());
				session.removeAttribute("location");
				session.setAttribute("bindLoginListener-1", listener);
				response.sendRedirect(location.toString());
				return;
			}
			session.setAttribute("bindLoginListener-2", listener);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
	
	}

}
