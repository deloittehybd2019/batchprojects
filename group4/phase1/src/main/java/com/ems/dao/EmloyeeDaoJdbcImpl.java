package com.ems.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ems.model.Employee;
import com.ems.util.CustomerNotFoundException;
import com.ems.util.Util;

import oracle.jdbc.driver.OracleDriver;

public class EmloyeeDaoJdbcImpl implements DAO {
		
	Util util = new Util();
	
	@Override
	public boolean save(Employee employee) {
		Connection connection = null;
		try {
			connection = getConnection();
			String sql = "insert into employee(id,name,dob,salary) values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			String id=generateId();
			preparedStatement.setString(1,id);
			preparedStatement.setString(2, employee.getEmpName());
			Date d = util.convert(employee.getDOB());
			preparedStatement.setDate(3, d);
			preparedStatement.setDouble(4, employee.getBasicSalary());

			preparedStatement.execute();
			 int count = preparedStatement.getUpdateCount();
		      System.out.println("rows inserted = "+count);	 
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			close(connection);
		}
		return true;
	}

	@Override
	public boolean delete(String empid) {
		Connection connection = null;
		try {
			connection = getConnection();
			String sql = "delete from employee where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, empid);
			preparedStatement.execute();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			close(connection);
		}
		return true;
	}

	@Override
	public Employee getEmployee(String id) throws CustomerNotFoundException{
		Connection connection = null;
		try {
			connection = getConnection();
			String sql = "select * from employee where id =?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getResultSet();
			while(!(resultSet.next()))
			{
				throw new CustomerNotFoundException();
			}
			String name = resultSet.getString("name");
			Date date = resultSet.getDate("dob");
			LocalDate desired = util.convert(date);
			double basicSalary = resultSet.getDouble("salary");
			Employee employee = new Employee(name, desired, basicSalary);
			employee.setEmpId(id);
			return employee;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		} finally {
			close(connection);
		}
	}

	@Override
	public boolean update(Employee employee) {
		try {
			Connection connection = getConnection();
			String sql = "update employee set name=? where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, employee.getEmpName());
			preparedStatement.setString(2, employee.getEmpId());
			preparedStatement.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return true;
	}

	@Override
	public List<Employee> display() {
		Connection connection = null;
		try {
			connection = getConnection();
			String sql = "select * from employee";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getResultSet();
			List<Employee> emp = new ArrayList<>();
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String name = resultSet.getString("name");
				Date date = resultSet.getDate("dob");
				LocalDate desired = util.convert(date);
				double basicSalary = resultSet.getDouble("salary");
				Employee employee = new Employee(name, desired, basicSalary);
				employee.setEmpId(id);
				emp.add(employee);
			}
			return emp;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		} finally {
			close(connection);
		}
	}

	void close(Connection connection) {

		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	
	public Connection getConnection() {
		Connection connection = null;
		try {
			DriverManager.registerDriver(new OracleDriver());

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			connection = DriverManager.getConnection(url, "scott", "tiger");
			return connection;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	int count = 0;

	@Override
	public String generateId() {
		count++;
		String s = "" + count;
		return s;
	}

}
