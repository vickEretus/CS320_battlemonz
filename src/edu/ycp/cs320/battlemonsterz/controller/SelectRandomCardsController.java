package edu.ycp.cs320.battlemonsterz.controller;

import edu.ycp.cs320.battlemonsterz.model.Deck;
import edu.ycp.cs320.booksdb.persist.DatabaseProvider;
import edu.ycp.cs320.booksdb.persist.DerbyDatabase;
import edu.ycp.cs320.booksdb.persist.IDatabase;

public class SelectRandomCardsController {

	private IDatabase db    = null;

	public SelectRandomCardsController() {
		
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();		
	}

	public Deck getRandomCards() {
		
		// get random cards from card table
		Deck deck = db.selectRandomCards();
		
		
		if (deck == null) {
			System.out.println("Failed to select random cards");
			return null;
		}
		else {
			for (int i = 0; i < 3; i++) {
			System.out.println("Card " + (i+1) + ": " + deck.getCard(i).getID() + ", " + deck.getCard(i).getName() + ", " + 
			deck.getCard(i).getType() + ", " + deck.getCard(i).getHealth() + ", " + deck.getCard(i).getAttackRating() + ", " + 
			deck.getCard(i).getDefenseRating());
			}
		}
		
		// return random deck
		return deck;
	}
}