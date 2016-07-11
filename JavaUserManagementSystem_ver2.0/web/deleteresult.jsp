<%@page import="jums.JumsHelper"
        import="jums.UserDataBeans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!JumsHelper jh = JumsHelper.getInstance();%>
<% 
    UserDataBeans udb = new UserDataBeans();
    if(request.getAttribute("search") !=null){
        udb = (UserDataBeans)request.getAttribute("search");
    }
%>
<html lang="ja">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="http://purecss.io/css/layouts/side-menu.css">
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
    <title>削除結果</title>
</head>
<body>
    <div id ="layout">
    <%=jh.menu()%>
    <div id="main" align="center">
    <h1>削除確認</h1>
    削除しました。<br>
    <br>
    <%=jh.searchresult(udb.getName(),udb.getYear(),udb.getType())%>
    </div>
    </div>
    </body>    
</html>
