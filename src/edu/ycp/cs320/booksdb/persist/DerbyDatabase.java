package edu.ycp.cs320.booksdb.persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import edu.ycp.cs320.battlemonsterz.model.Deck;
import edu.ycp.cs320.battlemonsterz.model.Type;
import edu.ycp.cs320.battlemonsterz.model.Card;
import edu.ycp.cs320.battlemonsterz.model.Account;

public class DerbyDatabase implements IDatabase {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby driver");
		}
	}
	
	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;

	

	
	// wrapper SQL transaction function that calls actual transaction function (which has retries)
	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}
	
	// SQL transaction function which retries the transaction MAX_ATTEMPTS times before failing
	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();
		
		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;
			
			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}
			
			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}
			
			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}

	// TODO: Here is where you name and specify the location of your Derby SQL database
	// TODO: Change it here and in SQLDemo.java under CS320_LibraryExample_Lab06->edu.ycp.cs320.sqldemo
	// TODO: DO NOT PUT THE DB IN THE SAME FOLDER AS YOUR PROJECT - that will cause conflicts later w/Git
	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:C:/CS320-Battlemonz-DB/library.db;create=true");		
		
		// Set autocommit() to false to allow the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		
		return conn;
	}
	
	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		DerbyDatabase db = new DerbyDatabase();
		db.createTables();
		
		System.out.println("Loading initial data...");
		db.loadInitialData();
		
		System.out.println("Battlemonz DB successfully initialized!");
	}


	@Override
	public Card findCardByCardId(int cardId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Account findAccountByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void insertNewAccountByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
	}





	@Override
	public List<Card> findAllCards() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	// retrieves Author information from query result set
//	private void loadAttack(Attack attack, ResultSet resultSet, int index) throws SQLException {
//	
//		attack.setAttackId(resultSet.getInt(index++));
//		attack.setPower(resultSet.getInt(index++));
//		attack.setType(resultSet.getString(index++));
//		
//	}
	
	private void loadAccount(Account account, ResultSet resultSet, int index) throws SQLException {
		account.setAccountId(resultSet.getInt(index++));
		account.setPassword(resultSet.getString(index++));
		account.setUsername(resultSet.getString(index++));
		account.setCard1(resultSet.getString(index++));
		account.setCard2(resultSet.getString(index++));
		account.setCard3(resultSet.getString(index++));
	}
	
	// retrieves Book information from query result set
	private void loadCard(Card card, ResultSet resultSet, int index) throws SQLException {		
		card.setID(resultSet.getInt(index++));
		card.setDefenseRating(resultSet.getInt(index++));
		card.setHealth(resultSet.getInt(index++));
		card.setName(resultSet.getString(index++));
		card.setType(Type.valueOf(resultSet.getString(index++)));
		card.setAttackRating(resultSet.getInt(index++));
	}
	

	//  creates the Authors and Books tables
	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				//PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;				
			
				try {
//					stmt1 = conn.prepareStatement(
//						"create table attacks (" +
//						"	attack_Id integer primary key " +
//						"		generated always as identity (start with 1, increment by 1), " +									
//						"	type varchar(40)," +
//						"	power varchar(40)" +
//						")"
//					);	
//					stmt1.executeUpdate();
//					
//					System.out.println("Attacks table created");
					
					stmt2 = conn.prepareStatement(
							"create table cards (" +
							"	card_Id integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	name varchar(70)," +
							"	type varchar(15)," +
							"   hp integer," +
							"   defense integer," +
							"   attack integer" +
							")"
					);
					stmt2.executeUpdate();
					
					System.out.println("Cards table created");					
					
					stmt3 = conn.prepareStatement(
							"create table accounts (" +
							"	account_Id  integer primary key " + 
							"		generated always as identity (start with 1, increment by 1), " +
							"	username varchar(70)," +
							"	password varchar(70)" +
							"   card_1 integer," +
							"   card_2 integer," +
							"   card_3 integer" +
							")"
					);
					stmt3.executeUpdate();
					
					System.out.println("Accounts table created");					
										
					return true;
				} finally {
					//DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(stmt3);

				}
			}
		});
	}
	
	// loads data retrieved from CSV files into DB tables in batch mode
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				//List<Attack> attackList;
				List<Account> accountList;
				List<Card> cardList;
				
				
				try {
					//attackList     = InitialData.getAttacks();
					accountList     = InitialData.getAccounts();
					cardList       = InitialData.getCards();
									
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				//PreparedStatement insertAttack     = null;
				PreparedStatement insertAccount     = null;
				PreparedStatement insertCard       = null;

				try {
					//old attack structure might be imepenated again 
					// must completely populate Authors table before populating BookAuthors table because of primary keys
//					insertAttack = conn.prepareStatement("insert into attacks (type, power) values (?, ?)");
//					for (Attack attack : attackList) {
////						insertAuthor.setInt(1, author.getAuthorId());	// auto-generated primary key, don't insert this
//						insertAttack.setString(1, attack.getType());
//						insertAttack.setInt(2, attack.getPower());
//						insertAttack.addBatch();
//					}
//					insertAttack.executeBatch();
//					
//					System.out.println("Attacks table populated");
					
					// must completely populate Books table before populating BookAuthors table because of primary keys
					insertCard = conn.prepareStatement("insert into cards ( name, type, hp, defense, attack ) values (?, ?, ?, ?, ?)");
					for (Card card : cardList) {
//						insertBook.setInt(1, card.getCardId());		// auto-generated primary key, don't insert this
						insertCard.setString(1, card.getName());
						insertCard.setString(2, card.getType().toString());
						insertCard.setFloat(3, (float) card.getHealth());
						insertCard.setFloat(4, (float) card.getDefenseRating());
						insertCard.setFloat(5, (float) card.getAttackRating());

		
						insertCard.addBatch();
					}
					insertCard.executeBatch();
					
					System.out.println("Cards table populated");	
					
					insertAccount = conn.prepareStatement("insert into accounts (username, password) values (?, ?)");
					for (Account account: accountList) {
//						insertAuthor.setInt(1, account.getaccountId());	// auto-generated primary key, don't insert this
						insertAccount.setString(1, account.getUsername());
						insertAccount.setString(2,account.getPassword());
						insertAccount.addBatch();
					}
					insertAccount.executeBatch();
					
					System.out.println("Accounts table populated");
					
					return true;
				} finally {
					//DBUtil.closeQuietly(insertAttack);
					DBUtil.closeQuietly(insertAccount);
					DBUtil.closeQuietly(insertCard);					
				}
			}
		});
	}

	@Override
	public List<Account> findallAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Card findCardByName(String cardName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findAccountByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Deck selectRandomCards() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void insertDeckIntoUser(String username, Deck deck) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveDeckToUserByName(String username, String cardname1, String cardname2, String cardname3) {
		// TODO Auto-generated method stub
		
	}



}
