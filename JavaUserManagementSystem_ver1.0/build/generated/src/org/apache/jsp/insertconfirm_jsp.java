package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;
import jums.JumsHelper;
import jums.UserDataBeans;
import jums.CheckCharacter;

public final class insertconfirm_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    HttpSession hs = request.getSession();
    //課題７
    hs.setMaxInactiveInterval(60 * 3);
    UserDataBeans udb = new UserDataBeans();
    if(hs.getAttribute("FormContents") != null){
        udb = (UserDataBeans)hs.getAttribute("FormContents");
    }
    CheckCharacter cc = new CheckCharacter();

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JUMS登録確認画面</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <center>\n");
      out.write("        <h1>登録確認</h1>\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <th align=\"right\">名前:</th>\n");
      out.write("                <td width=\"280px\">");
      out.print( udb.getName());
      out.write("</td>\n");
      out.write("                <td width=\"170px\">");
      out.print( cc.checkCharacter(udb.getName()));
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <th align=\"right\">生年月日:</th>\n");
      out.write("                <td>");
      out.print( udb.getYear() +"年"+udb.getMonth()+"月"+ udb.getDay() +"日");
      out.write("</td>\n");
      out.write("                <td>");
      out.print( "年:" + cc.checkNumber(udb.getYear()));
      out.write("<br>\n");
      out.write("                    ");
      out.print( "月:" + cc.checkNumber(udb.getMonth()));
      out.write("<br>\n");
      out.write("                    ");
      out.print( "日:" + cc.checkNumber(udb.getDay()));
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <th align=\"right\">種別:</th>\n");
      out.write("                <td>");
if("1".equals(udb.getType())){
      out.write("エンジニア");
}
      out.write("\n");
      out.write("                    ");
if("2".equals(udb.getType())){
      out.write('営');
      out.write('業');
}
      out.write("\n");
      out.write("                    ");
if("3".equals(udb.getType())){
      out.write("その他");
}
      out.write("</td>\n");
      out.write("                <td>");
      out.print( cc.checkNumber(udb.getType()));
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <th align=\"right\">電話番号:</th>\n");
      out.write("                <td>");
      out.print( udb.getTell());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( cc.checkTell(udb.getTell()));
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <th align=\"right\">自己紹介:</th>\n");
      out.write("                <td>");
      out.print( udb.getComment());
      out.write("</td>\n");
      out.write("                <td></td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        ");
if(cc.isAllCheck){
      out.write("\n");
      out.write("        上記の内容で登録します。よろしいですか？\n");
      out.write("        <form action=\"insertresult\" method=\"POST\">\n");
      out.write("            <input type=\"hidden\" name=\"ac1\" value=\"");
      out.print( hs.getAttribute("ac1"));
      out.write("\">\n");
      out.write("            <input type=\"submit\" name=\"yes\" value=\"はい\">\n");
      out.write("        </form>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        <form action=\"insert\" method=\"POST\">\n");
      out.write("            <input type=\"submit\" name=\"no\" value=\"登録画面に戻る\">\n");
      out.write("        </form>\n");
      out.write("    <br>\n");
      out.write("    ");
      out.write("\n");
      out.write("    ");
      out.print(JumsHelper.getInstance().home());
      out.write("\n");
      out.write("    </center>\n");
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
