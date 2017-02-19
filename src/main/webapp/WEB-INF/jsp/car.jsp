<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST" modelAttribute="car" action="/garage/garage/cars/car/${operation}/">
		<form:input type="hidden" path="id" id="car.id"/>
		<table>
			<tr>
				<td>		
					<form:label path="name">Name: </form:label>
					<form:input path="name" id="car.name"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="yearcars">Years: </form:label>
					<form:input path="yearcars" id="car.yearcars"/>
				</td>
			</tr>
		</table>
		<c:if test="${operation eq 'add' }">
			<form:input type="hidden" path="idclients" id="car.idclients" value="0"/>
		</c:if>
		<c:if test="${operation eq 'update' }">
			<form:input type="hidden" path="idclients" id="car.idclients"/>
		</c:if>
	
		<c:if test="${operation eq 'update'}">
		   	<input type="submit" value="Update"/>
		</c:if>
		<c:if test="${operation eq 'add'}">
			<input type="submit" value="Add"/>
		</c:if>
		<input type="button" name="Back" value="Back" onClick="window.location='/garage/garage/cars';" />
	</form:form>
</body>
</html>