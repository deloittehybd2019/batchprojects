package org.del.service;

import org.del.dao.IEmployeeDao;
import org.del.entities.Employee;
import org.del.exceptions.EmployeeNotFoundException;
import org.del.exceptions.InvalidArgumentException;
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
    public Employee findEmployeeById(int id) throws EmployeeNotFoundException {
        Employee employee = getEmployeeDao().findEmployeeById(id);
        return employee;
    }

    @Override
    public boolean checkCredentials(int id, String password) {
        if(password==null){
            notEmpty(password);
        }
        boolean result = getEmployeeDao().checkCredentials(id, password);
        return result;
    }

    /**
     * validates string is not null and not empty
     */
    public void notEmpty(String arg){
        if(arg==null || arg.isEmpty()){
            throw new InvalidArgumentException(arg +" is empty");
        }
    }
}
