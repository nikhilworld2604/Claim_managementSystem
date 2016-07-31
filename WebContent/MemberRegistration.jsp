<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body>

<div id="form1">
<h2 align="center">Member Registration form</h2>
<%@include file="header.jsp" %>
<form action="" method="post">
<table align="center">
<tr><td>Enter First name</td><td><input type="text" name="fname"></td></tr>
<tr><td>Enter Last Name</td><td><input type="text" name="lname"></td></tr>
<tr><td>Enter Gender</td><td><input type="radio" name="gender" value="male">Male
<input type="radio" name="gender" value="female">Female</td></tr>
<tr><td>Enter Date Of Birth</td><td><input type="text" name="dob"></td></tr>
<tr><td>Enter Address1</td><td><input type="text" name="address1"></td></tr>
<tr><td>Enter Address2</td><td><input type="text" name="address2"></td></tr>
<tr><td>Enter city</td><td><input type="text" name="city"></td></tr>
<tr><td>Enter State</td><td><input type="text" name="state"></td></tr>
<tr><td>Enter Pincode</td><td><input type="text" name="pincode"></td></tr>
<tr><td>Enter Country</td><td><input type="text" name="country"></td></tr>
<tr><td>Enter Location</td><td><input type="text" name="location"></td></tr> 
<tr><td>Enter Contact No.</td><td><input type="text" name="contact"></td></tr>
<tr><td>Enter Email ID</td><td><input type="text" name="email"></td></tr>
<tr><td>Enter Nominee count</td><td><input type="text" name="nominee"></td></tr>
<tr><td>Select the Insurance Type</td><td><select name="insurancetype">
<option>--Select--</option>
<option>Home</option>
<option>Vehicle</option>
<option>Life</option>
</select></td></tr>
<tr><td>Enter Insured Amount</td><td><input type="text" name="insuredamt"></td></tr>
<tr><td>Enter Maximum claim amount</td><td><input type="text" name="maxamt"></td></tr>
<tr><td><input type="submit" value="Submit"></td></tr>
</table>
</form>
</div>


</body>
</html>