<%-- 
    Document   : index
    Created on : 2016/06/22, 12:43:52
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>データ操作</title>
    </head>
    <body>
        <h1>入力ページ</h1>
        <form method='post' action='result.jsp'>
            名前：<input type="text" name='name'><br>
            性別：男<input type="radio" name='sex' value="男">
                　女<input type='radio' name="sex" value='女'><br>
                 趣味：<br><textarea name='favorite' ></textarea><br>
            <input type='submit' value='送信'><br>
        </form>
    </body>
</html>
