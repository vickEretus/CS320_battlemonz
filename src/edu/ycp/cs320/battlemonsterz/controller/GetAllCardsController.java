package edu.ycp.cs320.battlemonsterz.controller;
import edu.ycp.cs320.battlemonsterz.model.Account;
import edu.ycp.cs320.battlemonsterz.model.Card;
import edu.ycp.cs320.booksdb.persist.DatabaseProvider;
import edu.ycp.cs320.booksdb.persist.DerbyDatabase;
import edu.ycp.cs320.booksdb.persist.IDatabase;

import java.util.ArrayList;
import java.util.List;

public class GetAllCardsController {
	
		private IDatabase db = null;

		public GetAllCardsController() {
			
			// creating DB instance here
			DatabaseProvider.setInstance(new DerbyDatabase());
			db = DatabaseProvider.getInstance();		
		}

		public ArrayList<Card> getAllCards() {
			
			// get the list of cards from db
			List<Card> cardList = db.findAllCards();
			ArrayList<Card> cards = null;
			
			if (cardList.isEmpty()) {
				System.out.println("No cards found");
				return null;
			}
			else {
				cards = new ArrayList<Card>();
				for (Card card: cardList) {
					cards.add(card);
					System.out.println(card.getID() + ", " + card.getName() + ", " + card.getType() + ", " 
					+ card.getHealth() + ", " + card.getAttackRating() + ", " + card.getDefenseRating());
				}			
			}
			
			// return accounts
			return cards;
		}
	}


