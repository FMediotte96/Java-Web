<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.facu.connector.AdministradorDeConexiones"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.facu.html.Html"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<% out.println(Html.head("Formulario de alumnos")); %>
<body>
	<%
		//Alta de Usuario
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		if(username != null && email != null && password != null && password2 != null) {
			if(password.equals(password2)) {
				String sql = "insert into users (username,email,password) values (?,?,?)";
				try {
					PreparedStatement ps = AdministradorDeConexiones.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, username);
					ps.setString(2, email);
					ps.setString(3, password);
					ps.execute();
					
					ResultSet rs = ps.getGeneratedKeys();
					if(rs.next()) {
						int id = rs.getInt(1);
						out.println("<h3>Se dio de alta el usuario id: "+id+".</h3>");
					}
				} catch (Exception e) {
					out.println("<h3>No se puede dar de alta.</h3>");
				}
			} else {
				out.println("<h3>No coinciden las claves.</h3>");
			}
		} else {
			out.println("<h3>Faltan ingresas campos.</h3>");
		}
		
		out.println(Html.volver("usuarios2.jsp"));
	%>
</body>
</html>