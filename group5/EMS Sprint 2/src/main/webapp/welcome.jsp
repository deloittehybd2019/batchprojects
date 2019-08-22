<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<h2>Hi ${empName}</h2>
	<p><b>Your Email: </b> ${email}</p>
	<p><b>Your Country: </b>${country}</p>
	<br>
	<form method = "get" action="/relogin">
		<input type = "submit" value = "Logout">
	</form>
</body>
</html>