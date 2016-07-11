<%@page contentType="text/html" pageEncoding="UTF-8"
        import="jums.JumsHelper"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="http://purecss.io/css/layouts/side-menu.css">
    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
    <title>JUMSトップ</title>
</head>
<body>
    <div id ="layout">
    <%=JumsHelper.getInstance().menu()%>
    <div id="main">
        <div class="header">
        <h1>ユーザー情報管理トップ</h1><br>
        <h3>ここでは、ユーザー情報管理システムとしてユーザー情報の登録や検索、
        付随して修正や削除を行うことができます</h3><br>
        </div>
        <div class="content">
        <div>
            <ul>
                <li><a href="insert">新規登録</a></li>
                <li><a href="Search" >検索(修正・削除)</a></li>
            </ul>
        </div>
        </div>
    </div>
    </div>
<script src="/combo/1.18.13?/js/ui.js"></script>
</body>
</html>
