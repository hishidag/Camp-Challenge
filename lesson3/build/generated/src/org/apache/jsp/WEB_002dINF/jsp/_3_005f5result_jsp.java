package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import lesson3_5.lesson3_5Bean;
import java.util.*;

public final class _3_005f5result_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>住所等表示</title>\n");
      out.write("    </head>\n");
      out.write("    <body>        \n");
      out.write("        ");
             
           lesson3_5Bean lb = (lesson3_5Bean)request.getAttribute("Data");
           //idを引数に入れるとMapにそのidをkeyとしたSetを取り出せる
           Set set = lb.getSet(20);
           //Setはイテレータによってしか取り出せない
           Iterator it = set.iterator();             
        
      out.write("\n");
      out.write("        \n");
      out.write("        名前：");
 out.println(it.next()); 
      out.write("<br>\n");
      out.write("        生年月日：");
 out.println(it.next()); 
      out.write("<br>\n");
      out.write("        住所：");
 out.println(it.next()); 
      out.write("<br><br>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");
            
            Integer limit = 2;
            HashMap<Integer,Set> map = lb.getMap();
            ArrayList<Map> array = new ArrayList();
            array.add(map);
            int i = 1;
            //MapからSetすべて取得     
            
            for(Integer key : map.keySet()){
                //limit+1番目にbreakだけすることにして、limitの人数だけとりだす                    
                if( i == limit + 1 ){
                    break;
                }
                Set set1 = map.get(key);
                //Setの値すべて取得、変数oはSetの要素をさせている
                for(Object o : set1){
                    if(o == null){
                        continue;                    
                    }                    
                    out.println(o + "<br>");
                }
                //見易さのため
                out.println("<br>");
                i++;
            }          
            
              
        
      out.write("\n");
      out.write("                     \n");
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
