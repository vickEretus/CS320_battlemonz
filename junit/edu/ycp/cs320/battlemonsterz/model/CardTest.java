package edu.ycp.cs320.battlemonsterz.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//import edu.ycp.cs320.battlemonsterz.model.Card;

public class CardTest {
	private Card card_one;
	private Card card_two;
	private Card card_three;
	private Card card_four;
	
	@Before
	public void setUp() {
		// unique cards
		card_one = new Card(90.0, 94.0, 66.0, Type.GRASS, "vader"); 
		card_two = new Card(94.0, 99.0, 57.0, Type.FIRE, "trance"); 
		card_three = new Card(84.0, 99.0, 67.0, Type.WATER, "coolwind");
		
		// default(empty) card
		card_four = new Card();
		
		
	
	}
	
	// test getters
	@Test
	public void testGetHealth() throws Exception {
		assertEquals(90, (int)(card_one.getHealth()));
		assertEquals(94, (int)(card_two.getHealth()));
		assertEquals(84, (int)(card_three.getHealth()));
		assertEquals(0, (int)(card_four.getHealth()));
		
		
	}
	
	@Test
	public void testGetAttackRating() throws Exception {
		assertEquals(94, (int)card_one.getAttackRating());
		assertEquals(99, (int)card_two.getAttackRating());
		assertEquals(99, (int)card_three.getAttackRating());
	
		
	}
	
	@Test
	public void testGetDefenseRating() throws Exception {
		assertEquals(66, (int)card_one.getDefenseRating());
		assertEquals(57, (int)card_two.getDefenseRating());
		assertEquals(67, (int)card_three.getDefenseRating());
		
	}
	
	@Test
	public void testGetType() throws Exception {
		assertEquals(Type.GRASS, card_one.getType());
		assertEquals(Type.FIRE, card_two.getType());
		assertEquals(Type.WATER, card_three.getType());
		
	}
	
	@Test
	public void testGetName() throws Exception {
		assertEquals("vader", card_one.getName());
		assertEquals("trance", card_two.getName());
		assertEquals("coolwind", card_three.getName());
		
	}
	
	@Test
	public void testgetURL() throws Exception {
		assertEquals("<%=request.getContextPath()%>/Images/vader.jpeg", card_one.getURL());
		assertEquals("<%=request.getContextPath()%>/Images/trance.jpeg", card_two.getURL());
		assertEquals("<%=request.getContextPath()%>/Images/coolwind.jpeg", card_three.getURL());
		
	}

	
	// test setters
	@Test
	public void testSetHealth() throws Exception {
		card_one.setHealth(75.0);
		card_two.setHealth(64.0);
		card_three.setHealth(0.0);
		card_four.setHealth(100.0);
		
		assertEquals(75, (int)card_one.getHealth());
		assertEquals(64, (int)card_two.getHealth());
		assertEquals(0, (int)card_three.getHealth());
		assertEquals(100, (int)card_four.getHealth());
		
	}
	
	@Test
	public void testSetAttackRating() throws Exception {
		card_one.setAttackRating(88.0);
		card_two.setAttackRating(43.0);
		card_three.setAttackRating(6.0);
		card_four.setAttackRating(60.0);
		
		assertEquals(88, (int)card_one.getAttackRating());
		assertEquals(43, (int)card_two.getAttackRating());
		assertEquals(6, (int)card_three.getAttackRating());
		assertEquals(60, (int)card_four.getAttackRating());
		
	}
	
	@Test
	public void testSetDefenseRating() throws Exception {
		card_one.setDefenseRating(33.0);
		card_two.setDefenseRating(3.0);
		card_three.setDefenseRating(16.0);
		card_four.setDefenseRating(88.0);
		
		assertEquals(33, (int)card_one.getDefenseRating());
		assertEquals(3, (int)card_two.getDefenseRating());
		assertEquals(16, (int)card_three.getDefenseRating());
		assertEquals(88, (int)card_four.getDefenseRating());
		
	}
	
	@Test
	public void testSetType() throws Exception {
		card_one.setType(Type.FIRE);
		card_two.setType(Type.FIRE);
		card_three.setType(Type.GRASS);
		card_four.setType(Type.WATER);
		
		assertEquals(Type.FIRE, card_one.getType());
		assertEquals(Type.FIRE, card_two.getType());
		assertEquals(Type.GRASS, card_three.getType());
		assertEquals(Type.WATER, card_four.getType());
		
	}
	
	@Test
	public void testSetName() throws Exception {
		card_one.setName("Cupid");
		card_two.setName("Skywalker");
		card_three.setName(null);
		card_four.setName("Vixon");
		
		assertEquals("Cupid", card_one.getName());
		assertEquals("Skywalker", card_two.getName());
		assertEquals(null, card_three.getName());
		assertEquals("Vixon", card_four.getName());
		
	}
	
	@Test
	public void testsetToOriginal() throws Exception {
		card_one.setToOriginal();
		card_two.setToOriginal();
		card_three.setToOriginal();
		card_four.setToOriginal();
		
		assertEquals(90, (int)card_one.getHealth());
		assertEquals(94, (int)card_two.getHealth());
		assertEquals(84, (int)card_three.getHealth());
		assertEquals(0, (int)card_four.getHealth());
	}
	
	@Test
	public void testsetURL() throws Exception {
		card_one.setURL("<%=request.getContextPath()%>/Images/poseidon.jpeg");
		card_two.setURL("<%=request.getContextPath()%>/Images/heathen.jpeg");
		card_three.setURL("<%=request.getContextPath()%>/Images/firebreather.jpeg");
		card_four.setURL("<%=request.getContextPath()%>/Images/splashfist.jpeg");
		
		assertEquals("<%=request.getContextPath()%>/Images/poseidon.jpeg", card_one.getURL());
		assertEquals("<%=request.getContextPath()%>/Images/heathen.jpeg", card_two.getURL());
		assertEquals("<%=request.getContextPath()%>/Images/firebreather.jpeg", card_three.getURL());
		assertEquals("<%=request.getContextPath()%>/Images/splashfist.jpeg", card_four.getURL());
		
	}
	
	

}
