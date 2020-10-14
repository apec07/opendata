package idv.cm.data;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

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
		JSONObject object = new JSONObject(sb.toString());
		JSONObject obj = object.getJSONObject("result");
		JSONArray spotsArray = obj.getJSONArray("results");
		//每月對照使用、直飲臺編號、轄區分處、市別、場所別、場所次分類、場所名稱、地址、行政區、管理單位、連絡電話、場所開放時間、設置地點、經度、緯度、狀態、狀態異動日期時間、最近採樣日期時間、大腸桿菌數、水質及維護資訊網址、直飲台照片
		//spotsArray.forEach(arg0);
		  out.println("<HTML><HEAD><TITLE>Access Denied</TITLE></HEAD>");
		  out.println("<BODY>_id  地址<BR>");
		  
		for(int i=0;i<spotsArray.length();i++) {
			int _id = spotsArray.getJSONObject(i).getInt("_id");
			String address = spotsArray.getJSONObject(i).getString("地址");
			
			out.println(_id+"\t"+address+"<BR>");
		}
		out.println("</BODY></HTML>");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
