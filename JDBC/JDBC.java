/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.text.*;

/**
 *
 * @author user1
 */
public class JDBC extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
    
        
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JDBC</title>");            
            out.println("</head>");
            out.println("<body>");
            //util.Date -> sql.Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            java.util.Date date = new java.util.Date();
            try{
                date = sdf.parse("1994/04/30 00:00:00");
            }catch(ParseException pe){
                System.out.println(pe.toString());
            }
            java.sql.Date sdate = new java.sql.Date(date.getTime());

            Connection db_con = null;
            PreparedStatement ps;
            ResultSet db_data;

            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","hishidag","hishidag");
                //トランザクション処理
                db_con.setAutoCommit(false);

                ps = db_con.prepareStatement("insert into profiles values(?,?,?,?,?)");
                ps.setInt(1, 6);
                ps.setString(2, "てすと");
                ps.setString(3,"0120-333-2222");
                ps.setInt(4,30);
                ps.setDate(5, sdate);
                ps.executeUpdate();

                ps.close();

                ps = db_con.prepareStatement("select * from profiles");
                //ps.setString(1, "profiles");
                db_data = ps.executeQuery();
                out.print("<table border=1>");
                out.println("<tr><td>ID</td><td>名前</td><td>電話番号</td><td>年齢</td><td>生年月日</td></tr>");
                while(db_data.next()){
                    out.println("<tr><td>" + db_data.getString("profilesID") +"</td><td>" 
                            + db_data.getString("name") + "</td><td>" 
                            + db_data.getString("tell") + "</td><td>" 
                            + db_data.getString("age") + "</td><td>" 
                            + db_data.getString("birthday") +"</td></tr>");
                }
                out.print("</table><br>");

                ps.close();
                db_data.close();
                
                ps = db_con.prepareStatement("select * from profiles where profilesID = ? ");
                ps.setInt(1, 1);
                db_data = ps.executeQuery();
                out.print("<table border=1>");
                out.println("<tr><td>ID</td><td>名前</td><td>電話番号</td><td>年齢</td><td>生年月日</td></tr>");
                while(db_data.next()){
                    out.println("<tr><td>" + db_data.getString("profilesID") +"</td><td>" 
                            + db_data.getString("name") + "</td><td>" 
                            + db_data.getString("tell") + "</td><td>" 
                            + db_data.getString("age") + "</td><td>" 
                            + db_data.getString("birthday") +"</td></tr>");
                }
                out.print("</table><br>");
                ps.close();
                db_data.close();
                
                ps = db_con.prepareStatement("select * from profiles where name like ? ");
                ps.setString(1, "%茂%");
                db_data = ps.executeQuery();
                out.print("<table border=1>");
                out.println("<tr><td>ID</td><td>名前</td><td>電話番号</td><td>年齢</td><td>生年月日</td></tr>");
                while(db_data.next()){
                    out.println("<tr><td>" + db_data.getString("profilesID") +"</td><td>" 
                            + db_data.getString("name") + "</td><td>" 
                            + db_data.getString("tell") + "</td><td>" 
                            + db_data.getString("age") + "</td><td>" 
                            + db_data.getString("birthday") +"</td></tr>");
                }
                out.print("</table><br>");
                ps.close();
                db_data.close();
                
                
                //トランザクション終了
                db_con.commit();            
                }catch(SQLException e_sql){
                    out.println("接続時エラー：" + e_sql.toString());
                    if(db_con != null){ 
                        try{
                            db_con.rollback();
                        }catch(SQLException e_sqlr){
                            System.out.println("ロールバックできませんでした");
                        }
                    } 
                }catch(Exception e){
                    out.println("接続時エラー：" + e.toString());            
                }finally{
                    try{
                        if(db_con != null){ db_con.close(); }
                    }catch(Exception e_con){
                        System.out.println(e_con.getMessage());
                    }        
                }
            
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
