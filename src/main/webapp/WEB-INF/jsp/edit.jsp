<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <form:form method="POST" modelAttribute="client" action="http://localhost:8080/garage/garage/clients/update/">
		<form:input type="hidden" path="id" id="id"/>
        <table>
            <tr>
                <td><label for="name">Name: </label> </td>
                <td><form:input path="name" id="name"/></td>
            </tr>
            <tr>
            	<td><label for="client.car.id">Car: </label> </td>
            	<td>
					<select name="client.car" id="client.car">
					    <c:forEach var="item" items="${cars}">
					        <option value="${item.id}" ${item.id == client.car.id ? 'selected="selected"' : ''}>${item.name}</option>
					    </c:forEach>
					</select>
				</td>
            </tr>
            <tr>
                <td colspan="3">
	                <input type="submit" value="Update"/>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>