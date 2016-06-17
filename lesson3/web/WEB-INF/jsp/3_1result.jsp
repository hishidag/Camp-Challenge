<%-- 
    Document   : 3_1result
    Created on : 2016/06/16, 11:16:30
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="lesson3_1.ProfileBean" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>自己紹介１０回表示</title>
        <% ProfileBean pb = (ProfileBean)request.getAttribute("Data"); %>
    </head>
    <body>        
        <% for(int i = 1; i <= 10; i++){%>
        <p>
        名前：<% out.print( pb.getName() );%><br>
        生年月日：<% out.print( pb.getBirth() ); %><br>
        自己紹介：<% out.print( pb.getText());%><br>
        </p>
        <%}%>
        <% if( pb.isSend() ){
            out.println("この処理は正しく実行できました");
        }else{
            out.println("正しく実行できませんでした");
        } %>
    </body>
</html>

