package com.ems.service;

import java.time.LocalDate;
import java.util.List;

import com.ems.dao.DAO;
import com.ems.dao.IDAO;
import com.ems.model.Employee;
import com.ems.util.EmployeeNotFoundException;
import com.ems.util.InvalidDateException;
import com.ems.util.InvalidLengthException;
import com.ems.util.InvalidSalaryException;

public class EmployeeServiceImpl implements EmployeeService{
	private IDAO dao;
	
	public EmployeeServiceImpl(IDAO dao){
		this.dao = dao;
	}
	

	public boolean validateEmployee(Employee emp) throws Exception{
		validateEmpId(emp.getEmpId());
		validateSalary(emp.getBasicSalary());
		validateDate(emp.getDOB());
		return true;
	}
	
	public void validateEmpId(String empId) throws InvalidLengthException{
		int l = empId.length();
		if(l!=6) {
			throw new InvalidLengthException("invalid length");
		}
	}
	
		public void validateSalary(double salary) throws InvalidSalaryException{
			if(salary<20000||salary>80000) {
				throw new InvalidSalaryException("invalid salary");
			}
		}
		public void validateDate(LocalDate date) throws InvalidDateException{
			if(date.getYear()<1900||date.getYear()>1995) {
				throw new InvalidDateException("invalid date");
			}
		}
	
	public String generateId(String empName) {
		return dao.generateId(empName);
	}
	public boolean save(Employee emp) {
		return dao.save(emp);
	}
	public boolean delete(String empId) {
		return dao.delete(empId);
	}
	public boolean update(Employee emp) {
		return dao.update(emp);
	}
	public Employee getEmployee(String empId) throws EmployeeNotFoundException {
		return dao.getEmployee(empId);
	}
	public List<Employee> display(){
		return dao.display();
	}
}
