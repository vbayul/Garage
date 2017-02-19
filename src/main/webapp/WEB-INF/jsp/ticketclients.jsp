<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<c:forEach items="${clients}" var="client">
			<tr>
				<td>${client.id}</td>
				<td>${client.name}</td>
				<td><a href="/garage/garage/tickets/ticket/create/${client.id}">Ticket</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="/garage/garage/tickets">Back</a>
</body>
</html>