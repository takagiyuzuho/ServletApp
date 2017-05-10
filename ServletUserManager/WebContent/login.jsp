<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン画面</title>
<link rel=stylesheet type="text/css" href="css/style.css">
</head>
<body>
<%
String line = (String)request.getAttribute("canNotLogin");
%>
<p>
<% if( line == null ){ %>
<% } else { %>
<%= line %>
<% } %>
<div class="login-form">
<h1>ログイン</h1>
   <form action="login" method="post">
        <table>
            <tr>
                <td>メールアドレス</td>
                <td><input type="text" name="mailaddress"></td>
            </tr>
            <tr>
                <td>パスワード</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="ログイン"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>