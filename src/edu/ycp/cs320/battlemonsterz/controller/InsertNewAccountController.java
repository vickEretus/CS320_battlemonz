package edu.ycp.cs320.battlemonsterz.controller;

import edu.ycp.cs320.booksdb.persist.DatabaseProvider;
import edu.ycp.cs320.booksdb.persist.DerbyDatabase;
import edu.ycp.cs320.booksdb.persist.IDatabase;

public class InsertNewAccountController {

	private IDatabase db = null;

	public InsertNewAccountController() {
		
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();		
	}

	public boolean insertNewAccount(String username, String password) {
		
		// insert new account into table
		Integer account_id = db.insertNewAccountByUsernameAndPassword(username, password);;

		// check if the insertion succeeded
		if (account_id > 0)
		{
			System.out.println("New account (ID: " + account_id + ") successfully added to account table: <" + username + ">");
			
			return true;
		}
		else
		{
			System.out.println("Failed to insert new account (ID: " + account_id + ") into account table: <" + username + ">");
			
			return false;
		}
	}
}