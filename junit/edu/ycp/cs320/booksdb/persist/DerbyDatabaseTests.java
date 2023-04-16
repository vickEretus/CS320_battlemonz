package edu.ycp.cs320.booksdb.persist;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.ycp.cs320.battlemonsterz.model.Deck;
import edu.ycp.cs320.battlemonsterz.model.Card;
import edu.ycp.cs320.battlemonsterz.model.Account;

public class DerbyDatabaseTests {

	private IDatabase db = null;
	
	ArrayList<Card> cards = null;
	ArrayList<Account>accounts  = null;
	ArrayList<Deck>   decks   = null;
	List<Card> cardList = null;
	List<Account> accountList = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();		
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	public void testFindAllCards(){

		System.out.println("\n*** Testing FindAllCards ***");

		// get the list of (Author, Book) pairs from DB
		List<Card> cardList = db.findAllCards();

		// NOTE: this is a simple test to check if no results were found in the DB
		if (cardList.isEmpty()) {
			System.out.println("No Card found in library");
			fail("No Card returned from Battlemonz DB");
		}
		// NOTE: assembling the results into Author and Book lists so that they could be
		//       inspected for correct content - well-formed objects with correct content
		else {
			cards = new ArrayList<Card>();
			for (Card card : cardList) {
				cards.add(card);
				System.out.println(card.getID() +", " + card.getName() + ", " + card.getType()+ ", " 
				+ card.getHealth()+ ", " + card.getAttackRating()+ ", " + card.getDefenseRating());
				
			}			
		}
	}
	
	public List<Account> findallAccounts(){
		// TODO Auto-generated method stub
		return null;
	}
	
	public Card findCardByCardId(int cardId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Card findCardByName(String cardName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Account findAccountByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Deck selectRandomCards() {
		// TODO Auto-generated method stub
		return null;
		
	}
	
	public void insertNewAccountByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
	}
	
	public void insertDeckIntoUser(String username, Deck deck) {
		// TODO Auto-generated method stub
	}
	
	public void saveDeckToUserByName(String username,String cardname1,String cardname2,String cardname3) {
		// TODO Auto-generated method stub
	}
	


	@Test
	public void testFindAccountByUsernameAndPassword() {
		System.out.println("\n*** Testing findAccountByUsernameAndPassword ***");
		
		String username = "Chapman";
		String password = "Graham";

		// get the list of (Author, Book) pairs from DB
		Account account = db.findAccountByUsernameAndPassword(username, password);
		
		// NOTE: this is a simple test to check if no results were found in the DB
		if (accounts.equals(null)) {
			System.out.println("No Account found in Battlemonz with Username <" + username + ">");
			fail("No Account with Password <" + password + "> returned from Battlemonz DB");
		}
		// NOTE: assembling the results into Author and Book lists so that they could be
		//       inspected for correct content - well-formed objects with correct content
		else {			
			accounts = new ArrayList<Account>();
			
				accounts.add(account);
				System.out.println(account.getAccountId() + "," + account.getUsername()+ ", " + account.getPassword()+ "," +
				account.getCard1() + "," + account.getCard2()+ "," + account.getCard3());
				

		}
	}


}
