<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Laboratorio 2</title>
</head>
<body>
	<div style="width: 400 px; align-items: center; background-color: blue; color: white; border: 2px black" >
		<h1>Datos Obtenidos</h1>
		<hr>
		<ul>
			<li><b>Nombre: </b> <%= request.getAttribute("nombre") %></li>
			<li><b>Apellido: </b> <%= request.getAttribute("apellido") %></li>
			<li><b>Dirección: </b> <%= request.getAttribute("direccion") %></li>
			<li><b>Sexo: </b> <%= request.getAttribute("sexo") %></li>
			<li><b>Puesto de trabajo: </b> <%= request.getAttribute("puesto") %></li>
			<li><b>Tiene experiencia: </b> <%= request.getAttribute("experiencia") %></li>
		</ul>
	</div>

</body>
</html>