<%@ page import="java.sql.*, java.util.*, java.net.*, 
   oracle.jdbc.*, oracle.sql.*,java.sql.DriverManager,oracle.jdbc.driver.OracleDriver.*" %>
<%

    String email=request.getParameter("emailid");
    String pwd=request.getParameter("pwd");
    String name=request.getParameter("name");
    String country=request.getParameter("country");

   
       
        try
        {
        	DriverManager.registerDriver(new OracleDriver());
            Connection connection = null;
            String url="jdbc:oracle:thin:@localhost:1521:orcl";
        connection = DriverManager.getConnection(url, "scott", "tiger");
        if(connection==null)
        {
            out.println("failed");
        }
        else
        {
            String sql = "insert into registration values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,pwd);
            preparedStatement.setString(3,name);
            preparedStatement.setString(4,country);
            preparedStatement.execute();
            int count = preparedStatement.getUpdateCount();
            response.sendRedirect("login.html");
         }
    }
catch(Exception e){
    out.print(e.getMessage());
}
%>