package edu.ycp.cs320.battlemonsterz.model;

// model class for users
// only the controller should be allowed to call the set methods

public class User{
	// fields
	private String username;
	private String password;
	private Deck deck;
	private boolean isLoggedIn;
	
	// constructors
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		isLoggedIn = false;
		deck = new Deck();
	}
	
	public User(String username, String password, Deck deck) {
		this.username = username;
		this.password = password;
		isLoggedIn = false;
		this.deck = deck;
	}
	
	public User(String username, String password, Deck deck, boolean isLoggedIn) {
		this.username = username;
		this.password = password;
		this.isLoggedIn = isLoggedIn;
		this.deck = deck;
	}
	
	public User() {
		this.username = null;
		this.password = null;
		isLoggedIn = false;
		deck = new Deck();
		
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
	

	
	
	
	
	
}
	
	
	
	
