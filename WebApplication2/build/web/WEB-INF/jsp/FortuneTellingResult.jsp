<%-- 
    Document   : FortuneTellingResult
    Created on : 2016/06/15, 12:07:18
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fortune.ResultDataBean" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>占いサーブレット版</title>
        <%
        ResultDataBean data = (ResultDataBean)request.getAttribute("DATA");
        %>
    </head>
    <body>
        
        <%
        if(data != null){ 
            out.println("<h1>あなたの" + data.getD() + "の運勢は、" + data.getLuck() + "です！</h1>");
        } 
        %>
        
    </body>
</html>
