package edu.ycp.cs320.booksdb.persist;

import java.util.List;

import edu.ycp.cs320.battlemonsterz.model.Deck;
import edu.ycp.cs320.battlemonsterz.model.Card;
import edu.ycp.cs320.battlemonsterz.model.Account;


public interface IDatabase {
	
	public List<Card> findAllCards();
	public List<Account> findallAccounts();
	public Card findCardByCardId(String cardId);
	public Integer findAccountByUsernameAndPassword(String username, String password);
	public Deck selectRandomCards();
	
	public void insertNewAccountByUsernameAndPassword(String username, String password);
	public void insertDeckIntoUser(String username, Deck deck);
	
	
}
