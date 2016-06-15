<%-- 
    Document   : 1_7
    Created on : 2016/06/14, 15:01:04
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>課題1_7＜表示ページ＞</title>
    </head>
    <body>
        <%
        //総額
        String param1 = request.getParameter("sougaku");
        //個数
        String param2 = request.getParameter("kosuu");
        //商品種別
        String param3 = request.getParameter("shubetsu");
        
        int price = Integer.parseInt(param1);
        int num = Integer.parseInt(param2);
        
        if(param3.equals("zakka")){
            out.println("商品種別：雑貨<br>");
        }else if(param3.equals("shokuhin")){
            out.println("商品種別：生鮮食品<br>");
        }else{
            out.println("商品種別：その他<br>");
        }
        out.println("一個あたりの値段：" + price/num + "<br>");
        out.println("総額：" + price + "<br>");
        if(price < 3000){
            out.println("ポイント付与：" + "0pt" + "<br>");
        }else if(price < 5000){
            out.println("ポイント付与：" + price * 4/100 +"pt" + "<br>");
        }else{
            out.println("ポイント付与：" + price * 5/100 +"pt" + "<br>");
        }
        
        %>
    </body>
</html>
