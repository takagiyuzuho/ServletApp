
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
String name = (String)request.getAttribute("servlet-name");
%>
<p><%= name %>さんこんにちは</p>
</body>
</html>