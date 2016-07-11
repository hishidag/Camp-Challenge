<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" 
        import="java.util.*"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    ArrayList<UserDataDTO> array = (ArrayList<UserDataDTO>)request.getAttribute("resultData");    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://purecss.io/css/layouts/side-menu.css">
        <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
        <style type="text/css"> tr{color: black} tr:nth-child(even){background-color: #ccffcc; } </style>
        <title>JUMS検索</title>
    </head>
    <body>
        <div id ="layout">
        <%=jh.menu()%>
        <div id="main" align="center">
            <h1>検索結果</h1>
        <%if(array.size() != 0){%>
        <table class="pure-table pure-table-bordered" >
            <thead>
                <tr align="center">
                    <th>名前</th>
                    <th>生年</th>
                    <th>種別</th>
                    <th>登録日時</th>
                </tr>
            </thead>
            <tbody>
            <%for( UserDataDTO udd : array ){%>
            <tr align="center" >
                <td><a href="ResultDetail?id=<%= udd.getUserID()%>"><%= udd.getName()%></a></td>
                <td><%= udd.getBirthday()%></td>
                <td><%= jh.exTypenum(udd.getType())%></td>
                <td><%= udd.getNewDate()%></td>
            </tr>
            <%}%>
            </tbody>
        </table>
        <%}else{%>
        検索結果はありません。        
        <%}%>
        </div>
        </div>
        <br>
        <br>
    </body>
</html>
