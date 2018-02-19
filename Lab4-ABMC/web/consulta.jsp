<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator" %>
<%@page import="entities.Alumno" %>
<%@page import="repositories.AlumnoR" %>
<%@page import="connectors.AdministradorDeConexiones" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="css/estilos.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
    <title>Administrador de Alumnos</title>
    </head>
    <body>

        <h1>Consulta de Alumnos</h1>
        <hr noshade color="#0000FF" size="3">
        <br>
        <form method="post" action="AlumnoServlet">
            Id: <input type="text" name="id" size="2"> 
            Nombre: <input type="text" name="nombre" size="10">
            Apellido: <input type="text" name="apellido" size="10">
            <input type="hidden" name="accion" value="consultar"/>
            <input type="submit" value="Buscar">
        </form>

        <form method="post" action="alta.jsp">
            <input type="submit" value="Ir a ventana Insertar">    
        </form>
        <hr>

        <table border="1">
            <tr background-color="blue">
            <th width="5%"><b>#</b></th>
            <th width="5%"><b>ID</b></th>
            <th width="30%"><b>NOMBRE</b></th>
            <th width="30%"><b>APELLIDO</b></th>
            <th width="30%"><b>ADMIN</b></th>
            </tr>
            
            <%  
                ArrayList alumnos = new ArrayList();
                if(request.getAttribute("losAlumnos") != null)
                    alumnos = (ArrayList) request.getAttribute("losAlumnos");
                else
                    alumnos = new AlumnoR(AdministradorDeConexiones.getConnection()).getAll();
                // Informa los alumnos si hay al menos uno
                if( alumnos.size() != 0  && alumnos !=null)
                {
                    // Variables
                    Iterator it = alumnos.iterator();
                    int contador = 0;

                    // Informa los datos de cada alumno
                    while( it.hasNext() )
                    {
                        contador++;
                        Alumno elAlumno = (Alumno) it.next();
            %>
            <tr>
                <td width="5%"><b><%=contador%>.</b></td>
                <td width="5%"><%=elAlumno.getId()%></td>
                <td width="30%"><%=elAlumno.getNombre()%></td>
                <td width="30%"><%=elAlumno.getApellido()%></td>
                <td width="30%">
                    <a href=AlumnoServlet?accion=modificar_init&id=<%=elAlumno.getId()%> >Modificar</a>
                    | 
                    <a href=AlumnoServlet?accion=eliminar&id=<%=elAlumno.getId()%> >Eliminar</a>
                </td>
            </tr>
            <%
                    }
                }
            %>
    
        </table>
        <p align=left>
        <b><%=alumnos.size()%></b> alumnos encontrado(s)
        </p>
    </body>
</html>