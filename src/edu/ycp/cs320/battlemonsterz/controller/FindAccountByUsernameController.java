package edu.ycp.cs320.battlemonsterz.controller;



import edu.ycp.cs320.battlemonsterz.model.Account;
import edu.ycp.cs320.booksdb.persist.DatabaseProvider;
import edu.ycp.cs320.booksdb.persist.DerbyDatabase;
import edu.ycp.cs320.booksdb.persist.IDatabase;

public class FindAccountByUsernameController {

	private IDatabase db    = null;

	public FindAccountByUsernameController() {
		
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();		
	}

	public Account getAccountByUsername(String username) {
		
		// get the account based on username
		Account account = db.findAccountByUsername(username);
		
		
		if (account == null) {
			System.out.println("No accounts found for the specified username");
			return null;
		}
		else {
			 		
			System.out.println(account.getAccountId()+ ", " + account.getUsername() + ", " + account.getCard1() + ", " 
					+ account.getCard2() + ", " + account.getCard3());
						
		}
		
		// return found acccunt
		return account;
	}
}