<%-- 
    Document   : search
    Created on : 2016/06/28, 10:24:42
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品検索</title>
    </head>
    <body>
    <%
        HttpSession hs = request.getSession(false);
        if(hs == null || hs.getAttribute("login") == null){            
            response.sendRedirect("loginerror.jsp");
        }else{
    %>
        <%hs.setAttribute("search","true");%>
        <center>
            検索したい商品情報を入力してください
        <form method="post" action="Search">
        <table>
            <tr><th align="right">商品ID：</th><td><input type="number" name="itemID"></td></tr>
            <tr><th align="right">商品名：</th><td><input type="text" name="itemName">
                    <select name="searchItem">
                        <option value="bubun">
                        </option>
                        <option value="kanzen">
                            完全一致検索
                        </option>
                        <option value="zenpou">
                            前方一致検索
                        </option>
                        <option value="kouhou">
                            後方一致検索
                        </option>
                        <option value="bubun">
                            部分一致検索
                        </option>
                    </select></td></tr>
            <tr><th align="right">製造元ID：</th><td><input type="number" name="makerID"></td></tr>
            <tr><th align="right">発売日：</th><td><input type="number" name="itemReleaseFromYear">年
                    <select name="itemReleaseFromMonth">
                        <option value="00"></option>
                    <%
                        for(int i = 1 ; i <= 12 ; i++){
                            out.println("<option value=\"" + String.valueOf(i) +"\">");
                            out.println(i);
                            out.println("</oution>");
                        }
                    %>
                    </select>月
                    <select name="itemReleaseFromDay">
                        <option value="00"></option>
                    <%
                    for(int i = 1; i <= 31 ; i++){
                        out.println("<option value=\"" + String.valueOf(i) +"\">");
                            out.println(i);
                            out.println("</oution>");
                    }
                %>
            </select> ～
                <input type="number" name="itemReleaseToYear">年
                    <select name="itemReleaseToMonth">
                    <option value="12"></option>
                    <%
                        for(int i = 1 ; i <= 12 ; i++){
                            out.println("<option value=\"" + String.valueOf(i) +"\">");
                            out.println(i);
                            out.println("</oution>");
                        }
                    %>
                    </select>月
                    <select name="itemReleaseToDay">
                    <option value="31"></option>
                    <%
                    for(int i = 1; i <= 31 ; i++){
                        out.println("<option value=\"" + String.valueOf(i) +"\">");
                            out.println(i);
                            out.println("</oution>");
                    }
                %>
            </select></td></tr>
            <tr><th align="right">仕入れ日：</th><td><input type="number" name="itemPurchaseFromYear">年
                    <select name="itemPurchaseFromMonth">
                    <option value="00"></option>
                    <%
                        for(int i = 1 ; i <= 12 ; i++){
                            out.println("<option value=\"" + String.valueOf(i) +"\">");
                            out.println(i);
                            out.println("</oution>");
                        }
                    %>
                    </select>月
                    <select name="itemPurchaseFromDay">
                    <option value="00"></option>
                    <%
                    for(int i = 1; i <= 31 ; i++){
                        out.println("<option value=\"" + String.valueOf(i) +"\">");
                            out.println(i);
                            out.println("</oution>");
                    }
                %>
            </select> ～
            <input type="number" name="itemPurchaseToYear">年
                    <select name="itemPurchaseToMonth">
                    <option value="12"></option>
                    <%
                        for(int i = 1 ; i <= 12 ; i++){
                            out.println("<option value=\"" + String.valueOf(i) +"\">");
                            out.println(i);
                            out.println("</oution>");
                        }
                    %>
                    </select>月
                    <select name="itemPurchaseToDay">
                    <option value="31"></option>
                    <%
                    for(int i = 1; i <= 31 ; i++){
                        out.println("<option value=\"" + String.valueOf(i) +"\">");
                            out.println(i);
                            out.println("</oution>");
                    }
                %>
            </select>
            </td></tr>
            <tr><th align="right">倉庫ID：</th><td><input type="number" name="warehouseID"></td></tr>
        </table>
            <input type="submit" value="検索">
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
