
package edu.ycp.cs320.battlemonsterz.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

//import edu.ycp.cs320.battlemonsterz.model.Card;

public class AccountTest {

	// needed parameters
	private Deck deck_one;
	private Deck deck_two;
	
	private boolean loggedIn;
	
	// users to test
	private Account user_one;
	private Account user_two;
	private Account user_three;
	private Account user_four;
	
	@Before
	public void setUp() {
		loggedIn = true;
		
		deck_one = new Deck(new Card(90.0, 94.0, 66.0, Type.GRASS, "vader"));
		deck_two = new Deck(new Card(94.0, 99.0, 57.0, Type.FIRE, "trance"));
	
		user_one = new Account("user456", "incorrect"); 
		user_two = new Account("user123","snuffles", deck_one);
		user_three = new Account("user","eggs", deck_two, loggedIn);
		user_four = new Account();

	
	}
	
	// test getters
	
	@Test
	public void testGetUsername() throws Exception {
		assertEquals("user456", user_one.getUsername());
		assertEquals("user123", user_two.getUsername());
		assertEquals("user", user_three.getUsername());
		assertEquals(null, user_four.getUsername());
		
		
		
	}
	
	@Test
	public void testGetPassword() throws Exception {
		assertEquals("incorrect", user_one.getPassword());
		assertEquals("snuffles", user_two.getPassword());
		assertEquals("eggs", user_three.getPassword());
		assertEquals(null, user_four.getPassword());
	
		
	}
	
	@Test
	public void testGetDeck() throws Exception {
		Deck deck = new Deck();
		Deck deck_two = new Deck();
		
		user_one.addDeck(deck);
		user_two.addDeck(deck_two);
		
		assertTrue(user_one.getDeck().equals(deck));
		assertTrue(user_two.getDeck().equals(deck_two));
		
	
		
	}
	
	@Test
	public void testGetisLoggedIn() throws Exception {
		assertEquals(false, user_one.getisLoggedIn());
		assertEquals(false, user_two.getisLoggedIn());
		assertEquals(true, user_three.getisLoggedIn());
		assertEquals(false, user_four.getisLoggedIn());
	
	}
	
	

	
	// test setters
	@Test
	public void testSetUsername() throws Exception {
		user_one.setUsername("changeduser");
		user_two.setUsername("user10");
		user_three.setUsername("123");
		user_four.setUsername("jeff");
		
		assertEquals("changeduser", user_one.getUsername());
		assertEquals("user10", user_two.getUsername());
		assertEquals("123", user_three.getUsername());
		assertEquals("jeff", user_four.getUsername());
	
		
	}
	
	@Test
	public void testSetPassworda() throws Exception {
		user_one.setPassword("football");
		user_two.setPassword("changed");
		user_three.setPassword("basketball");
		user_four.setPassword("changed_again");
		
		assertEquals("football", user_one.getPassword());
		assertEquals("changed", user_two.getPassword());
		assertEquals("basketball", user_three.getPassword());
		assertEquals("changed_again", user_four.getPassword());
	
	}
	
	@Test
	public void testSetisLoggedIn() throws Exception {
		
		user_one.setIsLoggedIn(false);
		user_two.setIsLoggedIn(true);
		user_three.setIsLoggedIn(true);
		user_four.setIsLoggedIn(false);
		
		
		assertEquals(false, user_one.getisLoggedIn());
		assertEquals(true, user_two.getisLoggedIn());
		assertEquals(true, user_three.getisLoggedIn());
		assertEquals(false, user_four.getisLoggedIn());
	
	}
	
	@Test
	public void testAddDeck() throws Exception {
		Deck deck_one = new Deck();
		Deck deck_two = new Deck();
		
		deck_one.addCard(new Card());
		deck_two.addCard(new Card());
		
		
		user_one.addDeck(deck_one);
		user_four.addDeck(deck_two);
		
		
		// test for added deck
		assertTrue(user_one.getDeck().equals(deck_one));
		assertTrue(user_four.getDeck().equals(deck_two));
	}
	
	@Test
	public void testAddCard() throws Exception {
		
	
		Card card_one = new Card(81.0, 87.0, 82.0, Type.FIRE, "brightsoul");
		
		Card card_two = new Card(96.0, 75.0, 79.0, Type.WATER, "braveface");
		
		user_two.addCard(card_one);
		
		user_three.addCard(card_two);
		
		
		// test for added card
		assertTrue(user_two.getDeck().getCard(1).equals(card_one));
		assertTrue(user_three.getDeck().getCard(1).equals(card_two));
	
		
	}
	
	
	
	
	
	

}

