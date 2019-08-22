package com.ems.dao;

import java.util.List;

import com.ems.model.Employee;
import com.ems.util.CustomerNotFoundException;

public interface DAO {
	public boolean  save(Employee emp);
	public  boolean  delete (String empid);
	public  boolean update (Employee emp);
	public Employee  getEmployee( String empId) throws CustomerNotFoundException;
	public  List<Employee> display();
	//public Connection getConnection();
	public String generateId();



}
