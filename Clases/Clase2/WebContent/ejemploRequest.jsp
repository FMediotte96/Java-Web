<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	String nombre = request.getParameter("nombre");
	String edad = request.getParameter("edad");
	if(edad != null) {
		int edadInt = Integer.parseInt(edad);
	}
	String host = request.getRemoteHost();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Request</title>
</head>
<body>
	<h1>Nombre: <%= nombre%></h1>
	<h1>Edad: <%= edad %></h1>
	<h1>Host: <%= host %></h1>
	<a href="ejemploRequest.jsp?nombre=Fer&edad=34">Ejemplo link con parametro nombre</a><br>
	<form method="post">
		Nombre: <input type="text" name="nombre">
		Edad: <input type="number" name="edad">
		<input type="submit" value="Enviar datos">
	</form>
</body>
</html>