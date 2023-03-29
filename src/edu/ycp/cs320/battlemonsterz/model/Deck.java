package edu.ycp.cs320.battlemonsterz.model;
import java.util.*;

// model class for Cards
// only the controller should be allowed to call the set methods

public class Deck {
	// fields
	private ArrayList<Card> cards;
	private double deck_health;
	
	
	// constructors
	public Deck() {
		 cards = new ArrayList<>();
	}
	
	public Deck(ArrayList<Card> cards) {
		this.cards = cards;
		
	}
	
	// getters
	
	public ArrayList<Card> getCards() { // get deck
		return cards;
	}	
	
	public Card getCard(int index) {
		return cards.get(index);
	}
	
	public int getSize() { // get size of deck
		return cards.size();
	}
	
	public Double getTeamHealth() { // get total team health
		double sum = 0;
		for (int i = 0; i < cards.size(); i++) {
			sum += cards.get(i).getHealth();
		}
		deck_health = sum;
		return deck_health;
	}
	
	
	// setters
	public void addCard(Card card) { // adds card to collection
		cards.add(card);
		
	}
	
	public void deleteCard() { // deletes card from collection
		cards.remove(cards.size() - 1);
	}
	
	
	
	
	/*public void saveCards() { // saves cards to collection
		
	}
	
	
	public void confirm() { // user confirms collection
		
	}*/

	public void setToOriginal() {
		for (int i = 0; i < cards.size(); i++) {
			cards.get(i).setToOriginal();
		}
	}
	

	// to string
	public String toString() {
		return("Cards in Deck: " + cards.get(0).getName() + ", Health = " + cards.get(0).getHealth() +
				"\n" + cards.get(1).getName() + ", Health = " + cards.get(1).getHealth() +
				"\n" + cards.get(2).getName() + ", Health = " + cards.get(2).getHealth() +
				"\nTeam Health = " + deck_health);
	}
	
	
	
	
	
	

	
	
}
	
	
	
	
