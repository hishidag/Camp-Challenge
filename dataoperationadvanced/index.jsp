<%-- 
    Document   : index
    Created on : 2016/06/22, 12:43:52
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.Cookie" %>
<%@page import="java.util.Date"%>
<%@page import="java.net.*" %>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="java.text.*" %>
<% request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<%  //クッキーの受け取り。可読性のためここでクッキーの情報を手に入れることにした
    Cookie cook[] = request.getCookies();
    String name = "";
    String sex = "";
    String favorite = "";
    if(cook != null){
        for(Cookie c : cook){
            if(c.getName().equals("name")){
                name = URLDecoder.decode(c.getValue(),"UTF-8");
            }else if(c.getName().equals("sex")){
                sex = URLDecoder.decode(c.getValue(),"UTF-8");
            }else if(c.getName().equals("favorite")){
                favorite = URLDecoder.decode(c.getValue(),"UTF-8");
            }
        }
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>データ操作</title>
    </head>
    <body>
        <%if(cook == null){ %>
        <h1>入力ページ</h1>
            <form method='post' action='result.jsp'>
                名前：<input type="text" name='name'><br>
                性別：男<input type="radio" name='sex' value="男">
                      女<input type='radio' name="sex" value='女'><br>
                     趣味：<br><textarea name='favorite' ></textarea><br>
                <input type='submit' value='送信'><br>
            </form>
        <%}else{%>        
            名前：<%= name%><br>
            性別：<%= sex%><br>
            趣味：<%= favorite%><br>        
        <%}%>
    </body>
</html>
