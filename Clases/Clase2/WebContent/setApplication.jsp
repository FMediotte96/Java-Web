<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.Date"%>
<%
	String nombre = "Facundo";
	int edad = 24;
	Date fecha = new Date();
	application.setAttribute("nombre", nombre);
	application.setAttribute("edad", edad);
	application.setAttribute("fecha", fecha);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Application</title>
</head>
<body>
	<h1>Application!!!</h1>
</body>
</html>