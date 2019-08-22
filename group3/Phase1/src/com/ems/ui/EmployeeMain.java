package com.ems.ui;
import com.ems.dao.*;
import com.ems.model.*;
import com.ems.util.*;
import com.ems.service.*;
import java.time.LocalDate;
import java.util.List;
public class EmployeeMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LocalDate date=LocalDate.of(1992, 6, 22);
		Employee e1=new Employee("101","rahul",date,25000.0);
		Employee e2=new Employee("123","shubham",date,25200.0);
		Employee e3=new Employee("161","kartik",date,21000.0);
		EmployeeService em=new EmployeeServiceImpl(new EmployeeDaoImpl());
		try{
			em.validateEmployee(e1);
		}
		catch(InvalidDateException e)
		{
			System.out.println(e.getMessage());
		}
		catch(InvalidLengthException e)
		{
			System.out.println(e.getMessage());
		}
		catch(InvalidSalaryException e)
		{
			System.out.println(e.getMessage());
		}
		boolean up=em.update(e1);
		up=em.update(e2);
		up=em.update(e3);
		List<Employee> list=em.display();
		for(Employee e:list)
		{
			System.out.println(e);
		}
		up=em.delete("101");
		System.out.println("after deletion");
		list=em.display();
		for(Employee e:list)
		{
			System.out.println(e);
		}
		
	}
	}
