package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.Iterator;
import entities.Alumno;
import repositories.AlumnoR;
import connectors.AdministradorDeConexiones;

public final class consulta_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<link href=\"css/estilos.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("    <title>Administrador de Alumnos</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <h1>Consulta de Alumnos</h1>\n");
      out.write("        <hr noshade color=\"#0000FF\" size=\"3\">\n");
      out.write("        <br>\n");
      out.write("        <form method=\"post\" action=\"AlumnoServlet\">\n");
      out.write("            Id: <input type=\"text\" name=\"id\" size=\"2\"> \n");
      out.write("            Nombre: <input type=\"text\" name=\"nombre\" size=\"10\">\n");
      out.write("            Apellido: <input type=\"text\" name=\"apellido\" size=\"10\">\n");
      out.write("            <input type=\"hidden\" name=\"accion\" value=\"consultar\"/>\n");
      out.write("            <input type=\"submit\" value=\"Buscar\">\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <form method=\"post\" action=\"alta.jsp\">\n");
      out.write("            <input type=\"submit\" value=\"Ir a ventana Insertar\">    \n");
      out.write("        </form>\n");
      out.write("        <hr>\n");
      out.write("\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr background-color=\"blue\">\n");
      out.write("            <th width=\"5%\"><b>#</b></th>\n");
      out.write("            <th width=\"5%\"><b>ID</b></th>\n");
      out.write("            <th width=\"30%\"><b>NOMBRE</b></th>\n");
      out.write("            <th width=\"30%\"><b>APELLIDO</b></th>\n");
      out.write("            <th width=\"30%\"><b>ADMIN</b></th>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            ");
  
                ArrayList alumnos = new ArrayList();
                if(request.getAttribute("losAlumnos") != null)
                    alumnos = (ArrayList) request.getAttribute("losAlumnos");
                else
                    alumnos = new AlumnoR(AdministradorDeConexiones.getConnection()).getAll();
                // Informa los alumnos si hay al menos uno
                if( alumnos.size() != 0  && alumnos !=null)
                {
                    // Variables
                    Iterator it = alumnos.iterator();
                    int contador = 0;

                    // Informa los datos de cada alumno
                    while( it.hasNext() )
                    {
                        contador++;
                        Alumno elAlumno = (Alumno) it.next();
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td width=\"5%\"><b>");
      out.print(contador);
      out.write(".</b></td>\n");
      out.write("                <td width=\"5%\">");
      out.print(elAlumno.getId());
      out.write("</td>\n");
      out.write("                <td width=\"30%\">");
      out.print(elAlumno.getNombre());
      out.write("</td>\n");
      out.write("                <td width=\"30%\">");
      out.print(elAlumno.getApellido());
      out.write("</td>\n");
      out.write("                <td width=\"30%\">\n");
      out.write("                    <a href=AlumnoServlet?accion=modificar_init&id=");
      out.print(elAlumno.getId());
      out.write(" >Modificar</a>\n");
      out.write("                    | \n");
      out.write("                    <a href=AlumnoServlet?accion=eliminar&id=");
      out.print(elAlumno.getId());
      out.write(" >Eliminar</a>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                    }
                }
            
      out.write("\n");
      out.write("    \n");
      out.write("        </table>\n");
      out.write("        <p align=left>\n");
      out.write("        <b>");
      out.print(alumnos.size());
      out.write("</b> alumnos encontrado(s)\n");
      out.write("        </p>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
