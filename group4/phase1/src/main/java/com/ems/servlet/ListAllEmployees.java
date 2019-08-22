package com.ems.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

@WebServlet("/listemp")
public class ListAllEmployees extends HttpServlet{

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
			List<Employee> empList=es.display();
			req.setAttribute("employee",empList);
			RequestDispatcher rd=req.getRequestDispatcher("showEmp.jsp");
			rd.forward(req,res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	

}
