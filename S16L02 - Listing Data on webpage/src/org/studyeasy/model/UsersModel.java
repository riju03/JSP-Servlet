package org.studyeasy.model;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.studyeasy.entity.User;

public class UsersModel {
	
	public List<User> listUsers(DataSource dataSource) {
		
		List<User> listUsers = new ArrayList<>();
		
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		// connecting to the database, there is always scope of error in connection so we should do all activity in try block
		try {
			// datasource needs to be received from controller itself we won't be able to make connection directly from model
			connect = dataSource.getConnection();
			//step2 : create sql statement String
			
			String query = "Select * from users";
			
		
			
			//create statement
			stmt = connect.createStatement();   
			
			//step 3: execute sql query
			
			rs = stmt.executeQuery(query);
			
			//step 4 : process result set
			
			// here we will create list of users and will be based on entitiy class
			
			while(rs.next()) {
				
				// get user id by rs
				
				listUsers.add(new User(rs.getInt("user_id"),rs.getString("username"), rs.getString("email")));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return listUsers;
		
	}

}
