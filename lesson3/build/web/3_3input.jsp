<%-- 
    Document   : 3_3input
    Created on : 2016/06/16, 13:17:43
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>引数三つ入力</title>
    </head>
    <body>
        <form method="get" action="index3">
            引数１：<input type="number" name="index1" required><br>
            引数２：<input type="number" name="index2" ><br>
            二乗しますか？：<input type="radio" name="index3" value="true">はい
            <input type="radio" name="index3" value="false">いいえ<br>
            <input type="submit" value="送信">
        </form>
    </body>
</html>
