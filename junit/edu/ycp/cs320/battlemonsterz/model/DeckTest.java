package edu.ycp.cs320.battlemonsterz.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class DeckTest {
	private Deck deck_one;
	private Deck deck_two;
	private ArrayList<Card> cards;

	
	@Before
	public void setUp() {
		cards = new ArrayList<>();
		cards.add(new Card());
		cards.add(new Card(100.0, 75.0, 50.0, Type.GRASS, "Monster"));
		
		deck_one = new Deck(cards);
		deck_two = new Deck();
		
		
	}
	
	@Test
	// test getter methods
	public void testGetCards() {
		assertEquals(cards, deck_one.getCards());
		
		
	}
	
	@Test
	public void testGetSize() {
		assertEquals(2, deck_one.getSize());
		assertEquals(0, deck_two.getSize());
		
	}
	
	@Test
	public void testGetTeamHealth() {
		assertEquals(200.0, deck_one.getTeamHealth());
		assertEquals(0.0, deck_two.getTeamHealth());
		
	}
	

	// test setter methods
	@Test
	public void testSetToOriginal() {
		deck_one.setToOriginal();
		for (int i = 0; i < deck_one.getSize(); i++) {
			assertEquals(100.0, deck_one.getCard(i).getHealth());
		}
	}
	
	@Test
	public void testAddCard() {
		deck_one.addCard(new Card());
		assertEquals(0.0, deck_one.getCard(deck_one.getSize()).getHealth());
		
	}
	
	@Test
	public void testDeleteCard() {
		deck_one.deleteCard();
		assertEquals(0.0, deck_one.getCard(deck_one.getSize()).getHealth());
		
	}
	
	

}
