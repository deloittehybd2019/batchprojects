<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Login</title>
</head>
<body>
	<form method="get" action="/login">
	<fieldset>
		<legend>Please Enter The Details: </legend>
		<div>
			<span>Email Id : </span> <input name="email" type="email" required>
		</div>
		<div>
			<span>Password : </span> <input name="password" type="password" required>
		</div>
		<input type="submit" value="Login">
		<div>
			<br>if you are new user please <a href="Register.jsp">Register</a>
		</div>
	</fieldset>
	</form>
</body>
</html>