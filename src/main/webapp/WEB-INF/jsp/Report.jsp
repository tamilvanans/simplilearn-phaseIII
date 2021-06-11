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
					<td> <b> Purchaser Login Name </b></td>
					<td> <b> Purchaser Name </b> </td>
					<td> <b> Delivery Address </b> </td>
					<td> <b> Purchase Date </b> </td>
					<td> <b> Purchase Amount </b> </td>
					<td> <b> Purchase Details </b> </td>
				</tr>
		<c:forEach items="${PurchaseList}" var="purchase">
				<tr>
					<td>${purchase.user.userName}</td>
					<td>${purchase.user.firstName} ${purchase.user.lastName}</td>
					<td>${purchase.user.addressLine1}, ${purchase.user.addressLine2}, ${purchase.user.addressLine3}, ${purchase.user.addressLine4}, ${purchase.user.addressLine5}</td>
					<td>${purchase.updationDate}</td>
					<td>${purchase.purchaseAmount}</td>
					<td> <c:forEach items="${purchase.shoes}" var="shoe">
							${shoe.shoeName} - ${shoe.shoeDetail}<br>
						</c:forEach>
					</td>
				</tr>
		</c:forEach>
	</table>
<br/>
<br/>
</form>
</body>
</html>