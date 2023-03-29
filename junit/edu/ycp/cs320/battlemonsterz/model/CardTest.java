package edu.ycp.cs320.battlemonsterz.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//import edu.ycp.cs320.battlemonsterz.model.Card;

public class CardTest {
	private Card card_one;
	private Card card_two;
	private Card card_three;
	
	@Before
	public void setUp() {
		card_one = new Card(80.0, 75.0, 66.0, Type.GRASS, "Vixon"); // unique card
		card_two = new Card(40.0, 40.0, 80.0, Type.FIRE, "Vader"); // default card
		card_three = new Card();
	
	}
	
	// test getters
	@Test
	public void testGetHealth() throws Exception {
		assertEquals(80.0, card_one.getHealth());
		assertEquals(40.0, card_two.getHealth());
		assertEquals(100.0, card_three.getHealth());
		
	}
	
	@Test
	public void testGetAttackRating() throws Exception {
		assertEquals(75.0, card_one.getAttackRating());
		assertEquals(40.0, card_two.getAttackRating());
		assertEquals(0.0, card_three.getAttackRating());
		
	}
	
	@Test
	public void testGetDefenseRating() throws Exception {
		assertEquals(66.0, card_one.getDefenseRating());
		assertEquals(80.0, card_two.getDefenseRating());
		assertEquals(0.0, card_three.getDefenseRating());
		
	}
	
	@Test
	public void testGetType() throws Exception {
		assertEquals(Type.GRASS, card_one.getType());
		assertEquals(Type.FIRE, card_two.getType());
		assertEquals(null, card_three.getType());
		
	}
	
	@Test
	public void testGetName() throws Exception {
		assertEquals("Vixon", card_one.getName());
		assertEquals("Vader", card_two.getName());
		assertEquals(null, card_three.getName());
		
	}

	
	// test setters
	@Test
	public void testSetHealth() throws Exception {
		assertEquals(75.0, card_one.setHealth(75.0));
		assertEquals(64.0, card_two.setHealth(64.0));
		assertEquals(0.0, card_three.setHealth(0.0));
		
	}
	
	@Test
	public void testSetAttackRating() throws Exception {
		assertEquals(88.0, card_one.setAttackRating(88.0));
		assertEquals(43.0, card_two.setAttackRating(43.0));
		assertEquals(6.0, card_three.setAttackRating(6.0));
		
	}
	
	@Test
	public void testSetDefenseRating() throws Exception {
		assertEquals(33.0, card_one.setDefenseRating(33.0));
		assertEquals(3.0, card_two.setDefenseRating(3.0));
		assertEquals(16.0, card_three.setDefenseRating(16.0));
		
	}
	
	@Test
	public void testSetType() throws Exception {
		assertEquals(Type.GRASS, card_one.setType(Type.GRASS));
		assertEquals(Type.FIRE, card_two.setType(Type.FIRE));
		assertEquals(Type.WATER, card_three.setType(Type.WATER));
		
	}
	
	@Test
	public void testSetName() throws Exception {
		assertEquals("Cupid", card_one.setName("Cupid"));
		assertEquals("Skywalker", card_two.setName("Skywalker"));
		assertEquals(null, card_three.setName(null)));
		
	}
	
	@Test
	public void testsetToOriginal() throws Exception {
		card_one.setToOriginal();
		assertEquals(100.0, card_one.getHealth());
	}
	
	
	

}
