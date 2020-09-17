<%-- 
    Document   : index
    Created on : 16/02/2018, 06:56:36
    Author     : Facundo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login de usuario!</h1>
        <hr>
        <h3> Ingrese usuario y contraseña: </h3>
        <form action="LoginServlet" method="post">
            <label>Usuario: <input type="text" name="username" required></label><br>
            <label>Contraseña: <input type="password" name="password" requited></label><br>
            <br><input type="submit" value="Loguearse">
        </form>
        <%
            if(session.getAttribute("error") != null) {
                out.println("<h3>" + session.getAttribute("error") +"</h3>");
            }
        %>
        
    </body>
</html>
