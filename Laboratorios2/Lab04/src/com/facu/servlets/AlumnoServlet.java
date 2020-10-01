package com.facu.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facu.connector.AdministradorDeConexiones;
import com.facu.dao.AlumnoDAO;
import com.facu.entities.Alumno;

/**
 * Servlet implementation class AlumnoServlet
 */
@WebServlet("/AlumnoServlet")
public class AlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlumnoServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		AlumnoDAO alumnoDAO = new AlumnoDAO(AdministradorDeConexiones.getConnection());
		RequestDispatcher rd;

		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		Alumno alumno;
		
		//Parametros recibidos del jsp
		String parametro = request.getParameter("accion");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String idString = request.getParameter("id");
		int id = 0;
		
		switch (parametro) {
			case "alta":
				alumno = new Alumno();
				alumno.setNombre(nombre);
				alumno.setApellido(apellido);
				alumnoDAO.save(alumno);
				alumnos = alumnoDAO.getAll();
				break;
			case "eliminar":
				id = Integer.valueOf(request.getParameter("id"));
				alumnoDAO.delete(id);
				alumnos = alumnoDAO.getAll();
				break;
			case "consultar":
				if(idString != null && !idString.isEmpty()) {
					id = Integer.valueOf(request.getParameter("id"));
				}
				if(id != 0) {
					alumno = alumnoDAO.getById(id);
					alumnos.add(alumno);
				} else if(nombre != null && !nombre.isEmpty()) {
					alumnos = alumnoDAO.getByName(nombre);
				} else if(apellido != null && !apellido.isEmpty()) {
					alumnos = alumnoDAO.getByLastName(apellido);
				} else if((nombre.equals("") || nombre == null) && 
						(apellido.equals("") || apellido == null)) {
					alumnos = alumnoDAO.getAll();
				}
				break;
			case "modificar_init":
				id = Integer.valueOf(request.getParameter("id"));
				alumno = alumnoDAO.getById(id);
				request.setAttribute("elAlumno", alumno);
				rd = request.getRequestDispatcher("modificar.jsp");
				rd.forward(request, response);
				break;
			case "modificar":
				id = Integer.valueOf(request.getParameter("id"));
				alumno = new Alumno(id, nombre, apellido);
				alumnoDAO.update(alumno);
				alumnos = alumnoDAO.getAll();
				break;
			default:
				break;
		}
		
		if(!parametro.equals("modificar_init")) {
			request.setAttribute("losAlumnos", alumnos);
			rd = request.getRequestDispatcher("consulta.jsp");
			rd.forward(request, response);
		}
		
	}

}
