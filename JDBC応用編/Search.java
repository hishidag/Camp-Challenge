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

public class Search extends HttpServlet {

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
        }
        
        out.println("<title>検索結果</title>");
        request.setCharacterEncoding("UTF-8");
        
        //?以下の文字列をURLに入れておくことでDateがNullを扱えるようになる
        String dburl = "jdbc:mysql://localhost:3306/challenge_db?zeroDateTimeBehavior=convertToNull";
        String dbuser = "hishidag";
        String dbpass = "hishidag";        
        
        Connection con = null;
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            ps = con.prepareStatement("select *,maker.makername,warehouse.warehouseplace from item "
                    + "inner join maker "
                    + "on item.makerID = maker.makerID "
                    + "inner join warehouse "
                    + "on item.warehouseID = warehouse.warehouseID "
                    + "where "
                    + "itemID like ? "
                    + "and itemname like ? "
                    + "and item.makerID like ? "
                    + "and year(itemRelease) between ? and ? " 
                    + "and month(itemRelease) between ? and ? "
                    + "and dayofmonth(itemRelease) between ? and ? "
                    + "and year(itemPurchase) between ? and ? "
                    + "and month(itemPurchase) between ? and ? "
                    + "and dayofmonth(itemPurchase) between ? and ? "
                    + "and item.warehouseID like ? "
                    + "order by itemID "            
                    );
            if(!"".equals(request.getParameter("itemID"))){
                ps.setString(1, request.getParameter("itemID"));           
            }else{
                ps.setString(1,"%");
            }
            
            if("kanzen".equals(request.getParameter("searchItem"))){
                ps.setString(2,request.getParameter("itemName"));
            }else if("zenpou".equals(request.getParameter("searchItem"))){
                ps.setString(2,request.getParameter("itemName") + "%");
            }else if("kouhou".equals(request.getParameter("searchItem"))){
                ps.setString(2, "%" +request.getParameter("itemName"));
            }else{
                ps.setString(2,"%"+ request.getParameter("itemName") +"%");
            }
            
            if(!"".equals(request.getParameter("makerID"))){
                ps.setString(3, request.getParameter("makerID"));           
            }else{
                ps.setString(3,"%");
            }
            
            ps.setString(4,"0");
            ps.setString(5,"9999");            
            if(!"".equals(request.getParameter("itemReleaseFromYear"))){
                ps.setString(4,request.getParameter("itemReleaseFromYear"));
            }
            if(!"".equals(request.getParameter("itemReleaseToYear"))){
                ps.setString(5, request.getParameter("itemReleaseToYear"));
            }
            
            ps.setString(6,"00");
            ps.setString(7,"12");
            if(!"".equals(request.getParameter("itemReleaseFromMonth"))){
                ps.setString(6,request.getParameter("itemReleaseFromMonth"));
                ps.setString(7,request.getParameter("itemReleaseFromMonth"));
            }
            if(!"".equals(request.getParameter("itemReleaseToMonth"))){
                ps.setString(7,request.getParameter("itemReleaseToMonth"));
            }
            
            ps.setString(8,"00");
            ps.setString(9,"31");
            if(!"".equals(request.getParameter("itemReleaseFromDay"))){
                ps.setString(8,request.getParameter("itemReleaseFromDay"));
                ps.setString(9,request.getParameter("itemReleaseFromDay"));
            }
            if(!"".equals(request.getParameter("itemReleaseToDay"))){
                ps.setString(9,request.getParameter("itemReleaseToDay"));
            }
            
            ps.setString(10,"0");
            ps.setString(11,"9999");            
            if(!"".equals(request.getParameter("itemPurchaseFromYear"))){
                ps.setString(10,request.getParameter("itemPurchaseFromYear"));
            }
            if(!"".equals(request.getParameter("itemPurchaseToYear"))){
                ps.setString(11, request.getParameter("itemPurchaseToYear"));
            }
            
            ps.setString(12,"00");
            ps.setString(13,"12");            
            if(!"".equals(request.getParameter("itemPurchaseFromMonth"))){
                ps.setString(12,request.getParameter("itemPurchaseFromMonth"));
                ps.setString(13, request.getParameter("itemPurchaseFromMonth"));
            }
            if(!"".equals(request.getParameter("itemPurchaseToMonth"))){
                ps.setString(13, request.getParameter("itemPurchaseToMonth"));
            }
            
            ps.setString(14,"00");
            ps.setString(15,"31");            
            if(!"".equals(request.getParameter("itemPurchaseFromDay"))){
                ps.setString(14,request.getParameter("itemPurchaseFromDay"));
                ps.setString(15,request.getParameter("itemPurchaseFromDay"));
            }
            if(!"".equals(request.getParameter("itemPurchaseToDay"))){
                ps.setString(15, request.getParameter("itemPurchaseToDay"));
            }
    
            if(!"".equals(request.getParameter("warehouseID"))){
                ps.setString(16, request.getParameter("warehouseID"));           
            }else{
                ps.setString(16,"%");
            }
            
            
            rs = ps.executeQuery();
            
            out.println("<center>");
            if(!rs.next()){
                out.println("表示するデータがありません<br>");
            }else{
                rs.beforeFirst();
                out.print("<table border=1>");
                out.println("<tr bgcolor=\"skyblue\"><td>商品ID</td><td>商品名</td><td>製造元名</td><td>発売日</td>"
                            + "<td>仕入れ日</td><td>仕入れ価格</td><td>在庫数量</td><td>倉庫場所</td></tr>");                
                while(rs.next()){
                    out.println("<tr><td>" 
                        + rs.getString("itemID") +"</td>" 
                        +"<td align=\"center\">" + rs.getString("itemname") + "</td>" 
                        +"<td align=\"center\">" + rs.getString("maker.makername") + "</td>" );

                    if(rs.getString("itemrelease") != null){
                        out.println("<td>" +rs.getString("itemrelease") + "</td>" );
                    }else{
                        out.println("<td align=\"center\">--</td>");
                    }

                    if(rs.getString("itempurchase") != null){
                        out.println("<td>" + rs.getString("itempurchase") +"</td>");
                    }else{
                        out.println("<td align=\"center\">--</td>");
                    }

                    out.println(
                        "<td align=\"right\">" + rs.getString("cost") + "</td>"
                        + "<td align=\"right\">" + rs.getString("stock") +"</td>"
                        + "<td align=\"center\">" + rs.getString("warehouse.warehouseplace") + "</td></tr>"
                        );
                }
                out.print("</table><br>");
            }
            rs.close();
            ps.close();
            out.println("<a href=\"search.jsp\">検索画面に戻る</a>");
            out.println("</center>");
        }catch(SQLException e_sql){
            out.println(e_sql.toString()); 
        }catch(Exception e){
            out.println("接続時エラー");            
        }finally{
            try{
                if(con != null){ con.close(); }
            }catch(Exception e_con){
                System.out.println(e_con.getMessage());
            }        
        }
        
    out.close();
        
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

