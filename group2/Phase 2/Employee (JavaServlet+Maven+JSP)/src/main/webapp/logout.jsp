<%

request.getSession(false);
request.removeAttribute("a");
request.removeAttribute("b");
request.removeAttribute("c");
response.sendRedirect("login.html");
%>