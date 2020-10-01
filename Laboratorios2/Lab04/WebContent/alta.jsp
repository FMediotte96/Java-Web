<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Administrador de Alumnos</title>
</head>
<body>
	<h1>Alta de alumnos</h1>
	<hr noshade color="#0000FF" size="3">
	<br><br>
	
	<form action="AlumnoServlet" method="post">
		<input type="hidden" name="accion" value="alta" />
		<table>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre" size="20"></td>
			</tr>
			<tr>
				<td>Apellido:</td>
				<td><input type="text" name="apellido" size="20"></td>
			</tr>
		</table>
		<hr>
		<input type="submit" value="Dar de alta" name="Enviar">
	</form>
</body>
</html>