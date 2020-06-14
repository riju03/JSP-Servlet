package org.studyeasy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/Demo")
public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Resource(name = "jdbc/project") // helps to import and get access to external resource file
	private DataSource dataSource; // creating object of data source, container
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Step 1: Initialize connection objects
		PrintWriter out = response.getWriter();
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		// connecting to the database, there is always scope of error in connection so we should do all activity in try block
		try {
			connect = dataSource.getConnection();
			//step2 : create sql statement String
			
			String query = "Select * from users";
			
			//create statement
			stmt = connect.createStatement();   
			
			//step 3: execute sql query
			
			rs = stmt.executeQuery(query);
			
			//step 4 : process result set
			
			while(rs.next()) {
				out.print("<br/>"+rs.getString("username"));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		
		
           

}}








