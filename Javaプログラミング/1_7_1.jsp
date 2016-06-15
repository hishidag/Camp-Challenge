<%-- 
    Document   : 1_7_2
    Created on : 2016/06/14, 15:22:06
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>課題1_7＜入力ページ＞</title>
    </head>
    <body>
        <form methode="post" action="1_7.jsp">
            総額：<input type="number" name="sougaku" min="0" ><br>
            個数：<input type="number" name="kosuu" min="1"><br>
            商品種別：<input type="radio" name="shubetsu" value="zakka">雑貨
                     <input type="radio" name="shubetsu" value="shokuhin">生鮮食品
                     <input type="radio" name="shubetsu" value="other">その他<br>
            <input type="submit" value="送信"><br>
        </form>
    </body>
</html>
