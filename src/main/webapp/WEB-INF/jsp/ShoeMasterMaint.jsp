<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/ShoeApp/doShoeMaint" method="get">
<c:catch var="exception">${ShoeData.shoeId}</c:catch>
<c:choose>
<c:when test="${not empty exception}">
Shoe ID <input type="text" name="shoeId">
Brand Name <input type="text" name="shoeName">
Shoe Count <input type="text" name="shoeCount">
Shoe Cost <input type="text" name="shoeCost">
Shoe Description <input type="text" name="shoeDesc">
</c:when>
<c:when test="${empty exception}">
Shoe ID <input type="text" name="shoeId" value='${ShoeData.shoeId}'>
Brand Name <input type="text" name="shoeName" value='${ShoeData.shoeName}'>
Shoe Count <input type="text" name="shoeCount" value='${ShoeData.shoeCount}'>
Shoe Cost <input type="text" name="shoeCost" value='${ShoeData.shoeCost}'>
Shoe Description <input type="text" name="shoeDesc" value='${ShoeData.shoeDesc}'>
</c:when>
</c:choose>	
<button type="submit" name="submit">Submit</button>
</form>
</body>
</html>