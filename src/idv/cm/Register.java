package idv.cm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import idv.cm.db.UserBean;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserBean user = new UserBean();
	
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }


	@Override
	public void init() throws ServletException {
		
	}


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
