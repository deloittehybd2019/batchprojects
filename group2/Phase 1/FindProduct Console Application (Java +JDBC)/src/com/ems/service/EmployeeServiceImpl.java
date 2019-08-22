package com.ems.service;
import java.time.LocalDate;
import java.util.*;

import com.ems.dao.DAOInterface;
import com.ems.model.Employee;
import com.ems.util.EmployeeNotFoundException;
import com.ems.util.InvalidDateException;
import com.ems.util.InvalidLengthException;
import com.ems.util.InvalidSalaryException;
public class EmployeeServiceImpl implements EmployeeService{
		private int generateid=0;
		private DAOInterface dao;
				
		public EmployeeServiceImpl(DAOInterface dao) {
			this.dao = dao;
		}

		public void validateName(Employee emp) throws InvalidLengthException
		{
			if(emp.getEmpName().length()>15 || emp.getEmpName().length()<4)
			{
				throw new InvalidLengthException("Invalid Name");
			}
		}
		
		public void validateDate(LocalDate date) throws InvalidDateException
		{
			if(date.getYear()<1900 || date.getYear()>1995)
				throw new InvalidDateException("Invalid Date");
		}
	
		public void validateSalary(Employee emp) throws InvalidSalaryException
		{
			if(emp.getBasicSalary()>80000 || emp.getBasicSalary()<20000)
			{
				throw new InvalidSalaryException("Invalid Salary");
			}
		}
	public String generateId()
	{
		generateid++;
		String idstr=""+generateid;
		return idstr;
		
		/*Random random=new Random();
		int add= random.nextInt(10000);
		String e=empname.substring(0, 2);
		String id=e+add;
		return id;*/
	}

	@Override
	public boolean validateEmployee(Employee emp) throws Exception {
		// TODO Auto-generated method stub
		validateName(emp);
		validateDate(emp.getDOB());
		validateSalary(emp);
		return true;
	}

	@Override
	public void save(Employee emp){
	//	validateEmployee(emp);
		dao.save(emp);
		// TODO Auto-generated method stub
		//return true;
	}

	@Override
	public void delete(String empid) {
		// TODO Auto-generated method stub
		dao.delete(empid);
		//return true;
	}

	@Override
	public void update(String emp,String n) {
		// TODO Auto-generated method stub
		dao.update(emp,n);
	//	return true;
	}

	@Override
	public Employee getEmployee(String empid) throws EmployeeNotFoundException{
		// TODO Auto-generated method stub
		return dao.getEmployee(empid);
	}

	@Override
	public List<Employee> display() {
		// TODO Aut-generated method stub
		return dao.display();
	}
	
}
