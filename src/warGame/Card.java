package warGame;

import java.util.List;

//this class represents a card, value, suit and rank
public class Card {
	private String suits;
	private String cardValues;
	private int rank;
//initialize card object, value, suit, rank
Card(String cardValue, String suit, int rank) {
	this.cardValues = cardValue;
	this.suits = suit;
	this.rank = rank;
}


@Override
public String toString() {
	return cardValues + " of " + suits;
	
} 
 


public int getRank() {
	// TODO Auto-generated method stub
	return rank;
}
}
	

