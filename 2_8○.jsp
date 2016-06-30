<%-- 
    Document   : 2_8
    Created on : 2016/06/14, 16:56:52
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>課題2_8</title>
    </head>
    <body>
        <%
        //８．７で作成した配列の"soeda"を"33"に変更してください。
        String array[] = {"10", "100", "soeda", "hayashi", "-20", "118", "END"};
        int max = array.length;
        //リニアサーチによって"soeda"の配列を探索
        int i  = 0;
        boolean b = false;
        while(i < max){
            if(array[i].equals("soeda")){
                array[i] = "33";
                for(String val : array){
                    out.println(val);
                }
                b = true;
            }else{
                i++;                                                    
            }
        }
        
        if(!b){out.println("要素\"soeda\"はありませんでした");}
        %>
    </body>
</html>
