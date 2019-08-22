package com.ems.dao;

import com.ems.model.Employee;
import com.ems.util.EmployeeNotFoundException;

import java.util.*;

public class EmployeeDaoImpl implements IEmployeeDao {
    private Map<String, Employee> map = new HashMap<>();
    private int generatedId;

    @Override
    public String generateId() {
        generatedId++;
        String idStr = "" + generatedId;
        return idStr;
    }

    @Override
    public boolean save(Employee emp) {
        map.put(emp.getEmpId(), emp);
        return true;
    }

    @Override
    public boolean delete(Employee emp) {
        map.remove(emp.getEmpId());
        return true;
    }

    @Override
    public boolean update(Employee emp) {
        map.put(emp.getEmpId(), emp);
        return true;
    }

    @Override
    public Employee getEmployee(String empId) throws EmployeeNotFoundException {
        Employee emp = map.get(empId);
        if (emp == null) {
            throw new EmployeeNotFoundException("Employee not found of id=" + empId);
        }
        return emp;
    }

    public List<Employee> display() {
        Collection<Employee> values = map.values();
        List<Employee> list = new ArrayList<>(values);
        return list;
    }
}
