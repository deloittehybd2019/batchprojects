<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <h1> Employee Sign in</h1>

</head>
<body>

<div>
<c:if test="${error==1}">

<span style="color:red"> Id or password is incorrect</span>
</c:if>
</div>

<form method="post" action="loginsubmit">


<div>
    <span>Id</span>
    <input name="id" type="number"/>

    </div>



<div>
    <span>Password</span>
    <input name="password" type="password"/>

    </div>




    <input type="submit" value="Submit">

</form>

</body>
</html>