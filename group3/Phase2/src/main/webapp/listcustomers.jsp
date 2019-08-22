<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <h1> Customers</h1>

</head>

<body>
<ol>
<c:forEach items="${customers}" var="customer">
    <li>

   Customer
    <c:out value="${customer.id}"/>
    <c:out value="${customer.name}"/>
  </li>

</c:forEach>
</ol>
</body>

</html>






