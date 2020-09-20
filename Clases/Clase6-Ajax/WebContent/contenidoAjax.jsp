<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 	String nombre = request.getParameter("nombre"); %>
<% 	String apellido = request.getParameter("apellido"); %>
Hola <%= nombre %> <%=apellido%>