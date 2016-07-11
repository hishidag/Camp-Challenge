<%@page import="java.util.ArrayList"
        import="javax.servlet.http.HttpSession"
        import="jums.JumsHelper"
        import="jums.UserDataBeans" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");
    ArrayList<String> chkList = udb.chkproperties();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="http://purecss.io/css/layouts/side-menu.css">
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
    <style type="text/css">tr td:nth-child(1){background-color: #ffccff}</style>
    <title>JUMS登録確認</title>
</head>
<body>
    <div id ="layout">
    <%=jh.menu()%>
    <div id="main" align="center">
    <% if(chkList.size()==0){ %>
        <h1>登録確認</h1>
        <table class="pure-table pure-table-bordered">
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
        上記の内容で登録します。よろしいですか？
        <br><br>
        <div style="display: inline-flex">
        <form action="insertresult" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <button type="submit" name="yes" class="pure-button pure-button-active pure-button-primary">はい</button>
        </form>
    <% }else{ %>
        <h1>入力が不完全です</h1>
        <%=jh.chkinput(chkList) %>
    <% } %>
        <br>
        <form action="insert" method="POST">
            <button type="submit" name="no" class="pure-button pure-button-active">登録画面に戻る</button>
            <input type="hidden" name="mode" value="REINPUT">
        </form>
        </div>
    </div>
    </div>
    </body>
</html>
