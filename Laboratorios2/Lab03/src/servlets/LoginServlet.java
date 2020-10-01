package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		//Cargo una lista de usuarios hardcodeado
		ArrayList<User> usuarios = new ArrayList<User>();
		usuarios.add(new User("fmediotte", "1234", "Facundo", "Mediotte"));
		usuarios.add(new User("fmaceri", "1234", "Fernando", "Maceri"));
		usuarios.add(new User("locampo", "1234", "Lucas", "Ocampo"));
		
		//Leo lo que recibo de la vista
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		boolean existeUser = false;
		
		//Java 8 con stream
		User user = usuarios.stream().filter(u -> 
			u.getUsername().equals(username) && u.getPassword().equals(password)).findAny().orElse(null);
		
		if(user != null) {
			existeUser = true;
			session.setAttribute("error", "");
			session.setAttribute("user", user);
			response.sendRedirect("bienvenido.jsp");
		}
		
//		for(User user: usuarios) {
//			
//			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
//				existeUser = true;
//				session.setAttribute("error", "");
//				session.setAttribute("user", user);
//				response.sendRedirect("bienvenido.jsp");
//			}
//		}
		
		if(!existeUser) {
			session.setAttribute("error", "El usuario es invalido");
			response.sendRedirect("index.jsp");
		}
	}

}
