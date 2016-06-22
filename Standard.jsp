<%-- 
    Document   : Expression
    Created on : 2016/06/21, 14:46:08
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="java.sql.Timestamp" %>
<%@page import="java.text.*"%>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>基礎解答</title>
    </head>
    <body>
        １．2016年1月1日 0時0分0秒のタイムスタンプを作成し、表示してください。<br>
        <%  //課題1
            SimpleDateFormat sd = new SimpleDateFormat();            
            Date date = sd.parse("2016/01/01 00:00:00");
        %>
        <%=date.getTime()%><br>
        ２．現在の日時を「年-月-日 時:分:秒」で表示してください。<br>
        <%  //課題2 SimpleDateFormatで
            Date now = new Date();            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strdate = sdf.format(now.getTime());
        %>
        <%= strdate %><br>
        ３．2016年11月4日 10時0分0秒のタイムスタンプを作成し、「年-月-日 時:分:秒」で表示してください。<br>
        <% //課題3 Calendarで
            Calendar cal = Calendar.getInstance();
            cal.set(2016,10,4,10,0,0);
            int yy = cal.get(Calendar.YEAR);
            int MM = cal.get(Calendar.MONTH) + 1;
            int dd = cal.get(Calendar.DATE);
            int HH = cal.get(Calendar.HOUR);
            int mm = cal.get(Calendar.MINUTE);
            int ss = cal.get(Calendar.SECOND);        
        %>
        <%= yy + "-" + MM + "-" + dd + " " + HH + ":" + mm + ":" + ss%><br>
        ４．2015年1月1日 0時0分0秒と2015年12月31日 23時59分59秒の差（ミリ秒）を表示してください。<br>
        <%//課題4
            Date ad = sd.parse("2015/01/01 00:00:00");
            Date bd = sd.parse("2015/12/31 23:59:59");
            long add = ad.getTime();
            long bdd = bd.getTime();
        %>
        <%= bdd - add%>(ミリ秒)<br>
        ５．自分の氏名について、バイト数と文字数を取得して、表示してください。<br>
        <%  //課題5
            String name = "石田紘隆";
        %>
        <%=name%><br>
        <%=name.getBytes().length%>byte<br>
        <%=name.length()%>文字<br>
        ６．自分のメールアドレスの「@」以降の文字を取得して、表示してください。<br>
        <% //課題6
            String email = "hishidag@gmail.com";            
        %>
        <%=email.substring(email.indexOf("@")) %><br>
        ７．以下の文章の「I」⇒「い」に、「U」⇒「う」に入れ替える処理を作成し、結果を表示してください。<br>
        「きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます」<br>
        <% //課題7
            String str = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
        %>
        <%=str.replace("I", "い").replace("U", "う") %><br>
        ８．ファイルに自己紹介を書き出し、保存してください。<br>
        <% //課題8
            File text = new File(application.getRealPath("test.txt"));
            FileWriter fw = new FileWriter(text);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("私は石田紘隆と申します。");
            bw.newLine();
            bw.write("よろしくお願いします。");
            bw.newLine();
            bw.close();
        %>
        ９．ファイルから自己紹介を読み出し、表示してください。<br>
        <% //課題9
            FileReader fr = new FileReader(text);
            BufferedReader br = new BufferedReader(fr);
            String strbr;
            while((strbr = br.readLine()) != null){
                out.print(strbr + "<br>");
            }
            br.close();
        %>
        
    </body>
</html>
