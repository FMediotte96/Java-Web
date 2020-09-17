<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date"%>

<%
	String nombre = "Facu";
	int edad = 24;
	Date fecha = new Date();
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<h1>Hola <%= nombre %></h1>
	Mi edad es: <b><%= edad %></b><br>
	<% for(int i=0;i<edad;i++) {%>
		<%= fecha %> <br>
	<%} %>
</body>
</html>