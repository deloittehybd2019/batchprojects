package com.ems.dao;

import com.ems.model.*;
import com.ems.util.EmployeeNotFoundException;

import java.util.*;
import java.util.List;

public class EmployeeDaoImpl implements DAO{
	
	private int count=0;
	private Map<String,Employee> empMap=new HashMap<>();
	public EmployeeDaoImpl() {
		
	}
	
	@Override
	public boolean save(Employee emp) {
		empMap.put(emp.getEmpId(),emp);
		return true;
	}
	@Override
	public boolean delete(String empId) {
		empMap.remove(empId);
		return true;
	}
	@Override
	public boolean update(Employee emp) {
		empMap.put(emp.getEmpId(),emp);
		return true;
	}
	@Override
	public Employee getEmployee(String empId) throws EmployeeNotFoundException {
		Employee e=empMap.get(empId);
		if (e == null) {
            throw new EmployeeNotFoundException("Employee not found of id=" + empId);
        }
		return e;
	}
	@Override
	public List<Employee> display(){
		Collection<Employee> values =empMap.values();
		List<Employee> L=new ArrayList<>(values);
		return L;
	}
	@Override
	public String generateId() {
		count++;
		String s=""+count;
		return s;
	}

	@Override
	public boolean delete(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}
}
