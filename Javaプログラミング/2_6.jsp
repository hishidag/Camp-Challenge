<%-- 
    Document   : 2_6
    Created on : 2016/06/14, 16:47:38
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>課題2_6</title>
    </head>
    <body>
        <%
        /*
        ６．while文を利用して、以下の処理を実現してください。
　　　　1000を2で割り続け、100より小さくなったらループを抜ける処理
        */
        int sen = 1000;
        //100 * 2未満のとき100以下の値も表示されてしまうので回避
        while(sen >= 100 * 2){
            sen /= 2;
            //out.println(sen + "<br>");
        }
        
        %>
    </body>
</html>
