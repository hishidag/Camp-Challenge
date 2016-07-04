package jums;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * insertresultと対応するサーブレット
 * フォームから入力された値をセッション経由で受け取り、データベースにinsertする
 * 直接アクセスした場合はerror.jspに振り分け
 * @author hayashi-s
 */
public class InsertResult extends HttpServlet {

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
            //これの影響で結果ページが文字化け
            //PrintWriter out = response.getWriter();
        try{
            HttpSession session = request.getSession();
            request.setCharacterEncoding("UTF-8");//セッションに格納する文字コードをUTF-8に変更
            String accesschk = request.getParameter("ac1");
            //課題２
            if(accesschk ==null || (Integer)session.getAttribute("ac1")!=Integer.parseInt(accesschk)){
                    throw new Exception("不正なアクセスです");
            }
            
            UserDataBeans udb = (UserDataBeans)session.getAttribute("FormContents");                                             
            
            //ユーザー情報に対応したJavaBeansオブジェクトに格納していく
            UserDataDTO userdata = new UserDataDTO();
            userdata.setName(udb.getName());
            Calendar birthday = Calendar.getInstance();
            
            int birthdayYear = Integer.parseInt(udb.getYear());
            int birthdayMonth = Integer.parseInt(udb.getMonth()) - 1;
            int birthdayDay = Integer.parseInt(udb.getDay());            
            birthday.set(birthdayYear,birthdayMonth,birthdayDay,0,0,0);
            userdata.setBirthday(birthday.getTime());
            
            userdata.setType(Integer.parseInt(udb.getType()));
            userdata.setTell(udb.getTell());
            userdata.setComment(udb.getComment());

            //DBへデータの挿入
            UserDataDAO.getInstance().insert(userdata);
            request.getRequestDispatcher("/insertresult.jsp").forward(request,response);            
        }catch(SQLException e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }catch(Exception e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }finally{
            //out.close();
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
