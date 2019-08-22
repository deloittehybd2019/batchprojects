package com.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



import java.sql.Date;
import java.sql.DriverManager;

import com.ems.model.Employee;
import com.ems.util.EmployeeNotFoundException;
import com.ems.util.Util;

import oracle.jdbc.driver.OracleDriver;

public class DAOJDBCImpl implements DAOInterface{

	public void save(Employee emp)//change to boolean afterwards
	{
		 Connection connection = null;
	        try {
	            connection = getConnection();
	            String sql = "insert into Employees values(?,?,?,?)";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, emp.getEmpId());
	            preparedStatement.setString(2, emp.getEmpName());
	            LocalDate date=emp.getDOB();
	            Date desired=Util.convert(date);
	            preparedStatement.setDate(3,desired);
	            preparedStatement.setDouble(4,emp.getBasicSalary());
	            preparedStatement.execute();
	            int count = preparedStatement.getUpdateCount();
	            System.out.println(count + "rows inserted");
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	          
	        }

		
	}

	private Connection getConnection() {
		// TODO Auto-generated method stub
		 Connection connection = null;
	        try {
	            DriverManager.registerDriver(new OracleDriver());// 1)registering driver

	            //Class.forName("oracle.jdbc.driver.OracleDriver");// 1)registering driver

	           // String url = "jdbc:postgresql://localhost:5432/students";//url for connection with database
	            String url="jdbc:oracle:thin:@localhost:1521:orcl";
	            connection = DriverManager.getConnection(url, "scott", "tiger");
	            return connection;

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
		return null;
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
	 
	 @Override
	    public void update(String emp,String n) {
	        try {
	            Connection connection = getConnection();
	            String sql = "update Employees set empName=? where empId=?";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            System.out.println(n+" "+emp);
	            preparedStatement.setString(1,n);
	            preparedStatement.setString(2,emp);
	            
	            preparedStatement.execute();
	            int count = preparedStatement.getUpdateCount();
	            System.out.println(count + "rows updated");
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }

	@Override
	public void delete(String empid) {
		// TODO Auto-generated method stub
		 Connection connection = null;
	        try {
	            connection = getConnection();
	            String sql = "delete from Employees where empId=?";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1,empid);
	            preparedStatement.execute();
	            int count = preparedStatement.getUpdateCount();
	            System.out.println(count + "rows deleted");
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            close(connection);
	        }
		
	}

	@Override
	public Employee getEmployee(String empid) throws EmployeeNotFoundException {
		 Connection connection = null;
	        try {
	            connection = getConnection();
	            System.out.println(empid);
	            String sql = "select * from employees where empId =?";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, empid);
	            preparedStatement.execute();
	            ResultSet resultSet = preparedStatement.getResultSet();
	            if (!resultSet.next()) {
	              throw new EmployeeNotFoundException("No such Employee");
	            }
	            String name = resultSet.getString("empName");
	            Date date=resultSet.getDate("DOB");
	            LocalDate desired=Util.convert(date);
	            Double bs=resultSet.getDouble("basicSalary");
                Employee emp1 = new Employee(empid, name,desired,bs);
	            return emp1;

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            return null;
	        } finally {
	            close(connection);
	        }
	}

	@Override
	public List<Employee> display() {
		// TODO Auto-generated method stub
		Connection connection = null;
        try {
            connection = getConnection();
            String sql = "select * from Employees";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            List<Employee> emp= new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getString("empId");
                String name = resultSet.getString("empName");
                Date date=resultSet.getDate("DOB");
                LocalDate desired=Util.convert(date);
                Double bs=resultSet.getDouble("basicSalary");
                Employee emp1 = new Employee(id, name,desired,bs);
                emp.add(emp1);
            }
            return emp;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            close(connection);
        }
		
	}
}
