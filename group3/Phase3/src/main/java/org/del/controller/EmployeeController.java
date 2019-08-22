package org.del.controller;

import org.del.entities.Employee;
import org.del.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.Min;

@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;


    @GetMapping("/employee/details")
    public ModelAndView fetchEmployee(@RequestParam(value = "id") int id) {
        Employee employee=employeeService.findEmployeeById(id);
        ModelAndView mv = new ModelAndView("employeedetails", "employee", employee);
        return mv;
    }

    @PostMapping("/employee/create")
    public ModelAndView createEmployee(@RequestParam("username") String name) {
        System.out.println("inside employeeFromPostRequest(*)");
        Employee employee = new Employee();
        employee.setName(name);
        employeeService.save(employee);
        ModelAndView mv = new ModelAndView("employeedetails", "employee", employee);
        return mv;
    }






}










