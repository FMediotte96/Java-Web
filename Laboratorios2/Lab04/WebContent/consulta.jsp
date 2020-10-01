<%@page import="java.util.Iterator"%>
<%@page import="com.facu.connector.AdministradorDeConexiones"%>
<%@page import="com.facu.dao.AlumnoDAO"%>
<%@page import="com.facu.entities.Alumno"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Administrador de Alumnos</title>
	<link href="css/estilos.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<h1>Consulta de Alumnos</h1>
	<hr noshade color="#0000FF" size="3">
	<br>
	<form action="AlumnoServlet" method="post">
		Id: <input type="text" name="id" size="2">
		Nombre: <input type="text" name="nombre" size="10">
		Apellido: <input type="text" name="apellido" size="10">
		<input type="hidden" name="accion" value="consultar">
		<input type="submit" value="Buscar">
	</form>
	
	<form action="alta.jsp" method="post">
		<input type="submit" value="Ir a ventana Insertar">
	</form>
	<hr>
	
	<table border="1">
		<tr background="">
			<th width="5%"><b>#</b></th>
			<th width="5%"><b>ID</b></th>
			<th width="30%"><b>NOMBRE</b></th>
			<th width="30%"><b>APELLIDO</b></th>
			<th width="30%"><b>ADMIN</b></th>
		</tr>
		
		<%
			ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
			if(request.getAttribute("losAlumnos") != null) {
				alumnos = (ArrayList<Alumno>) request.getAttribute("losAlumnos");
			} else {
				alumnos = new AlumnoDAO(AdministradorDeConexiones.getConnection()).getAll();
			}
			
			if(alumnos.size() != 0 && alumnos != null) {
				//Variables
				Iterator<Alumno> it = alumnos.iterator();
				int contador = 0;
				
				//Informa los datos de cada alumno
				while(it.hasNext()) {
					contador++;
					Alumno elAlumno = (Alumno) it.next();
		%>
		<tr>
			<td width="5%"><b><%= contador%>.</b></td>
			<td width="5%"><b><%= elAlumno.getId() %></b></td>
			<td width="30%"><b><%= elAlumno.getNombre() %>.</b></td>
			<td width="30%"><b><%= elAlumno.getApellido() %>.</b></td>
			<td width="30%">
				<a href="AlumnoServlet?accion=modificar_init&id=<%=elAlumno.getId()%>"> >Modificar</a>
				|
				<a href="AlumnoServlet?accion=eliminar&id=<%=elAlumno.getId()%>"> >Eliminar</a>
			</td>
		</tr>
		<%
				}
			}
		%>
	</table>
	<p align="left">
		<b><%= alumnos.size() %></b> alumnos encontrado(s)
	</p>
</body>
</html>