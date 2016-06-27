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
public class JDBC6 extends HttpServlet {

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
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new java.util.Date();
        
        request.setCharacterEncoding("UTF-8");
        
        String name = ""; 
        if(!"".equals(request.getParameter("name"))){
            name = request.getParameter("name");
        }
        
        int age = 0;
        if(!"".equals(request.getParameter("age"))){
            age = Integer.parseInt(request.getParameter("age"));
        }
        
        int fyear = 0000;
        if(!"".equals(request.getParameter("fyear"))){
            fyear = Integer.parseInt(request.getParameter("fyear"));
        }
        
        int fmonth = 01;
        if(!"".equals(request.getParameter("fmonth"))){
            fmonth = Integer.parseInt(request.getParameter("fmonth"));
        }
        
        int fday = 01;
        if(!"".equals(request.getParameter("fday"))){
            fday = Integer.parseInt(request.getParameter("fday"));
        }
        
        int tyear = 9999;
        if(!"".equals(request.getParameter("tyear"))){
            tyear = Integer.parseInt(request.getParameter("tyear"));
        }else{
            if(!"".equals(request.getParameter("fyear"))){
                tyear = Integer.parseInt(request.getParameter("fyear"));
            }
        }
        
        int tmonth = 12;
        if(!"".equals(request.getParameter("tmonth"))){
            tmonth = Integer.parseInt(request.getParameter("tmonth"));
        }else{
            if(!"".equals(request.getParameter("fmonth"))){
                tmonth = Integer.parseInt(request.getParameter("fmonth"));
            }
        }
        
        int tday = 31;
        if(!"".equals(request.getParameter("tday"))){
            tday = Integer.parseInt(request.getParameter("tday"));
        }else{
            if(!"".equals(request.getParameter("fday"))){
                tday = Integer.parseInt(request.getParameter("fday"));
            }
        }
        
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JDBC</title>");            
            out.println("</head>");
            out.println("<body>");
            
            Connection dc = null;
            PreparedStatement ps = null;
            ResultSet rs;

            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                dc = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","hishidag","hishidag");
                //トランザクション処理
                ps = dc.prepareStatement("select * from profiles where name like ? "
                          + "and age between ? and ? "
                          + "and year(birthday) between ? and ? "
                          + "and month(birthday) between ? and ? "
                          + "and dayofmonth(birthday) between ? and ?"
                          );
                
                ps.setString(1,"%" + name + "%");
                
                if(!"".equals(request.getParameter("age"))){
                    ps.setInt(2,age);
                    ps.setInt(3,age);
                }else{
                    ps.setInt(2,Integer.MIN_VALUE);
                    ps.setInt(3,Integer.MAX_VALUE);
                }
                
                ps.setInt(4,fyear);
                ps.setInt(5,tyear);
                
                ps.setInt(6,fmonth);
                ps.setInt(7,tmonth);
                
                ps.setInt(8,fday);
                ps.setInt(9,tday);
                
                
                rs = ps.executeQuery();
                out.print("<table border=1>");
                out.println("<tr><td>ID</td><td>名前</td><td>電話番号</td><td>年齢</td><td>生年月日</td></tr>");                
                while(rs.next()){
                    out.println("<tr><td>" + rs.getString("profilesID") +"</td><td>" 
                            + rs.getString("name") + "</td><td>" 
                            + rs.getString("tell") + "</td><td>" 
                            + rs.getString("age") + "</td><td>" 
                            + rs.getString("birthday") +"</td></tr>");
                    }
                out.print("</table><br>");
                
                ps.close();
                
            }catch(SQLException e_sql){
                out.println("接続時エラー：" + e_sql.toString()); 
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
