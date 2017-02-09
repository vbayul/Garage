<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<c:forEach items="${client}" var="client">
			<tr>
				<td>ID</td>
				<td>${client.id}</td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" size="40" value="${client.name}"></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>