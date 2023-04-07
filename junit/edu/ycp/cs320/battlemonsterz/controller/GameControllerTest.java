package edu.ycp.cs320.battlemonsterz.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.battlemonsterz.controller.GameController;
import edu.ycp.cs320.battlemonsterz.model.Card;
import edu.ycp.cs320.battlemonsterz.model.Deck;
import edu.ycp.cs320.battlemonsterz.model.Game;
import edu.ycp.cs320.battlemonsterz.model.Type;

public class GameControllerTest {
	private GameController controller;
	private Game model;
	private Deck deck_one, deck_two;
	private Card card_one, card_two, card_three, card_four, card_five, card_six;
	private int round, currentplayer;
	

	
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
		
		controller = new GameController();
		
		model = new Game(deck_one, deck_two, currentplayer, round);
		
		controller.setModel(model);
		
	}
	
	
	// test getters
	@Test
	public void testGetModel() {
		assertTrue(controller.getModel().equals(model));
	}
	
	// test setters
	@Test
	public void testChangePlayer() {
		controller.changePlayer();
		assertEquals(1, model.getTurn());

	}
	@Test
	public void checkWin() {
		model.setFinished(true);
		
		assertTrue(controller.checkWin(model));
	}
	
	@Test
	public void checkAttack() {
		Card card_water_one = controller.getModel().getDeckOne().getCard(0); // poseidon
		Card card_fire_one = controller.getModel().getDeckOne().getCard(1); // glowzee
		Card card_grass_one = controller.getModel().getDeckOne().getCard(2); // vixon
		
		Card card_water_two = controller.getModel().getDeckTwo().getCard(0); // searvoid
		Card card_fire_two = controller.getModel().getDeckTwo().getCard(1); // nethertalon
		Card card_grass_two = controller.getModel().getDeckTwo().getCard(2); // vader
	
		// extra damage attacks
		assertEquals(28, (int)controller.attack(card_water_one, card_fire_two));
		assertEquals(41, (int)controller.attack(card_fire_one, card_grass_two));
		assertEquals(35, (int)controller.attack(card_grass_one, card_water_two));
		
		// inverse damage attacks
		assertEquals(15, (int)controller.attack(card_water_one, card_grass_two));
		assertEquals(19, (int)controller.attack(card_fire_one, card_water_two));
		assertEquals(14, (int)controller.attack(card_grass_one, card_fire_two));
		
		// regular attacks
		assertEquals(21, (int)controller.attack(card_water_one, card_water_two));
		assertEquals(27, (int)controller.attack(card_fire_one, card_fire_two));
		assertEquals(29, (int)controller.attack(card_grass_one, card_grass_two));
	}
	
	
	
	
}
