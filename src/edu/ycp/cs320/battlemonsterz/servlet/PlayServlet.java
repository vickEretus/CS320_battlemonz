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
	
		

		// holds the error message text, if there is any
		String errorMessage = null;

		// result of calculation goes here
		Double result = null;
		
		// decode POSTed form parameters and dispatch to controller
		try {
			
			// otherwise, data is good, do the calculation
			// must create the controller each time, since it doesn't persist between POSTs
			// the view does not alter data, only controller methods should be used for that
			// thus, always call a controller method to operate on the data
		
				Game model = new Game();
				GameController controller = new GameController();
		
			
				
			
		} catch (NumberFormatException e) {
			errorMessage = "Invalid double";
		}
		
		// Add parameters as request attributes

	
	
		
		// add result objects as attributes
		// this adds the errorMessage text and the result to the response
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("result", result);
		
		// Forward to view to render the result HTML document
        if (req.getParameter("game") != null) {
            // call addNumbers JSP
            req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
        }
        
        else {
        
		req.getRequestDispatcher("/_view/play.jsp").forward(req, resp);}
	}

	// gets double from the request with attribute named s
	private Double getDoubleFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return Double.parseDouble(s);
		}
	}
}
