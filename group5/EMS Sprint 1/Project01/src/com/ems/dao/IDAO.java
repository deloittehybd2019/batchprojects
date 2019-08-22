package com.ems.dao;

import java.sql.Connection;
import java.util.List;

import com.ems.model.Employee;
import com.ems.util.EmployeeNotFoundException;

public interface IDAO {

	public boolean save(Employee emp);
	public boolean delete(String empId);
	public boolean update(Employee emp);
	public Employee getEmployee(String empId) throws EmployeeNotFoundException; 
	public List<Employee> display();
	//public Connection getConnection();
	public String generateId(String empName);
}
