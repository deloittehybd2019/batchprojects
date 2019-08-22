package org.del.frontend;


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
import java.util.List;

@WebServlet("/listcustomers")
public class ListAllCustomers extends HttpServlet {
    private ICustomerService customerService = new CustomerServiceImpl(new CustomerJdbcDaoImpl());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        try {
            List<Customer> customers = customerService.allCustomers();
            req.setAttribute("customers", customers);
            RequestDispatcher dispatcher = req.getRequestDispatcher("listcustomers.jsp");
            dispatcher.forward(req, resp);
        } catch (Throwable e) {
            e.printStackTrace();
            out.println("something went wrong");
        }
    }
}
