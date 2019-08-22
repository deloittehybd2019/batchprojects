<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>

    <h1> User inputs</h1>

</head>

<body>

  <c:set var = "number"  value = "10"/>
          <c:if test = "${number%2==0}">
             <p>  <c:out value = "${number}"/><p>
   </c:if>




  <c:out value="hello from jstl tag" />

  <br>


<%

  for(int i=0;i<5;i++){
   out.println("i="+i);
   out.println("<br>");
  }


  %>

    <br>


  <c:forEach var = "counter" begin = "1" end = "5">

    Counter is  <c:out value = "${counter}"/><p>

   </c:forEach>

</body>

</html>