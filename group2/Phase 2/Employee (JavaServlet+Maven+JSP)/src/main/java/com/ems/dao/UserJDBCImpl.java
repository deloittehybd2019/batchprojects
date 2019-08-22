package com.ems.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ems.exceptions.UserNotFoundException;
import com.ems.model.User;

import oracle.jdbc.driver.OracleDriver;

public class UserJDBCImpl implements IUserDao{



	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		 
        try
        {
        	DriverManager.registerDriver(new OracleDriver());
            Connection connection = null;
            System.out.println("Hi");
            String url="jdbc:oracle:thin:@localhost:1521:orcl";
           	connection = DriverManager.getConnection(url, "scott", "tiger");
            String sql = "insert into registration(emailid,pwd,name,country) values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getEmailid());
            preparedStatement.setString(2,user.getPwd());
            preparedStatement.setString(3,user.getName());
            preparedStatement.setString(4,user.getCountry());
            preparedStatement.execute();
            int count = preparedStatement.getUpdateCount();

        }
        catch(Exception e){
        		System.out.print(e.getMessage());
        	}
		
	}

	@Override
	public User findUserById(String id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		try {
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection connection = null;
        
    	String url="jdbc:oracle:thin:@localhost:1521:orcl";
		     try {
				connection = DriverManager.getConnection(url, "scott", "tiger");
	       	  String sql = "select * from registration where emailid=?";
	            PreparedStatement preparedStatement;
			
					preparedStatement = connection.prepareStatement(sql);
			
					preparedStatement.setString(1,id);
					preparedStatement.execute();
		            ResultSet resultSet = preparedStatement.getResultSet();
		            if (!resultSet.next()) {
		                throw new UserNotFoundException("user not found");
		            }
		            String name=resultSet.getString(3);
		            String country=resultSet.getString(4);
		            String pwd=resultSet.getString(2);
		            User u=new User(id,pwd,name,country);
		            return u;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            return null;
	}
	
}
