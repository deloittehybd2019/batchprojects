<!DOCTYPE html>
<html lang="en">
<head>

    <h1> Second jsp</h1>

</head>

<body>


<%

Object username =session.getAttribute("sessionusername");
out.println("username fetched ="+username);
%>



</body>

</html>






