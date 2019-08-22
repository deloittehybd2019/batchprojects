package com.ems.service;

import java.util.List;

import com.ems.model.Employee;
import com.ems.util.CustomerNotFoundException;

public interface EmployeeService {
	public boolean validateEmployee(Employee emp)  throws Exception ;
	public  String  genearateId(String empname);
	public boolean  save(Employee emp) throws Exception ;
	public  boolean  delete (String empid);
	public  boolean update (Employee emp)throws Exception;
	public Employee  getEmployee( String empId) throws CustomerNotFoundException;
	public  List<Employee> display();

}
