package edu.ycp.cs320.booksdb;

import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.battlemonsterz.model.Deck;
import edu.ycp.cs320.booksdb.persist.DatabaseProvider;
import edu.ycp.cs320.booksdb.persist.IDatabase;
import edu.ycp.cs320.battlemonsterz.model.Card;
import edu.ycp.cs320.battlemonsterz.model.Account;
import java.util.Random;

public class AllCardsQuery {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase.init(keyboard);
		
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		List<Card> cardList = db.findAllCards();
		
		// check if anything was returned and output the list
		if (cardList.isEmpty()) {
			System.out.println("There are no cards in the database");
		}
		else {
			for (Card cards : cardList) {
				
				System.out.println(cards.getID() + " | " + cards.getName() + " | " + cards.getType() + " | " + cards.getHealth() + " | " + cards.getAttackRating() + " | " + cards.getDefenseRating());
			}
		}
	}
}
