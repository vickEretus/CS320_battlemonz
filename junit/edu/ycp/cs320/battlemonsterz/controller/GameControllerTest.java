package edu.ycp.cs320.battlemonsterz.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.battlemonsterz.controller.GameController;
import edu.ycp.cs320.battlemonsterz.model.Card;
import edu.ycp.cs320.battlemonsterz.model.Game;

public class GameControllerTest {
	private GameController controller_one;
	private GameController controller_two;
	private Game game_one; private Game game_two;
	



	
	@Before
	public void setUp() {
		controller_one = new GameController();
		controller_two = new GameController(game_two);
	}
	
	
	// test getters
	@Test
	public void testGetModel() {
		controller_one.setModel(game_one);
		assertEquals(game_one, controller_one.getModel());
		assertEquals(game_two, controller_two.getModel());
	}
	
	// test setters
	@Test
	public void testUpdateTurn() {
		controller_one.changePlayer();
		assertEquals(1, controller_one.getModel().getTurn());
	}
	
	public void checkWin() {
		//assertTrue(controller_one.checkWin(game_one));
		//assertFalse(controller_two.checkWin(game_two));
	}
	
	
	
}
