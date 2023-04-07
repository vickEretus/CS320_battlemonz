package edu.ycp.cs320.battlemonsterz.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


import edu.ycp.cs320.battlemonsterz.model.User;

public class UserControllerTest {
	private UserController controller;
	private User model;
	
	@Before
	public void setUp() {
		controller = new UserController();
		model = new User();
		controller.setModel(model);
	}
	
	
	// test getters
	@Test
	public void testGetModel() {
		assertTrue(controller.getModel().equals(model));
	}
	
	// test setters
	@Test
	public void testSetModel() {
		User model_check = new User();
		controller.setModel(model_check);
		assertTrue(controller.getModel().equals(model_check));
	}
	
	public void testMakeNewUser() {
		controller.MakeNewUser("cam", "vaughn");
		
		assertTrue(model.getUsername().equals("cam"));;
		assertTrue(model.getPassword().equals("vaughn"));;
	}
	
	public void testCreateUsername() {
		String created_username;
		
		created_username = controller.createUsername("fluff");
		
		assertTrue(model.getUsername().equals("fluff"));
	}
	

	public void testCreatePassword() {
		String created_password;
		
		created_password = controller.createUsername("fluff_two");
		
		assertTrue(model.getPassword().equals("fluff_two"));
	
}

	
	
}
