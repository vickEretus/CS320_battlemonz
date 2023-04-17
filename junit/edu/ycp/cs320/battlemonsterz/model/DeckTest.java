package edu.ycp.cs320.battlemonsterz.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class DeckTest {
	private Deck deck_one;
	private Deck deck_two;
	private Card card_one;
	private Card card_two;
	private Card card_three;
	private ArrayList<Card> cards;

	
	@Before
	public void setUp() {
		cards = new ArrayList<>();
		card_one = new Card();
		card_two = new Card(95.0, 85.0, 70.0, Type.GRASS, "smokedux");
		card_three = new Card(94.0, 99.0, 57.0, Type.FIRE, "trance");
		cards.add(card_one);
		cards.add(card_two);
		cards.add(card_three);
		
		deck_one = new Deck(cards);
		deck_two = new Deck();
		
		
	}
	
	@Test
	public void testGetCards() {
		assertEquals(cards, deck_one.getCards());
		assertEquals(0, deck_two.getCards().size());
		
	}
	
	@Test
	public void testGetCard() {
		
		assertTrue(card_one.equals(deck_one.getCard(0)));
		assertTrue(card_two.equals(deck_one.getCard(1)));
		assertTrue(card_three.equals(deck_one.getCard(2)));
		
		
	}
	
	@Test
	public void testGetSize() {
		assertEquals(3, deck_one.getSize());
		assertEquals(0, deck_two.getSize());
		
	}
	
	@Test
	public void testGetTeamHealth() {
		assertEquals(189.0, deck_one.getTeamHealth(), 0.001);
	    assertEquals(0.0, deck_two.getTeamHealth(), 0.001);
		
	}
	

	// test setter methods
	@Test
	public void testSetToOriginal() {
		deck_one.setToOriginal();
		
		assertEquals(0, (int)deck_one.getCards().get(0).getHealth());
		assertEquals(95, (int)deck_one.getCards().get(1).getHealth());
		assertEquals(94, (int)deck_one.getCards().get(2).getHealth());
	}
	
	@Test
	public void testAddCard() {
		Card card_one = new Card();
		Card card_two = new Card(84, 80, 86, Type.WATER, "coolwind");
		
		deck_one.addCard(card_one);
		deck_two.addCard(card_two);
		
		assertTrue(deck_one.getCards().get(deck_one.getSize() - 1).equals(card_one));
		assertTrue(deck_two.getCards().get(deck_two.getSize() - 1).equals(card_two));
		
	}
	
	@Test
	public void testDeleteCard() {
		Card card = deck_one.deleteCard(0);
		assertEquals(2, deck_one.getSize());
		assertTrue(card_one.equals(card));
		
	}
	
	@Test
	public void testDeleteLastCard() {
		deck_one.deleteLastCard();
		assertEquals(2, deck_one.getSize());
		
	}
	
	

}
