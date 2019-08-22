package com.ems.controller;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.net.*; 
import oracle.jdbc.*;
import oracle.sql.*;
import java.sql.DriverManager;
import oracle.jdbc.driver.OracleDriver.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.session.Session;

@WebServlet(value="/userprofile")

public class UserProfile extends HttpServlet  {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		try
        {
        	DriverManager.registerDriver(new OracleDriver());
            Connection connection = null;
            
        	String url="jdbc:oracle:thin:@localhost:1521:orcl";
   		     connection = DriverManager.getConnection(url, "scott", "tiger");
    	    if(connection==null)
   	   	  {
       	     System.out.println("failed");
       	 }
       	 else
       	 {
       		String emailid=req.getParameter("emailid");
       		String pwd=req.getParameter("pwd");
            String sql = "select * from registration where emailid=? and pwd=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,emailid);
            preparedStatement.setString(2,pwd);
            ResultSet rst=preparedStatement.executeQuery();
            if(!rst.next())
            {
            	
                 resp.sendRedirect("login.html") ;
            }
            else
            {
            	System.out.println(rst.getString(3));
            	req.setAttribute("a",rst.getString(3));
            	req.setAttribute("b",rst.getString(1));
            	req.setAttribute("c",rst.getString(4));
            	RequestDispatcher rd=req.getRequestDispatcher("UserProfile.jsp");  
    			rd.forward(req,resp);
            }
       	 }
    	    
        }
		catch(Exception e) {}
	
	}}
