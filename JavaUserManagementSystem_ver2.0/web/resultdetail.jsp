<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" 
        import="javax.servlet.http.HttpSession"
        import="jums.UserDataBeans"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("resultData");
    UserDataBeans sudb = (UserDataBeans)hs.getAttribute("search");
    if(hs.getAttribute("search") != null){
        sudb = (UserDataBeans)hs.getAttribute("search");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="http://purecss.io/css/layouts/side-menu.css">
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
    <style type="text/css">tr td:nth-child(1){background-color: #ffccff}</style>
    <title>JUMSユーザー情報詳細</title>
</head>
<body>
    <div id ="layout">
    <%=jh.menu()%>
    <div id="main" align="center">
        <h1>詳細情報</h1>
        <table class="pure-table pure-table-bordered">
        <tr>
            <td><b>名前</b></td>
            <td><%= udd.getName()%></td>
        </tr>
        <tr>
            <td><b>生年月日</b></td>
            <td><%= udd.getBirthday()%></td>
        </tr>
        <tr>
            <td><b>種別</b></td>
            <td><%= jh.exTypenum(udd.getType())%></td>
        </tr>
        <tr>
            <td><b>電話番号</b></td>
            <td><%= udd.getTell()%></td>
        </tr>
        <tr>
            <td><b>自己紹介</b></td>
            <td><div style = "width:300px; height:200px; overflow:auto"><%= udd.getComment()%></div></td>
        </tr>
        <tr>
            <td><b>登録日時</b></td>
            <td><%= udd.getNewDate()%></td>
        </tr>
    </table>
        <br>
        <div style="display: inline-flex">
            <form action="Update" method="POST">
                <button type="submit" name="update" style="width:100px" class="pure-button pure-button-active">変更</button>
                <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
            </form>
            <form action="Delete" method="POST">
                <button type="submit" name="delete" style="width:100px" class="pure-button pure-button-active">削除</button>
                <input type="hidden" name="ac" value="<%=hs.getAttribute("ac")%>">
            </form>
        </div>
        <br><br>
        <div>
        <%=jh.searchresult(sudb.getName(),sudb.getYear(),sudb.getType())%>
        </div>
    </div>
    </div>
    </body>    

</html>
