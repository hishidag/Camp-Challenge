<%-- 
    Document   : 2_2
    Created on : 2016/06/14, 16:17:38
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>課題2_2</title>
    </head>
    <body>
        <%
            /*
            ２．switch文を利用して、以下の処理を実現してください。
         　　値が"A"なら「英語」、値が"あ"なら「日本語」、それ以外は何も表示しない処理
            */
            
            String str = "A";
            String msg = "";
            //文字列をswitch入れられないので数値に変換
            int conp = 0;
            if(str.equals("A")){
                conp = 1;
            }else if(str.equals("あ")){
                conp = 2;
            }
            switch(conp){
                case 1:
                    msg = "英語";
                    break;
                case 2:
                    msg = "日本語";
                    break;
                default:
                    break;
            }
            out.println(msg);
        
        %>
    </body>
</html>
