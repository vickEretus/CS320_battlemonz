package edu.ycp.cs320.battlemonsterz.controller;

import edu.ycp.cs320.battlemonsterz.model.*;

public class UserController {
	
	// fields
	private User model;
	
	
	
	// constructors
	public UserController(User model) {
		this.model = model;
	}
	
	public UserController() {
		
	}
	
	
	// methods
	
	public User getModel() {
		return model;
		
	}
	
	public void setModel(User model) {
		this.model = model;
	}
	
	public void MakeNewUser(String username, String password) {

		model.setUsername(username);
		model.setPassword(password);

	}
	
	public String createUsername(String username) {
		String result;
		result = username;
		model.setUsername(result);
		return result;
	}
	
	public String createPassword(String password) {
		String result;
		result = password;
		model.setPassword(result);
		return result;
	}
	
	
	
	
	
	
	
}
