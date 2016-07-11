<%@page import="javax.servlet.http.HttpSession"
        import="jums.JumsHelper"
        import="jums.UserDataBeans" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataBeans udb = (UserDataBeans)request.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="http://purecss.io/css/layouts/side-menu.css">
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
    <style type="text/css">tr td:nth-child(1){background-color: #ffccff}</style>
    <title>JUMS登録結果</title>
</head>
<body>
    <div id ="layout">
    <%=jh.menu()%>
    <div id="main" align="center">
        <h1>登録結果</h1>
        <h3>以下の内容で登録しました</h3>
        <table class="pure-table pure-table-horizontal">
            <tr>
                <td><b>名前</b></td>
                <td><%= udb.getName()%></td>
            </tr>
            <tr>
                <td><b>生年月日</b></td>
                <td><%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%></td>
            </tr>
            <tr>
                <td><b>種別</b></td>
                <td><%= jh.exTypenum(udb.getType())%></td>
            </tr>
            <tr>
                <td><b>電話番号</b></td>
                <td><%= udb.getTell()%></td>
            </tr>
            <tr>
                <td><b>自己紹介</b></td>
                <td><div style = "width:300px; height:200px; overflow:auto"><%= udb.getComment()%></div></td>
            </tr>
        </table>
            <br>
            <br>
            <%=jh.home()%>
    </div>
    </div>            
    </body>
</html>
