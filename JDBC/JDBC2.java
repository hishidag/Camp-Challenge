/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user1
 */
public class JDBC2 extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        
    
        
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JDBC</title>");            
            out.println("</head>");
            out.println("<body>");
            
            Connection db_con = null;
            PreparedStatement ps;
            ResultSet db_data;
            String search = request.getParameter("name");
            
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","hishidag","hishidag");
                
                ps = db_con.prepareStatement("select * from profiles where name like ?");
                ps.setString(1,"%" + search + "%");
                db_data = ps.executeQuery();
                if(db_data.next()){
                    db_data.beforeFirst();
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
                }else{
                    out.println("検索した文字は見つかりませんでした");
                }
                db_data.close();
                ps.close();                
                
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
