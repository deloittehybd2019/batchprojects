package com.ems.service;

import java.time.LocalDate;
import java.util.List;

import com.ems.dao.DAO;
import com.ems.model.Employee;
import com.ems.util.CustomerNotFoundException;
import com.ems.util.InvalidDateException;
import com.ems.util.InvalidLengthException;
import com.ems.util.InvalidSalaryException;

public class EmployeeServiceImpl implements EmployeeService {

	private DAO dao;

	public EmployeeServiceImpl(DAO dao) {
		this.dao = dao;
	}

	@Override
	public boolean validateEmployee(Employee emp) throws Exception {
		String name=emp.getEmpName();
		validateLength(name);
		double salary = emp.getBasicSalary();
		validateSalary(salary);
		validateDate(emp.getDOB());
		return true;
	}

	@Override
	public String genearateId(String empname) {

		return dao.generateId();
	}

	@Override
	public boolean save(Employee emp) throws Exception {
		validateEmployee(emp);
		return dao.save(emp);

	}

	@Override
	public boolean delete(String empid) {
		return dao.delete(empid);
	}

	@Override
	public boolean update(Employee emp)throws Exception {
		validateEmployee(emp);
		return dao.update(emp);
	}

	@Override
	public Employee getEmployee(String empId)throws CustomerNotFoundException{
		return dao.getEmployee(empId);
	}

	@Override
	public List<Employee> display() {
		return dao.display();
	}

	public void validateDate(LocalDate date) throws InvalidDateException {
		if (date.getYear() < 1900 || date.getYear() > 1995) {
			throw new InvalidDateException("Year out of range");
		}
	}
	
	public void validateLength(String s) throws InvalidLengthException{
		int len = s.length();
		if (len < 4 || len > 15) {
			throw new InvalidLengthException("invalid name");
		}
	}
	public void validateSalary(double salary) throws InvalidSalaryException{
		if (salary < 20000 || salary > 80000) {
			throw new InvalidSalaryException("invalid salary");
		}
	}
}
