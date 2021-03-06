package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jums.JumsHelper;
import jums.UserDataBeans;

public final class deleteresult_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

JumsHelper jh = JumsHelper.getInstance();
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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write('\n');
 
    UserDataBeans udb = new UserDataBeans();
    if(request.getAttribute("search") !=null){
        udb = (UserDataBeans)request.getAttribute("search");
    }

      out.write("\n");
      out.write("<html lang=\"ja\">\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"http://purecss.io/css/layouts/side-menu.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"http://yui.yahooapis.com/pure/0.6.0/pure-min.css\">\n");
      out.write("    <title>削除結果</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div id =\"layout\">\n");
      out.write("    ");
      out.print(jh.menu());
      out.write("\n");
      out.write("    <div id=\"main\" align=\"center\">\n");
      out.write("    <h1>削除確認</h1>\n");
      out.write("    削除しました。<br>\n");
      out.write("    <br>\n");
      out.write("    ");
      out.print(jh.searchresult(udb.getName(),udb.getYear(),udb.getType()));
      out.write("\n");
      out.write("    ");
      out.print(jh.home());
      out.write("\n");
      out.write("    </div>\n");
      out.write("    </div>\n");
      out.write("    </body>    \n");
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
