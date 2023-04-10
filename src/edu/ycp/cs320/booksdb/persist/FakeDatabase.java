package edu.ycp.cs320.booksdb.persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.booksdb.model.Account;
import edu.ycp.cs320.booksdb.model.Attack;
import edu.ycp.cs320.booksdb.model.Card;
import edu.ycp.cs320.booksdb.model.Pair;

public class FakeDatabase implements IDatabase {
	
	//private List<Attack> attackList;
	private List<Account> accountList;
	private List<Card> cardList;
	
	// Fake database constructor - initializes the DB
	// the DB only consists for a List of Authors and a List of Books
	public FakeDatabase() {
		//attackList = new ArrayList<Attack>();
		accountList = new ArrayList<Account>();
		cardList = new ArrayList<Card>();
		
		// Add initial data
		readInitialData();
		
		System.out.println(accountList.size() + " accounts");
		System.out.println(cardList.size() + " cards");
	}

	// loads the initial data retrieved from the CSV files into the DB
	public void readInitialData() {
		try {
			accountList.addAll(InitialData.getAccounts());
			cardList.addAll(InitialData.getCards());
		} catch (IOException e) {
			throw new IllegalStateException("Couldn't read initial data", e);
		}
	}
	

	@Override
	public Card findCardByCardId(int cardId) {
		Card theCard  = new Card();
		for(Card cards: cardList ) {
			if(cards.getCardId() == cardId ) {
				theCard = cards;
			}
		}
		return theCard;
	}

	@Override
	public Integer findAccountByUsernameAndPassword(String username, String password) {
		Integer ID = -1;
		for(Account account: accountList ) {
			if(account.getUsername() == username && account.getPassword() == password ) {
				ID = account.getAccountId();
			}
		}
		return ID;
	}
	

	@Override
	public Integer insertNewAccountByUsernameAndPassword(String username, String password) {
		Integer ID = -1;
		for(Account account: accountList ) {
			if(account.getUsername() == username && account.getPassword() == password ) {
				ID = account.getAccountId();
			}
		}
		return ID;
	}

	@Override
	public List<Card> findAllCards() {
		List<Card> result = new ArrayList<Card>();
		for (Card card: cardList) {
			
				result.add(card);
			}
		
		return result;
	}
}
