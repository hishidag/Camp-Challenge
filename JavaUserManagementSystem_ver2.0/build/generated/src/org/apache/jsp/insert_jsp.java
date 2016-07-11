package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;
import jums.JumsHelper;
import jums.UserDataBeans;

public final class insert_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');

    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataBeans udb = new UserDataBeans();
    boolean reinput = false;
    if(request.getParameter("mode") != null && request.getParameter("mode").equals("REINPUT") && hs.getAttribute("udb") != null){
        reinput = true;
        udb = (UserDataBeans)hs.getAttribute("udb");
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"ja\">\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://purecss.io/css/layouts/side-menu.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://yui.yahooapis.com/pure/0.6.0/pure-min.css\">\n");
      out.write("        <script src=\"/combo/1.18.13?/js/ui.js\"></script>\n");
      out.write("        <title>JUMS登録画面</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id =\"layout\">\n");
      out.write("        <a id=\"menuLink\" class=\"menu-link\" href=\"#menu\"><span></span></a>\n");
      out.write("    ");
      out.print(jh.menu());
      out.write("\n");
      out.write("        <div id=\"main\">\n");
      out.write("            <div align=\"center\">\n");
      out.write("                <h1>新規登録</h1>\n");
      out.write("        <form action=\"insertconfirm\" method=\"POST\">\n");
      out.write("        <table class=\"pure-table pure-table-horizontal\">\n");
      out.write("            <tr>\n");
      out.write("                <th>名前:</th>\n");
      out.write("                <td><input id=\"name\" type=\"text\" name=\"name\" value=\"");
 if(reinput){out.print(udb.getName());}
      out.write("\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <th>生年月日:</th>\n");
      out.write("                <td>");
      out.print(jh.getYearForm(reinput,udb.getYear()));
      out.write("\n");
      out.write("                    ");
      out.print(jh.getMonthForm(reinput,udb.getMonth()));
      out.write("\n");
      out.write("                    ");
      out.print(jh.getDayForm(reinput,udb.getDay()));
      out.write("\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <th>種別:</th>\n");
      out.write("                <td>");
      out.print(jh.getTypeForm(reinput,udb.getType()));
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <th>電話番号:</th>\n");
      out.write("                <td><input type=\"text\" name=\"tell\" value=\"");
 if(reinput){out.print(udb.getTell());}
      out.write("\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <th>自己紹介文</th>\n");
      out.write("                <td>\n");
      out.write("                    <textarea name=\"comment\" rows=10 cols=50 style=\"resize:none\" wrap=\"hard\">");
 if(reinput){out.print(udb.getComment());}
      out.write("</textarea><br><br>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("                <br>\n");
      out.write("        <input type=\"hidden\" name=\"ac\"  value=\"");
      out.print( hs.getAttribute("ac"));
      out.write("\">\n");
      out.write("        <input type=\"submit\" name=\"btnSubmit\" value=\"確認画面へ\">\n");
      out.write("        \n");
      out.write("    </form>\n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <div align=\"center\">\n");
      out.write("        ");
      out.print(jh.home());
      out.write("\n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
