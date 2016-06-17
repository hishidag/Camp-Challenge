<%-- 
    Document   : 3_3
    Created on : 2016/06/15, 17:29:33
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="lesson3_3.index3Bean;"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>引数3つ</title>
        <% index3Bean i3b = (index3Bean)request.getAttribute("Data");%>
    </head>
    <body>
        <%
          /*
          int index1 = i3b.getIndex1();
          int index2 = i3b.getIndex2();
          boolean index3 = i3b.getIndex3();
          out.println(index1);
          out.println(index2);
          out.println(index3);
          */
          out.println(i3b.squareIndex(100));
        %> です。
    </body>
</html>
