<%-- 
    Document   : 2_10
    Created on : 2016/06/14, 17:40:18
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>課題2_10＜表示ページ＞</title>
    </head>
    <body>
        <%
        /*
        １０．クエリストリングを利用して、以下の処理を実現してください。

       　簡易素因数分解のロジックを作成します。

        クエリストリングから渡された数値を1ケタの素数で可能な限り分解し、
        元の値と素因数分解の結果を表示するようにしてください。
　
        2ケタ以上の素数が含まれた数値の場合は、
        「元の値　1ケタの素因数　その他」と表記して、その他　に含んでくださ
            
         */
            
        //2_10_1からパラメータを受け取る    
        String num = request.getParameter("soin");
        
        int nat = Integer.parseInt(num);
        %>
        元の値：<% out.println(num);%>　　
        <%
        int array[];
        int two = 0;
        int three = 0;
        int five = 0;
        int seven = 0;
        
        while(nat % 2 == 0){
            nat /= 2; 
            two++;
        }
         %>
         2^<% out.println(two);%>  
         <%
         while(nat % 3 == 0){
            nat /= 3; 
            three++;
         }
         %>
         3^<% out.println(three);%>
         <%
         while(nat % 5 == 0){
            nat /= 5; 
            five++;
         }
         %>
         5^<% out.println(five);%>
         <%
         while(nat % 7 == 0){
            nat /= 7; 
            seven++;
         }
         %>
         7^<% out.println(seven);%>
         <%
         if(nat != 1){
            out.println("その他"); 
         }
         %>
         
    </body>
</html>
