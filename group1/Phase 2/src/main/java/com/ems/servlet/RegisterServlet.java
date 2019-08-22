package com.ems.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.UserJdbcImpl;
import com.ems.model.User;
import com.ems.service.UserService;
import com.ems.service.UserServiceImpl;

@WebServlet("/acceptor")
public class RegisterServlet extends HttpServlet{
	
	private UserService us=new UserServiceImpl(new UserJdbcImpl());
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
		{
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			PrintWriter writer=res.getWriter();
			String email_id=req.getParameter("userid");
			String password=req.getParameter("password");
			String name=req.getParameter("name");
			String country=req.getParameter("country");
			User user=new User(email_id,password,name, country);
			us.add(user);
			res.sendRedirect("success.html");
		}

}
