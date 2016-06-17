<%-- 
    Document   : 3_2
    Created on : 2016/06/15, 16:05:40
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "lesson3_2.OddEvenBean" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>奇数・偶数の判断</title>
        <% 
        OddEvenBean oeb = (OddEvenBean)request.getAttribute("Data");
        %>
    </head>
    <body>
        <%
        //受け取った数値を奇数判別しjudgeに入れて表示
        out.print(oeb.judgeOddEven(oeb.isNum(oeb.getNum())));
        %>
    </body>
</html>
