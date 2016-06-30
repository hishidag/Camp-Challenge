<%-- 
    Document   : tourokucheck
    Created on : 2016/06/29, 12:10:33
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="java.sql.*"%>
<%@page import="log.tourokucheck"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%!public Boolean isMatch = true;%>
<!DOCTYPE html>
<% 
    HttpSession hs = request.getSession(false);
    tourokucheck tc = new tourokucheck();
    tc.testSession(request,response);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録確認</title>
    </head>
    <body>       
        <center>
            <h1>確認ページ</h1>
            この内容で登録します。よろしければ、登録を押してください。<br><br>
        <table>
            <tr><th align="right">商品ID：</th><td><%=request.getAttribute("itemID")%></td><td><%=tc.perror%>
                    <%if("".equals(tc.perror)){%>
                       <%=tc.setMAIM(request.getAttribute("itemID"))%>
                    <%}%></td></tr>
            <tr><th align="right">商品名：</th><td><%=request.getAttribute("itemName")%></td><td><%=tc.setMAIM(request.getAttribute("itemName"))%></td></tr>
            <tr><th align="right">製造元ID：</th><td><%=request.getAttribute("makerID")%></td><td><%=tc.setMAIM(request.getAttribute("makerID"))%></td></tr>
            <tr><th align="right">発売日：</th><td><%=request.getAttribute("itemReleaseYear")%>年
                    <%=request.getAttribute("itemReleaseMonth")%>月
                    <%=request.getAttribute("itemReleaseDay")%>日</td></tr>
            <tr><th align="right">仕入れ日：</th><td><%=request.getAttribute("itemPurchaseYear")%>年
                    <%=request.getAttribute("itemPurchaseMonth")%>月
                    <%=request.getAttribute("itemPurchaseDay")%>日</td></tr>
            <tr><th align="right">仕入れ価格：</th><td><%=request.getAttribute("cost")%></td></tr>
            <tr><th align="right">在庫数量：</th><td><%=request.getAttribute("stock")%></td></tr>
            <tr><th align="right">倉庫ID：</th><td><%=request.getAttribute("warehouseID")%></td><td><%=tc.setMAIM(request.getAttribute("warehouseID"))%></td></tr>
        </table>
        <form method="post" action="touroku">            
            <input type="submit" name="return" value="戻る">            
            <input type="submit" name="regist" value="登録" 
                   <%if(!tc.match){out.print("disabled");}%>>            
        </form>        
        </center>    
    </body>
</html>
 <%tc.setSession(request, response);%>
