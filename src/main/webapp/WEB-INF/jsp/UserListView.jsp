<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body>
<form> 
<h1>User Details</h1>
			
<br/>
	<table border="1">
				<tr>
					<td> <b> User ID </b> </td>
					<td> <b> Login Name </b> </td>
					<td> <b> User Name </b> </td>
					<td> <b> User eMail ID </b> </td>
					<td> <b> User Mobile Number </b> </td>
					<td> <b> User Address </b> </td>
				</tr>
		<c:forEach items="${UserList}" var="user">
				<tr>
					<td>${user.userId}</td>
					<td>${user.userName}</td>
					<td>${user.firstName} ${user.lastName}</td>
					<td>${user.emailId}</td>
					<td>${user.mobileNumber}</td>
					<td>${user.addressLine1} ${user.addressLine2} ${user.addressLine3} ${user.addressLine4} ${user.addressLine5}</td>
				</tr>
		</c:forEach>
	</table>
<br/>
<br/>
</form>
</body>
</html>