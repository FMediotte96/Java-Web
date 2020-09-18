<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="com.facu.connector.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Alta de Usuarios</title>
</head>
<body>
	<h1>Formulario de usuarios</h1>
	<form method="post">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username" required></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" required></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" required></td>
			</tr>
			<tr>
				<td>Pass Confirm:</td>
				<td><input type="password" name="password2" required></td>
			</tr>
			
			<tr>
				<td><input type="reset" value="limpiar"></td>
				<td><input type="submit" value="crear"></td>
			</tr>
		</table>
	</form>
	
	<% 
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		if(username != null && email != null && password != null && password2 != null) {
			if(password.equals(password2)) {
				String sql = "insert into users (username,email,password) values (?,?,?)";
				try{
					PreparedStatement ps = AdministradorDeConexiones.getConnection()
								.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, username);
					ps.setString(2, email);
					ps.setString(3, password);
					ps.execute();
					
					ResultSet rs = ps.getGeneratedKeys();
					if(rs.next()) {
						int id = rs.getInt(1);
						out.println("<h3>Se dio de alta el usuario id: " + id + ".</h3>");
					}
					
				} catch(Exception e) {
					out.println("<h3>No se puede dar de alta.</h3>");
				}
			} else {
				out.println("<h3>No coinciden las claves</h3>");
			}
		} else {
			out.println("<h3>Faltan ingresar campos</h3>");
		}
	%>
	<!-- Listado de usuarios -->
	<form>
		Buscar Username:<input type="text" name="buscarUser" />
		<input type="submit" value="buscar">
		<%
			String query = "select * from users";
			String buscarApe = request.getParameter("buscarUser");
			if(buscarApe != null && !buscarApe.isEmpty()) {
				query = "select * from users where username like '%" + buscarApe + "%'";
			}
			
			ResultSet rs = AdministradorDeConexiones.getConnection().createStatement().executeQuery(query);
			out.println("<table border=1>");
			out.println("<tr><th>Id</th><th>Username</th><th>email</th></tr>");
			while(rs.next()) { 
				out.println("<tr>");
				out.println("<td>" + rs.getInt("id") + "</td>");
				out.println("<td>" + rs.getString("username") + "</td>");
				out.println("<td>" + rs.getString("email") + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		%>
	</form>
</body>
</html>