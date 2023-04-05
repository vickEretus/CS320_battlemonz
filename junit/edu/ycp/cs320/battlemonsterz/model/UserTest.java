package edu.ycp.cs320.battlemonsterz.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//import edu.ycp.cs320.battlemonsterz.model.Card;

public class UserTest {
	private User user_one;
	private User user_two;
	
	@Before
	public void setUp() {
		user_one = new User("user456", "incorrect"); // unique card
		user_two = new User("user123","snuffles");

	
	}
	
	// test getters
	
	@Test
	public void testGetUsername() throws Exception {
		assertEquals("user456", user_one.getUsername());
		assertEquals("user123", user_two.getUsername());
		
		
	}
	
	@Test
	public void testGetPassword() throws Exception {
		assertEquals("incorrect", user_one.getPassword());
		assertEquals("snuffles", user_two.getPassword());
	
		
	}
	

	
	// test setters
	@Test
	public void testSetUsername() throws Exception {
		user_one.setUsername("changeduser");
		user_two.setUsername("user10");
		
		assertEquals("changeduser", user_one.getUsername());
		assertEquals("user10", user_two.getUsername());
	
		
	}
	
	@Test
	public void testSetPassworda() throws Exception {
		user_one.setPassword("football");
		user_one.setPassword("changed");
		
		assertEquals("football", user_one.getPassword());
		assertEquals("changed", user_two.getPassword());
	
		
	}
	
	
	
	

}
