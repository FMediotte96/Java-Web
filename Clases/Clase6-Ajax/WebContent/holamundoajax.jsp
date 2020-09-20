<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSP AJAX</title>
	<script src="js/libs/jquery/jquery.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#buttonAjax').on('click', function(){
				var campos = $('#miForm').serialize();
				$.post('contenidoAjax.jsp', campos, function(resp){
					$('#miDiv').html(resp);
				})
			})
		});
	</script>
</head>
<body>
	<form id="miForm">
		Nombre: <input type="text" name="nombre">
		Apellido: <input type="text" name="apellido">
	</form>
	<h1 id="miDiv">Hello word!</h1>
	<button id="buttonAjax">Llamar ajax</button>
</body>
</html>