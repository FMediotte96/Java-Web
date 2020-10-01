<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Laboratorio 2</title>
</head>
<body>
	<div style="width: 400 px; align-items: center; background-color: blue; color: white; border: 2px black" >
		<h1>Formulario de inscripción</h1>
		<hr>
		<form action="ProcesadorDeDatos" method="post">
			<label>Nombre: <input type="text" name="nombre"></label><br>
			<label>Apellido: <input type="text" name="apellido"></label><br>
			<label>Dirección: <input type="text" name="direccion"></label><br>
			<label>Sexo: </label>
				<label>Masculino <input type="radio" value="masculino" name="sexo"></label>
				<label>Femenino <input type="radio" value="femenino" name="sexo"></label>
			<br>
			<label>Puesto de trabajo:</label>
			<select name="puesto">
				<option value="programador">Programador</option>
				<option value="disenador">Diseñador</option>
				<option value="analista">Analista Funcional</option>
				<option value="lider">Lider de Proyecto</option>
			</select>
			<br>
			<label>Tiene experiencia <input type="checkbox" value="true" name="experiencia"></label>
			<br><br><hr>
			<button type="submit">Registrarme!</button>
		</form>
	</div>
</body>
</html>