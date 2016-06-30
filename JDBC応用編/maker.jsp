<%-- 
    Document   : maker
    Created on : 2016/06/28, 15:59:00
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
        <title>製造元ID対応表</title>
    </head>
    <body>
        <center>
        <h1>製造元ID対応表</h1>
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

                ps = con.prepareStatement("select * from maker");
                rs = ps.executeQuery();
        %>
        <table border="1">
            <tr bgcolor="skyblue"><td>製造元ID</td><td>製造元名</td></tr>
            <%while(rs.next()){%>
            <tr><td align="center"><%=rs.getString("makerID")%></td><td align="center"><%=rs.getString("makername")%></td></tr>
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