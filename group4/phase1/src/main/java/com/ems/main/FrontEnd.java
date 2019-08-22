package com.ems.main;

import java.time.LocalDate;
import java.util.List;

import com.ems.dao.EmloyeeDaoJdbcImpl;
import com.ems.dao.EmployeeDaoImpl;
import com.ems.model.Employee;
import com.ems.service.EmployeeService;
import com.ems.service.EmployeeServiceImpl;
import com.ems.util.InvalidDateException;
import com.ems.util.InvalidLengthException;
import com.ems.util.InvalidSalaryException;

public class FrontEnd {

	public static void main(String[] args) throws Exception {
		LocalDate date = LocalDate.of(2002, 6, 22);
		LocalDate date1 = LocalDate.of(1990, 6, 22);
		EmployeeService em = new EmployeeServiceImpl(new EmloyeeDaoJdbcImpl());

		Employee e1 = new Employee("mansi", date1, 25000.0);
		Employee e2 = new Employee("trish", date1, 25200.0);
		Employee e3 = new Employee("jasprit", date1, 21000.0);
		Employee[] empArray = { e1, e2, e3 };
		boolean up;
		for (Employee e : empArray) {
			try {
				up = em.save(e);

			} catch (InvalidDateException ex) {
				System.out.println(ex.getMessage());
			} catch (InvalidLengthException ex) {
				System.out.println(ex.getMessage());
			} catch (InvalidSalaryException ex) {
				System.out.println(ex.getMessage());
			}
		}
		List<Employee> list = em.display();
		for (Employee e : list) {
			System.out.println(e);
		}
		up=em.delete("1");
		// System.out.println("after deletion");
		// list=em.display();
		// for(Employee e:list)
		// {
		// System.out.println(e);
		// }
		
	}

}
