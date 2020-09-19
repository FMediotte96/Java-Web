package com.facu.servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facu.connector.AdministradorDeConexiones;
import com.facu.dao.UserDAO;
import com.facu.entities.User;

/**
 * Servlet implementation class AltaUsuarios
 */
@WebServlet("/AltaUsuarios")
public class AltaUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaUsuarios() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("CartelNoAltaUsuario.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Alta de usuario
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		if(username != null && email != null && password != null && password2 != null) {
			if(password.equals(password2)) {
				//Alta usando el DAO
				try{
					UserDAO userDAO = new UserDAO(AdministradorDeConexiones.getConnection());
					User user = new User(username, email, password);
					userDAO.save(user);
					if(user.getId() != 0) {
						response.sendRedirect("CartelAltaUsuario.jsp?id=" + user.getId());
					} else {
						response.sendRedirect("CartelNoAltaUsuario.jsp");
					}
				} catch (Exception e) {
					Logger.getLogger(AltaUsuarios.class.getName()).log(Level.SEVERE, null, e);
				}
				
			} else {
				response.sendRedirect("CartelNoAltaUsuario.jsp");
			}
		} else {
			response.sendRedirect("CartelNoAltaUsuario.jsp");
		}

	}

}
