<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー登録</title>
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
<h1>ユーザー登録画面</h1>
   <form action="signup" method="post">
        <table>
            <tr>
                <td>名前</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>ふりがな</td>
                <td><input type="text" name="furigana"></td>
            </tr>
            <tr>
                <td>メールアドレス</td>
                <td><input type="text" name="mailaddress"></td>
            </tr>
            <tr>
                <td>パスワード（10文字）</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>部署</td>
                <td><input type="text" name="department" value="10"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="登録"></td>
            </tr>
        </table>
    </form>
</body>
</html>