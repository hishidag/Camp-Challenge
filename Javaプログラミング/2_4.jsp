<%-- 
    Document   : 2_4
    Created on : 2016/06/14, 16:37:05
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>課題2_4</title>
    </head>
    <body>
        <%
        //４．for文を利用して、"A"を30個連結する処理を実現してください。
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i <= 30;i++){
            sb.append("A");
        }
        //out.println(sb.toString());
        %>
    </body>
</html>
