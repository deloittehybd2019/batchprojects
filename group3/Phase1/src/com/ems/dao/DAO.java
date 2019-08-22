package com.ems.dao;
import com.ems.util.*;
import java.util.List;
import com.ems.model.*;

public interface DAO {
	public boolean  save(Employee emp);
	public boolean  delete (String empId);
	public boolean update (Employee emp);
	public Employee  getEmployee(String empId) throws EmployeeNotFoundException;
	public List<Employee> display();
	public String generateId();
	boolean delete(Employee employee);
}
