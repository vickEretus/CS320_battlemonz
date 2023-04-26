package edu.ycp.cs320.booksdb;

import java.util.List;
import java.util.Scanner;

import edu.ycp.cs320.battlemonsterz.model.Deck;
import edu.ycp.cs320.booksdb.persist.DatabaseProvider;
import edu.ycp.cs320.booksdb.persist.IDatabase;
import edu.ycp.cs320.battlemonsterz.model.Card;
import edu.ycp.cs320.battlemonsterz.model.Account;
import java.util.Random;

public class removeAccounts {
	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);

		// Create the default IDatabase instance
		InitDatabase.init(keyboard);
		
		System.out.print("Enter the accounts's username: ");
		String username = keyboard.nextLine();
		
		System.out.print("Enter the accounts's password: ");
		String password = keyboard.nextLine();
		
		// get the DB instance and execute transaction
		IDatabase db = DatabaseProvider.getInstance();
		Account account = db.removeAccountByUsernameAndPassword(username, password);
		
		// check if anything was returned and output the list
		if (account.equals(null) || account.getAccountId() == 0) {
			System.out.println("There are no account in the database to remove ");
		}
		else {
		
				
			System.out.println(account.getAccountId()+ " | " + account.getUsername()+ " | " + account.getPassword()+ " | " + account.getCard1()+ " | " + account.getCard2()+ " | " + account.getCard3());
			System.out.println("Account:  <" + account.getAccountId() + "> "  + account.getUsername()+ " removed");
		}
	}
}
