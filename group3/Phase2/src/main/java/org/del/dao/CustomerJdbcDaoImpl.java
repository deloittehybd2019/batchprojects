package org.del.dao;

import oracle.jdbc.driver.OracleDriver;
import org.del.entities.Customer;
import org.del.exceptions.CustomerNotFoundException;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class CustomerJdbcDaoImpl implements ICustomerDao {

  

    private int generatedId;

    @Override
    public String generateId() {
        generatedId++;
        String idStr = "" + generatedId;
        return idStr;
    }

    @Override
    public void add(Customer customer) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "insert into customer(id,pass,name,country) values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getId());
            preparedStatement.setString(2, customer.getPass());
            preparedStatement.setString(3, customer.getName());
            preparedStatement.setString(4, customer.getCountry());
    
            preparedStatement.execute();
            int count = preparedStatement.getUpdateCount();
            System.out.println(count + "rows inserted");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(connection);
        }

    }

  

    @Override
    public Customer findCustomerById(String id) throws CustomerNotFoundException {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "select * from customer where id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (!resultSet.next()) {
                throw new CustomerNotFoundException("customer not found");
            }
            String id1 = resultSet.getString("id");
            String pass1 = resultSet.getString("pass");
            String name1 = resultSet.getString("name");
            String country1 = resultSet.getString("country");
            
          
            Customer customer = new Customer(id1,pass1, name1,country1);
            return customer;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            close(connection);
        }
    }

    @Override
    public void update(Customer customer) {
        try {
            Connection connection = getConnection();
            String sql = "update customer set name=? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getId());
            preparedStatement.execute();
            int count = preparedStatement.getUpdateCount();
            System.out.println(count + "rows updated");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public List<Customer> allCustomers() {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "select * from customer";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            List<Customer> customers = new ArrayList<>();
            while (resultSet.next()) {
            	String id = resultSet.getString("id");
                String pass = resultSet.getString("pass");
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");
                Customer customer = new Customer(id,pass, name,country);
                customers.add(customer);
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



}




