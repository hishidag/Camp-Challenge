<%-- 
    Document   : result
    Created on : 2016/06/22, 17:39:17
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.Cookie" %>
<%@page import="java.net.*" %>
<% request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>確認ページ</title>
    </head>
    <body>
        記入した内容はCookieに書き込まれました。
    </body>
</html>
<% //クッキー作る
    Cookie cname = new Cookie("name",URLEncoder.encode(request.getParameter("name"),"UTF-8"));
    cname.setMaxAge(60 * 60 * 24);
    response.addCookie(cname);
%>
<% 
    Cookie csex = new Cookie("sex",URLEncoder.encode(request.getParameter("sex"),"UTF-8"));
    csex.setMaxAge(60 * 60 * 24);
    response.addCookie(csex);
%>
<%
    Cookie cfavorite = new Cookie("favorite",URLEncoder.encode(request.getParameter("favorite"),"UTF-8"));
    cfavorite.setMaxAge(60 * 60 * 24);
    response.addCookie(cfavorite);
%>