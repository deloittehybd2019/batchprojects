package com.ems.service;

import java.util.List;

import com.ems.model.Employee;
import com.ems.util.EmployeeNotFoundException;

public interface EmployeeService {

	public boolean validateEmployee(Employee emp) throws Exception;
	public String generateId(String empName);
	public boolean save(Employee emp);
	public boolean delete(String empId);
	public boolean update(Employee emp);
	public Employee getEmployee(String empId) throws EmployeeNotFoundException; 
	public List<Employee> display();

}