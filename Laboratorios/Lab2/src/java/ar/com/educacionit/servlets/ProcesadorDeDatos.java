/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Facundo
 */
public class ProcesadorDeDatos extends HttpServlet {

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
        // Establece el tipo de contenido y obtiene la salida


        // Obtiene los datos del formulario
        // Obtiene el nombre
        String nombre =  request.getParameter("nombre");
        request.setAttribute("nombre", nombre);

        // Obtiene el apellido
        String apellido =  request.getParameter("apellido");
        request.setAttribute("apellido", apellido);

        // Obtiene la dirección
        String direccion =  request.getParameter("direccion");
        request.setAttribute("direccion", direccion);

        // Obtiene el sexo
        String sexo =  request.getParameter("sexo");
        request.setAttribute("sexo", sexo);

        // Obtiene el puesto de trabajo
        String puestoDeTrabajo =  request.getParameter("puesto");
        request.setAttribute("puesto", puestoDeTrabajo);

        // Obtiene si tiene experiencia
        String tieneExperiencia = request.getParameter("experiencia");
        
        if (tieneExperiencia == null) {
            request.setAttribute("experiencia", "No");
        } else{
            request.setAttribute("experiencia", "Si");
        }
        
        request.getRequestDispatcher("/destino.jsp").forward(request, response);
        
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
