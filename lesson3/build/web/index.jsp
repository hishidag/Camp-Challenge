<%-- 
    Document   : index
    Created on : 2016/06/15, 14:45:12
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>自己紹介の入力</title>
    </head>
    <body>
        <form method="post" action="intro">
            名前：<input type="text" name="name" required><br>
            誕生日：<input type="date" name="birth" required><br>
            自己紹介：<br>
            <textarea name="text" rows="4" cols="40"></textarea><br>
            <input type="submit" value="送信"><input type="reset" value="リセット">
        </form>
        
        
    </body>
</html>
