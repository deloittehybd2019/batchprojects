package com.ems.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ems.model.User;

import oracle.jdbc.driver.OracleDriver;

public class UserJdbcImpl implements DAO {

    private int count;

    @Override
    public void add(User user) {
        int id = generateId();
        Connection c = null;
        try {
            c = getConnection();
            String sql = "insert into user1(id,email_id,password,name,country) values (?,?,?,?,?)";
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, user.getEmail_id());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getName());
            stmt.setString(5, user.getCountry());
            stmt.execute();
            int c1 = stmt.getUpdateCount();
            System.out.println("rows inserted:" + c1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(c);
        }
    }

    @Override
    public User find(String email_id) {
        Connection c = null;
        try {
            c = getConnection();
            String sql = "select * from user1 where email_id=?";
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, email_id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            if (rs.next() == false) {
                User u = null;
                return u;
            }
            String password = rs.getString("password");
            String name = rs.getString("name");
            String country = rs.getString("country");
            User user = new User(email_id, password, name, country);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            close(c);
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

    @Override
    public int generateId() {
        count++;
        return count;
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

}
