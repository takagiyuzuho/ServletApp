
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MENU</title>
</head>
<body>
	<h1>LOGIN Success!!</h1>
<%
String id = (String)request.getAttribute("servlet-id");
String pass = (String)request.getAttribute("servlet-pass");
%>
	<table border="1" cellspacing="0" cellpadding="3">
		<tr>
			<td>LOGIN USER</td>
			<td><% out.print(session.getAttribute("LOGIN_USER")); %></td>
		</tr>
		<tr>
			<td>LOGIN PASSWORD</td>
			<td><%= pass %></td>
		</tr>
	</table>
</body>
</html>