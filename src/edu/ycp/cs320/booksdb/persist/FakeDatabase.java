package edu.ycp.cs320.booksdb.persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import edu.ycp.cs320.battlemonsterz.model.Deck;
import edu.ycp.cs320.battlemonsterz.model.Card;
import edu.ycp.cs320.battlemonsterz.model.Account;

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
	public Card findCardByCardID(int cardID) {
		Card theCard  = new Card();
		for(Card cards: cardList ) {
			if(cards.getID() == cardID ) {
				theCard = cards;
				
			}
		}
		return theCard;
	}

	@Override
	public Account findAccountByUsernameAndPassword(String username, String password) {
		Account result = new Account();
		for(Account accounts: accountList ) {
			if(accounts.getUsername().equals(username)&& accounts.getPassword().equalsIgnoreCase(password) ) {
				result = accounts;
				
			}
		}
		
		return result;
	}
	

	@Override
	public Integer insertNewAccountByUsernameAndPassword(String username, String password) {
				Integer ID; 
				Account account = new Account();
				account.setPassword(password);
				account.setUsername(username);
				account.setAccountId(accountList.size());
				accountList.add(account);
				ID = account.getAccountId();
				
				
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

	@Override
	public List<Account> findallAccounts() {
		List<Account> result = new ArrayList<Account>();
		for (Account accounts: accountList) {
			
				result.add(accounts);
			}
		
		return result;
	}



	@Override
	public Deck selectRandomCards() {
		Deck ranDeck = new Deck();
		Random rand = new Random();
		int randInt =  rand.nextInt(15);	
		int amount = 0;
		for (Card card: cardList) {
			if(card.getID() == randInt && amount < 2) {
			ranDeck.addCard(card);
			randInt = rand.nextInt(15);	
			amount++;
			}
		}
	
		return ranDeck;	
			
		}

	@Override
	public Card findCardByName(String cardName) {
		Card result = new Card();
		for (Card card: cardList) {
			if(card.getName().equals(cardName)) {
				result = card;
				}
			}
		
		return result;
	}

	@Override
	public Integer saveDeckToUserByName(String username, String cardname1, String cardname2, String cardname3) {
		Deck deck = new Deck();
		int authorID = -1;
		
		for(Account account: accountList) {
			if(account.getUsername().equals(username)) {
				
				authorID = account.getAccountId();
				
			}
		
		}
		
		for (Card card: cardList) {
			if(card.getName().equals(cardname1)) {
				deck.addCard(card);
			}
			if(card.getName().equals(cardname2)) {
				deck.addCard(card);
			}
			if(card.getName().equals(cardname3)) {
				deck.addCard(card);
			}
				
				
			}
		
		return authorID;
		}

	@Override
	public Account findAccountByUsername(String username) {
		Account result = new Account();
		for (Account account: accountList) {
			if(account.getUsername().equals(username)) {
				result = account;
				}
			}
		
		return result;
	}
	
	//not implemented in FakeDB
	@Override
	public Deck removeDeckToUserByName(String username,String cardname1,String cardname2,String cardname3) {
		Deck deck = new Deck();
		
		return deck;
	}
	
	//not implemented in FakeDB
	@Override
	public Account removeAccountByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	}

