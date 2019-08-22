package com.ems.ui;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

//import java.util.Date;
import com.ems.dao.DAO;
import com.ems.dao.DAOJDBCImpl;
import com.ems.model.Employee;
import com.ems.service.EmployeeService;
import com.ems.service.EmployeeServiceImpl;
import com.ems.util.EmployeeNotFoundException;

public class UI {

	EmployeeService service=new EmployeeServiceImpl(new DAOJDBCImpl());
	public static void main(String args[]) throws Exception
	{
		UI ui=new UI();
		ui.runUI();
	}
	private void runUI() throws Exception {
		int ch;
		do
		{
			Scanner s=new Scanner(System.in);
			System.out.println("****MENU****\n1.ADD EMPLOYEE\n2.DELETE EMPLOYEE\n3.UPDATE EMPLOYEE\n4.DISPLAY ALL\n5.DISPLAY BY ID\n6.Exit\nEnter choice");
			ch=s.nextInt();
			switch(ch)
			{
				case 1:	
						String id1 = service.generateId();
						System.out.println(id1);
						LocalDate d=LocalDate.of(1993, 2, 13);
						Employee emp=new Employee(id1,"pari",d,25000);
						service.validateEmployee(emp);
						addEmployee(emp);
						break;
				case 2:
						System.out.println("Enter EmpId for deletion");
						String e=s.next();
						del(e);
						break;	
				case 3:
						System.out.println("Enter EmpId for updation");
						String eid=s.next();
						System.out.println("Enter Empname for updation");
						String n=s.next();
						updated(eid,n);
						break;
				case 4:
						display();
						break;
				case 5:
						System.out.println("Enter EmpId");
						String eeid=s.next();
						fetch(eeid);
						break;	
				case 6:break;
			}
			
			
		
	
	
		}while(ch!=6);
	}
	private void fetch(String e) throws EmployeeNotFoundException
	{
		System.out.println(service.getEmployee(e));
	}
	private void updated(String e,String n)
	{
		service.update(e,n);
		
	}
	private void addEmployee(Employee emp){
		service.save(emp);
		System.out.println("Employee added");
	}
	
	public void display()
	{
		List<Employee> employees=service.display();
		for(Employee o:employees )
		{
			System.out.println(o);
		}
		
	}
	
	public void del(String eid)
	{
		service.delete(eid);
	
	}
	
	
	
	
	
}
