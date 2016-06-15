<%-- 
    Document   : 1_3
    Created on : 2016/06/14, 13:13:45
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>課題1_3</title>
    </head>
    <body>
        <%
        //３．自分の自己紹介を作成してみてください。
        String name = "石田　紘隆";
        int age  = 23;
        String text = "よろしくおねがいします。";
        
        %>
        <h1>自己紹介</h1>
        名前：<% out.println(name); %><br/>
        年齢：<% out.println(age);%><br/>
        ひとこと：<% out.println(text);%><br/>
        
    </body>
</html>
