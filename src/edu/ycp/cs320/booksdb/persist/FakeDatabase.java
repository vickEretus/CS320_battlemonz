package edu.ycp.cs320.booksdb.persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.booksdb.model.Attack;
import edu.ycp.cs320.booksdb.model.Card;
import edu.ycp.cs320.booksdb.model.Pair;

public class FakeDatabase implements IDatabase {
	
	private List<Attack> attackList;
	private List<Card> cardList;
	
	// Fake database constructor - initializes the DB
	// the DB only consists for a List of Authors and a List of Books
	public FakeDatabase() {
		attackList = new ArrayList<Attack>();
		cardList = new ArrayList<Card>();
		
		// Add initial data
		readInitialData();
		
//		System.out.println(authorList.size() + " authors");
//		System.out.println(bookList.size() + " books");
	}

	// loads the initial data retrieved from the CSV files into the DB
	public void readInitialData() {
		try {
			attackList.addAll(InitialData.getAttacks());
			cardList.addAll(InitialData.getCards());
		} catch (IOException e) {
			throw new IllegalStateException("Couldn't read initial data", e);
		}
	}
	

	@Override
	public List<Pair<Attack, Card>> findCardByCardId(int cardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pair<Attack, Card>> findAccountByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertNewAccountByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pair<Attack, Card>> findAllCardsWithAttacks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Attack> findAllCards() {
		// TODO Auto-generated method stub
		return null;
	}
}
