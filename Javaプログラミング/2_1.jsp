<%-- 
    Document   : 2_1
    Created on : 2016/06/14, 16:11:34
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>課題2_1</title>
    </head>
    <body>
        <%
        /*
        １．switch文を利用して、以下の処理を実現してください。
　　　　 値が1なら「one」、値が2なら「two」、それ以外は「想定外」と表示する処理
        */
        int a = 2;
        String msg = "";
        switch(a){
            case 1:
             msg = "one";
             break;
            case 2:
             msg = "two";
             break;
            default:
             msg = "想定外";
             break;
        }
        out.println(msg);
        %>
    </body>
</html>
