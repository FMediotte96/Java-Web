<!DOCTYPE>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LAB6</title>
        <script src="js/libs/jquery/jquery.js" type="text/javascript"></script>
    </head>
    <body>
        Seleccione nombre de usuario: <input type="text" size="20" name="user" id="idUsuario">
        <span id="spanRespuesta"></span>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#idUsuario').keyup(function () {
                    $.ajax({
                        url: 'ValidadorUsuario',
                        dataType: 'html',
                        data: {
                            id: $('#idUsuario').val()
                        },
                        success: function(responseText) {
                            if(responseText === "true") {
                                $('#spanRespuesta').css('color','red');
                                $('#spanRespuesta').html("Ese nombre de usuario ya existe");
                            }else {
                                $('#spanRespuesta').css('color','green');
                                $('#spanRespuesta').html("Nombre de usuario disponible");
                            }
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            alert(textStatus+errorThrown);
                        }
                    });
                });
            });
        </script>
    </body>
</html>
