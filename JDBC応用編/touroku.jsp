<%-- 
    Document   : touroku
    Created on : 2016/06/28, 16:24:02
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品登録ページ</title>
    </head>
    <body>
    <%
        request.setCharacterEncoding("UTF-8");
        HttpSession hs = request.getSession(false);
        hs.setAttribute("primarykeyerror","0");
        if(hs == null || hs.getAttribute("login") == null){            
            response.sendRedirect("loginerror.jsp");
        }else if(hs.getAttribute("auth") == "tennin"){
            response.sendRedirect("autherror.jsp");
        }else{            
     %>    
    <center>
        商品登録ページ
        <form method="post" action="tourokucheck">
        <table>
            <tr><th align="right">商品ID：</th><td><input type="number" name="itemID" <%="value=" + hs.getAttribute("itemID") %> required></td></tr>
            <tr><th align="right">商品名：</th><td><input type="text" name="itemName" 
                <% if(hs.getAttribute("itemPurchaseDay") != null){%>
                    value = "<%=hs.getAttribute("itemName")%>"
                <%}%>
                required></td></tr>
            <tr><th align="right">製造元ID：</th><td><input type="number" name="makerID" <%="value=" + hs.getAttribute("makerID")%> required></td></tr>
            <tr><th align="right">発売日：</th><td><input type="number" name="itemReleaseYear" <%="value=" + hs.getAttribute("itemReleaseYear")%>>年
                    <select name="itemReleaseMonth">
                        <%
                            if( hs.getAttribute("itemReleaseMonth") != "" && hs.getAttribute("itemReleaseMonth") != null){
                        %>
                            <option value= "<%=hs.getAttribute("itemReleaseMonth")%>"><%= hs.getAttribute("itemReleaseMonth")%></option>
                        <%
                            }
                        %>
                        
                        <option value=""></option>
                    <%
                        for(int i = 1 ; i <= 12 ; i++){                            
                            out.println("<option value=\"" + String.valueOf(i) +"\">");
                            out.println(i);
                            out.println("</oution>");
                        }
                    %>
                    </select>月
                    <select name="itemReleaseDay">
                        <%
                            if( hs.getAttribute("itemReleaseDay") != "" && hs.getAttribute("itemReleaseDay") != null){
                        %>
                            <option value= "<%=hs.getAttribute("itemReleaseDay")%>"><%= hs.getAttribute("itemReleaseDay")%></option>
                        <%
                            }
                        %>
                        <option value=""></option>
                    <%
                    for(int i = 1; i <= 31 ; i++){
                        out.println("<option value=\"" + String.valueOf(i) +"\">");
                        out.println(i);
                        out.println("</oution>");
                    }
                %>
            </td></tr>
            <tr><th align="right">仕入れ日：</th><td><input type="number" name="itemPurchaseYear" <%="value=" + hs.getAttribute("itemReleaseYear")%>>年
                    <select name="itemPurchaseMonth">
                        <%
                            if( hs.getAttribute("itemPurchaseMonth") != "" && hs.getAttribute("itemPurchaseMonth") != null){
                        %>
                            <option value="<%=hs.getAttribute("itemPurchaseMonth")%>"><%= hs.getAttribute("itemPurchaseMonth")%></option>
                        <%
                            }
                        %>
                    <option value=""></option>
                    <%
                        for(int i = 1 ; i <= 12 ; i++){
                            out.println("<option value=\"" + String.valueOf(i) +"\">");
                            out.println(i);
                            out.println("</oution>");
                        }
                    %>
                    </select>月
                    <select name="itemPurchaseDay">
                        <%
                            if( hs.getAttribute("itemPurchaseDay") != "" && hs.getAttribute("itemPurchaseDay") != null){
                        %>
                            <option value="<%=hs.getAttribute("itemPurchaseDay")%>"><%= hs.getAttribute("itemPurchaseDay")%></option>
                        <%
                            }
                        %>
                        <option value=""></option>
                    <%
                    for(int i = 1; i <= 31 ; i++){
                        out.println("<option value=\"" + String.valueOf(i) +"\">");
                            out.println(i);
                            out.println("</oution>");
                    }
                %>
            </select>日
            </td></tr>
            <tr><th align="right">仕入れ価格：</th><td><input type="number" name="cost" <%="value=" + hs.getAttribute("cost")%>></td></tr>
            <tr><th align="right">在庫数量：</th><td><input type="number" name="stock" <%="value=" + hs.getAttribute("stock")%>></td></tr>
            <tr><th align="right">倉庫ID：</th><td><input type="number" name="warehouseID" <%="value=" + hs.getAttribute("warehouseID")%> required></td></tr>
        </table>
            <br>
            <input type="submit" value="確認">
            <input type="reset" value="リセット">            
        </form><br>
            <a href="maker.jsp">製造元ID対応表</a>
            <a href="warehouse.jsp">倉庫ID対応表</a><br>
            <br>
            <a href="manage.jsp">管理画面へ戻る</a>
        </center>
    <%}%>
    </body>
</html>
