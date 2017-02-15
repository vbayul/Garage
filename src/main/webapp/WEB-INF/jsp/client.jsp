<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
    <form:form method="POST" modelAttribute="client" action="/garage/garage/clients/client/${operation}/">
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
                <td colspan="1">
                	<c:if test="${operation eq 'update'}">
	                	<input type="submit" value="Update"/>
	                </c:if>
	                <c:if test="${operation eq 'add'}">
	                	<input type="submit" value="Add"/>
	                </c:if>
                </td>
                <td colspan="1">
                	<input type="button" name="Back" value="Back" onClick="window.location='/garage/garage/clients';" />
                </td>
            </tr>
        </table>
    </form:form>
	<c:if test="${operation eq 'update'}">
	    <table>
	        <c:forEach var="item" items="${clientcars}" >
	        	<tr>
	        		<td>${item.id}</td>
	        		<td>${item.name}</td>
	        		<td>${item.yearcars}</td>
	        		<td><a href="/garage/garage/clients/client/${client.id}/delete/${item.id}">Delete</a></td>
	        	</tr>
			</c:forEach>
	    </table>
	    <input type="button" name="Add Car" value="Add Car" onClick="window.location='/garage/garage/clients/client/${client.id}/add';" />
	</c:if>
</body>
</html>