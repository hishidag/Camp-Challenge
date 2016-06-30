<%-- 
    Document   : warehouse
    Created on : 2016/06/28, 16:15:45
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%
    HttpSession hs = request.getSession(false);
    if(hs == null || hs.getAttribute("login") == null){
        response.sendRedirect("loginerror.jsp");
    }else{
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>倉庫ID対応表</title>
    </head>
    <body>
        <center>
        <h1>倉庫ID対応表</h1>
        <%
            String dburl = "jdbc:mysql://localhost:3306/challenge_db";
            String dbuser = "hishidag";
            String dbpass = "hishidag";

            Connection con = null;
            PreparedStatement ps;
            ResultSet rs;

            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection(dburl,dbuser,dbpass);

                ps = con.prepareStatement("select * from warehouse");
                rs = ps.executeQuery();
        %>
        <table border="1">
            <tr bgcolor="skyblue"><td>倉庫ID</td><td>倉庫場所</td></tr>
            <%while(rs.next()){%>
            <tr><td align="center"><%=rs.getString("warehouseID")%></td><td align="center"><%=rs.getString("warehouseplace")%></td></tr>
            <%}%>
        </table>
        <%
            }catch(SQLException e_sql){
                out.println("接続に失敗しました。更新してください"); 
            }catch(Exception e){
                out.println("接続に失敗しました。更新してください");            
            }finally{
                try{
                    if(con != null){ con.close(); }
                }catch(Exception e_con){
                    System.out.println(e_con.getMessage());
                }        
            }
        %>
        <br>
        <form>
            <a href onClick="history.back()">戻る</a>
        </form>
        </center>
    </body>
</html>
<%}%>