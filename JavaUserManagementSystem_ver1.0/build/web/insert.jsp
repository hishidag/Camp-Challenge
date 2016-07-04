<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataBeans"%>
<%
    HttpSession hs = request.getSession();
    //課題７
    hs.setMaxInactiveInterval(60 * 30);
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
        <title>JUMS登録画面</title>
    </head>
    <body>
        <center>
        <h3>ユーザー情報登録</h3>
        <b>*は必須項目です</b>
        <form action="insertconfirm" method="POST">
        <table>
            <tr>
                <th>*名前:</th>
                <td><input type="text" name="name" value="<%=udb.getName()%>"></td>                
            </tr>
            <tr>
                <th>*生年月日:</th>　
                <td>
                    <select name="year">
                        <option value="<%=udb.getYear()%>"><%=udb.getYear()%></option>
                        <%
                            for(int i=1950; i<=2010; i++){ %>
                                <option value="<%=i%>"> <%=i%> </option>
                        <% } %>
                    </select>年
                    <select name="month">
                        <option value="<%=udb.getMonth()%>"><%=udb.getMonth()%></option>
                        <%
                            for(int i = 1; i<=12; i++){ %>
                                <option value="<%=i%>"><%=i%></option>
                        <% } %>
                    </select>月
                    <select name="day">
                        <option value="<%=udb.getDay()%>"><%=udb.getDay()%></option>
                        <%
                        for(int i = 1; i<=31; i++){ %>
                        <option value="<%=i%>"><%=i%></option>
                        <% } %>
                    </select>日
                </td>
            </tr>
            <tr>
                <th>*種別:</th>
                <td><input type="radio" name="type" value="1" <%if("1".equals(udb.getType()) ||"".equals(udb.getType())){%>checked<%}%>>エンジニア<br>
                <input type="radio" name="type" value="2" <%if("2".equals(udb.getType())){%>checked<%}%>>営業<br>
                <input type="radio" name="type" value="3" <%if("3".equals(udb.getType())){%>checked<%}%>>その他<br>
                </td>
            </tr>
            <tr>    
                <th>*電話番号:</th>
                <td><input type="text" name="tell" value="<%=udb.getTell()%>"> <b>※数字と"-"で記入してください</b></td>
            </tr>
            <tr>
                <th>自己紹介文:</th>
                <td><textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard" ><%=udb.getComment()%></textarea></td>
                <td></td>
            </tr>
        </table>
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
        </center>
    </body>
</html>
