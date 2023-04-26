package edu.ycp.cs320.booksdb.persist;

import java.io.IOException;
import java.lang.reflect.Array;
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
//import edu.ycp.cs320.booksdb.persist.DBUtil;
//import edu.ycp.cs320.booksdb.persist.DerbyDatabase.Transaction;
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
		card.setName(resultSet.getString(index++));
		card.setType(Type.valueOf(resultSet.getString(index++)));
		card.setDefenseRating(Double.parseDouble(resultSet.getString(index++)));
		card.setHealth(resultSet.getDouble(index++));
		card.setAttackRating(resultSet.getDouble(index++));
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
							"	card_ID integer primary key " +
							"		generated always as identity (start with 1, increment by 1), " +
							"	name varchar(70)," +
							"	type varchar(15)," +
							"   hp varchar(15)," +
							"   defense varchar(15)," +
							"   attack varchar(15)" +
							")"
					);
					stmt2.executeUpdate();
					
					System.out.println("Cards table created");					
					
					stmt3 = conn.prepareStatement(
							"create table accounts (" +
							"	account_ID  integer primary key " + 
							"		generated always as identity (start with 1, increment by 1), " +
							"	username varchar(70)," +
							"	password varchar(70)," +
							"   card_1 varchar(15)," +
							"   card_2 varchar(15)," +
							"   card_3 varchar(15)" +
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
					
					insertAccount = conn.prepareStatement("insert into accounts (username, password, card_1, card_2, card_3) values (?, ?, ?, ?, ?)");
					for (Account account: accountList) {
//						insertAuthor.setInt(1, account.getaccountId());	// auto-generated primary key, don't insert this
						insertAccount.setString(1, account.getUsername());
						insertAccount.setString(2,account.getPassword());
						insertAccount.setString(3, account.getCard1());
						insertAccount.setString(4, account.getCard2());
						insertAccount.setString(5, account.getCard3());
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
	public Card findCardByName(String cardName) {
	    return executeTransaction(new Transaction<Card>() {
	        @Override
	        public Card execute(Connection conn) throws SQLException {
	            PreparedStatement stmt = null;
	            ResultSet resultSet = null;
	            try {
	                stmt = conn.prepareStatement(
	                        "SELECT cards.* " +
	                        "FROM cards " +
	                        "WHERE cards.name = ?"
	                );
	                
	                stmt.setString(1, cardName);
	                
	                Card card = new Card();
	                
	                resultSet = stmt.executeQuery();
	                
	                if (resultSet.next()) {
	                   
	                    
	                    loadCard(card, resultSet, 1);
	                    
	                   
	                } 
	                
	                    return card;
	                
	            } finally {
	                DBUtil.closeQuietly(resultSet);
	                DBUtil.closeQuietly(stmt);
	            }
	        }
	    });
	}

	
	@Override
	public Card findCardByCardID(int cardID) {
		return executeTransaction(new Transaction<Card>() {
			@Override
			public Card execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				// try to retrieve Authors and Books based on Author's last name, passed into query
				try {
					stmt = conn.prepareStatement(
							"select cards.* " +
							"  from  cards " +
							"  where cards.card_ID = ? " 
					
					
					);
					stmt.setInt(1, cardID);
					
					// establish the list of (Author, Book) Pairs to receive the result
					Card result = new Card();
					
					// execute the query, get the results, and assemble them in an ArrayLsit
					resultSet = stmt.executeQuery();
					if (resultSet.next()) {
						
						loadCard(result, resultSet, 1);						

					}
					
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}


	@Override
	public Account findAccountByUsernameAndPassword(String username, String password) {
		return executeTransaction(new Transaction<Account>() {
	        @Override
	        public Account execute(Connection conn) throws SQLException {
	            PreparedStatement stmt = null;
	            ResultSet resultSet = null;
	            try {
	                stmt = conn.prepareStatement(
	                        "SELECT accounts.* " +
	                        "FROM accounts " +
	                        "WHERE accounts.username = ? and accounts.password = ?"
	                );
	                
	                stmt.setString(1, username);
	                stmt.setString(2, password);

	                
	                Account account = new Account();
	                
	                resultSet = stmt.executeQuery();
	                
	                if (resultSet.next()) {
	                   
	                    
	                    loadAccount(account, resultSet, 1);
	                    
	                    
	                } 
	                
	                    return account;
	                
	            } finally {
	                DBUtil.closeQuietly(resultSet);
	                DBUtil.closeQuietly(stmt);
	            }
	        }
	    });
	}

	
	@Override
	public Integer insertNewAccountByUsernameAndPassword(String username, String password) {
		return executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				
				
				ResultSet resultSet1 = null;
				ResultSet resultSet3 = null;
				
				// for saving author ID and book ID
				Integer account_id = -1;
				

				// try to retrieve author_id (if it exists) from DB, for Author's full name, passed into query
				try {
					stmt1 = conn.prepareStatement(
							"select account_id from accounts " +
							"  where username = ? and password = ? "
					);
					stmt1.setString(1, username);
					stmt1.setString(2, password);
					
					// execute the query, get the result
					resultSet1 = stmt1.executeQuery();

					
					// if Author was found then save author_id					
					if (resultSet1.next())
					{
						account_id = resultSet1.getInt(1);
						System.out.println("Account <" + username + ", " + password + "> found with ID: " + account_id );						
					}
					else
					{
						System.out.println("Account <" + username + ", " + password + "> not found");
				
						// if the Author is new, insert new Author into Authors table
						if (account_id <= 0) {
							// prepare SQL insert statement to add Author to Authors table
							stmt2 = conn.prepareStatement(
									"insert into accounts (username, password) " +
									"  values(?, ?) "
							);
							stmt2.setString(1, username);
							stmt2.setString(2, password);
							
							// execute the update
							stmt2.executeUpdate();
							
							System.out.println("New Account <" + username + ", " + password + "> inserted in Authors table");						
						
							// try to retrieve author_id for new Author - DB auto-generates author_id
							stmt3 = conn.prepareStatement(
									"select account_id from accounts " +
									"  where username = ? and password = ? "
							);
							stmt3.setString(1, username);
							stmt3.setString(2, password);
							
							// execute the query							
							resultSet3 = stmt3.executeQuery();
							
							// get the result - there had better be one							
							if (resultSet3.next())
							{
								account_id = resultSet3.getInt(1);
								System.out.println("New Account <" + username + ", " + password + "> ID: " + account_id);						
							}
							else	// really should throw an exception here - the new author should have been inserted, but we didn't find them
							{
								System.out.println("New Account <" + username + ", " + password + "> not found in Account table (ID: " + account_id);
							}
						}
					}


				
					return account_id;
				} finally {
					DBUtil.closeQuietly(resultSet1);
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);					
					DBUtil.closeQuietly(resultSet3);
					DBUtil.closeQuietly(stmt3);					
				
				}
			}
		});
	}
	


	@Override
	public List<Card> findAllCards() {
		return executeTransaction(new Transaction<List<Card>>() {
			@Override
			public List<Card> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select * from Cards " 
					);
					
					List<Card> result = new ArrayList<Card>();
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						
						Card card = new Card();
						loadCard(card, resultSet, 1);
						
						result.add(card);
					}
					
					// check if any authors were found
					if (!found) {
						System.out.println("No cards were found in the database");
					}
					
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	

	@Override
	public List<Account> findallAccounts() {
		return executeTransaction(new Transaction<List<Account>>() {
			@Override
			public List<Account> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select * from accounts " 
					);
					
					List<Account> result = new ArrayList<Account>();
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						
						Account account = new Account();
						loadAccount(account , resultSet, 1);
						
						result.add(account );
					}
					
					// check if any authors were found
					if (!found) {
						System.out.println("No accounts were found in the database");
					}
					
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	
	

	@Override
	public Account findAccountByUsername(String username) {
		return executeTransaction(new Transaction<Account>() {
	        @Override
	        public Account execute(Connection conn) throws SQLException {
	            PreparedStatement stmt = null;
	            ResultSet resultSet = null;
	            try {
	                stmt = conn.prepareStatement(
	                        "SELECT accounts.* " +
	                        "FROM accounts " +
	                        "WHERE username = ?"
	                );
	                
	                stmt.setString(1, username);
	                
	                Account account = new Account();
	                
	                resultSet = stmt.executeQuery();
	                
	                if (resultSet.next()) {
	                   
	                    
	                    loadAccount(account, resultSet, 1);
	                    
	                    
	                } 
	                
	                    return account;
	                
	            } finally {
	                DBUtil.closeQuietly(resultSet);
	                DBUtil.closeQuietly(stmt);
	            }
	        }
	    });
	}
	

	@Override
	public Integer saveDeckToUserByName(String username, String cardname1, String cardname2, String cardname3) {
		return executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				
				
				ResultSet resultSet1 = null;
				ResultSet resultSet3 = null;
				
				// for saving author ID and book ID
				Integer account_id = -1;
				

				// try to retrieve author_id (if it exists) from DB, for Author's full name, passed into query
				try {
					stmt1 = conn.prepareStatement(
							"select accounts.* from accounts " +
							"  where username = ? "
					);
					stmt1.setString(1, username);
					
					// execute the query, get the result
					resultSet1 = stmt1.executeQuery();

					
					// if Author was found then save author_id					
					if (resultSet1.next())
					{
						account_id = resultSet1.getInt(1);
						System.out.println("Account <" + username + "> found with ID: " + account_id);						
					
							// prepare SQL insert statement to add Author to Authors table
							stmt2 = conn.prepareStatement(
									"update accounts "
									+ "set card_1 = ? , card_2 = ?, card_3 = ?"
									+ "WHERE account_id = ?" 
							);
							stmt2.setString(1, cardname1);
							stmt2.setString(2, cardname2);
							stmt2.setString(3, cardname3);
							stmt2.setInt(4, account_id);
							
							// execute the update
							stmt2.executeUpdate();
							
							System.out.println("New Cards <" + cardname1 + ", " + cardname2 + " , " + cardname3 + "> inserted in Account: <" + username + ">  ");						
						
							// try to retrieve author_id for new Author - DB auto-generates author_id
							stmt3 = conn.prepareStatement(
									"select account_id from accounts " +
									"  where username = ?  "
							);
							stmt3.setString(1, username);
							
							// execute the query							
							resultSet3 = stmt3.executeQuery();
							
							// get the result - there had better be one							
							if (resultSet3.next())
							{
								account_id = resultSet3.getInt(1);
								System.out.println("New Cards <" + cardname1 + ", " + cardname2 + " , " + cardname3 + "> ID: " + account_id);						
							}
							else	// really should throw an exception here - the new author should have been inserted, but we didn't find them
							{
								System.out.println("New Cards <" + cardname1 + ", " + cardname2 + " , " + cardname3 + "> not found in Account (ID: " + account_id);
							}
						}
					
					else {
					System.out.println("Account <" + username + "> not found");

					}
					return account_id;
				} finally {
					DBUtil.closeQuietly(resultSet1);
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);					
					DBUtil.closeQuietly(resultSet3);
					DBUtil.closeQuietly(stmt3);					
				
				}
			}
		});
	}
		

	@Override
	public Account removeAccountByUsernameAndPassword(String username, String password) {
		return executeTransaction(new Transaction<Account>() {
			@Override
			public Account execute(Connection conn) throws SQLException {
				
				PreparedStatement stmt3 = null;
				
				try {
					Account account= findAccountByUsernameAndPassword(username, password);
					
					int accountID = account.getAccountId();
					// first delete entries in BookAuthors junction table
					// can't delete entries in Books or Authors tables while they have foreign keys in junction table
					// prepare to delete the junction table entries (bookAuthors)
					stmt3 = conn.prepareStatement(
							"delete from accounts " +
							"  where account_id = ? "
					);
					
					// delete the junction table entries from the DB for this title
					// this works if there are not multiple books with the same name
					stmt3.setInt(1, accountID);
					stmt3.executeUpdate();
					
					System.out.println("Deleted junction table entries for Account(s) <" + accountID +", " + username + "> from DB");									
				
						
	
					return account;
				} finally {
					DBUtil.closeQuietly(stmt3);								
				}
			}
		});
	}

	@Override
	public Integer removeDeckToUserByName(String username) {
		return executeTransaction(new Transaction<Integer>() {
			@Override
			public Integer execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				
				
				ResultSet resultSet1 = null;
				ResultSet resultSet3 = null;
				
				// for saving author ID and book ID
				Integer account_id = -1;
				String cardname1 = "";
				String cardname2 = "";
				String cardname3 = "";
				

				// try to retrieve author_id (if it exists) from DB, for Author's full name, passed into query
				try {
					stmt1 = conn.prepareStatement(
							"select accounts.* from accounts " +
							"  where username = ? "
					);
					stmt1.setString(1, username);
					
					// execute the query, get the result
					resultSet1 = stmt1.executeQuery();

					
					// if Author was found then save author_id					
					if (resultSet1.next())
					{
						account_id = resultSet1.getInt(1);
						System.out.println("Account <" + username + "> found with ID: " + account_id);						
					
							// prepare SQL insert statement to add Author to Authors table
							stmt2 = conn.prepareStatement(
									"update accounts "
									+ "set card_1 = ?, card_2 = ?, card_3 = ?"
									+ "WHERE account_id = ?" 
							);
							stmt2.setString(1, cardname1);
							stmt2.setString(2, cardname2);
							stmt2.setString(3, cardname3);
							stmt2.setInt(4, account_id);
							
							// execute the update
							stmt2.executeUpdate();
							
							//System.out.println("New Cards <" + cardname1 + ", " + cardname2 + " , " + cardname3 + "> inserted in Account: <" + username + ">  ");						
						
							// try to retrieve author_id for new Author - DB auto-generates author_id
							stmt3 = conn.prepareStatement(
									"select account_id from accounts " +
									"  where username = ?  "
							);
							stmt3.setString(1, username);
							
							// execute the query							
							resultSet3 = stmt3.executeQuery();
							
							// get the result - there had better be one							
							if (resultSet3.next())
							{
								account_id = resultSet3.getInt(1);
								System.out.println("Cards removed from ID:"  + account_id +" <" + cardname1 + " , " + cardname2 + " , " + cardname3 + ">" );						
							}
							else	// really should throw an exception here - the new author should have been inserted, but we didn't find them
							{
								System.out.println("New Cards <" + cardname1 + ", " + cardname2 + " , " + cardname3 + "> not found in Account (ID: " + account_id);
							}
						}
					
					else {
					System.out.println("Account <" + username + "> not found");
					}

					return account_id;
				} finally {
					DBUtil.closeQuietly(resultSet1);
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);					
					DBUtil.closeQuietly(resultSet3);
					DBUtil.closeQuietly(stmt3);					
				
				}
			}
		});
	}
	
	
	@Override
	public Deck selectRandomCards() {
		Deck newDeck = new Deck();
		
		//Creates a pseudorandom random number the first time 
		Random rand = new Random();
		int randInt =  rand.nextInt(15)+1;	
		int[] array = new int[3] ;
		for (int i = 0; i <= 2; i++) {
			array[i] = randInt;
			//Creates a pseudorandom random number for a new seed so that a different number is created
			rand = new Random();
			randInt = rand.nextInt(15)+1;	
			
			}
		
	Card card1 = findCardByCardID(array[0]);
	Card card2 = findCardByCardID(array[1]);
	Card card3 = findCardByCardID(array[2]);
		
	newDeck.addCard(card1);	
	newDeck.addCard(card2);
	newDeck.addCard(card3);
		
		
	return newDeck;
		
		
		
	}




}
