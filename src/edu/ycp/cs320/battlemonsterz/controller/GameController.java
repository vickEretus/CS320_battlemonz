package edu.ycp.cs320.battlemonsterz.controller;

import edu.ycp.cs320.battlemonsterz.model.*;

public class GameController {
	
	// fields
	private Game model;
	private static double damage_modifier = 1.25;
	
	
	// constructors
	public GameController(Game model) {
		this.model = model;
	}
	
	public GameController() {
		model = new Game();
	}
	
	
	// methods
	
	public Game getModel() {
		return model;
		
	}
	
	public void setModel(Game model) {
		this.model = model;
	}
	
	
	public void changePlayer() {
		model.updateTurn();
	}

	
	/*// method to check if the user's move is a valid move
	public boolean makeMove(Game model, int player) {
		
	}*/
	
	public boolean checkWin(Game model) {
		if ((model.getDeckOne().getTeamHealth() <= 0.0) ||  (model.getDeckTwo().getTeamHealth() <= 0.0)){
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public void attack(Card AttackCard, Card DefenseCard) { // user chooses to attack
		
		// within each type there is a typical attack and a damage modified attack
		
		// grass type
		if (AttackCard.getType() == Type.GRASS) {
			if (DefenseCard.getType() != Type.WATER) { 
				DefenseCard.setHealth(DefenseCard.getHealth() * AttackCard.getAttackRating());
			}
			else {
				DefenseCard.setHealth(DefenseCard.getHealth() * AttackCard.getAttackRating() * damage_modifier);
			}
			
		}
		
		// fire type
		else if (AttackCard.getType() == Type.FIRE) {
			if (DefenseCard.getType() != Type.GRASS) {
				DefenseCard.setHealth(DefenseCard.getHealth() * (1-AttackCard.getAttackRating()));
			}
			else {
				DefenseCard.setHealth(DefenseCard.getHealth() * (1-AttackCard.getAttackRating()) * damage_modifier);
			}
		}
		
		// water type
		else {
			if (DefenseCard.getType() != Type.FIRE) {
				DefenseCard.setHealth(DefenseCard.getHealth() * AttackCard.getAttackRating());
				
			}
			else {
				DefenseCard.setHealth(DefenseCard.getHealth() * (1-AttackCard.getAttackRating()) * damage_modifier);
			}
			
			
		}
		

	}
	
	/*public void defend(Type defense_type) { // user chooses to defend
		
	}*/
	

	
	
	
	
	
	
}
