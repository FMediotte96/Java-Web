<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ejemplo Form</title>
</head>
<body>
	<h1>Formulario</h1>
	<form action="mostrarDatos.jsp" method="post">
		Campo texto: <input type="text" name="campoTexto" size="15" maxlength="50"><br>
		Campo número: <input type="number" name="campoNumber"><br>
		Campo email: <input type="email" name="campoEmail" value="facumediotte@gmail.com"><br>
		Campo password: <input type="password" name="campoPassword"><br>
		Campo hidden: <input type="hidden" name="campoHidden" value="12345"><br>
		Campo texto largo: <textarea rows="6" cols="20"></textarea><br>
		
		<select name="campoSelect1">
			<option value="valor1">UNO</option>
			<option value="valor2">DOS</option>
			<option value="valor3">TRES</option>
		</select><br>
		
		<select name="campoSelect2" multiple>
			<option value="valor1">UNO</option>
			<option value="valor2">DOS</option>
			<option value="valor3">TRES</option>
		</select><br>
		
		Uno<input type="checkbox" name="campoCheck" value="check1">
		Dos<input type="checkbox" name="campoCheck" value="check2">
		Tres<input type="checkbox" name="campoCheck" value="check3"><br>
		
		Uno<input type="radio" name="campoRadio" value="radio1">
		Dos<input type="radio" name="campoRadio" value="radio2">
		Tres<input type="radio" name="campoRadio" value="radio3"><br>
		
		<br><button type="submit">Enviar datos</button>
		
	</form>
</body>
</html>