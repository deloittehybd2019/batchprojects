<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<h1> Hi <c:out value="${user.name}"/></h1>
<h3> Your email : <c:out value="${user.email_id }"/></h3>
<h3> Your Country : <c:out value="${user.country }"/></h3>
<br>
<form method="get" action="loggedout.html">
<input type="submit" value=" logout">
</form>
</body>
</html>