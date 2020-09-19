<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.facu.html.*"%>
<!DOCTYPE html>
<html>
<% out.println(Html.head("Formulario de alumnos")); %>
<body>
	<h1>Se dio de alta un usuario</h1>
	<%
		String id = request.getParameter("id");
		if(id != null && id != "") {
			out.println("id=" + id);
		}
	%>
	<% out.println(Html.volver("usuarios3.jsp")); %>
</body>
</html>