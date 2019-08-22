
            <h2>Hi&nbsp;&nbsp;<%
            
   
           
            out.println(request.getAttribute("a")); %></h2>
            
            <h3>Your Email : &nbsp;<%
           	out.println(request.getAttribute("b"));
           %></h3>
           
           <h3> Your Country: &nbsp;
           <%
           	out.println(request.getAttribute("c"));
%></h3>
<form action="logout.jsp" method="post">
<input type="submit" value="Logout">
</form>