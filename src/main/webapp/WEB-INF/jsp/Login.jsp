<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Sporty Shoes</title>
</head>
<body>
<div class="form-group">
	 
		<h1 align="center" class="color:red;">Welcome to SPORTY SHOES</h1>
		<h3 align="center">The world of shoes</h3>
	
</div>
<form action="/ShoeApp/ValidateLogin" method="post">
UserName - <input type=text name="username"><br/><br/><br/>
Password - <input type=password name="password"><br><br/><br/>

<input type=button name="Sign" value="Sign Up/Sign In" onclick='submit()'>

</form>

</body>
</html>