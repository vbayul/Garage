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
	<form:form method="POST" modelAttribute="ticket" action="/garage/garage/tickets/ticket/${operation}">
	<table>
	<tr>
		<td>
			<label>Ticket: - ${ticket.id}</label>
			<form:input type="hidden" path="id" id="ticket.id"/>
		</td>
	</tr>
	<tr>
		<td>
			<form:input type="hidden" path="client.id" id="ticket.client.id"/>
			<label>Name: </label>
			<form:label path="client.name" id="ticket.client.name">${ticket.client.name}</form:label>
			<label>Phone: </label>
			<form:label path="client.phone" id="ticket.client.phone">${ticket.client.phone}</form:label>
		</td>
	</tr>
	<tr>
		<c:if test="${operation eq 'add' }">
		<td>
			<label>Car: </label>
    		<form:select path="car.id" id="ticket.car.id" items="${cars}" itemValue="id" itemLabel="name"/>
		</td>
		</c:if>
		<c:if test="${operation eq 'update' }">
		<td>
			<form:input type="hidden" path="car.id" id="ticket.car.id"/>
			<label>Car: </label>
			<form:label path="car.name" id="ticket.car.name">${ticket.car.name}</form:label>
		</td>
		</c:if>
	</tr>
	<tr>
		<td>
			<label>Trouble: </label>
			<form:select path="trouble.id" id="ticket.trouble.id" items="${troubles}" itemValue="id" itemLabel="name"/>
		</td>
	</tr>
	<tr>
		<td>
			<label>Comment: </label>
			<form:input path="comment" id="ticket.comment"/>
		</td>
	</tr>
	</table>
		<c:if test="${operation eq 'add' }">
			<input type="submit" value="Add">
			<input type="button" value="Back" onclick="window.location='/garage/garage/tickets/ticket/clients'"> 
		</c:if>
		<c:if test="${operation eq 'update' }">
			<input type="submit" value="Update">
			<input type="button" value="Back" onclick="window.location='/garage/garage/tickets'"> 
		</c:if>

	</form:form>
</body>
</html>