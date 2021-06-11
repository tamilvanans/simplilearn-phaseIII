<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shoe Payment</title>
</head>
<body>
<h1 align="center"> Make It Yours, Make Payment !!!</h1>
<form  method="post" action="/ShoeApp/doPayment"> 
<h1>Payment Details</h1>
			
<br/>
	<table border="1">
				<tr>
					<td> <b> Purchase Details </b> </td>
					<td> <b> Total Amount </b> </td>
				</tr>
				
				<tr>
					<td>
					<c:forEach items="${Purchase.shoes}" var="shoe">
						${shoe.shoeName} - ${shoe.shoeDetail} <br>
					</c:forEach>
					</td>
					<td>${Purchase.purchaseAmount}</td>
				</tr>
	</table>
<br/>
<br/><button name="action" value="Payment">Make Payment</button>
<button name="action" value="Cancel">Cancel</button>
</form>
</body>
</html>