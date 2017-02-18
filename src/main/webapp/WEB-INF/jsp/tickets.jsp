<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<c:forEach var="ticket" items="${tickets}">
			<tr>
			<td>${ticket.id}</td>
			<td>${ticket.client.name}</td>
			<td>${ticket.car.name}</td>
			<td><a href="/garage/garage/tickets/ticket/${ticket.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>