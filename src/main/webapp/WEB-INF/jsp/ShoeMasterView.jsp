<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shoe Maintenance</title>
</head>
<body>
<form> 
<h1>Shoe Details</h1>
			
<br/>
	<table border="1">
				<tr>
					<td> <b> Select </b> </td>
					<td> <b> Shoe ID </b> </td>
					<td> <b> Brand Name </b> </td>
					<td> <b> Shoe Detail </b> </td>
					<td> <b> Shoe Quantity </b> </td>
					<td> <b> Cost per Shoe </b> </td>
				</tr>
		<c:forEach items="${ShoeMaster}" var="shoe">
				<tr>
					<td> <input type="radio" name="shoeId" value="${shoe.shoeId}" /> </td>
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
<button name="action" value="AddMod">Add/Modify </button>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button name="action" value="Delete">Delete</button>
</form>
</body>
</html>