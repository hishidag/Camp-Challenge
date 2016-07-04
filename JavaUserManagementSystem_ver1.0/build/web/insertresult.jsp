<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper"%>
<%@page import="jums.UserDataBeans"%>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = new UserDataBeans();
    if(hs.getAttribute("FormContents") != null){
        udb = (UserDataBeans)hs.getAttribute("FormContents");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <center>
        <h1>登録結果</h1><br>
        <b>以上の内容で登録しました。</b><br>        
        <table>
            <tr>
                <th align="right">名前:</th>
                <td width="300px"><%= udb.getName()%></td>
            </tr>
            <tr>
                <th align="right">生年月日:</th>
                <td><%=udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%></td>
            </tr>
            <tr>
                <th align="right">種別:</th>
                <td><%if("1".equals(udb.getType())){%>エンジニア<%}%>
                    <%if("2".equals(udb.getType())){%>営業<%}%>
                    <%if("3".equals(udb.getType())){%>その他<%}%></td>
            </tr>
            <tr>
                <th align="right">電話番号:</th>
                <td><%= udb.getTell()%></td>
            </tr>        
            <tr>
                <th align="right">自己紹介:</th>
                <td><%= udb.getComment()%></td>
            </tr>
        </table>
        <%--課題１--%>
        <%=JumsHelper.getInstance().home()%>
        </center>
    </body>
</html>
<%--課題７--%>
<% hs.invalidate();%>