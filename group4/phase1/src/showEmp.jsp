<!DOCTYPE html>
<%taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title> Search for Employee</title>


</head>
<body>
<h1> Employees</h1>
<br>
<ol>
<c:forEach item="${employees}" var="emp">
<li>
EMPLOYEE
<c: out value="${emp.empId}"/>
<br>
<c: out value="${emp.empName}"/>
<br>
<c: out value="${employee.DOB}"/>
<br>
<c: out value="${employee.basicSalary}"/>
</li>
</c:forEach>
</body>
</html>