<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p><% out.print(session.getAttribute("SIGNUP_NAME")); %>さんの情報</p>
     <table>
         <tr>
             <td>ID</td>
             <td><% out.print(session.getAttribute("SIGNUP_ID")); %></td>
         </tr>
         <tr>
             <td>名前</td>
             <td><% out.print(session.getAttribute("SIGNUP_NAME")); %></td>
         </tr>
         <tr>
             <td>ふりがな</td>
             <td><% out.print(session.getAttribute("SIGNUP_FURIGANA")); %></td>
         </tr>
         <tr>
             <td>メールアドレス</td>
             <td><% out.print(session.getAttribute("SIGNUP_MAIL")); %></td>
         </tr>
         <tr>
             <td>パスワード</td>
             <td><% out.print(session.getAttribute("SIGNUP_PASS")); %></td>
         </tr>
         <tr>
             <td>部署</td>
             <td><% out.print(session.getAttribute("SIGNUP_DEPARTMENT")); %></td>
         </tr>
     </table>
</body>
</html>