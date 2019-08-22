package org.del.controller;

import org.del.entities.Employee;
import org.del.exceptions.EmployeeNotFoundException;
import org.del.service.IEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class EmployeeController {
    private static final Logger Log = LoggerFactory.getLogger(EmployeeController.class);

    private final String idAttributeName = "id";

    @Autowired
    private IEmployeeService employeeService;


    /**
     * registration is the default page
     */
    @GetMapping("/")
    public ModelAndView defaultPage() {
        return new ModelAndView("register");
    }

    @GetMapping("/employeedetails")
    public ModelAndView fetchEmployee(@RequestParam(value = "id") int id) throws EmployeeNotFoundException {
        Employee employee = employeeService.findEmployeeById(id);
        ModelAndView mv = new ModelAndView("employeedetails", "employee", employee);
        return mv;
    }

    @PostMapping("/create")
    public ModelAndView createEmployee(@RequestParam("username") String name,
                                       @RequestParam("password") String password,
                                       @RequestParam("email") String email,
                                       @RequestParam("country") String country) {
        Employee employee = new Employee(name, password, email, country);
        employeeService.save(employee);
        ModelAndView mv = new ModelAndView("employeelogin", "employee", employee);
        return mv;
    }

    @GetMapping("/login")
    public ModelAndView login(HttpSession session) throws EmployeeNotFoundException {
        Object idValue = session.getAttribute(idAttributeName);
        if (idValue == null) {
            ModelAndView mv = new ModelAndView("employeelogin");
            return mv;
        }
        Integer idValueInt = (Integer) idValue;
        Employee employee = employeeService.findEmployeeById(idValueInt);
        ModelAndView mv = new ModelAndView("employeehome", "employee", employee);
        return mv;
    }

    @PostMapping("/loginsubmit")
    public ModelAndView loginSubmit(@RequestParam("id") int id,
                                    @RequestParam("password") String password,
                                    HttpSession session) throws EmployeeNotFoundException {
        try {
            boolean success = employeeService.checkCredentials(id, password);
            if (success) {
                session.setAttribute(idAttributeName, id);
                Employee employee = employeeService.findEmployeeById(id);
                ModelAndView mv = new ModelAndView("employeehome", "employee", employee);
                return mv;
            }
        } catch (Throwable e) {
            Log.error("exception in loginSubmit()", e);
        }

        ModelAndView mv = new ModelAndView("employeelogin", "error", 1);
        return mv;
    }


}










