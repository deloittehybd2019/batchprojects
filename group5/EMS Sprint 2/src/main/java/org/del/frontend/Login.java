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
import org.del.exceptions.EmployeeNotFoundException;
import org.del.service.*;

@WebServlet("/login")
public class Login extends HttpServlet {
	
    private IEmployeeService service = new EmployeeServiceImpl(new EmployeeJdbcDaoImpl()); 

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter writer = response.getWriter();
        
        String emailId = request.getParameter("email");
        String password = request.getParameter("password");
        
        try {
			Employee emp = service.showEmployee(emailId);
			if(emp.getPassword().equals(password)) {
				request.setAttribute("empName", emp.getName());
				request.setAttribute("email", emp.getEmailId());
				request.setAttribute("country", emp.getCountry());
				
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			}
		} catch (EmployeeNotFoundException e) {
			response.sendRedirect("invalid.jsp");
			e.printStackTrace();
		}
        HttpSession session = request.getSession();
        session.setAttribute("email", emailId);
        session.setMaxInactiveInterval(60);
		session.invalidate();
	}
}
