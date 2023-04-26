package edu.ycp.cs320.battlemonsterz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Index Servlet: doGet");
		
		String user = (String) req.getSession().getAttribute("user");
		if (user == null) {
			System.out.println("   User: <" + user + "> not logged in or session timed out");
			
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		// now we have the user's User object,
		// proceed to handle request...
		
		System.out.println("   User: <" + user + "> logged in");
		
		req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Index Servlet: doPost");
	        
	        // check which button the user pressed
	        if (req.getParameter("account") != null) {
	            // call addNumbers JSP
	            req.getRequestDispatcher("/_view/account.jsp").forward(req, resp);
	        }
	        
	        else if (req.getParameter("play") != null) {
	            // call addNumbers JSP
	            req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
	        }
	        
	        //else if (req.getParameter("about") != null) {
	            // call addNumbers JSP
	        //    req.getRequestDispatcher("/_view/about.jsp").forward(req, resp);
	        //}
	        
	        else if (req.getParameter("carddatabase") != null) {
	            // call addNumbers JSP
	            req.getRequestDispatcher("/_view/carddatabase.jsp").forward(req, resp);
	        }

	        
	        else {
	        	throw new ServletException("Unknown command");
	        }
	        
	}}