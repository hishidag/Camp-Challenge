<%@page import="javax.servlet.http.HttpSession"
        import="jums.JumsHelper"
        import="jums.UserDataBeans" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataBeans udb = new UserDataBeans();
    boolean reinput = false;
    if(request.getParameter("mode") != null && request.getParameter("mode").equals("REINPUT")){
        reinput = true;
        udb = (UserDataBeans)hs.getAttribute("udb");
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
        <title>JUMS登録画面</title>
    </head>
    <body>
        <div id ="layout">        
        <%=jh.menu()%>
        <div id="main">
            <div align="center">
                <h1>新規登録</h1>
        <form action="insertconfirm" method="POST">
        <table class="pure-table pure-table-bordered">
            <tr>
                <td><b>名前</b></td>
                <td><input id="name" type="text" name="name" value="<% if(reinput){out.print(udb.getName());}%>"></td>
            </tr>
            <tr>
                <td><b>生年月日</b></td>
                <td><%=jh.getYearForm(reinput,udb.getYear())%>
                    <%=jh.getMonthForm(reinput,udb.getMonth())%>
                    <%=jh.getDayForm(reinput,udb.getDay())%>
                </td>
            </tr>
            <tr>
                <td><b>種別</b></td>
                <td><%=jh.getTypeForm(reinput,udb.getType())%></td>
            </tr>
            <tr>
                <td><b>電話番号</b></td>
                <td><input type="text" name="tell" value="<% if(reinput){out.print(udb.getTell());}%>"></td>
            </tr>
            <tr>
                <td><b>自己紹介文</b></td>
                <td>
                    <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><% if(reinput){out.print(udb.getComment());}%></textarea><br><br>
                </td>
            </tr>
        </table>
                <br>
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <button type="submit" name="btnSubmit" class="pure-button pure-button-active pure-button-primary">確認画面へ</button>
        
    </form>
        </div>
        </div>
        <br>
        </div>
    </body>
</html>
