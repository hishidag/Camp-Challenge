<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" 
        import="javax.servlet.http.HttpSession"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="http://purecss.io/css/layouts/side-menu.css">
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
    <style type="text/css">tr td:nth-child(1){background-color: #ffccff}</style>
    <title>削除確認</title>
</head>
<body>
    <div id ="layout">
    <%=jh.menu()%>
    <div id="main" align="center">
    <h1>削除確認</h1>
    <h3>以下の内容を削除します。よろしいですか？</h3>
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
    <form action="DeleteResult" method="POST">
        <button class="pure-button pure-button-primary pure-button-active" type="submit" name="YES" style="width:100px">はい</button>
      <input type="hidden" name="dac" value="<%=hs.getAttribute("dac")%>">
    </form>
    <form action="ResultDetail">
        <button class="pure-button pure-button-active" type="submit" name="No" style="width:100px">いいえ</button>
        <input type="hidden" name="id" value="<%=udd.getUserID()%>">
    </form>
    </div>
    <br>
    <br>
    </div>
    </div>    
</body>
    
</html>
