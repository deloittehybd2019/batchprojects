package com.ems.dao;

import java.util.List;

import com.ems.model.Employee;
import com.ems.util.EmployeeNotFoundException;

public interface DAOInterface {
	
//	public boolean validateEmployee(Employee emp) throws Exception;
	public void save(Employee emp);
	public void delete(String empid);
	public void update(String emp,String n);
	public Employee getEmployee(String empid) throws EmployeeNotFoundException;
	public List<Employee> display();


}
