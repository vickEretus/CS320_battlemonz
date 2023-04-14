package edu.ycp.cs320.battlemonsterz.controller;

import edu.ycp.cs320.battlemonsterz.model.*;



public class AccountController {
	
	// fields
	private Account model;
	
	
	
	// constructors
	public AccountController(Account model) {
		this.model = model;
	}
	
	public AccountController() {
		
	}
	
	
	// methods
	
	public Account getModel() {
		return model;
		
	}
	
	public void setModel(Account model) {
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

