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
    <form:form method="POST" modelAttribute="client" action="/garage/garage/clients/update/">
		<form:input type="hidden" path="id" id="client.id"/>
        <table>
            <tr>
                <td><label for="name">Name: </label> </td>
                <td><form:input path="name" id="client.name"/></td>
            </tr>
            <tr>
                <td><label for="phone">Phone: </label> </td>
                <td><form:input path="phone" id="client.phone"/></td>
            </tr>
            <tr>
                <td colspan="3">
	                <input type="submit" value="Update"/>
                </td>
            </tr>
        </table>
    </form:form>
    <table>
        <c:forEach var="item" items="${cars}" >
        	<tr>
        		<td>${item.id}</td>
        		<td>${item.name}</td>
        		<td>${item.yearcars}</td>
        		<td><a href="/garage/garage/clients/delete/${client.id}/${item.id}">Delete</a></td>
        	</tr>
		</c:forEach>
    </table>
</body>
</html>