<%-- 
    Document   : destino
    Created on : 14/02/2018, 02:13:43
    Author     : Facundo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Laboratorio 2</title>
    </head>
    <body>
        <div style="width: 400px; align-items: center; background-color: blue; color: white; border: 2px black">
        <h1>Datos Obtenidos</h1>
        <hr>
        <ul>
            <li><b>Nombre: </b> <%= request.getAttribute("nombre") %></li><br>
            <li><b>Apellido: </b> <%= request.getAttribute("apellido") %></li><br>
            <li><b>Dirección: </b> <%= request.getAttribute("direccion") %></li><br>
            <li><b>Sexo: </b> <%= request.getAttribute("sexo") %></li><br>
            <li><b>Puesto de trabajo: </b> <%= request.getAttribute("puesto") %></li><br> 
            <li><b>Tiene experiencia: </b> <%= request.getAttribute("experiencia") %></li><br>
        </ul>
        </div>
    </body>
</html>
