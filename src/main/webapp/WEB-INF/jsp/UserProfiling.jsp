<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>
<form action="/ShoeApp/MaintainUser" method="post">
<h1 align="center"> New User ? Provide your details for further shopping...</h1>
<h1 align="center"> Existing User ? Return back and Provide valid user name and correct credentials</h1>
First Name: <input type="text" name="firstName"> &nbsp; &nbsp;
Last Name: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="lastName"> <br/><br/><br/>
E-Mail ID: &nbsp;<input type="text" name="emailId"> &nbsp;&nbsp;&nbsp;
Mobile Number:&nbsp;<input type="text" name="mobileNumber"><br/><br/><br/> 
<h3> <b> Address </b> </h3> <br/><br/><br/>
Address Line 1:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="AddressLine1"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Address Line 2:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="AddressLine2"><br/><br/><br/>
Village/Town/City:&nbsp;<input type="text" name="AddressLine3"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
State:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="AddressLine4"><br/><br/><br/>
Pin Code:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="AddressLine5"><br/><br/><br/>
<h3> <b> Login Details </b> </h3> <br/><br/><br/>
User Name: <input type="text" name="UserName"> &nbsp; &nbsp;
Password: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="PassWord"> <br/><br/><br/>
<input type="button" name="Submit" value="Submit" onclick="submit()">
</form>
</body>
</html>