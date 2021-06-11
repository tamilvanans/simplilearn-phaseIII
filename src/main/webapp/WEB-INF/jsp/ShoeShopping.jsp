<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shoe Shopping</title>
</head>
<body>
<h1 align="center"> Welcome Back, Enjoy Shopping !!!</h1>
<form  method="post" action="/ShoeApp/doShopping"> 
<h1>Shoe Details</h1>
			
<br/>
	<table border="1">
				<tr>
					<td> <b> Select </b> </td>
					<td> <b> Shoe ID </b> </td>
					<td> <b> Shoe Name </b> </td>
					<td> <b> Shoe Details </b> </td>
					<td> <b> Shoe Quantity </b> </td>
					<td> <b> Cost per Shoe </b> </td>
				</tr>
				
		<c:forEach items="${ShoeMaster}" var="shoe">
				<tr>
					<td> <select name="count">
           					<c:forEach var = "i" begin = "0" end = "${shoe.shoeCount}">
        						<option value = "${i}-${shoe.shoeId}"> ${i} </option>
     						</c:forEach>
        				</select>
        			</td>
					<td>${shoe.shoeId}</td>
					<td>${shoe.shoeName}</td>
					<td>${shoe.shoeDetail}</td>
					<td>${shoe.shoeCount}</td>
					<td>${shoe.shoeCost}</td>
				</tr>
		</c:forEach>
	</table>
<br/>
<br/>
<input type="hidden" value="${UserId}" name="userId">
<button name="action" value="Checkout">Checkout</button>
</form>
</body>
</html>