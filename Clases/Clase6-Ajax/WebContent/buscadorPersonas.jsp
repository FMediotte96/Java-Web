<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Buscador Personas</title>
	<script type="text/javascript" src="js/libs/jquery/jquery.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#botonBuscar').on('click', function(){
				var campos = $('#formBuscar').serialize();
				$.post('BuscadorServlet', campos, function(resp){
					$('#resultadoBuscador').html(resp);
				})
			});
		});
	</script>
</head>
<body>
	<h1>Buscador de Personas....</h1>
	<form id="formBuscar">
		<input name="campoBuscador" placeholder="Texto a buscar...">
		<button type="button" id="botonBuscar">Buscar</button>
	</form>
	<div id="resultadoBuscador">
	</div>

</body>
</html>