package com.hackbulgaria;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		LinkedList<String> users = new LinkedList<>();
		
		users.add("Kamen");
		users.add("Maken");
		
		
		String usersString = "<ul>";
		for (String u : users) {
			usersString += "<li>" + u + "</li>";
		}
		usersString += "</ul>";
		
		
		response.
			getWriter()
			.write("<h1>Hello Hack!</h1>" + usersString);*/
		
		LinkedList<String> users = new LinkedList<>();
		
		users.add("Kamen");
		users.add("Maken");
		
		request.getSession().setAttribute("message", "hello");
		request.getSession().setAttribute("title", "ToDo List");
		request.getSession().setAttribute("users",users);
		
		RequestDispatcher view = 
				request.getRequestDispatcher("index.jsp");
		
		view.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
