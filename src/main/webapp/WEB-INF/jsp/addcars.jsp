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
		<c:forEach items="${cars}" var="car">
			<tr>
				<td>${car.id}</td>
				<td>${car.name}</td>
				<td><a href="/garage/garage/clients/client/${client}/add/${car.id}">Add</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="/garage/garage/clients/client/${client}">Back</a>
</body>
</html>