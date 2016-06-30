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
import javax.servlet.http.HttpSession;

/**
 *
 * @author user1
 */
public class tourokucheck extends HttpServlet {
    public String itemID             = "";
    public String itemName           = "";
    public String makerID            = "";
    public String itemReleaseYear    = "";
    public String itemReleaseMonth   = "";
    public String itemReleaseDay     = "";
    public String itemPurchaseYear   = "";
    public String itemPurchaseMonth  = "";
    public String itemPurchaseDay    = "";
    public String cost               = "";
    public String stock              = "";
    public String warehouseID        = "";
    public static Boolean match = true;
    public String perror = "";
    
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
        itemID              =escapeHTML(request.getParameter("itemID"));
        itemName            =escapeHTML(request.getParameter("itemName"));
        makerID             =escapeHTML(request.getParameter("makerID"));
        itemReleaseYear     =escapeHTML(request.getParameter("itemReleaseYear"));
        itemReleaseMonth    =escapeHTML(request.getParameter("itemReleaseMonth"));
        itemReleaseDay      =escapeHTML(request.getParameter("itemReleaseDay"));
        itemPurchaseYear    =escapeHTML(request.getParameter("itemPurchaseYear"));
        itemPurchaseMonth   =escapeHTML(request.getParameter("itemPurchaseMonth"));
        itemPurchaseDay     =escapeHTML(request.getParameter("itemPurchaseDay"));
        cost                =escapeHTML(request.getParameter("cost"));
        stock               =escapeHTML(request.getParameter("stock"));
        warehouseID         =escapeHTML(request.getParameter("warehouseID"));
        
        request.setAttribute("itemID",itemID);
        request.setAttribute("itemName",itemName);
        request.setAttribute("makerID",makerID);
        request.setAttribute("itemReleaseYear",itemReleaseYear);
        request.setAttribute("itemReleaseMonth",itemReleaseMonth);
        request.setAttribute("itemReleaseDay",itemReleaseDay);
        request.setAttribute("itemPurchaseYear",itemPurchaseYear);
        request.setAttribute("itemPurchaseMonth",itemPurchaseMonth);
        request.setAttribute("itemPurchaseDay",itemPurchaseDay);
        request.setAttribute("cost",cost);
        request.setAttribute("stock",stock);
        request.setAttribute("warehouseID",warehouseID);
        
        request.getRequestDispatcher("tourokucheck.jsp").forward(request, response);
     
    }
public void testSession(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    HttpSession hs = request.getSession(false);
    if(hs == null || hs.getAttribute("login") == null){            
        response.sendRedirect("loginerror.jsp");
    }else if("tennin".equals(hs.getAttribute("auth"))){
        response.sendRedirect("autherror.jsp");
    }else{        
    if("1".equals(hs.getAttribute("primarykeyerror"))){
        perror = "<font color = \"red\">itemIDが重複しています!!!</font>";
        isAllMatch(false);
        }else{
        isAllMatch(true);
    }
    }
}
        
public String escapeHTML(String val) {
        if (val == null) {return "";}        
        val = val.replaceAll("&", "&amp;");
        val = val.replaceAll("<", "&lt;");
        val = val.replaceAll(">", "&gt;");
        val = val.replaceAll("\"", "&quot;");
        val = val.replaceAll("'", "&apos;");
        //val = val.replaceAll("&", "&amp;");
        return val;
    }

public static Boolean isMatchParameter(String val) {        
        if(val == null || "".equals(val)) {
            isAllMatch(false);
            return false;
        }              
        return true;
    }

public static void isAllMatch(Boolean flag) {        
        if(flag){ 
            match = true; 
        }else{
            match = false;
        }        
    }

public static String setMatchString(Boolean flag) {
        if(!flag) {return "<font color = \"red\">修正してください!!!</font>";}
        return "<font color = \"blue\">OK!</font>";
    }

public static String setMAIM(Object o){
    String str = "";
    if(o != null){
        str = o.toString();
    }
    return setMatchString(isMatchParameter(str));
}

public void setSession(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
    HttpSession hs = request.getSession(false);
    hs.setMaxInactiveInterval(60*60);
    hs.setAttribute("itemID",               request.getAttribute("itemID"));
    hs.setAttribute("itemName",             request.getAttribute("itemName"));
    hs.setAttribute("makerID",              request.getAttribute("makerID"));
    hs.setAttribute("itemReleaseYear",      request.getAttribute("itemReleaseYear"));
    hs.setAttribute("itemReleaseMonth",     request.getAttribute("itemReleaseMonth"));
    hs.setAttribute("itemReleaseDay",       request.getAttribute("itemReleaseDay"));
    hs.setAttribute("itemPurchaseYear",     request.getAttribute("itemPurchaseYear"));
    hs.setAttribute("itemPurchaseMonth",    request.getAttribute("itemPurchaseMonth"));
    hs.setAttribute("itemPurchaseDay",      request.getAttribute("itemPurchaseDay"));
    hs.setAttribute("cost",                 request.getAttribute("cost"));
    hs.setAttribute("stock",                request.getAttribute("stock"));
    hs.setAttribute("warehouseID",          request.getAttribute("warehouseID"));
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
