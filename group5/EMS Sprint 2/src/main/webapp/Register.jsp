<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<h1>Provide all the fields for Registration</h1>
</head>
<body>

	<form method="get" action="/registration">

		<div>
			<span>Email Id : </span> <input name="email" type="email" required>
		</div>
		<div>
			<span>Password : </span> <input name="password" type="password" required>
		</div>
		<div>
			<span>Name : </span> <input name="name" type="text" required>
		</div>
		<div>
			<span>Country : </span> <input name="country" type="text" required>
		</div>
		<input type="submit" value="Register">
		<div>
			<br>if you are registered user please <a href="login.jsp">login</a>
		</div>

	</form>
</body>
</html>