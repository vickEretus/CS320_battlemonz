package edu.ycp.cs320.booksdb.persist;

import java.util.List;

import edu.ycp.cs320.battlemonsterz.model.Deck;
import edu.ycp.cs320.battlemonsterz.model.Card;
import edu.ycp.cs320.battlemonsterz.model.Account;
import java.util.Random;



public interface IDatabase {
	
	public List<Card> findAllCards();
	
	public List<Account> findallAccounts();
	
	public Card findCardByCardID(int cardID);
	
	public Card findCardByName(String cardName);
	

	
	public Account findAccountByUsernameAndPassword(String username, String password);
	
	public Account findAccountByUsername(String username);
	
	public Deck selectRandomCards();
	
	public Integer insertNewAccountByUsernameAndPassword(String username, String password);
	
	public Account removeAccountByUsernameAndPassword(String username, String password); 
	
	
	public Integer saveDeckToUserByName(String username,String cardname1,String cardname2,String cardname3);
	
	public Deck removeDeckToUserByName(String username,String cardname1,String cardname2,String cardname3);
}
