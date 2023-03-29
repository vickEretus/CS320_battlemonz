package edu.ycp.cs320.battlemonsterz.model;


public class Game {
	// fields
	public static final int PLAYER_1 = 0;
	public static final int PLAYER_2 = 1;
	
	private int currentplayer;
	private int round;
	private Deck deck_one;
	private Deck deck_two;
	private String status;
	private boolean finished;
	
	
	// Game constructors
	public Game(Deck deck_one, Deck deck_two, int currentplayer) {
		this.deck_one = deck_one;
		this.deck_two = deck_two;
		this.currentplayer = currentplayer;
		finished = false;
		
	}
	
	public Game(Deck deck_one, Deck deck_two, int currentplayer, int round) {
		this.deck_one = deck_one;
		this.deck_two = deck_two;
		this.currentplayer = currentplayer;
		this.round = round;
		finished = false;
	}
	
	public Game() {
		currentplayer = PLAYER_1;
		round = 0;
		deck_one = new Deck();
		deck_two = new Deck();
		finished = false;
		
	}
	
	// getters
	
	public int getTurn() {
		return currentplayer;
	}
	
	public Deck getDeckOne() {
		return deck_one;
	}
	
	public Deck getDeckTwo() {
		return deck_two;
	}
	
	public Deck getCurrentDeck() {
		if (currentplayer == PLAYER_1) {
			return deck_one;
		}
		
		else {
			return deck_two;
		}
	}
	
	public Deck getOtherDeck() {
		if (currentplayer == PLAYER_1) {
			return deck_two;
		}
		
		else {
			return deck_one;
		}
	}
			
	
	
	public int getRound() {
		return round;
	}
	
	// setters
	public void setTurn(int player) {
		currentplayer = player;
	}
	
	public void updateTurn() {
		if (currentplayer == PLAYER_1){
			currentplayer = PLAYER_2;
		}
		else{
			currentplayer = PLAYER_1;
		}
	}
	
	public boolean checkFinished() {  // check to see if either deck is less than 0 health
	
		if ((deck_one.getTeamHealth() < 0.0) || (deck_two.getTeamHealth() < 0.0)) {
		finished = true;
		}
		
		else {
			finished = false;
		}
		
		return finished;
	}
	
	public void setStatus() {
		if (finished) {
			status = "Game Over";
		}
		else {
			status = "Game In Progress";
		}
	
		
	}
	
	public void setRound(int round) {
		this.round = round;
	}
	
	public String toString() {
		return ("Game Status: " + status + "Team 1 Health: " + deck_one.getTeamHealth() + 
				"Team 2 Health: " + deck_two.getTeamHealth());
	}
	
}
