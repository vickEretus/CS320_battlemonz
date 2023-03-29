package edu.ycp.cs320.battlemonsterz.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.battlemonsterz.model.Card;
import edu.ycp.cs320.battlemonsterz.model.Game;

public class GameTest {
	private Game game_one;
	private Game game_two;
	
	private Deck deck_one;
	private Deck deck_two;
	private int currentplayer;
	private int round;
	
	@Before
	public void setUp() {
		
		game_one = new Game();
		
		game_two = new Game(deck_one, deck_two, currentplayer, round);
		
	
	}
	
	// test getters
	
	@Test
	public void testGetTurn() {
		assertEquals(currentplayer, game_two.getTurn());
	}
	
	@Test
	public void testGetRound() {
		assertEquals(0, game_one.getRound());
	}
	
	
	// test setters

	@Test
	public void testSetTurn() {
		assertEquals(2, game_two.setTurn(2));
	}
	
	@Test
	public void testSetRound() {
		assertEquals(3, game_one.setRound(3));
	}
	
	
	
	

}
