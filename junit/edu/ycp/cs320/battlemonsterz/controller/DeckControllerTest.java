package edu.ycp.cs320.battlemonsterz.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.battlemonsterz.controller.DeckController;
import edu.ycp.cs320.battlemonsterz.model.Card;
import edu.ycp.cs320.battlemonsterz.model.Deck;
import edu.ycp.cs320.battlemonsterz.model.Game;
import edu.ycp.cs320.battlemonsterz.model.Type;

public class DeckControllerTest {
	private DeckController controller;
	private Deck model;
	private Card card;

	@Before
	public void setUp() {
		card = new Card(92, 99, 70, Type.GRASS, "Heathen");
		model = new Deck();
		model.addCard(card);
		controller = new DeckController(model);
	}
	
	
	// test getters
	@Test
	public void testGetModel() {
		assertTrue(controller.getModel().equals(model));
		
	}
	
	// test setters
	
	@Test
	public void testsetModel() {
		Deck newdeck = new Deck();
		controller.setModel(newdeck);
		
		assertTrue(controller.getModel().equals(newdeck));
	}
	
	
	@Test
	public void testchangeCardWithIndex() {
		Card replacement = new Card();
		controller.changeCardWithIndex(replacement, 0);
		
		assertTrue(model.getCard(0).equals(replacement));
		
	}
	
	
}
