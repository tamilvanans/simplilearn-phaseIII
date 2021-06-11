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
<h1>Purchase Details</h1>
			
<br/>
	<table border="1">
				<tr>
					<td> Select </td>
					<td> Purchase ID </td>
					<td> Purchase Detail </td>
					<td> Purchase Amount </td>
				</tr>
		<c:forEach items="${PurchaseMaster}" var="purchase">
				<tr>
					<td>${purchase.purchaseId}</td>
					<td>${purchase.purchaseDetail}</td>
					<td>${purchase.purchaseAmount}</td>
				</tr>
		</c:forEach>
	</table>
<br/>
<br/>
</form>
</body>
</html>