<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper"%>
<%@page import="jums.UserDataBeans"%>
<%@page import="jums.CheckCharacter"%>
<%
    HttpSession hs = request.getSession();
    //課題７
    hs.setMaxInactiveInterval(60 * 3);
    UserDataBeans udb = new UserDataBeans();
    if(hs.getAttribute("FormContents") != null){
        udb = (UserDataBeans)hs.getAttribute("FormContents");
    }
    CheckCharacter cc = new CheckCharacter();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        <center>
        <h1>登録確認</h1>
        <table>
            <tr>
                <th align="right">名前:</th>
                <td width="280px"><%= udb.getName()%></td>
                <td width="170px"><%= cc.checkCharacter(udb.getName())%></td>
            </tr>
            <tr>
                <th align="right">生年月日:</th>
                <td><%= udb.getYear() +"年"+udb.getMonth()+"月"+ udb.getDay() +"日"%></td>
                <td><%= "年:" + cc.checkNumber(udb.getYear())%><br>
                    <%= "月:" + cc.checkNumber(udb.getMonth())%><br>
                    <%= "日:" + cc.checkNumber(udb.getDay())%></td>
            </tr>
            <tr>
                <th align="right">種別:</th>
                <td><%if("1".equals(udb.getType())){%>エンジニア<%}%>
                    <%if("2".equals(udb.getType())){%>営業<%}%>
                    <%if("3".equals(udb.getType())){%>その他<%}%></td>
                <td><%= cc.checkNumber(udb.getType())%></td>
            </tr>
            <tr>
                <th align="right">電話番号:</th>
                <td><%= udb.getTell()%></td>
                <td><%= cc.checkTell(udb.getTell())%></td>
            </tr>
            <tr>
                <th align="right">自己紹介:</th>
                <td><%= udb.getComment()%></td>
                <td></td>
            </tr>
        </table>
        <%if(cc.isAllCheck){%>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="hidden" name="ac1" value="<%= hs.getAttribute("ac1")%>">
            <input type="submit" name="yes" value="はい">
        </form>
        <%}%>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
    <br>
    <%--課題１--%>
    <%=JumsHelper.getInstance().home()%>
    </center>
    </body>
</html>
