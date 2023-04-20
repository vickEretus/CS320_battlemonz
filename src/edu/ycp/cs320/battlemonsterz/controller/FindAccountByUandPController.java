package edu.ycp.cs320.battlemonsterz.controller;



import edu.ycp.cs320.battlemonsterz.model.Account;
import edu.ycp.cs320.booksdb.persist.DatabaseProvider;
import edu.ycp.cs320.booksdb.persist.DerbyDatabase;
import edu.ycp.cs320.booksdb.persist.IDatabase;

public class FindAccountByUandPController {

	private IDatabase db    = null;

	public FindAccountByUandPController() {
		
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();		
	}

	public Account getAccountByUsernameAndPassword(String username, String password) {
		
		// get the account based on username and password
		Account account = db.findAccountByUsernameAndPassword(username, password);
		
		
		if (account == null) {
			System.out.println("No accounts found for the specified username and password");
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
