package edu.ycp.cs320.battlemonsterz.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.battlemonsterz.controller.GameController;
import edu.ycp.cs320.battlemonsterz.model.Game;

public class PlayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("Play Servlet: doGet");	
		
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
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/play.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Play Servlet: doPost");
		
		if (req.getParameter("back") != null) {
            // call index JSP
            req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
        }
		else if (req.getParameter("1player") != null) {
            // call game JSP
            req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
        }
        
        else if (req.getParameter("2player") != null) {
            // call game JSP
            req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
        }

        
        else {
        	throw new ServletException("Unknown command");
        }
	
		

		
		
		
		
		// Forward to view to render the result HTML document
        if (req.getParameter("game") != null) {
            // call addNumbers JSP
            req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
        }
        
        else {
        
		req.getRequestDispatcher("/_view/play.jsp").forward(req, resp);}
	}

	
}
