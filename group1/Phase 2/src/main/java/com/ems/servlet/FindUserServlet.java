package com.ems.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.UserJdbcImpl;
import com.ems.model.User;
import com.ems.service.UserService;
import com.ems.service.UserServiceImpl;


@WebServlet("/find")
public class FindUserServlet extends HttpServlet{

	
	private UserService us=new UserServiceImpl(new UserJdbcImpl());
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
		{
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			PrintWriter writer=res.getWriter();
			String email_id=req.getParameter("useremail");
			String password=req.getParameter("password");
			System.out.println("inside findservlet doget,email="+email_id+" password="+password);
			User user=us.find(email_id);
			System.out.println("not found,user="+user);
			if(user.getPassword().equalsIgnoreCase(password))
			{
				req.setAttribute("user",user);
				RequestDispatcher dispatcher= req.getRequestDispatcher("details.jsp");
		        dispatcher.forward(req,res);
				
			}
			else
			{
				 RequestDispatcher dispatcher= req.getRequestDispatcher("errorpage.html");
			     dispatcher.forward(req,res);
			}
		}

}
