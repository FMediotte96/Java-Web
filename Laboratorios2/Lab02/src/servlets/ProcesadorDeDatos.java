package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcesadorDeDatos
 */
@WebServlet("/ProcesadorDeDatos")
public class ProcesadorDeDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesadorDeDatos() {
        super();
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
		//Obtener los datos del formulario
		String nombre = request.getParameter("nombre");
		request.setAttribute("nombre", nombre);
		
		String apellido = request.getParameter("apellido");
		request.setAttribute("apellido", apellido);
		
		String direccion = request.getParameter("direccion");
		request.setAttribute("direccion", direccion);
	
		String sexo = request.getParameter("sexo");
		request.setAttribute("sexo", sexo);
		
		String puestoDeTrabajo = request.getParameter("puesto");
		request.setAttribute("puesto", puestoDeTrabajo);

		String tieneExperiencia = request.getParameter("experiencia");
		
		if(tieneExperiencia == null) {
			request.setAttribute("experiencia", "No");
		} else {
			request.setAttribute("experiencia", "Si");
		}
		
		request.getRequestDispatcher("/destino.jsp").forward(request, response);
	}

}
