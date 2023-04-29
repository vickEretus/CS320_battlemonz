package edu.ycp.cs320.battlemonsterz.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.battlemonsterz.controller.FindAccountByUsernameController;
import edu.ycp.cs320.battlemonsterz.controller.GameController;
import edu.ycp.cs320.battlemonsterz.model.Account;
import edu.ycp.cs320.battlemonsterz.model.Game;

public class AboutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("About Servlet: doGet");	
		
		String username = (String) req.getSession().getAttribute("user");
		if (username == null) {
			System.out.println("   User: <" + username + "> not logged in or session timed out");
			
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		// now we have the user's User object,
		// proceed to handle request...
		
		System.out.println("   User: <" + username + "> logged in");
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/about.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Account Servlet: doPost");
		 // check which button the user pressed
        if (req.getParameter("back") != null) {
            // call index JSP
            req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
        }
        
                
        String username = (String) req.getSession().getAttribute("user");
        
        FindAccountByUsernameController controller = new FindAccountByUsernameController();
        Account account = controller.getAccountByUsername(username);
        
       
        req.getSession().setAttribute("account", account);
        
	
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/account.jsp").forward(req, resp);
	}

	
}
