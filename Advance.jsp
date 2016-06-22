<%-- 
    Document   : Advance
    Created on : 2016/06/21, 17:53:40
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="java.text.*"%>
<%@page import="java.util.*"%>
<%@page import="java.math.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>応用解答</title>
    </head>
    <body>
        ①処理の経過を書き込むログファイルを作成する。<br>
        ②処理の開始、終了のタイミングで、ログファイルに開始・終了の書き込みを行う。<br>
        ③書き込む内容は、「日時　状況（開始・終了）」の形式で書き込む。<br>
        ④最後に、ログファイルを読み込み、その内容を表示してください。<br>
        <br>        
        <%    
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
            String strdate = "";
        %>
        <h3>---java.math.*を使った処理---</h3><br>
        <%  //logファイルを生成し書き込む
            File log = new File(application.getRealPath("log.txt"));
            FileWriter fw = new FileWriter(log);
            BufferedWriter bw = new BufferedWriter(fw);
            //dateに新しくDateインスタンスを入れてやることで現在時刻を取り直させることができる
            //ただし、処理の早さの所為で（おかげで？）ほとんどの場合、時刻がすべて同じ値になってしまう
            date = new Date();
            strdate = sdf.format(date.getTime());
            bw.write(strdate + "　プログラム開始");            
            bw.newLine();            
        %>
        <%
            date = new Date();
            strdate = sdf.format(date.getTime());        
            bw.write(strdate + "　乱数開始");
            bw.newLine();
        %>        
        <b>乱数を表示(1-100)</b><br>
        <%= (int)(Math.random()*100) + 1%><br>
        <br>
        <%  
            date = new Date();
            strdate = sdf.format(date.getTime());        
            bw.write(strdate + "　乱数終了");
            bw.newLine();
        %>
        <%
            date = new Date();
            strdate = sdf.format(date.getTime());        
            bw.write(strdate + "　絶対値表示開始");
            bw.newLine();
        %>
        <%  
            int num = -10;
            int absnum = Math.abs(num);
        %>
        <b><%= num %>の絶対値は、</b><br>
        <%= num + "　→　" + absnum %><br>
        <%
            date = new Date();
            strdate = sdf.format(date.getTime());
            bw.write(strdate + "　絶対値表示終了");
            bw.newLine();            
        %>
        <br>
        <%
            date = new Date();
            strdate = sdf.format(date.getTime());
            bw.write(strdate + "　どちらが大きいか小さいか比較開始");
            bw.newLine();
        %>
        <%
            long a = 123456;
            long b = 1234567;            
        %>
        <b><%= "Aの値は、" + a %><br> 
        <%= "Bの値は、" + b %></b><br>
        <%= "大きいのは、" + Math.max(a,b) %><br>
        <%= "小さいのは、" + Math.min(a,b) %><br>
        <%
            date = new Date();
            strdate = sdf.format(date.getTime());
            bw.write(strdate + "　どちらが大きいか小さいか比較終了");
            bw.newLine();            
        %>
        <br>
        <%
            date = new Date();
            strdate = sdf.format(date.getTime());
            bw.write(strdate + "　対数処理開始");
            bw.newLine();            
        %>
        <%
            double d = 10.0;            
        %>
        <b><%= d%>の</b><br>
        自然対数は、<%= Math.log(d) %><br>
        対数は、<%= Math.log10(d) %><br>                
        <br>
        <%
            date = new Date();
            strdate = sdf.format(date.getTime());
            bw.write(strdate + "　対数処理終了");
            bw.newLine();
        %>
        <%
            date = new Date();
            strdate = sdf.format(date.getTime());
            bw.write(strdate + "　切り捨て、切り上げ、四捨五入開始");
            bw.newLine();
        %>
        <%
            double cfr = 12.345;
            double mcfr = -12.345;
        %>
        <b><%= cfr %>を、切り捨て、切り上げ、四捨五入</b><br>
        <%= Math.floor(cfr)%><br>
        <%= Math.ceil(cfr)%><br>
        <%= Math.round(cfr)%><br>
        <br>
        <b><%= mcfr %>を、切り捨て、切り上げ、四捨五入</b><br>
        <%= Math.floor(mcfr)%><br>
        <%= Math.ceil(mcfr)%><br>
        <%= Math.round(mcfr)%><br>
        <br>
        <%
            date = new Date();
            strdate = sdf.format(date.getTime());
            bw.write(strdate + "　切り捨て、切り上げ、四捨五入終了");
            bw.newLine();
        %>
        <%
            date = new Date();
            strdate = sdf.format(date.getTime());
            bw.write(strdate + "　三角関数処理開始");
            bw.newLine();        
        %>
        <%
            int rad = 60;
        %>
        <b>角度<%= rad%>°の</b><br>
        sin = <%= Math.sin(Math.toRadians(rad))%><br>
        cos = <%= Math.cos(Math.toRadians(rad))%><br>
        tan = <%= Math.tan(Math.toRadians(rad))%><br>
        <b>sin から　角度　へ変換すると、</b><br>
        角度は、<%= Math.toDegrees(Math.asin(Math.sin(Math.toRadians(rad))))%><br>        
        <br>
        <%
            date = new Date();
            strdate = sdf.format(date.getTime());
            bw.write(strdate + "　三角関数処理終了");
            bw.newLine();        
        %>
        <%
            date = new Date();
            strdate = sdf.format(date.getTime());
            bw.write(strdate + "　円周率・自然対数処理開始");
            bw.newLine();        
        %>
        <b>円周率は</b><br>
        <%= Math.PI%><br>
        <b>自然対数の底は</b><br>
        <%= Math.E%><br>
        <%
            date = new Date();
            strdate = sdf.format(date.getTime());
            bw.write(strdate + "　円周率・自然対数処理終了");
            bw.newLine();        
        %>
        <%  //logファイルを閉じ表示する
            date = new Date();
            strdate = sdf.format(date.getTime());
            bw.write(strdate + "　プログラム終了");
            bw.newLine();
            bw.close();
            FileReader fr = new FileReader(application.getRealPath("log.txt"));
            BufferedReader br = new BufferedReader(fr);
            String strbr;
            while((strbr = br.readLine()) != null){
                //文字列に"プログラム"が含まれているならば<br>をいれる
                if(strbr.indexOf("プログラム") != -1){
                    out.print("<br>");
                }
                out.print(strbr + "<br>");
                if(strbr.indexOf("プログラム") != -1){
                    out.print("<br>");
                }
            }
            br.close();
        %>
    </body>
</html>
