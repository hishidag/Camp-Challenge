<%-- 
    Document   : 2_3
    Created on : 2016/06/14, 16:33:51
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>課題2_3</title>
    </head>
    <body>
        <%
        //３．for文を利用して、8を20回掛ける処理を実現してください。
        for(int i = 1;i <= 20;i++){
            out.print(8 * i + "<br>");
        }
        
        /*
        int multi_eight = 1;
        for(int i = 1;i <= 20;i++){
            multi_eight *= i;
        }
        */
        
        %>
    </body>
</html>
