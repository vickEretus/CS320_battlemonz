package edu.ycp.cs320.battlemonsterz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Login Servlet: doGet");
		
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Login Servlet: doPost");
	        
	        // check which button the user pressed
	        if (req.getParameter("login") != null) {
	            // call addNumbers JSP
	            req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	        }
	        
	        
	        
	        else {
	        	throw new ServletException("Unknown command");
	        }
	        
	}}