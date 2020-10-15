package idv.cm.data;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class TaipeiWater
 */
@WebServlet("/TaipeiWaterSpot")
public class TaipeiWaterSpot extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String url = "https://data.taipei/api/v1/dataset/59629791-5f4f-4c91-903b-e9ab9aa0653b?scope=resourceAquire&limit=20"; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaipeiWaterSpot() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		StringBuffer sb = new StringBuffer();
		String str;
		while((str=br.readLine())!=null) {
			sb.append(str);
			sb.append("\n");
		}
		PrintWriter out = response.getWriter();
		//out.append(sb);
		System.out.println(sb.toString());
		JSONObject object = new JSONObject(sb.toString());
		request.setAttribute("JSONObject", object);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
//		response.sendRedirect(request.getContextPath()+"/index.jsp");
		
		/*
		JSONObject obj = object.getJSONObject("result");
		JSONArray spotsArray = obj.getJSONArray("results");
		
		  out.println("<HTML><HEAD><TITLE>Access Denied</TITLE></HEAD>");
		  out.println("<BODY>_id  地址<BR>");
		  
		for(int i=0;i<spotsArray.length();i++) {
			int _id = spotsArray.getJSONObject(i).getInt("_id");
			String address = spotsArray.getJSONObject(i).getString("地址");
			
			out.println(_id+"\t"+address+"<BR>");
		}
		out.println("</BODY></HTML>");
		
		**/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
