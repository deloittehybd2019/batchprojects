package com.ems.frontend;

import java.time.LocalDate;
import java.util.List;
import com.ems.dao.DAO;
import com.ems.dao.IDAO;
import com.ems.dao.JdbcDaoImpl;
import com.ems.model.Employee;
import com.ems.service.EmployeeService;
import com.ems.service.EmployeeServiceImpl;

public class UI {
EmployeeService service = new EmployeeServiceImpl(new JdbcDaoImpl());
	
	public static void main(String[] args) {
			UI ui = new UI();
			ui.runUi();
	}
	public void runUi()  {
		LocalDate localDate=LocalDate.of(2000, 10, 17);
		Employee emp = new Employee("Aoawe",localDate,50000);
		String id = service.generateId(emp.getEmpName());
		emp.setEmpId(id);
		
		try {
			service.validateEmployee(emp);
			// TODO Auto-generated catch block
		
		service.save(emp);
		
		/*LocalDate localDate1=LocalDate.of(1992, 10, 17);
		Employee emp1 = new Employee("Alawe",localDate1,70000);
		String id1 = service.generateId(emp1.getEmpName());
		emp1.setEmpId(id1);
		service.save(emp1);*/
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		displayEmployees();
	}
	
	public void displayEmployees() {
		List<Employee>emps=service.display();
		for(Employee e : emps)
		{
			System.out.println(e);
		}
	}
}
