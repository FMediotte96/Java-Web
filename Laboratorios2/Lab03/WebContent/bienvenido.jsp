<%@ page import="domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	User usuarioNuevo = (User) session.getAttribute("user");
	if(usuarioNuevo == null) {
%>
		<jsp:forward page="index.jsp"></jsp:forward>
<%	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Bienvenido</title>
</head>
<body>
	<h1>Bienvenido, <%= usuarioNuevo.getApellido() %>, <%= usuarioNuevo.getNombre() %></h1>
</body>
<a href="index.jsp" onclick="<% session.invalidate(); %>">Cerrar Sesión</a>
</html>