/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import connectors.AdministradorDeConexiones;
import entities.Alumno;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositories.AlumnoR;

/**
 *
 * @author Facundo
 */
public class AlumnoServlet extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        AlumnoR ar = new AlumnoR(AdministradorDeConexiones.getConnection());
        String parametro = request.getParameter("accion");
        switch (parametro) {
            case "alta":
                {
                    Alumno alumno = new Alumno();
                    String nombre = request.getParameter("nombre");
                    String apellido = request.getParameter("apellido");
                    alumno.setNombre(nombre);
                    alumno.setApellido(apellido);
                    ar.save(alumno);
                    ArrayList alumnos = ar.getAll();
                    request.setAttribute("losAlumnos", alumnos);
                    RequestDispatcher rd = request.getRequestDispatcher("consulta.jsp");
                    rd.forward(request, response);
                    break;
                }
            case "eliminar":
                try {
                    int id = Integer.valueOf(request.getParameter("id"));
                    ar.eliminar(id);
                    ArrayList alumnos = ar.getAll();
                    request.setAttribute("losAlumnos", alumnos);
                    RequestDispatcher rd = request.getRequestDispatcher("consulta.jsp");
                    rd.forward(request, response);
                } catch (SQLException ex) {
                    System.out.println(ex);
                }   break;
            case "consultar":
                {
                    ArrayList<Alumno> alumnos = new ArrayList();
                    String nombre = request.getParameter("nombre");
                    String apellido = request.getParameter("apellido");
                    String idString = request.getParameter("id");
                    int id = 0;
                    if(idString != null && !idString.isEmpty())
                        id = Integer.valueOf(request.getParameter("id"));
                    if(id!=0) {
                        Alumno alumno = ar.getById(id);
                        alumnos.add(alumno);
                    }else if(nombre != null && !nombre.isEmpty()) {
                        alumnos = ar.getByName(nombre);
                    }else if(apellido != null && !apellido.isEmpty()) {
                        alumnos = ar.getByApellido(apellido);
                    }else if((nombre.equals("") || nombre == null) && 
                            (apellido.equals("") || apellido ==null)){
                        alumnos = ar.getAll();
                    }      
                    request.setAttribute("losAlumnos", alumnos);
                    RequestDispatcher rd = request.getRequestDispatcher("consulta.jsp");
                    rd.forward(request, response);
                    break;
                }
            case "modificar_init":
                try {
                    int id = Integer.valueOf(request.getParameter("id"));
                    Alumno alumno = ar.getById(id);
                    request.setAttribute("elAlumno", alumno);
                    RequestDispatcher rd = request.getRequestDispatcher("modificar.jsp");
                    rd.forward(request, response);
                } catch (SQLException ex) {
                    System.out.println(ex);
                }   break;
            case "modificar":
                {
                    int id = Integer.valueOf(request.getParameter("id"));
                    String nombre = request.getParameter("nombre");
                    String apellido = request.getParameter("apellido");
                    Alumno alumno = new Alumno(id, nombre, apellido);
                    ar.update(alumno);
                    ArrayList alumnos = ar.getAll();
                    request.setAttribute("losAlumnos", alumnos);
                    RequestDispatcher rd = request.getRequestDispatcher("consulta.jsp");
                    rd.forward(request, response);
                    break;
                }
            default:
                break;
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
