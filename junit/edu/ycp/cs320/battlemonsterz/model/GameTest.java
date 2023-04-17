package edu.ycp.cs320.battlemonsterz.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.battlemonsterz.model.Card;
import edu.ycp.cs320.battlemonsterz.model.Game;

public class GameTest {
	private Game game;

	
	private Deck deck_one;
	private Deck deck_two;
	
	private Card card_one;
	private Card card_two;
	private Card card_three;
	private Card card_four;
	private Card card_five;
	private Card card_six;
	
	private int currentplayer;
	private int round;
	
	@Before
	public void setUp() {
		
		round = 0;
		
		currentplayer = 0;
		
		deck_one = new Deck();
		
		deck_two = new Deck();
		// set up each player's cards/decks
			// player one
		card_one = new Card(93, 90, 67, Type.WATER, "Poseidon");
		card_two = new Card(87, 98, 65, Type.FIRE, "Glowzee");
		card_three = new Card(82, 95, 73, Type.GRASS, "Vixon");
		
		deck_one.addCard(card_one);
		deck_one.addCard(card_two);
		deck_one.addCard(card_three);
			
			// player two
		card_four = new Card(93, 88, 69, Type.WATER, "Searvoid");
		card_five = new Card(89, 90, 71, Type.FIRE, "Nethertalon");
		card_six = new Card(90, 94, 66, Type.GRASS, "Vader");
		
		deck_two.addCard(card_four);
		deck_two.addCard(card_five);
		deck_two.addCard(card_six);
		
		game = new Game(deck_one, deck_two, currentplayer, round);
		
	
	}
	
	// test getters
	
	@Test
	public void testGetTurn() {
		assertEquals(0, game.getTurn());
		
	}
	
	@Test
	public void testGetRound() {
		assertEquals(0,  game.getRound());
	}
	
	@Test
	public void testGetDeckOne() {
		assertTrue(deck_one.equals(game.getDeckOne()));
	}
	
	@Test
	public void testGetDeckTwo() {
		assertTrue((game.getDeckTwo().equals(deck_two)));
	}
	
	@Test
	public void testGetCurrentDeck() {
		assertTrue(deck_one.equals(game.getCurrentDeck()));
		game.updateTurn();
		assertTrue(deck_two.equals(game.getCurrentDeck()));
	}
	
	@Test
	public void testGetOtherDeck() {
		assertTrue(deck_two.equals(game.getOtherDeck()));
		game.updateTurn();
		assertTrue(deck_one.equals(game.getOtherDeck()));
	}

	@Test
	public void testGetFinished() {
		assertTrue(!game.getFinished());
		
	}

	
	@Test
	public void testGetStatus() {
		assertTrue(game.getStatus().equals("Game In Progress"));

	}
	
	
	// test setters
	
	@Test
	public void testupdateTurn() {
		game.updateTurn();
		assertEquals(1, game.getTurn());
		game.updateTurn();
		assertEquals(0, game.getTurn());
	}
	

	@Test
	public void testSetTurn() {
		game.setTurn(1);
		assertEquals(1, game.getTurn());
		
		game.setTurn(0);
		assertEquals(0, game.getTurn());
	}
	
	@Test
	public void testSetRound() {
		game.setRound(3);
		assertEquals(3, game.getRound());
	}
	
	public void testNextRound() {
		game.nextRound();
		assertEquals(1, game.getRound());
		game.nextRound();
		assertEquals(2, game.getRound());
	}
	
	public void testSetStatus() {
		assertEquals("Game In Progress", game.getStatus());
		for (int i = 0; i < game.getCurrentDeck().getSize()-1; i++) {
			game.getCurrentDeck().getCard(i).setHealth(0);
			game.getOtherDeck().getCard(i).setHealth(0);
		}
		assertEquals("Game Over", game.getStatus());
	}
	
	public void testCheckFinished() {
		assertEquals(false, game.checkFinished());
		for (int i = 0; i < game.getCurrentDeck().getSize()-1; i++) {
			game.getCurrentDeck().getCard(i).setHealth(0);
			game.getOtherDeck().getCard(i).setHealth(0);
		}
		assertEquals(true, game.checkFinished());
	}
	
	public void setFinished() {
		game.setFinished(true);
		assertTrue(game.getFinished());
		game.setFinished(false);
		assertTrue(!game.getFinished());
	}
	
	
	

}
