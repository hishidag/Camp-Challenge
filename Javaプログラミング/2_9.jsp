<%-- 
    Document   : 2_9
    Created on : 2016/06/14, 17:31:45
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.HashMap"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>課題2_9</title>
    </head>
    <body>
        <%
        /*
        ９．以下の順で、連想配列を作成してください。
　　　　"1"に"AAA", "hello"に"world", "soeda"に"33", "20"に"20"    
        */
        HashMap<String,String> lesson = new HashMap<String,String>();
        
        lesson.put("1","AAA");
        lesson.put("hello","world");
        lesson.put("soeda","33");
        lesson.put("20","20");
        
        //out.print(lesson.get("hello"));
        
        %>
    </body>
</html>
