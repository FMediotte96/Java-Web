package com.facu.html;

import java.sql.ResultSet;
import java.util.List;

import com.facu.connector.AdministradorDeConexiones;
import com.facu.dao.UserDAO;
import com.facu.entities.User;

public class Html {

	public static String volver(String url) { 
		return "<form action=" + url + ">\n" + 
				"<input type=submit value=volver />\n" + 
				"</form>";
	}
	
	public static String head(String title) { 
		return "<head>\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" + 
				"<title>" + title + "</title>\n" + 
				"</head>";
	}
	
	public static String listarUsuarios(String username) { 
		String retorno = "";
		String query = "select * from users";
		if(username != null && !username.isEmpty()) { 
			query = "select * from users where username like '%" + username + "%'";
		}
		
		try {
			ResultSet rs = AdministradorDeConexiones.getConnection().createStatement().executeQuery(query);
			retorno += "<table border=1>";
			retorno += "<tr><th>Id</th><th>Username</th><th>email</th></tr>";
			
			while(rs.next()) {
				retorno += "<tr>";
				retorno += "<td>" + rs.getInt("id") + "</td>";
				retorno += "<td>" + rs.getString("username") + "</td>";
				retorno += "<td>" + rs.getString("email") + "</td>";
				retorno += "</tr>";
			}
			retorno+="</table>";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	public static String listarUsuarios2(String buscarApe) {
		//Este método usa el repositorio DAO
		List<User> lista;
		if(buscarApe == null || buscarApe.isEmpty()) { 
			lista = new UserDAO(AdministradorDeConexiones.getConnection()).getAll();
		} else {
			lista = new UserDAO(AdministradorDeConexiones.getConnection()).getLikeUsername(buscarApe);
		}
		
		String retorno = "";
		retorno += "<table border=1>";
		retorno += "<tr><th>Id</th><th>Username</th><th>Email</th></tr>";
		for(User user: lista) {
			retorno += "<tr>";
			retorno += "<td>" + user.getId() + "</td>";
			retorno += "<td>" + user.getUsername() + "</td>";
			retorno += "<td>" + user.getEmail() + "</td>";
			retorno += "</tr>";
		}
		retorno += "</table>";
		return retorno;
	}
	
}
