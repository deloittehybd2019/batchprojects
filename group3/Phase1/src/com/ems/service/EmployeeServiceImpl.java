package com.ems.service;

import java.time.LocalDate;
import java.util.List;
import java.util.List;

import com.ems.dao.DAO;
import com.ems.dao.EmployeeDaoImpl;
import com.ems.model.Employee;
import com.ems.util.InvalidDateException;
import com.ems.util.InvalidLengthException;
import com.ems.util.InvalidSalaryException;
import com.ems.util.*;
public class EmployeeServiceImpl implements EmployeeService{

    private DAO dao;

    public EmployeeServiceImpl(DAO employeeDaoImpl) {
    	this.dao=employeeDaoImpl;
	}

	public void validateEmployee(Employee emp) throws InvalidDateException, InvalidSalaryException, InvalidLengthException {
        validateName(emp.getEmpName());
        validateSalary(emp.getBasicSalary());
        validateDOB(emp.getDOB());

    }

    public void validateDOB(LocalDate date) throws InvalidDateException {
        if (date.getYear() < 1990 || date.getYear() > 1995) {
            throw new InvalidDateException("year out of range");
        }
    }

    public void validateSalary(double salary) throws InvalidSalaryException {
        if (salary < 20000 || salary > 80000) {
            throw new InvalidSalaryException("Salary out of range");
        }
    }

    public void validateName(String name) throws InvalidLengthException {
        if (name.length() < 4 || name.length() > 15) {
            throw new InvalidLengthException("Name length out of range");
        }
    }
	@Override
	public String generateId(String empName) {
		return dao.generateId();
	}
	@Override
	public boolean save(Employee emp) {
		return dao.save(emp);
	}
	@Override
	public boolean delete(String empId) {
		return dao.delete(empId);
	}
	@Override
	public boolean update(Employee emp) {
		return dao.update(emp);
	}
	@Override
	public Employee getEmployee(String empId)throws EmployeeNotFoundException{
		return dao.getEmployee(empId);
	}
	@Override
	public  List<Employee> display()
	{ 
		return dao.display();
	}
	
	public void validateDate(LocalDate date) throws InvalidDateException
	{
		if(date.getYear()<1900||date.getYear()>1995){
			throw new InvalidDateException("Year out of range");
		}
}
}
	