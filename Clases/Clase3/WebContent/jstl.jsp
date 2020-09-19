<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Page</title>
</head>
<body>
	<h1>JSTL</h1>
	
	<!-- tag out -->
	<c:out value="Hola Mundo, soy el tag out!" /><br>
	
	<!-- tag set para crear una variable -->
	<c:set var="variable" scope="request" value="Curso Java Web" />
	<c:out value="${variable}" />
	
	<!-- tag if -->
	<c:set var="nro" scope="request" value="100" />
	<c:if test="${nro==100}" >
		<c:out value="Valor=100"/>
	</c:if>
	<c:if test="${!(nro==100)}"> 
		<c:out value="Valor no igual a 100" />
	</c:if>
	
	<!-- Entrada de parametros -->
	<c:if test="${param.saludar}">
		<h1>Hola ${param.nombre}!!</h1>
	</c:if>
	<br>
	
	<!-- Java Bean -->
	<jsp:useBean id="now" class="java.util.Date">
		Fecha: <fmt:formatDate value="${now}" dateStyle="full"/>
	</jsp:useBean>
	<br>
	<c:out value="${now}" />
	
	<!-- tag choose -->
	<c:set var="categoria" value="C" scope="request"/>
	<c:choose>
		<c:when test="${categoria=='A'}"><h3>Categoria A</h3></c:when>
		<c:when test="${categoria=='B'}"><h3>Categoria B</h3></c:when>
		<c:when test="${categoria=='C'}"><h3>Categoria C</h3></c:when>
	</c:choose>
	<br>
	
	<!-- tag forEach -->
	<c:forEach var="i" begin="10" end="20" step="2">
		<c:out value="${i}" /><br>
	</c:forEach>
	
	<c:forEach var="i" begin="10" end="20" varStatus="status">
		Indice: <c:out value="${status.index}" />
		Iteración #: <c:out value="${status.count}" /> <br>
	</c:forEach>
	<br>
	
	<!-- itera los valores de una lista -->
	<jsp:useBean id="us" scope="request" 
                     class="com.facu.dao.UserDAO" />
		
	<c:forEach var="u" items="${us.all}">
		${u.id} | ${u.username} | ${u.email} <br>
	</c:forEach>
	
	<table border="1">
		<tr><th>Id</th><th>Username</th><th>Email</th></tr>
		<c:forEach var="u" items="${us.all}">
			<tr>
				<td>${u.id}</td>
				<td>${u.username}</td>
				<td>${u.email}</td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- jstl SQL -->
	<sql:setDataSource
		var="ds"
		driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
		url="jdbc:sqlserver://localhost\\SQLEXPRESS01;database=JavaWeb"
		user="sa"
		password="123456"
	/>
	<sql:query var="allRows" dataSource="${ds}">
		select id,username,email from users;
	</sql:query>
	<hr>
	<table border="1">
		<tr><th>Id</th><th>Username</th><th>Email</th></tr>
		<c:forEach var="u" items="${allRows.rows}">
			<tr>
				<td>${u.id}</td>
				<td>${u.username}</td>
				<td>${u.email}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>