<%-- 
    Document   : index
    Created on : 23/02/2018
    Author     : Facundo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lab3-JavaScript</title>
    </head>
    <body>
        <h1>Login de Usuario</h1>
        <hr>
        <form name="formulario" method="post" action="LoginServlet" onsubmit="return validar()">
            <label>Username: <input type="text" name="user" id="userID"></label><br>
            <label>Password: <input type="password" name="password" id="passwordID"></label><br>
            <label>Aceptar términos y condiciones <input type="checkbox" name="check" id="aceptar"></label>
            <br><hr>
            <input type="submit" value="Login">
        </form>
        <script LANGUAGE="JavaScript">
            function validar() {
                var username = document.getElementById("userID");
                var password = document.getElementById("passwordID");
                var aceptar = document.getElementById("aceptar");
                if(username.value === "" || password.value === "") {
                    alert("Debe ingresar usuario y clave");
                }else if(aceptar.checked){
                    return (true);  
                }else{
                    alert("Debe aceptar los terminos y condiciones");                
                }
                return (false);
            }
            
        </script>
        <%
            if(session.getAttribute("error") != null)
                out.println("<h3>"+session.getAttribute("error")+"<h3>");
        %>
        
    </body>
</html>
