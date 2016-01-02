<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Hello World</title>
</head>
<body>
	<h2>Hello World from Struts2!</h2>
	<form action="hello" method="post">
		<label for="name">Please Enter Your Name</label><br/>
		<input type="text" name="name"/>
		<input type="submit" value="Say Hello">
	</form>
	<%String host =request.getServerName();
	  int portNum = request.getServerPort();
	  String cont = request.getServletPath();
	  String red = "http://"+host+":"+portNum+"/hello/metronic/templates/frontend/index-custom.jsp";
	  response.sendRedirect(red);
				%>
	<h1><%=red %></h1>
</body>
</html>
