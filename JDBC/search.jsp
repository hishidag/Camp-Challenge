<%-- 
    Document   : search
    Created on : 2016/06/24, 14:24:57
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>検索フォーム</title>
    </head>
    <body>
        <form method="get" action="JDBC2">
            <b>検索したい名前（部分一致検索）</b><br>
            <input type="text" name="name"><input type="submit" value="検索"><br>
        </form>
        <br>
        <b>データベースに挿入します</b>
        <form method="get" action="JDBC3">
        <table>
            <tr><th align="right">profileID：</th><td><input type="number" name="ID" required></td></tr>
            <tr><th align="right">名前：</th><td><input type="text" name="name"></td></tr>
            <tr><th align="right">電話番号：</th><td><input type="text" name="tell"></td></tr>
            <tr><th align="right">年齢：</th><td><input type="number" name="age"></td></tr>
            <tr><th align="right">誕生日：</th><td><input type="date" name="date"></td></tr>
        </table>
            <input type="submit" value="挿入">
        </form>
        <br>
        <form method="get" action="JDBC4">
            <b>削除したいprofilesID</b><br>
            <input type="number" name="id"><input type="submit" value="削除"><br>
        </form>
        <br>
        <b>データベースに上書きします</b>
        <form method="get" action="JDBC5">
        <table>
            <tr><th align="right">profileID：</th><td><input type="number" name="ID" required></td></tr>
            <tr><th align="right">名前：</th><td><input type="text" name="name"></td></tr>
            <tr><th align="right">電話番号：</th><td><input type="text" name="tell"></td></tr>
            <tr><th align="right">年齢：</th><td><input type="number" name="age"></td></tr>
            <tr><th align="right">誕生日：</th><td><input type="date" name="date"></td></tr>
        </table>
            <input type="submit" value="上書き">
        </form>
        <br>
        <b>複合検索</b>
        <form method="get" action="JDBC6">
        <table>
            <tr><th align="right">名前：</th><td><input type="text" name="name"></td></tr>
            <tr><th align="right">年齢：</th><td><input type="number" name="age"></td></tr>
            <tr><th align="right">誕生日：</th><td><input type="number" name="fyear">年</td>
                <td><select name="fmonth">
                        <option value=""></option>
                    <%
                        for(int i = 1 ; i <= 12 ; i++){
                            out.println("<option value=\"" + String.valueOf(i) +"\">");
                            out.println(i);
                            out.println("</oution>");
                        }
                    %>
                    </select>月</td>
                <td><select name="fday">
                        <option value=""></option>
                    <%
                        for(int i = 1 ; i <= 31 ; i++){
                            out.println("<option value=\""+ String.valueOf(i) +"\">");
                            out.println(i);
                            out.println("</oution>");
                        }
                    %>    
                    </select>日</td>
                    
                <td>～<input type="number" name="tyear">年</td>
                <td><select name="tmonth">
                        <option value=""></option>
                    <%
                        for(int i = 1 ; i <= 12 ; i++){
                            out.println("<option value=\""+ String.valueOf(i) + "\">");
                            out.println(i);
                            out.println("</oution>");
                        }
                    %>
                    </select>月</td>
                <td><select name="tday">
                        <option value=""></option>
                    <%
                        for(int i = 1 ; i <= 31 ; i++){
                            out.println("<option value=\"" + String.valueOf(i) + "\">");
                            out.println(i);
                            out.println("</oution>");
                        }
                    %>    
                    </select>日</td>
            </tr>
        </table>
            <input type="submit" value="検索">
        </form>
        <br>
        <form method="get" action="JDBCe">
            <b>いまのデータベース状況の表示</b><input type="submit" value="表示"><br>
        </form>
        <br>
    </body>
</html>
