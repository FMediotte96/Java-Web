<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%
	String nombre = (String) session.getAttribute("nombre");
	int edad = (Integer) session.getAttribute("edad");
	Date fecha = (Date) session.getAttribute("fecha");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Get Session</title>
</head>
<body>
	<h1><%= nombre %></h1>
	<h1><%= edad %></h1>
	<h1><%= fecha %></h1>
	<h1><%= session.getId() %></h1>
</body>
</html>