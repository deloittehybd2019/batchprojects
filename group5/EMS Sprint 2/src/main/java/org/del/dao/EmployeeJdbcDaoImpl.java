package org.del.dao;

import oracle.jdbc.driver.OracleDriver;
import org.del.entities.Employee;
import org.del.entities.Employee;
import org.del.exceptions.EmployeeNotFoundException;

//import com.ems.util.EmployeeNotFoundException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeJdbcDaoImpl implements IEmployeeDao {

	@Override
	public void addEmployee(Employee employee) {
		Connection connection = null;
		try {
			connection = getConnection();
			String sql = "insert into empregistration(email,password,name,country) values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, employee.getEmailId());
			preparedStatement.setString(2, employee.getPassword());
			preparedStatement.setString(3, employee.getName());
			preparedStatement.setString(4, employee.getCountry());

			preparedStatement.execute();
			int count = preparedStatement.getUpdateCount();
			System.out.println(count + "rows inserted");
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			};
		}
	}

	
	@Override
	public Employee showEmployee(String email) throws EmployeeNotFoundException {
		 Connection connection = null;
	        try {
	            connection = getConnection();
	            String sql = "select * from empregistration where email = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            
	            preparedStatement.setString(1, email);
	            preparedStatement.execute();
	            ResultSet resultSet = preparedStatement.getResultSet();
	            if (!resultSet.next()) {
	                throw new EmployeeNotFoundException("Employee not found");
	            }
	            String password = resultSet.getString("password");
	            String name = resultSet.getString("name");
	            String country = resultSet.getString("country");
	            Employee emp = new Employee(email, password, name, country);
	            return emp;

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            return null;
	        } finally {
	            try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	        }
	    }
	
	
	Connection getConnection() {
		Connection connection = null;
		try {
			DriverManager.registerDriver(new OracleDriver());// 1)registering driver

			// Class.forName("oracle.jdbc.driver.OracleDriver");// 1)registering driver

			// String url = "jdbc:postgresql://localhost:5432/students";//url for connection
			// with database
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			connection = DriverManager.getConnection(url, "scott", "tiger");
			return connection;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
