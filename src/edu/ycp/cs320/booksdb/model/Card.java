package edu.ycp.cs320.booksdb.model;

public class Card {
	private int cardId;
	private int attackId;
	private String name;
	private String type;
	private int hp;
	private int defense;
	
	public Card() {
		
	}
	
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	
	public int getCardId() {
		return cardId;
	}
	
	public void setAttackId(int attackId) {
		this.attackId = attackId;
	}
	
	public int getAttackId() {
		return attackId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setHP(int hp) {
		this.hp = hp;
	}
	
	public int getHP() {
		return hp;
	}
	
	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	public int getDefense() {
		return defense;
	}
}
