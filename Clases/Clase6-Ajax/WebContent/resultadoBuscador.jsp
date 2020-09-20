<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
	<tr>
		<th>ID</th>
		<th>Username</th>
		<th>Email</th>
	</tr>
	
	<c:forEach items="${personas}" var="p">
		<tr>
			<td><c:out value="${p.id}"/></td>
			<td><c:out value="${p.username}"/></td>
			<td><c:out value="${p.email}"/></td>
		</tr>
	</c:forEach>
	
</table>