package edu.ycp.cs320.booksdb.persist;

import java.util.List;

import edu.ycp.cs320.battlemonsterz.model.Deck;
import edu.ycp.cs320.battlemonsterz.model.Card;
import edu.ycp.cs320.battlemonsterz.model.Account;
import java.util.Random;



public interface IDatabase {
	
	public List<Card> findAllCards();
	
	public List<Account> findallAccounts();
	
	public Card findCardByCardId(int cardId);
	
	public Card findCardByName(String cardName);
	
	public Account findAccountByUsernameAndPassword(String username, String password);
	
	public Account findAccountByUsername(String username);
	
	public Deck selectRandomCards();
	
	public void insertNewAccountByUsernameAndPassword(String username, String password);
	
	public void insertDeckIntoUser(String username, Deck deck);
	
	public void saveDeckToUserByName(String username,String cardname1,String cardname2,String cardname3);
}
