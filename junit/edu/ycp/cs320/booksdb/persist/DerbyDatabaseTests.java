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
//		Scanner keyboard = new Scanner(System.in);
//
//		// Create the default IDatabase instance
//		InitDatabase.init(keyboard);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void testFindAllCards(){

		System.out.println("\n*** Testing FindAllCards ***");

		// get the list of (Author, Book) pairs from DB
		List<Card> cardList = db.findAllCards();

		// NOTE: this is a simple test to check if no results were found in the DB
		if (cardList.isEmpty()) {
			System.out.println("No Card found in Database");
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
	
	@Test
	public void testFindallAccounts(){
		System.out.println("\n*** Testing findAllAccounts ***");
		List<Account> accountList = db.findallAccounts();
		
		if(accountList.isEmpty()) {
			System.out.println("No accounts found in Database");
			fail("No accounts returned from Battlemonz DB");
		}
		else {
			accounts = new ArrayList<Account>();
			for(Account account: accountList) {
				accounts.add(account);
				System.out.println(account.getAccountId() +", " + account.getUsername() + ", " + account.getPassword()+ ", " 
						+ account.getCard1() + ", " +  account.getCard2() + ", "  +  account.getCard3() + ", " );

				 
			}
		}
		
	}
	
	
	@Test
	public void testFindCardByCardID() { //int cardID
		System.out.println("\n*** Testing findCardByCardID ***");
		int cardID = 1;
		
		Card card =  db.findCardByCardID(cardID);
		
		if(card != null ) {
			
			System.out.println(card.getID() +", " + card.getName() + ", " + card.getType()+ ", " 
					+ card.getHealth()+ ", " + card.getAttackRating()+ ", " + card.getDefenseRating());
		}
		else {
				System.out.println("No Card found in Database");
				fail("No Card returned from Battlemonz DB");
			}
			
		}
	

	@Test
	public void findCardByCardName() {
	    System.out.println("\n*** Testing findCardByName ***");
	    String cardName = "Vader";

	        Card card = db.findCardByName(cardName);
	        if (card != null) {
	        	System.out.println(card.getID() +", " + card.getName() + ", " + card.getType()+ ", " 
						+ card.getHealth()+ ", " + card.getAttackRating()+ ", " + card.getDefenseRating()); // Print all attributes using toString() method
	        } else {
	            System.out.println("No Card found in Database");
	            fail("No Card returned from Battlemonz DB");
	        }
	    }  
	       
	
	@Test
	public void TestFindAccountByUsername() { //String username
		  System.out.println("\n*** Testing findCardByName ***");
		  String username = "admin";
		    
		        Account account =  db.findAccountByUsername(username);
		        if (account != null) {
		        	System.out.println(account.getAccountId() +", " + account.getUsername()+ ", " + account.getPassword()+ ", " 
							+ account.getCard1() + ", " + account.getCard2() + ", " + account.getCard3() ); // Print all attributes using toString() method
		        } else {
		            System.out.println("No Account found in Database");
		            fail("No Account returned from Battlemonz DB");
		        }
		    }
		

	@Test
	public void testFindAccountByUsernameAndPassword() {
		System.out.println("\n*** Testing findAccountByUsernameAndPassword ***");
		
		String username = "admin";
		String password = "admin";

		// get the list of (Author, Book) pairs from DB
		Account account = db.findAccountByUsernameAndPassword(username, password);
		
		// NOTE: this is a simple test to check if no results were found in the DB
		if (account != null ) {
			System.out.println(account.getAccountId() + "," + account.getUsername()+ ", " + account.getPassword()+ "," +
					account.getCard1() + "," + account.getCard2()+ "," + account.getCard3());
		}
		// NOTE: assembling the results into Author and Book lists so that they could be
		//       inspected for correct content - well-formed objects with correct content
		else {			
//			accounts = new ArrayList<Account>();
//				accounts.add(account);
				
				System.out.println("No Account found in Battlemonz with Username <" + username + ">");
				fail("No Account with Password <" + password + "> returned from Battlemonz DB");
				

		}
	}



	
	
	@Test
	public void TestInsertNewAccountByUsernameAndPassword() { //String username, String password
		System.out.println("\n*** Testing InsertNewAccountByUsernameAndPassword ***");
		
		String username = "test";
		String password = "admin";
		
		Integer account_id = db.insertNewAccountByUsernameAndPassword(username, password);
		
		if(account_id > 0) {
			
			Account account = db.findAccountByUsernameAndPassword(username, password);
			
			if(account == null) {
				System.out.println("No Account found for username <" + username + ">");
				fail("Failed to insert new Account <" + username + " " + password +   "> into Account database");				
			}
			else {
				System.out.println("New Account (ID: " + account_id + ") successfully added to Account table: <" + username + ">");
				 account = db.removeAccountByUsernameAndPassword(username, password);
				
				 
				
			}
			
		}
		else {
			System.out.println("Failed to insert new Account (ID: " + account_id + ") into Accounts table: <" + username + ">");
			fail("Failed to insert new Account <" + username + "> into Account DB");
			
			
		}
	}
	

	

	
	@Test
	public void testSaveDeckToUserByName() { //String username, String cardname1, String cardname2, String cardname3
		System.out.println("\n*** Testing saveDeckToUserByName ***");
		
		String cardname1 = "Vader";
		String cardname2 = "Vixon";
		String cardname3 = "Smokedux";
		String username = "admin";
		
		Integer  account_id = db.saveDeckToUserByName(username, cardname1, cardname2, cardname3);
	
		if(account_id > 0) {
			Account account = db.findAccountByUsername(username);
			
			if(account == null) {
				System.out.println("No Decks found for username <" + username + ">");
				fail("Failed to insert new deck <" + cardname1 + " " + cardname2 + " " + cardname3 + " " +  "> into Username database");
					
			}
			else {
				System.out.println("New Deck (ID: " + account_id + ") successfully added to Username: <" + username + ">");
				
				// now delete Book (and its Author) from DB
				// leaving the DB in its previous state - except that an author_id, and a book_id have been used
				
				account_id = db.removeDeckToUserByName(username);
				//Deck deck = db.removeDeckToUserByName(account.getUsername(), account.getCard1(), account.getCard2(), account.getCard3());
				System.out.println("New Deck (ID: " + account_id + ") successfully removed from Username: <" + username + ">");
				
			}
		}
		else {
			System.out.println("Failed to save a deck into User: <" + username + ">");
			fail("Failed to insert new Cards <" + cardname1 + " " + cardname2 + " " + cardname3 + " " +  "> into Username database");
		}
		
	}
	
	@Test
	public void testRemoveAccountByUsernameAndPassword() {//String username, String password
		// TODO Auto-generated method stub
	}

	@Test
	public void testRemoveDeckToUserByName() { //String username, String cardname1, String cardname2, String cardname3
		// TODO Auto-generated method stub

	}
	
	@Test
	public void testselectRandomCards() {
		// Checking by using recursive function calling itself ~3 times
		System.out.println("\n*** Testing selectRandomCards *** \n");
		for(int i = 0 ; i <= 5 ; i++) {
			Deck deck= db.selectRandomCards();
			System.out.println("\n * New RandomCards *");
			System.out.println(deck.getCard(0).getID() +", " + deck.getCard(0).getName() + ", " + deck.getCard(0).getType()+ ", " 
					+ deck.getCard(0).getHealth()+ ", " + deck.getCard(0).getAttackRating()+ ", " + deck.getCard(0).getDefenseRating()); 
			
			System.out.println(deck.getCard(1).getID() +", " + deck.getCard(1).getName() + ", " + deck.getCard(1).getType()+ ", " 
					+ deck.getCard(1).getHealth()+ ", " + deck.getCard(1).getAttackRating()+ ", " + deck.getCard(1).getDefenseRating()); 
			
			System.out.println(deck.getCard(2).getID() +", " + deck.getCard(2).getName() + ", " + deck.getCard(2).getType()+ ", " 
					+ deck.getCard(2).getHealth()+ ", " + deck.getCard(2).getAttackRating()+ ", " + deck.getCard(2).getDefenseRating()); 
			
			
		}
		
		
	}
	


}
