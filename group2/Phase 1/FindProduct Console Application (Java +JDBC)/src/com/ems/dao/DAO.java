package com.ems.dao;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ems.model.Employee;
import com.ems.util.EmployeeNotFoundException;
import com.ems.util.Util;
//import com.ems.util.InvalidLengthException;
//import com.ems.util.InvalidSalaryException;

public class DAO implements DAOInterface{
	
	private Map<String,Employee> map=new HashMap<>();
	
	public void save(Employee emp)//change to boolean afterwards
	{
		map.put(emp.getEmpId(),emp);
	}
	public void delete(String empid)
	{
		
		map.remove(empid);
	//	return true;
		
	}
	public void update(String emp,String n)
	{
		//map.put(emp,emp);
		//return true;
	}
	public Employee getEmployee(String empid) throws EmployeeNotFoundException
	{
		return map.get(empid);
	
	}
	public List<Employee> display()
	{
		Collection<Employee> values=map.values();
		List<Employee> list=new ArrayList<>(values);
		return list;
		
	}
	
	/*public Connection getConnection()
	{
		
	}*/

}
