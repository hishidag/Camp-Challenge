<%@page import="jums.JumsHelper" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="http://purecss.io/css/layouts/side-menu.css">
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
    <title>エラー</title>
</head>
<body>
    <div id ="layout">
        <%=jums.JumsHelper.getInstance().menu()%>
        <div id="main" align="center">
            <h2>エラーが発生しました。以下の項目を確認してください。</h2><br>
        <%if(request.getAttribute("error") == null || "null".equals(request.getAttribute("error"))){%>
        セッションが無効です<br><br>
        <%}else{%>
        <%=request.getAttribute("error")%><br><br>
        <%}%>
        <%=JumsHelper.getInstance().home()%>
    </div>
    </div>
    </body>
</html>
