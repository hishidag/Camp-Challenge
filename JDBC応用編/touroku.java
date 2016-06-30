/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user1
 */
public class touroku extends HttpServlet {

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
        
        HttpSession hs = request.getSession(false);
        if(hs == null || hs.getAttribute("login") == null){
            response.sendRedirect("loginerror.jsp");
        }else if(hs.getAttribute("auth") == "tennin"){
            response.sendRedirect("autherror.jsp");
        }else{
        
        if(request.getParameter("regist") != null){
        
        request.setCharacterEncoding("UTF-8");
        
        String dburl = "jdbc:mysql://localhost:3306/challenge_db";
        String dbuser = "hishidag";
        String dbpass = "hishidag";        
        
        Connection con = null;
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            ps = con.prepareStatement("insert into item values(?,?,?,?-?-?,?-?-?,?,?,?)");
                        
            ps.setString(1,hs.getAttribute("itemID").toString());
                        
            ps.setString(2,hs.getAttribute("itemName").toString());
            if(!"".equals(hs.getAttribute("makerID"))){
                ps.setString(3,hs.getAttribute("makerID").toString());
            }else{
                ps.setString(3,"0");
            }
            
            if(!"".equals(hs.getAttribute("itemReleaseYear"))){
                ps.setString(4,hs.getAttribute("itemReleaseYear").toString());
            }else{
                ps.setString(4,"0");                
            }
            
            if(!"".equals(hs.getAttribute("itemReleaseMonth"))){
                ps.setString(5,hs.getAttribute("itemReleaseMonth").toString());
            }else{
                ps.setString(5,"0");                
            }
            
            if(!"".equals(hs.getAttribute("itemReleaseDay"))){
                ps.setString(6,hs.getAttribute("itemReleaseDay").toString());
            }else{
                ps.setString(6,"0");                
            }
            
            if(!"".equals(hs.getAttribute("itemPurchaseYear"))){
                ps.setString(7,hs.getAttribute("itemPurchaseYear").toString());
            }else{
                ps.setString(7,"0");                
            }
            
            if(!"".equals(hs.getAttribute("itemPurchaseMonth"))){
                ps.setString(8,hs.getAttribute("itemPurchaseMonth").toString());
            }else{
                ps.setString(8,"0");                
            }
            
            if(!"".equals(hs.getAttribute("itemPurchaseDay"))){
                ps.setString(9,hs.getAttribute("itemPurchaseDay").toString());
            }else{
                ps.setString(9,"0");                
            }
            
            if(!"".equals(hs.getAttribute("cost"))){
                ps.setString(10,hs.getAttribute("cost").toString());
            }else{
                ps.setString(10,"0");
            }
            
            if(!"".equals(hs.getAttribute("stock"))){
                ps.setString(11,hs.getAttribute("stock").toString());
            }else{
                ps.setString(11,"0");
            }
            if(!"".equals(hs.getAttribute("cost"))){
                ps.setString(12,hs.getAttribute("warehouseID").toString());
            }else{
                ps.setString(12,"0");
            }
            
            ps.executeUpdate();
            ps.close();
            out.println("<title>登録完了</title>");        
            out.println("<center>");
            out.println("登録が完了しました<br>");
            out.println("<a href = \"touroku.jsp\">続けて登録する</a>");        
            out.println("<a href = \"manage.jsp\">管理画面に戻る</a>");
            out.println("</center>");
            
            hs.invalidate();
            HttpSession hpn = request.getSession(true);
            hpn.setAttribute("login","true");
                    
        }catch(SQLException e_sql){
            //if(e_sql.getErrorCode()){
                hs.setAttribute("primarykeyerror","1");
                request.setAttribute("itemID",hs.getAttribute("itemID"));
                request.setAttribute("itemName",hs.getAttribute("itemName"));
                request.setAttribute("makerID",hs.getAttribute("makerID"));
                request.setAttribute("itemReleaseYear",hs.getAttribute("itemReleaseYear"));
                request.setAttribute("itemReleaseMonth",hs.getAttribute("itemReleaseMonth"));
                request.setAttribute("itemReleaseDay",hs.getAttribute("itemReleaseDay"));
                request.setAttribute("itemPurchaseYear",hs.getAttribute("itemPurchaseYear"));
                request.setAttribute("itemPurchaseMonth",hs.getAttribute("itemPurchaseMonth"));
                request.setAttribute("itemPurchaseDay",hs.getAttribute("itemPurchaseDay"));
                request.setAttribute("cost",hs.getAttribute("cost"));
                request.setAttribute("stock",hs.getAttribute("stock"));
                request.setAttribute("warehouseID",hs.getAttribute("warehouseID"));
                request.getRequestDispatcher("tourokucheck.jsp").forward(request, response);
            //}
        }catch(Exception e){
            out.println("<title>エラー</title>");
            out.println("何も記入されていません");            
        }finally{
            try{
                if(con != null){ con.close(); }
            }catch(Exception e_con){
                System.out.println(e_con.getMessage());
            }
        }        
        }else if(request.getParameter("return") != null){
            response.sendRedirect("touroku.jsp");
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
