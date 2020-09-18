<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.Date" %>
<%
	String nombre = (String) application.getAttribute("nombre");
	int edad = (Integer) application.getAttribute("edad");
	Date fecha = (Date) application.getAttribute("fecha");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Get Application</title>
</head>
<body>
	<h1><%= nombre %></h1>
	<h1><%= edad %></h1>
	<h1><%= fecha %></h1>
</body>
</html>