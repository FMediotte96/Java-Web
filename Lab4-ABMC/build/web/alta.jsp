<html>
    <head>
        <title>Administrador de Alumnos</title>
    </head>
    <body>
        <H1>Alta de Alumnos</H1>
        <hr noshade color="#0000FF" size="3"><BR>
        
        <BR>
        <form method="post" action="AlumnoServlet">
            <input type="hidden" name="accion" value="alta"/>
            <table>
                <tr>
                    <td>Nombre: </td>
                    <td><input type="text" name="nombre" size="20"> </td>
                </tr>
                <tr>
                    <td>Apellido: </td>
                    <td><input type="text" name="apellido" size="20"> </td>
                </tr>
            </table>
            <hr>  
            <input type="submit" value="Dar de alta" name="enviar" >
        </form>
    </body>
</html>