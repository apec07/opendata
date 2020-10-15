<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>    
<%@ page import="org.json.JSONArray,org.json.JSONObject"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Open Data Query</title>
</head>
<body>

<h1>Welcome ${account}</h1>
<form method="post" action="LogoutHandler">
	<input type="submit" name="logout" value="Logout"></input>
</form> 


<h2>This is my Query Data</h2>
<form method="get" action="TaipeiWaterSpot">
	<input type="submit" name="q" value="query"></input>
	<table border="1">
	<tr><th>id</th><th>address</th></tr>
	<% 
	JSONObject obj = (JSONObject)request.getAttribute("JSONObject");
	if(obj==null){
		out.println("no Data");
		return;
	}
	JSONObject content = obj.getJSONObject("result");
	JSONArray spotsArray = content.getJSONArray("results");
	for(int i=0;i<spotsArray.length();i++) {
		int _id = spotsArray.getJSONObject(i).getInt("_id");
		String address = spotsArray.getJSONObject(i).getString("地址");
	
	%>
	<tr><td><%=_id %></td><td><%=address %></td></tr>
	<%} %>
	</table>
</form>

</body>
</html>