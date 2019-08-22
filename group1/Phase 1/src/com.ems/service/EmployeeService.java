package com.ems.service;

import com.ems.model.Employee;
import com.ems.util.*;

import java.util.*;

public interface EmployeeService {

    void validateEmployee(Employee emp) throws Exception;

    String generateId();

    boolean save(Employee emp);

    boolean delete(Employee empid);

    boolean update(Employee emp);

    Employee getEmployee(String empId) throws EmployeeNotFoundException;

    List<Employee> display();
}
