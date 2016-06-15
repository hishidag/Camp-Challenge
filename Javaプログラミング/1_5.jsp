<%-- 
    Document   : 1_5
    Created on : 2016/06/14, 14:43:17
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>課題1_5</title>
    </head>
    <body>
        <%
        //５．四則演算の結果をそれぞれ表示してください。
        //定数の宣言
        final int a = 10;
        int b = 4;
        
        int add = a + b;
        int sub = a - b;
        int mul = a * b;
        int div = a / b;
        int rem = a % b;
        
        out.println("定数：" + a + "<br>");
        out.println("変数：" + b + "<br>");
        out.println("加算：" + add + "<br>");
        out.println("減算：" + sub + "<br>");
        out.println("乗算：" + mul + "<br>");
        out.println("割算：" + div + "<br>");
        out.println("剰算：" + rem + "<br>");

        %>
    </body>
</html>
