package com.ems.servlet;
import java.io.IOException;

import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.EmloyeeDaoJdbcImpl;
import com.ems.model.Employee;
import com.ems.service.EmployeeService;
import com.ems.service.EmployeeServiceImpl;
import com.ems.util.CustomerNotFoundException;
@WebServlet("/acceptor")
public class SearchEmployee extends HttpServlet {
	
	private EmployeeService es =new EmployeeServiceImpl(new EmloyeeDaoJdbcImpl());
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)
		throws ServletException, IOException
	{
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		PrintWriter writer=res.getWriter();
		String empid=req.getParameter("userid");
		try
		{
			Employee emp=es.getEmployee(empid);
			req.setAttribute("employee",emp);
			RequestDispatcher rd=req.getRequestDispatcher("searchResult.jsp");
			rd.forward(req,res);
		}
		catch(CustomerNotFoundException e)
		{
			writer.println("employee not found for id =" + empid);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	

}
