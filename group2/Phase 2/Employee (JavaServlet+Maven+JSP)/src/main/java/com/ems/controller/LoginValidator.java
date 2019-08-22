package com.ems.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ems.dao.UserJDBCImpl;
import com.ems.exceptions.UserNotFoundException;
import com.ems.model.User;
import com.ems.service.IUserService;
import com.ems.service.UserImpl;

@WebServlet(value="/loginvalidate")
public class LoginValidator extends HttpServlet {

	private IUserService service = new UserImpl(new UserJDBCImpl());


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		PrintWriter writer = resp.getWriter();
		String email = req.getParameter("emailid");
		String pwd = req.getParameter("pwd");
		
		User u1;
		try {
			u1=service.findUserById(email);
	
		
		if(u1.getPwd().equals(pwd))
		{

			HttpSession session = req.getSession(); 
			session.setAttribute("user",email);
			RequestDispatcher rd=req.getRequestDispatcher("userprofile");  
			rd.forward(req,resp);
		}
		else
		{
			resp.sendRedirect("login.html");
		}
		} 
		catch (UserNotFoundException e) {
			e.printStackTrace();
		}
}
}
