package org.del.frontend;

import org.del.dao.CustomerDaoImpl;
import org.del.dao.CustomerJdbcDaoImpl;
import org.del.entities.Customer;
import org.del.exceptions.CustomerNotFoundException;
import org.del.service.CustomerServiceImpl;
import org.del.service.ICustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {
    private ICustomerService customerService = new CustomerServiceImpl(new CustomerJdbcDaoImpl());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String customerId = req.getParameter("id");
        String customerPass=req.getParameter("pass");
        String customerName = req.getParameter("name");
        String customerCountry=req.getParameter("country");
        customerId.trim();
        PrintWriter writer = resp.getWriter();
        try {
            Customer customer = customerService.findCustomerById(customerId);
            req.setAttribute("customer",customer);
            RequestDispatcher dispatcher= req.getRequestDispatcher("home.jsp");
            dispatcher.forward(req,resp);
        }
        catch (CustomerNotFoundException ex){
            writer.println("Customer not found for id="+customerId);
            ex.printStackTrace();
        }
        catch (Throwable e) {
            e.printStackTrace();
            writer.println("something went wrong");
        }
    }
}





