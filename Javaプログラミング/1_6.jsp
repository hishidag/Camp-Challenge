<%-- 
    Document   : 1_6
    Created on : 2016/06/14, 14:45:39
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>課題1_6</title>
    </head>
    <body>
     <%
        
     /*   ６．変数を宣言し、その変数の中身によって以下の表示を行ってください。
　　　⇒値が 1 なら「１です！」
　　　⇒値が 2 なら「プログラミングキャンプ！」
　　　⇒それ以外なら「その他です！」
      */
      
      int a;
      a = 1;     
      if(a==1){
          out.println("１です！");
      }else if(a==2){
          out.println("プログラミングキャンプ！"); 
      }else{
          out.println("その他です！");
      }
      
     %>
    </body>
</html>
