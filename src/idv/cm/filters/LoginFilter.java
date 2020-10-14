package idv.cm.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {
	
	private FilterConfig fconfig;

    public LoginFilter() {
    	
    }

	public void init(FilterConfig fConfig) throws ServletException {
		this.fconfig = fConfig;
	}
	
	public void destroy() {
		fconfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		//get Session
		HttpSession session = req.getSession();
		Object account = session.getAttribute("account"); 
		if(account==null){
			session.setAttribute("location", req.getRequestURL());
			res.sendRedirect(req.getContextPath()+"/login.html");
			return;
		}else {
			// pass the request along the filter chain
			chain.doFilter(req, res);
		}
		
	}


}
