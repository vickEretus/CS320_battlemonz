package edu.ycp.cs320.battlemonsterz.model;

// model class for users
// only the controller should be allowed to call the set methods

public class Account{
	// fields
	private String username;
	private String password;
	private Deck deck;
	private boolean isLoggedIn;
	private int accountId;
	private String card1;
	private String card2;
	private String card3;
	
	// constructors
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
		isLoggedIn = false;
		deck = new Deck();
	}
	
	public Account(String username, String password, Deck deck) {
		this.username = username;
		this.password = password;
		isLoggedIn = false;
		this.deck = deck;
	}
	
	public Account(String username, String password, Deck deck, boolean isLoggedIn) {
		this.username = username;
		this.password = password;
		this.isLoggedIn = isLoggedIn;
		this.deck = deck;
	}
	
	public Account() {
		this.username = null;
		this.password = null;
		isLoggedIn = false;
		deck = new Deck();
		
	}
	
	public Account(String username, String password, String card1, String card2, String card3) {
		this.username = username;
		this.password = password;
		this.card1 = card1;
		this.card2 = card2;
		this.card3 = card3;
		
		
	}
	
	public Account(String username, String card1, String card2, String card3) {
		this.username = username;
		this.card1 = card1;
		this.card2 = card2;
		this.card3 = card3;
		
	}
	// getters
	
	public String getUsername() {
		return username;
	}
	
	
	public String getPassword() {
		return password;
	}

	public Deck getDeck() {
		return deck;
	}
	
	public boolean getisLoggedIn() {
		return isLoggedIn;
	}
	
	// setters
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	public int getAccountId() {
		return accountId;
	}
	
	public void setIsLoggedIn(boolean bool) { 
		if (bool) {
			isLoggedIn = true;
		}
		else {
			isLoggedIn = false;
		}
	}
	
	public void addCard(Card card) { // add card to existing user's deck
		deck.addCard(card);
	}
	
	public void addDeck(Deck deck) { // add/replace the user's deck
		this.deck = deck; 
	}
	
	public void setCard1(String card1) {
		this.card1 = card1;
	}
	public String getCard1() {
		return card1;
	}
	
	
	public void setCard2(String card2) {
		this.card2 = card2;
	}
	public String getCard2() {
		return card2;
	}
	
	public void setCard3(String card3) {
		this.card3 = card3;	
	}
	public String getCard3() {
		return card3;
	}
	




	
	
	
	
	
}
	
	

