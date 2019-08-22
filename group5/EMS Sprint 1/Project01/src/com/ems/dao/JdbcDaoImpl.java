package com.ems.dao;
import com.ems.*;
import com.ems.model.Employee;
import com.ems.util.EmployeeNotFoundException;
import com.ems.util.Util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleDriver;


public class JdbcDaoImpl implements IDAO {

    public Util util=new Util();

    int generateId = 1000;
    String EmpId;

    @Override
    public String generateId(String empName) {
    	EmpId = empName.substring(0,2) + generateId;
    	//String EmpId = "" + generateId;
    	generateId++;
		return EmpId;
    }

    @Override
    public boolean save(Employee emp) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "insert into employees(empid,empname,dob,basicsalary) values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, emp.getEmpId());
            preparedStatement.setString(2, emp.getEmpName());
            LocalDate date=emp.getDOB();
            Date desired=util.convert(date);
            preparedStatement.setDate(3,desired);
            preparedStatement.setDouble(4, emp.getBasicSalary());
            preparedStatement.execute();
            int count = preparedStatement.getUpdateCount();
            System.out.println(count + "rows inserted");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(connection);
        }
        return true;
    }

    @Override
    public boolean delete(String empId) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "delete from employees where empid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, empId);
            preparedStatement.execute();
            int count = preparedStatement.getUpdateCount();
            System.out.println(count + "rows deleted");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(connection);
        }
        return true;
    }

    @Override
    public Employee getEmployee(String empId) throws EmployeeNotFoundException {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "select * from employees where empid =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, empId);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (!resultSet.next()) {
                throw new EmployeeNotFoundException("Employee not found");
            }
            String name = resultSet.getString("empname");
            Date date=resultSet.getDate("dob");
            LocalDate desired=util.convert(date);
            double basicSalary =resultSet.getDouble("basicSalary");
            Employee emp = new Employee(empId, name,desired,basicSalary);
            return emp;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            close(connection);
        }
    }

    @Override
    public boolean update(Employee emp) {
        try {
            Connection connection = getConnection();
            String sql = "update employees set empname=? where empid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, emp.getEmpName());
            preparedStatement.setString(2, emp.getEmpId());
            preparedStatement.execute();
            int count = preparedStatement.getUpdateCount();
            System.out.println(count + "rows updated");
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
            String sql = "select * from employees";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            List<Employee> employees= new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getString("empid");
                String name = resultSet.getString("empname");
                Date date=resultSet.getDate("dob");
                //System.out.println(date.getDay()+date.getMonth()+date.getYear());
                LocalDate desired=util.convert(date);
                double basicSalary =resultSet.getDouble("basicsalary");
                Employee emp = new Employee(id, name,desired,basicSalary);
                employees.add(emp);
            }
            return employees;
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

    Connection getConnection() {
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
            return null;
        }
    }

/*
    Connection getConnection() {
        Connection connection = null;
        try {
            DriverManager.registerDriver(new OracleDriver());// 1)registering driver

            //Class.forName("oracle.jdbc.driver.OracleDriver");// 1)registering driver

            String url = "jdbc:postgresql://localhost:5432/students";//url for connection with database
            String oracleUel="jdbc:oracle:thin:@localhost:1521:orcl";
            connection = DriverManager.getConnection(url, "scooby", "scooby123");
            return connection;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }*/
}