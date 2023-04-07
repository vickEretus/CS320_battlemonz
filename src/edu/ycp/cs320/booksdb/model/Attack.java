package edu.ycp.cs320.booksdb.model;

public class Attack {
	private int attackId;
	private String type;
	private int power;
	
	public Attack() {
		
	}
	
	public void setAttackId(int attackId) {
		this.attackId = attackId;
	}
	
	public int getAttackId() {
		return attackId;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setPower(int power) {
		this.power = power;
	}
	
	public int getPower() {
		return power;
	}
}
