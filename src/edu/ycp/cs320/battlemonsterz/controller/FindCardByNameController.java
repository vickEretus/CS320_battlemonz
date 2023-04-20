package edu.ycp.cs320.battlemonsterz.controller;



import edu.ycp.cs320.battlemonsterz.model.Account;
import edu.ycp.cs320.battlemonsterz.model.Card;
import edu.ycp.cs320.booksdb.persist.DatabaseProvider;
import edu.ycp.cs320.booksdb.persist.DerbyDatabase;
import edu.ycp.cs320.booksdb.persist.IDatabase;

public class FindCardByNameController {

	private IDatabase db    = null;

	public FindCardByNameController() {
		
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();		
	}

	public Card getCardByName(String cardname) {
		
		// get the card by name
		Card card = db.findCardByName(cardname);
		
		
		if (card == null) {
			System.out.println("No cards found for the specified name");
			return null;
		}
		else {
			System.out.println(card.getID() + ", " + card.getName() + ", " + card.getType() + ", " 
					+ card.getHealth() + ", " + card.getAttackRating() + ", " + card.getDefenseRating());
						
		}
		
		// return found card
		return card;
	}
}