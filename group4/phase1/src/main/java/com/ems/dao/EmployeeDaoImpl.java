package com.ems.dao;

import java.util.*;
import java.util.List;

import com.ems.model.Employee;

public class EmployeeDaoImpl implements DAO {
	private int count = 0;
	private Map<String, Employee> empMap = new HashMap<>();

	public EmployeeDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean save(Employee emp) {
		String id=generateId();
		emp.setEmpId(id);
		empMap.put(emp.getEmpId(), emp);
		return true;
	}

	@Override
	public boolean delete(String empid) {
		empMap.remove(empid);
		return true;
	}

	@Override
	public boolean update(Employee emp) {
		String id=generateId();
		emp.setEmpId(id);
		empMap.put(emp.getEmpId(), emp);
		return true;
	}

	@Override
	public Employee getEmployee(String empId) {
		Employee e = empMap.get(empId);
		return e;
	}

	@Override
	public List<Employee> display() {
		Collection<Employee> values = empMap.values();
		List<Employee> l = new ArrayList<>(values);
		return l;
	}

	@Override
	public String generateId() {
		count++;
		String s = "" + count;
		return s;
	}

}
