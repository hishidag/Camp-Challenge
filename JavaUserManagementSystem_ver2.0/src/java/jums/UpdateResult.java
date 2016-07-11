package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class UpdateResult extends HttpServlet {

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
        
        try{
            request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更
            HttpSession hs = request.getSession(false);
            
            String accesschk = request.getParameter("uac"); 
            //Updateからの遷移ではないとき　||　ページの更新時　||　セッションから拾ってきた乱数とUpdateが渡した乱数が一致しないとき
            if(accesschk == null || hs.getAttribute("uac") == null||(Integer)hs.getAttribute("uac") != Integer.parseInt(accesschk)){ 
                throw new Exception("不正なアクセスです"); 
            }
            
            UserDataDTO udd = (UserDataDTO)hs.getAttribute("resultData");
            UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");
            udb.UD2DTOMapping(udd);
            
            UserDataDAO .getInstance().update(udd);
            
            request.setAttribute("updateData", udb);
            //検索語句をリクエストで渡す
            udb = (UserDataBeans)hs.getAttribute("search");
            request.setAttribute("search",udb);
            //セッション破棄
            hs.invalidate();

            request.getRequestDispatcher("/updateresult.jsp").forward(request, response);
        }catch(IllegalMonitorStateException e){
            request.setAttribute("error", "データベースへの接続に失敗しました");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }catch(SQLException e){
            request.setAttribute("error","データベースの操作に失敗しました");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);    
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
