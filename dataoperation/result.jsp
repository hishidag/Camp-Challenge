<%-- 
    Document   : result
    Created on : 2016/06/22, 12:45:35
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.Cookie" %>
<%@page import="java.util.Date"%>
<%@page import="java.text.*"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%--下の一文を入れることでgetParameterの値が文字化けしない--%>
<% request.setCharacterEncoding("UTF-8");%>
<% //現在時刻とSimpleDateFormatをセットにしておくと使いやすい
    Date nowdate = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");            
%>
<%  //クッキーの受け取り
    Cookie cook[] = request.getCookies();
    String strcnow = "クッキーがありません";
    if(cook != null){
        for(Cookie cvalue : cook){
            if(cvalue.getName().equals("cnow")){
                strcnow = cvalue.getValue();
            }
        }
    }
%>
<%  //セッション
    HttpSession hs = request.getSession(true);
    Object time = hs.getAttribute("snow");
    String access = "１度目の訪問です";
    if(time != null){
       access = sdf.format(time);
    }
%>
<%  //パラメータの受け取り            
    String name = request.getParameter("name");
    String sex = request.getParameter("sex"); 
    String favorite = request.getParameter("favorite");                               
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>表示ページ</title>
    </head>
    <body>    
        <h1>表示ページ</h1>
        名前：<%= name %><br>
        性別：<%= sex %><br>
        趣味：<%= favorite %><br>
        前回アクセスした日時（クッキーによる取得）：<%= strcnow%><br>
        前回アクセスした日時（セッションによる取得）：<%= access%><br>        
    </body>
</html>
<% //今回のアクセス時間をクッキーに登録
            Cookie cdate = new Cookie("cnow",sdf.format(nowdate));
            cdate.setMaxAge(60 * 60 * 24);
            response.addCookie(cdate);
        %>
<% //今回のアクセス時間をセッションに登録
    hs.setAttribute("snow",nowdate);
%>