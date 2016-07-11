<%@page import="jums.JumsHelper" 
        import="javax.servlet.http.HttpSession"
        import="jums.UserDataDTO"
        import="jums.UserDataBeans"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = new UserDataDTO();
    //訂正したデータを表示するための処理
    if(request.getParameter("mode") != null && request.getParameter("mode").equals("REINPUT")){
        UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");
        udb.UD2DTOMapping(udd);
        udd.setUserID(((UserDataDTO)hs.getAttribute("resultData")).getUserID());
    }else{
        udd = (UserDataDTO)hs.getAttribute("resultData");
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
    <title>JUMS変更</title>
</head>
<body>
    <div id ="layout">
    <%=jh.menu()%>
    <div id="main" align="center">
        <h1>登録内容変更</h1>
    <form action="UpdateConfirm" method="POST">
        <table class="pure-table pure-table-bordered">
            <tr>
                <td><b>名前</b></td>
                <td><input type="text" name="name" value="<%=udd.getName()%>" placeholder="name"></td>
            </tr>
            <tr>
                <td><b>生年月日</b></td>
                <td>
                    <%=jh.getYearForm(jh.getYear(udd.getBirthday()))%>
                    <%=jh.getMonthForm(jh.getMonth(udd.getBirthday()))%>
                    <%=jh.getDayForm(jh.getDay(udd.getBirthday()))%>
                </td>
            </tr>
            <tr>
                <td><b>種別</b></td>
                <td><%=jh.getTypeForm(udd.getType())%></td>
            </tr>
            <tr>
                <td><b>電話番号</b></td>
                <td><input type="text" name="tell" value="<%=udd.getTell()%>" placeholder="tel"></td>
            </tr>
            <tr>
                <td><b>自己紹介文</b></td>
                <td><textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard" placeholder="よろしくお願いします！"><%=udd.getComment()%></textarea></td>
            </tr>           
        </table>
            <br>
            <div style="display: inline-flex">
            <input type="hidden" name="uac" value="<%= hs.getAttribute("uac")%>">
            <button type="submit" name="btnSubmit" class="pure-button pure-button-primary pure-button-active">確認画面へ</button>
    </form>
    <form action="ResultDetail">
        <button class="pure-button pure-button-active" type="submit" name="No" style="width:150px">詳細画面へ戻る</button>
        <input type="hidden" name="id" value="<%=udd.getUserID()%>">
    </form>
        </div>
        <br>
    </div>
    </div>
    </body>
</html>
