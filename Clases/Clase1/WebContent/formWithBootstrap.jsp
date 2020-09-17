<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Formulario de Inscripción</title>
	
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>Formulario de Inscripción</h1>
	<hr>
	<form>
		Nombre: <input type="text" name="campoNombre" maxlength="30"> <br><br>
		Apellido: <input type="text" name="campoApellido" maxlength="30"> <br><br>
		Dirección: <input type="text" name="campoDireccion" maxlength="50"> <br><br>
		Sexo:
			&nbsp;Masculino&nbsp; <input type="radio" name="campoRadio" value="masculino">
			&nbsp;Femenino&nbsp; <input type="radio" name="campoRadio" value="femenino">
		<br><br>
		Puesto de trabajo:
		<select name="campoTrabajo">
			<option value="valor1">Programador</option>
			<option value="valor2">Analista</option>
			<option value="valor3">Ingeniero</option>
		</select> <br><br>
		Tiene experiencia
		<input type="checkbox" name="experiencia"><br><br>
		<hr><br>
		
		<button type="submit">Registrarme!</button>
	</form>
</body>
</html>