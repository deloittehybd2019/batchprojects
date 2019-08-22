package com.ems.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ems.model.Employee;

public class DAO implements IDAO{
	private Map<String,Employee> map = new HashMap<>();
	int generateId = 1000;
	public String generateId(String empName) {
		//String num = generateId;
		String EmpId = empName.substring(0,2) + generateId;
		generateId++;
		return EmpId;
	}
	public boolean save(Employee emp) {
		String name = emp.getEmpName();
		String generatedId=generateId(name);
		emp.setEmpId(generatedId);
		map.put(emp.getEmpId(),emp);
		return true;
	}
	public boolean delete(String empId) {
		map.remove(empId);
		return true;
	}
	public boolean update(Employee emp) {
		map.put(emp.getEmpId(),emp);	
		return true;
	}
	public Employee getEmployee(String empId) {
		Employee emp = map.get(empId);
		return emp;
	}
	public List<Employee> display(){
		Collection<Employee>values = map.values();
		List<Employee>list = new ArrayList<>(values);
		return list;
	}
	//public Connection getConnection() {	}
	
}
