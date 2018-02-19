<%-- 
    Document   : bienvenido
    Created on : 16/02/2018, 07:18:03
    Author     : Facundo
--%>

<%@page import="entidades.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User usuarioNuevo = (User)session.getAttribute("user");
    if(usuarioNuevo == null) {
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido, <%= usuarioNuevo.getApellido()%>, <%= usuarioNuevo.getNombre()%></h1>
    </body>
    <a href="index.jsp" onclick="<%session.invalidate();%>">Logout</a>
</html>
