package org.del.dao;

import org.del.entities.Employee;
import org.del.exceptions.EmployeeNotFoundException;

import java.util.List;

/**
 * Data access specification for Customer
 */
public interface IEmployeeDao {

	void addEmployee(Employee employee);

	Employee showEmployee(String email) throws EmployeeNotFoundException;

}
