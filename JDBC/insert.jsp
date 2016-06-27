<%-- 
    Document   : insert
    Created on : 2016/06/24, 15:04:52
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>追加ページ</title>
    </head>
    <body>
        <b>データベースに追加します</b>
        <form method="get" action="JDBC3">
        <table>
            <tr><th align="right">profileID：</th><td><input type="number" name="ID" required></td></tr>
            <tr><th align="right">名前：</th><td><input type="text" name="name"></td></tr>
            <tr><th align="right">電話番号：</th><td><input type="text" name="tell"></td></tr>
            <tr><th align="right">年齢：</th><td><input type="number" name="age"></td></tr>
            <tr><th align="right">生年月日：</th><td><input type="date" name="date"></td></tr>
        </table>
            <input type="submit" value="追加">
        </form>
    </body>
</html>
