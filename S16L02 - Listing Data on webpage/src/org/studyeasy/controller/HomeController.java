package org.studyeasy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.studyeasy.entity.User;
import org.studyeasy.model.UsersModel;


@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/project") //using this resource we will connect to the database
	
	private DataSource dataSource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getParameter("page");
		page = page.toLowerCase();
		
		switch(page) {
		case "home":
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
			
		case "listusers":
			
			List<User> listUsers = new ArrayList<>();
			// we will recieve the information from database inside this list
			
			listUsers = new UsersModel().listUsers(dataSource);
			// now set the information to the jsp file
			
			request.setAttribute("listUsers", listUsers);
			
			
			request.getRequestDispatcher("listUser.jsp").forward(request, response);
			
			
		
		default:
			request.getRequestDispatcher("error.jsp").forward(request, response);
			
		}
		
	}

}
