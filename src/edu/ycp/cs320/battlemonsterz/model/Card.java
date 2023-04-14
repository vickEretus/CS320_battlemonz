package edu.ycp.cs320.battlemonsterz.model;

// model class for Cards
// only the controller should be allowed to call the set methods

public class Card {
	// fields
	private static double max_health;
	private double health, attack_rating, defense_rating;
	private Type type;
	private String name;
	private String url;
	
	// constructors
	public Card(double health, double attack_rating, double defense_rating, Type type, String name) {
		this.health = health;
		this.attack_rating = attack_rating;
		this.defense_rating = defense_rating;
		this.type = type;
		this.name = name;
		max_health = health;
		url ="<%=request.getContextPath()%>/Images/" + name + ".jpeg";
	}
	
	public Card() {	 // default card
		health = 100.0;
		attack_rating = 0.0;
		defense_rating = 0.0;
		type = null;
		name = null;
		max_health = health;
		url ="";
	}
	
	// getters
	
	public double getHealth() {
		return health;
	}
	
	
	public double getDefenseRating() {
		return defense_rating;
	}

	public double getAttackRating() {
		return attack_rating;
	}
	
	public Type getType()
	{	
		return type;
	}
	
	public String getName() {
		return name;
	}
	
	public String getURL() {
		return url;
	}
	
	// setters
	
	public void setHealth(double health) {
		this.health = health;
	}
	
	public void setAttackRating(double attack_rating) {
		this.attack_rating = attack_rating;
	}
	
	
	public void setDefenseRating(double defense_rating) {
		this.defense_rating = defense_rating;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setToOriginal() {
		health = max_health;
	}
	
	public void setURL(String url) {
		this.url = url;
	}
	
	public void createURL(String cardname) {
		url = "<%=request.getContextPath()%>/Images/" + cardname + ".jpeg";
	}
	
	// to string
	public String toString() {
		return("Health = " + health + "\nAttack Rating = " + attack_rating + 
				"\nDefense Rating = " + defense_rating + "\nType = " + type);
	}
	


	
	
	
}
	
	
	
	
