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
	

		Account model = new Account();

		
		AccountController controller = new AccountController();
		
		// assign model reference to controller so that controller can access model
		controller.setModel(model);

		// set username attribute to the model reference
		// the JSP will reference the model elements through "game"
		
		req.setAttribute("username", req.getParameter("username"));
		req.setAttribute("password", req.getParameter("password")); 
		
	
		
		/* IF VALID, AND USERNAME IS UNIQUE, USE DATABASE METHOD TO 
		 * INSERT USER OR CHECK IF USER EXISTS AND PASSWORD IS CORRECT
		 
		
		if (valid) {
		
		checkuserExists(username, password)

			// store user object in session
			req.getSession().setAttribute("user", username);
			
			insertUser(username, password)

			// redirect to /index page
			resp.sendRedirect(req.getContextPath() + "/index");

			return;
		}*/
		
		// now call the JSP to render the new page
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	}

	// gets an Integer from the Posted form data, for the given attribute name
	
	
	private String getStringFromParameter(String s) {
		return s;
	}
}

