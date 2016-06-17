<%-- 
    Document   : 3_5result
    Created on : 2016/06/16, 15:00:46
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="lesson3_5.lesson3_5Bean"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>住所等表示</title>
    </head>
    <body>        
        <%             
           //課題6
           lesson3_5Bean lb = (lesson3_5Bean)request.getAttribute("Data");
           //idを引数に入れるとMapにそのidをkeyとしたSetを取り出せる
           Set set = lb.getSet(20);
           //Setはイテレータによってしか取り出せない
           Iterator it = set.iterator();             
        %>
        
        名前：<% out.println(it.next()); %><br>
        生年月日：<% out.println(it.next()); %><br>
        住所：<% out.println(it.next()); %><br><br>
        
        
        <%        
            //課題7と8
            Integer limit = 2;
            HashMap<Integer,Set> map = lb.getMap();
            ArrayList<Map> array = new ArrayList();
            array.add(map);
            int i = 1;
            //MapからSetすべて取得     
            
            for(Integer key : map.keySet()){
                //課題8の分。limit+1番目にbreakして、limitの人数だけとりだす                    
                if( i == limit + 1 ){
                    break;
                }
                //Mapから取得したset要素
                Set set1 = map.get(key);
                //Setの値すべて取得、変数oはSetの要素、SetはStringとLocalDateが入り混じっているのでObject型でとりだす
                for(Object o : set1){
                    //課題7の分。oがnullのときスキップする
                    if(o == null){
                        continue;                    
                    }                    
                    out.println(o + "<br>");
                }
                //見易さのため
                out.println("<br>");
                i++;
            }          
            
              
        %>
                     
    </body>
</html>
