package warGame;

import java.util.LinkedList;
import java.util.List;

public class Player {
	private String name;
	private List<Card> hand = new LinkedList<>();
	private int score;
	
	public Player(String name) {
		this.name = name;
	}

	public int getScore() {
		// return the player's current score
		return score;
	}

	public List<Card> getHand() {
		// current hand- changes when flip is called
		return hand;
	}

	public Card flip() {
		//remove and return the card from the top of the player's hand
		return hand.remove(0);
	}

	public void incrementScore() {
		// increment player's score by 1
		score = getScore() + 1;
		
	}

	public void draw(Deck deck) {
		// remove the top card from the deck and add it to the player's hand
		getHand().add(deck.draw());
		
	}

	public String getName() {
		return name;
	}
	  @Override
	  public String toString() {
	    StringBuilder b = new StringBuilder();

	    b.append("Player ").append(name).append("'s hand: ")
	        .append(System.lineSeparator());

	    for(Card card : getHand()) {
	      b.append("   ").append(card).append("\n");
	    }

	    return b.toString();
	  }

}
	
	

