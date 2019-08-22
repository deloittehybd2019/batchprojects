package org.del.service;

import org.del.dao.IEmployeeDao;
import org.del.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeDao employeeDao;

    public void setEmployeeDao(IEmployeeDao dao) {
        this.employeeDao = dao;
    }

    public IEmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    @Transactional
    @Override
    public void save(Employee employee) {
        getEmployeeDao().save(employee);
    }

    @Transactional
    @Override
    public Employee update(Employee employee) {
        employee = getEmployeeDao().update(employee);
        return employee;
    }

    @Transactional
    @Override
    public void remove(Employee employee) {
        getEmployeeDao().remove(employee);
    }

    @Transactional
    @Override
    public Employee findEmployeeById(int id) {
        Employee employee=getEmployeeDao().findEmployeeById(id);
        return employee;
    }
}
