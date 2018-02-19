/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidades.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Facundo
 */
public class LoginServlet extends HttpServlet {

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
        //Carga de usuarios
        ArrayList<User> usuarios = new ArrayList<>();
        User usuario1 = new User("Facu96", "arjen10", "Facundo", "Mediotte");
        User usuario2 = new User("FerMaceri", "cr7", "Fernando", "Maceri");
        User usuario3 = new User("FPoroyan", "0401", "Fabiana", "Poroyan");
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        
        //Lectura de parametros
        String usuario = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        
        boolean encontro = false;
        for(int i = 0; i<usuarios.size(); i++){
            if(usuarios.get(i).getUsername().equals(usuario) &&
                    usuarios.get(i).getPassword().equals(password)) {
                encontro = true;
                session.setAttribute("error","");
                session.setAttribute("user", usuarios.get(i));
                response.sendRedirect("bienvenido.jsp");
            }
        }
        if(!encontro) {
            session.setAttribute("error", "El usuario es invalido");
            response.sendRedirect("index.jsp");
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
