package org.del.frontend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.del.dao.EmployeeJdbcDaoImpl;
import org.del.entities.Employee;
import org.del.service.*;

@WebServlet("/registration")
public class Registration extends HttpServlet {

    private IEmployeeService service = new EmployeeServiceImpl(new EmployeeJdbcDaoImpl()); 
    		
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter writer = response.getWriter();
        
        String emailId = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String country = request.getParameter("country");
        System.out.println("Email:"+emailId);
        Employee employee = new Employee(emailId, password, name, country);
        
        try {
        	service.add(employee);
        	response.sendRedirect("login.jsp");
    		//HttpSession session = request.getSession();
    		//session.setAttribute("password", password);
        } catch(Exception e) {
        	e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60);
		session.invalidate();
	}

}
