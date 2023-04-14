package edu.ycp.cs320.battlemonsterz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.battlemonsterz.controller.AccountController;
import edu.ycp.cs320.battlemonsterz.model.Account;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Login Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Login Servlet: doPost");
		
		String username = getStringFromParameter(req.getParameter("username"));
		String password = getStringFromParameter(req.getParameter("password"));
		String resultusername;
		String resultpassword;
		

		Account model = new Account();

		// create GuessingGame controller - controller does not persist between requests
		// must recreate it each time a Post comes in
		AccountController controller = new AccountController();
		
		// assign model reference to controller so that controller can access model
		controller.setModel(model);
		
		resultusername = controller.createUsername(username);
		resultpassword = controller.createPassword(password);
		

		// set "game" attribute to the model reference
		// the JSP will reference the model elements through "game"
		
		req.setAttribute("username", req.getParameter("username"));
		req.setAttribute("password", req.getParameter("password")); 
		
		
		req.setAttribute("resultusername", resultusername);
		req.setAttribute("resultpassword", resultpassword);
		
		// now call the JSP to render the new page
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	}

	// gets an Integer from the Posted form data, for the given attribute name
	
	
	private String getStringFromParameter(String s) {
		return s;
	}
}

/*package edu.ycp.cs320.battlemonsterz.servlet;

import java.io.IOException;

import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.battlemonsterz.controller.GameController;
import edu.ycp.cs320.battlemonsterz.controller.UserController;
import edu.ycp.cs320.battlemonsterz.model.User;


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
	        
	    /*    // check which button the user pressed
	        if (req.getParameter("login") != null) {
	            // call login JSP
	            req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	        }
	        
	   
	        else {
	        	throw new ServletException("Unknown command");
	        }
	        
	        // error message
	        String error_message = null;
	        
	        
	        // create user object
	        User created_user;
	        
	        try {
				String username = req.getParameter("username");
				String password = req.getParameter("password");
			

				// check for errors in the form data before using is in a calculation
				if (username == null) {
					error_message = "Please fill in field for username";
					
				}
				
				if (password == null) {
					error_message = "Please fill in field for password";
				}
				// otherwise, data is good, do the calculation
				// must create the controller each time, since it doesn't persist between POSTs
				// the view does not alter data, only controller methods should be used for that
				// thus, always call a controller method to operate on the data
				else {
					User model = new User("username","password");
					UserController controller = new UserController(model);
					controller.setModel(model);
					controller.MakeNewUser("username", "password");
				
				
				}
	        
	        
	        catch (NumberFormatException e) {
				error_message = "Invalid double";
			}
	       
	        //catch (ScriptException e) {
				//error_message = "Invalid string";
			//}
			
			// Add parameters as request attributes
			// this creates attributes named "first" and "second for the response, and grabs the
			// values that were originally assigned to the request attributes, also named "first" and "second"
			// they don't have to be named the same, but in this case, since we are passing them back
			// and forth, it's a good idea
			req.setAttribute("username", req.getParameter("username"));
			req.setAttribute("password", req.getParameter("password"));
		
			req.setAttribute("username", model);
			req.setAttribute("username", model);
			
			// add result objects as attributes
			// this adds the errorMessage text and the result to the response
			req.setAttribute("errorMessage", error_message);
		
			
			// Forward to view to render the result HTML document
			req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	
	        
	
	
	}}*/