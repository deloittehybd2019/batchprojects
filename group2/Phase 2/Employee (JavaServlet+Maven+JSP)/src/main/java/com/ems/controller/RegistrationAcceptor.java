package com.ems.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ems.dao.UserJDBCImpl;
import com.ems.model.User;
import com.ems.service.IUserService;
import com.ems.service.UserImpl;

@WebServlet(value="/regacceptor")
public class RegistrationAcceptor extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		PrintWriter writer = resp.getWriter();
		String email = req.getParameter("emailid");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String country = req.getParameter("country");
		
		
		IUserService service = new UserImpl(new UserJDBCImpl());
		
		User user =new User(email, pwd,name,country);
		service.add(user);
       // resp.sendRedirect("login.html");
		
		
	}
	
}
