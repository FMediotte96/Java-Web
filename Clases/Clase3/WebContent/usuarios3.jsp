<%@page import="com.facu.html.Html"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<% out.println(Html.head("Formulario de alumnos")); %>
<body>
	<h1>Formulario de usuarios</h1>
	<form method="post" action="AltaUsuarios">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username" required></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" required></td>
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
	
	<!-- Muestra el listado de usuarios -->
	<form>
		Buscar Username: <input type="text" name="buscarUser"/>
		<input type="submit" value="buscar">
	</form>
	<% //out.println(Html.listarUsuarios(request.getParameter("buscarUser")));
		out.println(Html.listarUsuarios2(request.getParameter("buscarUser")));
	%>
</body>
</html>