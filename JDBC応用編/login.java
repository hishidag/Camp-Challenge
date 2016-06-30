/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log;

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
import javax.servlet.http.HttpSession;

/**
 *
 * @author user1
 */
public class login extends HttpServlet {

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
        
        HttpSession hs = request.getSession(false);       
        if(hs == null){
            response.sendRedirect("loginerror.jsp");
        }else{
        
        Connection con = null;
        PreparedStatement ps;
        ResultSet rs;
        
        String id = null;
        if(!"".equals(request.getParameter("ID"))){
            id = request.getParameter("ID");
        }
        
        String passwd = null;
        if(!"".equals(request.getParameter("passwd"))){
            passwd = request.getParameter("passwd");
        }
        
        try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db","hishidag","hishidag");
                
                ps = con.prepareStatement("select * from users where loginID = ? and passwd = ?");
                ps.setString(1, id);
                ps.setString(2,passwd);
                rs = ps.executeQuery();
                
                if(!rs.next()){
                    rs.close();
                    ps.close();
                    con.close();
                    hs.setAttribute("logerr","1");                    
                    response.sendRedirect("login.jsp");
                }else{                    
                    hs.setAttribute("logerr", "0");
                    hs.setAttribute("login","true");
                    if(rs.getInt("auth") == 1){                        
                        hs.setAttribute("auth","techou");
                    }else if(rs.getInt("auth") == 0){
                        hs.setAttribute("auth","tennin");
                }     
                    rs.close();
                    ps.close();
                    con.close();
                    response.sendRedirect("manage.jsp");
                }                                                                
                
                
                }catch(SQLException e_sql){
                    out.println(e_sql.toString()); 
                }catch(Exception e){
                    out.println(e.toString());            
                }finally{
                    try{
                        if(con != null){ con.close(); }
                    }catch(Exception e_con){
                        System.out.println(e_con.getMessage());
                    }        
                }
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
