package edu.ycp.cs320.battlemonsterz.controller;

import edu.ycp.cs320.battlemonsterz.model.*;

import java.awt.*;

public class CardController {
	
	// fields
	private Card card;

	
	
	// constructors
	public CardController(Card card) {
		this.card = card;
	}
	
	public CardController() {
	
	}
	
	
	// methods
	
	public Card getModel() {
		return card;
		
	}
	
	public void setModel(Card card) {
		this.card = card;
	}
	
	
	public String createURL(String cardname) {
		return "<%=request.getContextPath()%>/Images/"+cardname+".jpeg";
	}
	
	


	
	
	
	
	
	
}
