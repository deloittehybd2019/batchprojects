package org.del.dao;

import org.del.entities.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public Employee update(Employee employee) {
        employee = entityManager.merge(employee);
        return employee;
    }

    @Override
    public void remove(Employee employee) {
        entityManager.remove(employee);
    }

    @Override
    public Employee findEmployeeById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;

    }
}

