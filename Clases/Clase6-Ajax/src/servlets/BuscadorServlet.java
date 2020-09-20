package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Persona;
import repositories.PersonaDAO;

/**
 * Servlet implementation class BuscadorServlet
 */
@WebServlet("/BuscadorServlet")
public class BuscadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscadorServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String campoBuscador = request.getParameter("campoBuscador");
		PersonaDAO personDAO = new PersonaDAO();
		ArrayList<Persona> personas = personDAO.buscarPersonas(campoBuscador);
		request.setAttribute("personas", personas);
		request.getRequestDispatcher("resultadoBuscador.jsp").forward(request, response);
	}
	
	@Override
	public String getServletInfo() {
		return "Short descripción";
	}
}
