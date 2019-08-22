package com.ems.dao;

import oracle.jdbc.driver.OracleDriver;
import com.ems.model.Employee;
import com.ems.util.EmployeeNotFoundException;
import com.ems.util.Util;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class EmployeeJdbcDaoImpl implements IEmployeeDao {

    private Util util=new Util();

    private int generatedId;

    @Override
    public String generateId() {
        generatedId++;
        String idStr = "" + generatedId;
        return idStr;
    }

    @Override
    public boolean save(Employee employee) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "insert into employees(id,name,salary,birthdate) values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getEmpId());
            preparedStatement.setString(2, employee.getEmpName());
            LocalDate date=employee.getDOB();
            Date desired=util.convert(date);
            preparedStatement.setDouble(3,employee.getBasicSalary());
            preparedStatement.setDate(4,desired);
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
    public boolean delete(Employee employee) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "delete from employees where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getEmpId());
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
    public Employee getEmployee(String id) throws EmployeeNotFoundException {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "select * from employees where id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (!resultSet.next()) {
                throw new EmployeeNotFoundException("employee not found");
            }
            String name = resultSet.getString("name");
            double salary=resultSet.getDouble("salary");
            Date date=resultSet.getDate("birthdate");
            LocalDate desired=util.convert(date);
            Employee employee = new Employee(id, name,salary, desired);
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
            String sql = "update employees set name=? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getEmpName());
            preparedStatement.setString(2, employee.getEmpId());
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
            List<Employee> customers = new ArrayList<>();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                Date date=resultSet.getDate("birthdate");
                double salary=resultSet.getDouble("salary");
                LocalDate desired=util.convert(date);
                Employee employee = new Employee(id, name,salary,desired);
                customers.add(employee);
            }
            return customers;
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

