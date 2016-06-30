<%-- 
    Document   : logout
    Created on : 2016/06/27, 17:56:36
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログアウト</title>
    </head>
    <body>
       ログアウトしました<br>
       <a href ="login.jsp">ログイン画面へ</a>
    </body>
</html>
<%
    HttpSession hs = request.getSession(false);
    hs.invalidate();
%>