<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>AJAX</title>
    </head>
    <body>
        <span>Seleccione nombre de usuario: </span>
        <input type="text" size="20" id="idUsuario" name="id" onkeyup="comienzo();">
        <span id="spanRespuesta"></span>
        <script type="text/javascript">
            function crearInstancia() {
                xmlhttp = null;
                if (window.XMLHttpRequest) {
                    xmlhttp = new XMLHttpRequest();
                } else {
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                return xmlhttp;

            }

            function comienzo() {

                var XMLRequest = crearInstancia();
                    XMLRequest.open("GET", "UsernameServlet?id=" + document.getElementById("idUsuario").value, false);
                    XMLRequest.onreadystatechange = cambiaEstado(XMLRequest);

            }

            function cambiaEstado(XMLRequest) {
                    
                if (XMLRequest.readyState === 1) {
                    XMLRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                    XMLRequest.send(null);
                }

                if (XMLRequest.readyState === 4) {
                    
                    var message = XMLRequest.responseText;
                    if ("true" === message) {
                        document.getElementById("spanRespuesta").style.color = "red";
                        document.getElementById("spanRespuesta").innerHTML = "Ese nombre de usuario ya existe";
                    } else {
                        document.getElementById("spanRespuesta").style.color = "green";
                        document.getElementById("spanRespuesta").innerHTML = "Nombre de usuario disponible";
                    }
                }
            }

        </script>
        
    </body>
</html>