package edu.ycp.cs320.battlemonsterz.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.battlemonsterz.controller.FindAccountByUsernameController;
import edu.ycp.cs320.battlemonsterz.controller.FindCardByNameController;
import edu.ycp.cs320.battlemonsterz.controller.GameController;
import edu.ycp.cs320.battlemonsterz.controller.SelectRandomCardsController;
import edu.ycp.cs320.battlemonsterz.model.Account;
import edu.ycp.cs320.battlemonsterz.model.Card;
import edu.ycp.cs320.battlemonsterz.model.Deck;
import edu.ycp.cs320.battlemonsterz.model.Game;


public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("Game Servlet: doGet");	
		
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
		
		boolean game_over;
		int round, turn;
		double health_bar_one, health_bar_two;
		Deck deck_one, deck_two;
		Card d1_card_one, d1_card_two, d1_card_three, d2_card_one, d2_card_two, d2_card_three;
		SelectRandomCardsController selectcontroller = new SelectRandomCardsController();
		FindAccountByUsernameController findcontroller = new FindAccountByUsernameController();
		FindCardByNameController findcardcontroller = new FindCardByNameController();
		
		Account account = findcontroller.getAccountByUsername(user);
		
		
		
		round = 1;
		turn = 0;
		game_over = false;
		
		health_bar_one = 0.0;
		health_bar_two = 0.0;
		

		
		deck_one = new Deck();
		

		// get logged in user's deck
		d1_card_one = findcardcontroller.getCardByName(account.getCard1());
		d1_card_two = findcardcontroller.getCardByName(account.getCard2());
		d1_card_three = findcardcontroller.getCardByName(account.getCard3());
		
		
		deck_one.addCard(d1_card_one);
		deck_one.addCard(d1_card_two);
		deck_one.addCard(d1_card_three);
		
		
		
		deck_two = selectcontroller.getRandomCards();
	
		
	
		Game model = new Game(deck_one, deck_two, turn, round);
		GameController controller = new GameController(model);
		
		req.getSession().setAttribute("game", model);
		req.getSession().setAttribute("deck_one_health", model.getDeckOne().getTeamHealth());
	    req.getSession().setAttribute("deck_two_health", model.getDeckTwo().getTeamHealth());
	   
	    
	    req.getSession().setAttribute("d1c1name", model.getDeckOne().getCard(0).getName());
	    req.getSession().setAttribute("d1c2name", model.getDeckOne().getCard(1).getName());
	    req.getSession().setAttribute("d1c3name", model.getDeckOne().getCard(2).getName());
	    req.getSession().setAttribute("d2c1name", model.getDeckTwo().getCard(0).getName());
	    req.getSession().setAttribute("d2c2name", model.getDeckTwo().getCard(1).getName());
	    req.getSession().setAttribute("d2c3name", model.getDeckTwo().getCard(2).getName());
	    
	    req.getSession().setAttribute("d1c1health", model.getDeckOne().getCard(0).getHealth());
	    req.getSession().setAttribute("d1c2health", model.getDeckOne().getCard(1).getHealth());
	    req.getSession().setAttribute("d1c3health", model.getDeckOne().getCard(2).getHealth());
	    req.getSession().setAttribute("d2c1health", model.getDeckTwo().getCard(0).getHealth());
	    req.getSession().setAttribute("d2c2health", model.getDeckTwo().getCard(1).getHealth());
	    req.getSession().setAttribute("d2c3health", model.getDeckTwo().getCard(2).getHealth());
		
		
		
		
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Game Servlet: doPost");
	
		
		/* WILL GET USER FROM HTTP SESSION, RETRIEVE CARDS FROM USER
	
		String username = (String) req.getSession().getAttribute("user");
		
		Account user = db.getUserByUsername(username);
		
		getCardNamesByUser();
		
		Deck 1 = GetCardbyName();
		Deck 2 = randomCards();
		*/

		
		Game game = (Game) req.getSession().getAttribute("game");
		GameController controller = new GameController(game);
		boolean game_over = false;
		int cardOneIndex = Integer.parseInt(req.getParameter("card_one_index"));
		int cardTwoIndex = Integer.parseInt(req.getParameter("card_two_index"));
		Double damage_one = 0.0;
		Double damage_two = 0.0;
	

		
		
		Card selectedCard1 = game.getDeckOne().getCard(cardOneIndex-1);
		Card selectedCard2 = game.getDeckTwo().getCard(cardTwoIndex-1);
	    // update the game state based on user input
		// decode POSTed form parameters and dispatch to controller
		
		if (req.getParameter("fight") != null) {
			
			damage_one = controller.attack(selectedCard1, selectedCard2);
			
			
			damage_two = controller.attack(selectedCard2, selectedCard1);
		
			
			game_over = controller.checkWin(game);
			
			game.nextRound();
		}/* else if (req.getParameter("attack") != null) {
			controller.attack(d1_card_one, d2_card_two);
		}  else {
			throw new ServletException("Unknown command");
		}*/
	
	    // set the updated game object as an attribute on the request object
	    req.getSession().setAttribute("game", game);
	    req.getSession().setAttribute("damage_one", damage_one);
	    req.getSession().setAttribute("damage_two", damage_two);
	    req.getSession().setAttribute("d1c1health", game.getDeckOne().getCard(0).getHealth());
	    req.getSession().setAttribute("d1c2health", game.getDeckOne().getCard(1).getHealth());
	    req.getSession().setAttribute("d1c3health", game.getDeckOne().getCard(2).getHealth());
	    req.getSession().setAttribute("d2c1health", game.getDeckTwo().getCard(0).getHealth());
	    req.getSession().setAttribute("d2c2health", game.getDeckTwo().getCard(1).getHealth());
	    req.getSession().setAttribute("d2c3health", game.getDeckTwo().getCard(2).getHealth());
	    req.getSession().setAttribute("deck_one_health", game.getDeckOne().getTeamHealth());
	    req.getSession().setAttribute("deck_two_health", game.getDeckTwo().getTeamHealth());
	    req.getSession().setAttribute("gameover", game_over);
		
		
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/game.jsp").forward(req, resp);
	}

}
