package org.del.service;

import org.del.entities.Employee;

public interface IEmployeeService {

    void save(Employee employee);

    Employee update(Employee employee);

    void remove(Employee employee);

    Employee findEmployeeById(int id);

}