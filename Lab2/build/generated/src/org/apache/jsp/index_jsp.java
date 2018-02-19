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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Laboratorio 2</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div align=\"center\" style=\"width: 400px; align-items: center; background-color: blue; color: white; border: 2px black\">\r\n");
      out.write("        <h1>Formulario de inscripción</h1>\r\n");
      out.write("        <hr>\r\n");
      out.write("        <form action=\"ProcesadorDeDatos\" method=\"post\">\r\n");
      out.write("            <label>Nombre: <input type=\"text\" name=\"nombre\"></label><br>\r\n");
      out.write("            <label>Apellido: <input type=\"text\" name=\"apellido\"></label><br>\r\n");
      out.write("            <label>Dirección: <input type=\"text\" name=\"direccion\"></label><br>\r\n");
      out.write("            <label>Sexo: \r\n");
      out.write("            <label>Masculino <input type=\"radio\" value=\"masculino\" name=\"sexo\"></label>\r\n");
      out.write("            <label>Femenino <input type=\"radio\" value=\"femenino\" name=\"sexo\"></label>\r\n");
      out.write("            </label><br>\r\n");
      out.write("            <label>Puesto de trabajo: \r\n");
      out.write("                <select name=\"puesto\">\r\n");
      out.write("                    <option value=\"programador\">Programador</option>\r\n");
      out.write("                    <option value=\"disenador\">Diseñador</option>\r\n");
      out.write("                    <option value=\"analista\">Analista Funcional</option>\r\n");
      out.write("                    <option value=\"lider\">Lider de Proyecto</option>\r\n");
      out.write("                </select>\r\n");
      out.write("            </label><br>\r\n");
      out.write("            <label>Tiene experiencia <input type=\"checkbox\" value=\"true\" name=\"experiencia\"></label>\r\n");
      out.write("            <br><br><hr>\r\n");
      out.write("            <button type=\"submit\">Registrarme!</button>\r\n");
      out.write("        </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
