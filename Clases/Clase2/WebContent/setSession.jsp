<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%
	String nombre = "Facundo";
	int edad = 24;
	Date fecha = new Date();
	session.setAttribute("nombre", nombre);
	session.setAttribute("edad", edad);
	session.setAttribute("fecha", fecha);

	String sessionID = session.getId();
	Date fechaCreacion = new Date(session.getCreationTime());
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Session</title>
</head>
<body>
	<h1>Ya se creo la session!! <%= sessionID %> - <%= fechaCreacion %></h1>
</body>
</html>