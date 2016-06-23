<%-- 
    Document   : resultsession
    Created on : 2016/06/23, 14:06:11
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="java.net.*"%>
<% request.setCharacterEncoding("UTF-8");%>
<%  //セッション
    HttpSession hs = request.getSession(true);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        記入した内容はセッションに書き込まれました。
    </body>
</html>
<% hs.setAttribute("name",URLEncoder.encode(request.getParameter("name"),"UTF-8"));%>
<% hs.setAttribute("sex",URLEncoder.encode(request.getParameter("sex"),"UTF-8"));%>
<% hs.setAttribute("favorite",URLEncoder.encode(request.getParameter("favorite"), "UTF-8"));%>