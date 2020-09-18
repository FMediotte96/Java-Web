<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="domain.*" %>
<%
	Persona p1 = new Persona();
	p1.setNombre("Facu");
	p1.setApellido("Mediotte");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Persona</title>
</head>
<body>
	<h1><%= p1.getNombre() %></h1>
	<h1><%= p1.getApellido() %></h1>
</body>
</html>