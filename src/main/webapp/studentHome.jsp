<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String host =request.getServerName();
	  int portNum = request.getServerPort();
	  String cont = request.getServletPath();
	  String red = "http://"+host+":"+portNum+"/hello/metronic/templates/frontend/home-student.jsp";
	  response.sendRedirect(red);
				%>
	<h1><%=red %></h1>
</body>
</html>