package edu.ycp.cs320.battlemonsterz.controller;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.battlemonsterz.model.Account;
import edu.ycp.cs320.booksdb.persist.DatabaseProvider;
import edu.ycp.cs320.booksdb.persist.DerbyDatabase;
import edu.ycp.cs320.booksdb.persist.IDatabase;

public class GetAllAccountsController {

	private IDatabase db = null;

	public GetAllAccountsController() {
		
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();		
	}

	public ArrayList<Account> getAllAccounts() {
		
		// get the list of accounts from db
		List<Account> accountList = db.findallAccounts();
		ArrayList<Account> accounts = null;
		
		if (accountList.isEmpty()) {
			System.out.println("No accounts found");
			return null;
		}
		else {
			accounts = new ArrayList<Account>();
			for (Account account : accountList) {
				accounts.add(account);
				System.out.println(account.getAccountId()+ ", " + account.getUsername() + ", " + account.getCard1() + ", " 
				+ account.getCard2() + ", " + account.getCard3());
			}			
		}
		
		// return accounts
		return accounts;
	}
}
