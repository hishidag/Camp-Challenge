<%-- 
    Document   : indexsession
    Created on : 2016/06/23, 14:05:56
    Author     : user1
--%>

<%@page import="java.net.URLDecoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="java.text.*"%>
<% request.setCharacterEncoding("UTF-8");%>
<% 
    Object name ="";
    Object sex = "";
    Object favorite ="";
    HttpSession hs = request.getSession(true);
    //セッションの最終アクセス時からの有効期限を指定
    hs.setMaxInactiveInterval(10);
    //isNewでそのセッションが新しいかどうかチェック
    if(!hs.isNew()){
        name = hs.getAttribute("name");
        sex = hs.getAttribute("sex");
        favorite = hs.getAttribute("favorite");
    }
%>
<% SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%if(hs.isNew()){%>
        <h1>入力ページ</h1>
            <form method='post' action='resultsession.jsp'>
                名前：<input type="text" name='name'><br>
                性別：男<input type="radio" name='sex' value="男">
                      女<input type='radio' name="sex" value='女'><br>
                     趣味：<br><textarea name='favorite' ></textarea><br>
                <input type='submit' value='送信'><br>
            </form>
        <%}else{%>
        名前：<%= URLDecoder.decode(name.toString(),"UTF-8")%><br>
        性別：<%= URLDecoder.decode(sex.toString(),"UTF-8")%><br>
        趣味：<%= URLDecoder.decode(favorite.toString(),"UTF-8")%><br>
        <%--getCreationTime()でセッションの作られた時間をタイムスタンプ型で入手--%>
        セッションの作成：<%= sdf.format(hs.getCreationTime())%><br>
        <%--getLastAccessedTime()で最終アクセス時をタイムスタンプ型で入手--%>
        前回のセッション：<%= sdf.format(hs.getLastAccessedTime())%><br>
        <%}%>
    </body>
</html>
