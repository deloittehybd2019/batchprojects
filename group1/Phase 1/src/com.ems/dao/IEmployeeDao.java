package com.ems.dao;

import com.ems.model.Employee;
import com.ems.util.EmployeeNotFoundException;

import java.util.List;

public interface IEmployeeDao {

    String generateId();

    boolean save(Employee emp);

    boolean delete(Employee empid);

    boolean update(Employee emp);

    Employee getEmployee(String empId) throws EmployeeNotFoundException;

    List<Employee> display();


}
