package org.del.dao;

import org.del.entities.Employee;

public interface IEmployeeDao {

    void save(Employee employee);

    Employee update(Employee employee);

    void remove(Employee employee);

    Employee findEmployeeById(int id);

}
