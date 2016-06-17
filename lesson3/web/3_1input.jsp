<%-- 
    Document   : 3_1
    Created on : 2016/06/15, 14:48:50
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
        <form method="post" action="Profile">
            名前：<input type="text" name="name" required><br>
            生年月日：<input type="date" name="birth" required>(例：2016-01-01)<br>
            自己紹介：<br>
            <textarea name="text" rows="4" cols="40"></textarea><br>
            <input type="submit" value="送信"><input type="reset" value="リセット">
        </form>
        
        
    </body>
</html>
