/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3_1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lesson3_1.ProfileBean;

/**
 *
 * @author user1
 */
public class Profile extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    /*
    課題1:自分のプロフィール(名前、生年月日、自己紹介)を3行に分けて表示する
    ユーザー定義メソッドを作り、メソッドを10回呼び出して下さい
    */
    
    
       
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
        //javabeanのインスタンス作成
        ProfileBean pb = new ProfileBean();
        
        //フォワード先jspの文字列
        final String resultURL = "/WEB-INF/jsp/3_1result.jsp"; 
       
        request.setCharacterEncoding("UTF-8");
       
        //パラメータの取得
        String name = request.getParameter("name");
        String birth = request.getParameter("birth");
        String text = request.getParameter("text");
        
        //値のset
        pb.setName(name);
        pb.setBirth(birth);
        pb.setText(text);
        
       //リクエストスコープに属性、属性値をセット
       request.setAttribute("Data", pb);
       
       //RequestDispatcharによってフォワード
       RequestDispatcher rd = request.getRequestDispatcher(resultURL);
       rd.forward(request,response);
       
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
