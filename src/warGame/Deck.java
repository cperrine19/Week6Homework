package warGame;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("serial") // The class doesn't declare the instance variable serialVersionUID so a warning
							// is generated. The class doesn't need to be serialized
public class Deck extends LinkedList<Card> {
	List<String> suits = List.of("Diamonds", "Hearts", "Clubs", "Spades");
	List<String> cardValues = List.of("Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
			"Jack", "Queen", "King", "Ace");

	public Deck() {
		// constructor- a deck is a linkedlist of card- create cards and add to deck
		for (int i = 0; i < cardValues.size(); i++) {
			int rank = i + 1;
			String cardValue = cardValues.get(i);
			for (String suit : suits) {
				add(new Card(cardValue, suit, rank));
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("List of cards:" + "\n");
		for (Card card : this) {
			b.append("  ").append(card).append("\n");
		} 
		return b.toString();
		
	} 

	public void shuffle() {
		Collections.shuffle(this);
		}
	

	public Card draw() {
		// remove = return a card and add back into deck (clear first)
		return remove(0);
	}
}
