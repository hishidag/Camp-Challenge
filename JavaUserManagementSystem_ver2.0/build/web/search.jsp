<%@page import="jums.JumsHelper" 
        import="javax.servlet.http.HttpSession"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://purecss.io/css/layouts/side-menu.css">
        <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
        <style type="text/css">tr td:nth-child(1){background-color: #ffccff}</style>
        <title>JUMS登録画面</title>
    </head>
    <body>
        <div id ="layout">
        <%=jh.menu()%>
        <div id="main" align="center">
            <h1>検索(修正・削除)</h1>
        <form action="SearchResult">
            <table class="pure-table pure-table-bordered ">
        <tr>
            <td><b>名前</b></td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td><b>生年</b></td>　
            <td><%=jh.getYearForm()%>生まれ</td>
        </tr>
        <tr>
            <td><b>種別</b></td>
            <td><%=jh.getTypeForm()%></td>
        </tr>
        </table>
        <br>
        <button type="submit" name="btnSubmit" class="pure-button pure-button-active pure-button-primary">検索</button>            
    </form>
        <br>
        </div>
        </div>
    </body>
</html>
