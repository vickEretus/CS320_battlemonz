package edu.ycp.cs320.battlemonsterz.controller;

import edu.ycp.cs320.battlemonsterz.model.*;

import java.awt.*;

public class GameController {
	
	// fields
	private Game model;
	private double damage_modifier = 0.10;
	private double damage_taken = 0.0;
	
	
	
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

	
	public boolean checkWin(Game model) {
		if (model.getFinished() == true) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public double attack(Card AttackCard, Card DefenseCard) { // user chooses to attack
		
		// within each type there is a typical attack and a damage modified attack

		    // Determine the effective attack rating, taking into account the damage modifier and defense rating
		    double effectiveAttackRating = AttackCard.getAttackRating();
		    
		    // grass type
		    if (AttackCard.getType() == Type.GRASS) {
		    	// damage modifications
		        if (DefenseCard.getType() == Type.WATER) {
		            effectiveAttackRating *= (1 + damage_modifier);
		        } else if (DefenseCard.getType() == Type.FIRE) {
		            effectiveAttackRating *= (1 - damage_modifier);
		        } 
		    } 
		    
		    // fire type
		    else if (AttackCard.getType() == Type.FIRE) {
		    	// damage modifications
		        if (DefenseCard.getType() == Type.GRASS) {
		            effectiveAttackRating *= (1 + damage_modifier);
		        } else if (DefenseCard.getType() == Type.WATER) {
		            effectiveAttackRating *= (1 - damage_modifier);
		        }
		    } 
		    
		    // water type
		    else {
		        if (DefenseCard.getType() == Type.FIRE) {
		        	// damage modifications
		            effectiveAttackRating *= (1 + damage_modifier);
		        } else if (DefenseCard.getType() == Type.GRASS) {
		            effectiveAttackRating *= (1 - damage_modifier);
		        }
		    }
		    
		    damage_taken = effectiveAttackRating - DefenseCard.getDefenseRating();
	
		
		
		// Reduce the defense card's health by the calculated damage
	    DefenseCard.setHealth(Math.max(0, DefenseCard.getHealth() - damage_taken));
	   
	    return damage_taken;

	}
	
	
	
	
	
	
	
}
