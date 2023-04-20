package edu.ycp.cs320.battlemonsterz.controller;

import edu.ycp.cs320.battlemonsterz.model.Deck;
import edu.ycp.cs320.booksdb.persist.DatabaseProvider;
import edu.ycp.cs320.booksdb.persist.DerbyDatabase;
import edu.ycp.cs320.booksdb.persist.IDatabase;

public class SaveDeckToUserController {

	private IDatabase db    = null;

	public SaveDeckToUserController() {
		
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();		
	}

	public void saveDecktoUser(String username, String cardname1, String cardname2, String cardname3) {
		
		// save card names to user
		db.saveDeckToUserByName(username, cardname1, cardname2, cardname3);
		
		
		
	}
}