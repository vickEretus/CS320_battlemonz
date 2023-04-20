package edu.ycp.cs320.battlemonsterz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.battlemonsterz.controller.FindAccountByUandPController;
import edu.ycp.cs320.battlemonsterz.controller.FindAccountByUsernameController;
import edu.ycp.cs320.battlemonsterz.controller.InsertNewAccountController;
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
		String errorMessage = "";
	

		
		
		FindAccountByUsernameController findcontroller = new FindAccountByUsernameController();
		
		Account account = findcontroller.getAccountByUsername(username);
		
		Account model = new Account();;
		
		if (account != null) {
		
		FindAccountByUandPController controller = new FindAccountByUandPController();
		
		model = controller.getAccountByUsernameAndPassword(username, password);
		}
		
		
		if (model == null) {

			errorMessage = "Invalid username or password";
		}
		
		else {
		
		// CREATING ACCOUNT
		
		InsertNewAccountController insertcontroller = new InsertNewAccountController();
		// store user object in session
			req.getSession().setAttribute("user", username);
					
			insertcontroller.insertNewAccount(username, password);

					// redirect to /index page
			resp.sendRedirect(req.getContextPath() + "/index");

			return;
		
		
		
		}
	
		
		
		
		// now call the JSP to render the new page
		req.setAttribute(errorMessage, "errorMessage");
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
		
		
	
	}
	
	
	
	private String getStringFromParameter(String s) {
		return s;
	}
}

