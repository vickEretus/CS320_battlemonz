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

	public void removeDeckFromUser(String username) {
		
		// save card names to user
		db.removeDeckToUserByName(username);
		
		
		
	}
}