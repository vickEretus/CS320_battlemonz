package edu.ycp.cs320.battlemonsterz.controller;

import edu.ycp.cs320.battlemonsterz.model.Deck;
import edu.ycp.cs320.booksdb.persist.DatabaseProvider;
import edu.ycp.cs320.booksdb.persist.DerbyDatabase;
import edu.ycp.cs320.booksdb.persist.IDatabase;

public class RemoveDeckToUserController {

	private IDatabase db    = null;

	public RemoveDeckToUserController() {
		
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();		
	}

	public void removeDeckFromUser(String username, String cardname1, String cardname2, String cardname3) {
		
		// save card names to user
		db.removeDeckToUserByName(username, cardname1, cardname2, cardname3);
		
		
		
	}
}