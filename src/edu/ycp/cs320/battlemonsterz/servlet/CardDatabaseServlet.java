
package edu.ycp.cs320.battlemonsterz.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ycp.cs320.battlemonsterz.controller.FindAccountByUsernameController;
import edu.ycp.cs320.battlemonsterz.controller.RemoveDeckToUserController;
import edu.ycp.cs320.battlemonsterz.controller.SaveDeckToUserController;
import edu.ycp.cs320.battlemonsterz.model.Account;

public class CardDatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("CardDatabase Servlet: doGet");	
		
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
		req.getRequestDispatcher("/_view/carddatabase.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
		
		 
	    System.out.println("CardDatabase Servlet: doPost");
	    
	    if (req.getParameter("back") != null) {
	    	resp.sendRedirect(req.getContextPath() + "/index");
	    	return;
	    	}
	    
		
		
		String user = (String) req.getSession().getAttribute("user");
		
		RemoveDeckToUserController removecontroller = new RemoveDeckToUserController();
		
		FindAccountByUsernameController controller = new FindAccountByUsernameController();

	    
	    String[] selectedCardNames = new String[3];
	  
	  
	    Account account = controller.getAccountByUsername(user);
		
	    
	    	if (account.getCard1()== null || account.getCard1().equals("") ||
	    	    account.getCard2()== null || account.getCard2().equals("") ||
	    	    account.getCard3()== null || account.getCard3().equals("")) {	
	    	
	    	
	    	
	    	
	    	selectedCardNames =  req.getParameterValues("card");
	    }
	    
	    else {
	    	selectedCardNames[0] = account.getCard1();
	    	selectedCardNames[1] = account.getCard2();
	    	selectedCardNames[2] = account.getCard3();
	    }
	    
	    SaveDeckToUserController savecontroller = new  SaveDeckToUserController();
	    
	    savecontroller.saveDecktoUser(user, selectedCardNames[0], selectedCardNames[1], selectedCardNames[2]);
		

	   

	    if (req.getParameter("remove") != null) {
	    	removecontroller.removeDeckFromUser(user);
	    	}
	    
	  
	  
	    // set the request attribute for the selected card names
	    req.setAttribute("selectedCardNames", selectedCardNames);
	   
	    // forward the request to the JSP
	    req.getRequestDispatcher("/_view/carddatabase.jsp").forward(req, resp);
	}
	

	private List<String> getCardNames() {
	    // create a list of card names
	    List<String> cardNames = new ArrayList<>();
	    cardNames.add("Vader");
	    cardNames.add("Vixon");
	    cardNames.add("Smokedux");
	    cardNames.add("Zeus");
	    cardNames.add("Heathen");
	    
	    cardNames.add("Trance");
	    cardNames.add("Nethertalon");
	    cardNames.add("Firebreather");
	    cardNames.add("Glowzee");
	    cardNames.add("Brightsoul");
	    
	    cardNames.add("Coolwind");
	    cardNames.add("Splashfist");
	    cardNames.add("Searvoid");
	    cardNames.add("Braveface");
	    cardNames.add("Poseidon");
	    // add more card names as needed
	    return cardNames;
	}

// gets double from the request with attribute named s
private String getStringFromParameter(String s) {
	return s;
}
}

	
