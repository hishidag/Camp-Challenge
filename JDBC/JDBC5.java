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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user1
 */
public class JDBC5 extends HttpServlet {

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
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        java.util.Date date = new java.util.Date();
        
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("ID"));
        String name = null; 
        if(request.getParameter("name") != null){
            name =request.getParameter("name");
        }
        String tell = null;
        if(request.getParameter("tell") != null){
            tell =request.getParameter("tell");
        }
        int age = 0;
        if(!"".equals(request.getParameter("age"))){
            age = Integer.parseInt(request.getParameter("age"));
        }
        
        try{
            date = sdf.parse(request.getParameter("date"));
        }catch(ParseException pe){
            out.println("生年月日を正しく入力してください。形式は20161231の様にご記入ください");
        }
        java.sql.Date sdate = new java.sql.Date(date.getTime()); 
        
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JDBC</title>");            
            out.println("</head>");
            out.println("<body>");
            //util.Date -> sql.Date
            
            Connection dc = null;
            PreparedStatement ps;
            ResultSet rs;

            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                dc = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","hishidag","hishidag");
                //トランザクション処理
                
                ps = dc.prepareStatement("update profiles set name=?,tell=?,age=?,birthday=? where profilesID = ?");
                ps.setString(1,name);
                ps.setString(2,tell);
                ps.setInt(3,age);
                ps.setDate(4, sdate);
                ps.setInt(5,id);
                ps.executeUpdate();
                
                ps.close();
                
            }catch(SQLException e_sql){
                    out.println("接続時エラー：" + e_sql.toString());
                    if(dc != null){ 
                        try{
                            dc.rollback();
                        }catch(SQLException e_sqlr){
                            System.out.println("ロールバックできませんでした:" + e_sqlr.toString());
                        }
                    } 
            }catch(Exception e){
                out.println("接続時エラー：" + e.toString());            
            }finally{
                try{
                    if(dc != null){ dc.close(); }
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
