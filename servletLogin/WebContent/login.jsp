<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LOGIN</title>
</head>
<body>
<%
String line = (String)request.getAttribute("canNotLogin");
%>
<p>
<% System.out.println(line); %>
</p>
   <form action="next" method="post">
        <table>
            <tr>
                <td>メールアドレス</td>
                <td><input type="text" name="mailadress"></td>
            </tr>
            <tr>
                <td>パスワード</td>
                <td><input type="password" name="pass"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="ログイン"></td>
            </tr>
        </table>
    </form>
</body>
</html>