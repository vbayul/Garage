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
	<form:form method="POST"  modelAttribute="ticket" action="/garage/garage/tickets/ticket/update">
		<form:input path="id" id="ticket.id"/>
		<form:form modelAttribute="ticket.car">
			<form:input path="id" id="ticket.car.id"/>
			<form:input path="name" id="ticket.car.name"/>
			<form:input path="idclients" id="ticket.car.idclients"/>
			<form:input path="yearcars" id="ticket.car.yearcars"/>
		</form:form>
		<input type="submit" value="Update">
	</form:form>
</body>
</html>