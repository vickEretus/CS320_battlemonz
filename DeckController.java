package edu.ycp.cs320.battlemonsterz.controller;

import edu.ycp.cs320.battlemonsterz.model.*;

import java.awt.*;

public class DeckController {
	
	// fields
	private Deck deck;

	
	
	// constructors
	public DeckController(Deck deck) {
		this.deck = deck;
	}
	
	public DeckController() {
		deck = new Deck();
	}
	
	
	// methods
	
	public Deck getModel() {
		return deck;
		
	}
	
	public void setModel(Deck deck) {
		this.deck = deck;
	}
	
	/*public void changeCardWithCard(Card replacement, Card card) {
		int i = 0;
		boolean found = false;
		
		while ((i < deck.getSize() - 1) && (!found)) {
			Card card_check = deck.getCard(i);
			if (card_check.equals(card)) {
				deck.getCards().set(i, replacement);
				found=true;
			}
			
			i++;
		}
		
	}*/
	
	public void changeCardWithIndex(Card replacement, int index) {
		deck.getCards().set(index, replacement);
		
	}
	
	
}
