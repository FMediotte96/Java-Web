<%@page import="com.facu.entities.Alumno"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	Alumno alumno = (Alumno) request.getAttribute("elAlumno");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Administrador de Alumnos</title>
</head>
<body>
	<h1>Modificar Alumno</h1>
	<hr noshade color="#0000FF" size="3"> 
	<br><br>
	
	<form method="post" action="AlumnoServlet">
		<input type="hidden" name="accion" value="modificar">
		<input type="hidden" name="id" value="<%=alumno.getId()%>">
		<table>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre" size="20" value='<%= alumno.getNombre()%>'></td>
			</tr>
			<tr>
				<td>Apellido:</td>
				<td><input type="text" name="apellido" size="20" value='<%= alumno.getApellido()%>'></td>
			</tr>
		</table>
		<hr>
		<input type="submit" value="Modificar" name="Enviar">
	</form>
</body>
</html>