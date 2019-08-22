package org.del.service;

import org.del.entities.Employee;
import org.del.exceptions.EmployeeNotFoundException;

import java.util.List;

public interface IEmployeeService {

    void add(Employee employee);

	Employee showEmployee(String email) throws EmployeeNotFoundException;
	
}
