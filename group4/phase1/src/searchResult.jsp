<!DOCTYPE html>
<%taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title> Search for Employee</title>


</head>
<body>
<h1> Employee:-</h1>
<br>
<c: out value="${employee.empId}"/>
<br>
<c: out value="${employee.empName}"/>
<br>
<c: out value="${employee.DOB}"/>
<br>
<c: out value="${employee.basicSalary}"/>
</body>
</html>