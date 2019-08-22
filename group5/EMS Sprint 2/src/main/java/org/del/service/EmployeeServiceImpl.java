package org.del.service;

import org.del.dao.IEmployeeDao;
import org.del.entities.Employee;
import org.del.exceptions.EmployeeNotFoundException;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {

	private IEmployeeDao dao;

	public IEmployeeDao getDao() {
		return dao;
	}

	public EmployeeServiceImpl(IEmployeeDao dao) {
		this.dao = dao;
	}

	@Override
	public void add(Employee employee) {
		dao.addEmployee(employee);
	}

	@Override
	public Employee showEmployee(String email) throws EmployeeNotFoundException {
		return dao.showEmployee(email);
	}

}
