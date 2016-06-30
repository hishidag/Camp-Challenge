<%-- 
    Document   : index
    Created on : 2016/06/27, 14:10:28
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession(true);
    hs.setMaxInactiveInterval(60 * 60 * 24);
    if(hs.isNew()){
        hs.setAttribute("logerr", "0");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログインページ</title>
    </head>
    <body>
        <center>
        <%
            if(hs.getAttribute("logerr").toString() == "1"){
        %>
        ログインに失敗しました。
        <%
            }
            hs.setAttribute("logerr","0");
        %>
            <form method="post" action="login">
            <table>
                <tr><th align="right">ログインID</th><td><input type="text" name="ID"></td><tr>
                <tr><th align="right">パスワード</th><td><input type="password" name="passwd"></td><tr>
            </table>
            <input type="submit" value="ログイン">
        </form>        
        </center>
    </body>
</html>
