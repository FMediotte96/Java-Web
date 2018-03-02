package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Lab3-JavaScript</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Login de Usuario</h1>\n");
      out.write("        <hr>\n");
      out.write("        <form name=\"formulario\" method=\"post\" action=\"LoginServlet\" onsubmit=\"return validar()\">\n");
      out.write("            <label>Username: <input type=\"text\" name=\"user\" id=\"userID\"></label><br>\n");
      out.write("            <label>Password: <input type=\"password\" name=\"password\" id=\"passwordID\"></label><br>\n");
      out.write("            <label>Aceptar términos y condiciones <input type=\"checkbox\" name=\"check\" id=\"aceptar\"></label>\n");
      out.write("            <br><hr>\n");
      out.write("            <input type=\"submit\" value=\"Login\">\n");
      out.write("        </form>\n");
      out.write("        <script LANGUAGE=\"JavaScript\">\n");
      out.write("            function validar() {\n");
      out.write("                var username = document.getElementById(\"userID\");\n");
      out.write("                var password = document.getElementById(\"passwordID\");\n");
      out.write("                var aceptar = document.getElementById(\"aceptar\");\n");
      out.write("                if(username.value === \"\" || password.value === \"\") {\n");
      out.write("                    alert(\"Debe ingresar usuario y clave\");\n");
      out.write("                }else if(aceptar.checked){\n");
      out.write("                    return (true);  \n");
      out.write("                }else{\n");
      out.write("                    alert(\"Debe aceptar los terminos y condiciones\");                \n");
      out.write("                }\n");
      out.write("                return (false);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("        ");

            if(session.getAttribute("error") != null)
                out.println("<h3>"+session.getAttribute("error")+"<h3>");
        
      out.write("\n");
      out.write("        \n");
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
