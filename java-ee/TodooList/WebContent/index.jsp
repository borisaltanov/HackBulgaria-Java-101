<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="java.util.List" %>
<% List eList = (List) session.getAttribute("users"); %>
	
<% String hi = "Hi!"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>${title}</title>
	</head>
	<body>
		<a href="/TodooList/AboutUs">About us</a>
	
		<h1>Hello Hack!</h1>
		<%=hi %>
		${message}
		
		<h3>Users: </h3>
		
		<ul>
		<% for (int i = 0; i < eList.size(); i++) { %>
			<li> <%=eList.get(i) %> </li>
		<% } %>

		</ul>
<%-- 		${users.get(0)}
		${users.get(1)} --%>
	</body>
</html>