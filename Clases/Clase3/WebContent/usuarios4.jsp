<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Usuarios 4</title>
	<script type="text/javascript" src="js/funciones.js"></script>
	<script type="text/javascript" src="js/md5.js"></script>
</head>
<body>
	<h1>Formulario de usuarios</h1>
	<form method="post" action="AltaUsuarios">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username" required></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" required></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" id="password" required onchange="revisar()"></td>
			</tr>
			<tr>
				<td>Pass Confirm:</td>
				<td><input type="password" name="password2" id="password2" required onchange="revisar()"></td>
			</tr>
			<tr>
				<td><input type="reset" value="limpiar"></td>
				<td><button id="enviar" type="submit" onclick="cifrar()">Enviar</button></td>
			</tr>
			<tr><td colspan="2"><div id="info"></div></td></tr>
			
		</table>
	</form>
</body>
</html>