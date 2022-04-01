package warGame;

public class App {
//main method, starts and plays the game
	/**
	 * Here are the rules of War:
	 * <ul>
	 * <li>Two players are randomly selected from a list of player names.
	 * <li>A card deck is generated and shuffled.
	 * <li>The players are dealt cards from the deck, which go into their hands.
	 * <li>Players draw the top card from their hand and compare the card rank. The
	 * player with the highest card gets a point. If there's a tie, neither player
	 * gets a point.
	 * <li>After all the cards have been played, the winner is announced. If the
	 * players both have the same number of points, a tie is announced.
	 * </ul>
	 * 
	 * @author Promineo
	 *
	 */
	public static void main(String[] args) {
		new App().run();

	}

	/**
	 * This method creates the players, creates and shuffles the deck, and plays the
	 * game.
	 */
	private void run() {
		Player player1 = new Player("Player1");
		Player player2 = new Player("Player2");
		
		/* Create and shuffle the deck. */
		Deck deck = new Deck();
		
		//System.out.println(deck); test to make sure it prints correctly
		deck.shuffle();
		
		//System.out.println(deck); test to make sure it prints correctly
		/* Deal the cards evenly to each player. */
	    deal(deck, player1, player2);

	    /* Play the game. */
	    play(player1, player2);

	    /* Announce the winner. If there is no winner, announce a tie. */
	    declareWinner(player1, player2);

	}
	//which player has the highest score- print winner, print loser or print tie
	private void declareWinner(Player player1, Player player2) {
		 if (player1.getScore() > player2.getScore()) {
		      printWinner(player1);
		      printLoser(player2);
		    } else if (player2.getScore() > player1.getScore()) {
		      printWinner(player2);
		      printLoser(player1);
		    } else {
		      printTie(player1, player2);
		    }
		  }
	//print tie
	private void printTie(Player player1, Player player2) {
		System.out.println("Player 1 and Player 2 tied with a score of: " + player1.getScore() + ".");
	}
	//print loser
	private void printLoser(Player loser) {
		System.out.println(loser + " is the loser with a score of: " + loser.getScore() + ".");
	}
	//print winner
	private void printWinner(Player winner) {
		System.out.println(winner + " is the winner with a score of: " + winner.getScore() + ".");
	}
	//plays the game and stores scores for each player
	private void play(Player player1, Player player2) {
			int numTurns = player1.getHand().size();
		//players flip over top card in their hand and removes it from their hand
		for (int turn = 0; turn < numTurns; turn++) {
		      Card card1 = player1.flip();
		      Card card2 = player2.flip();
		//card ranks are compared and winning card = score increment for that player
		      if (card1.getRank() > card2.getRank()) {
		          player1.incrementScore();
		        } else if (card2.getRank() > card1.getRank()) {
		          player2.incrementScore();
		        }
		}
}
	
	//deal the deck evenly to each player hand which equals how many turns they each get
	private void deal(Deck deck, Player player1, Player player2) {
	int size = deck.size();
	for (int index = 0; index < size; index++) {
		if (index % 2 == 0) {
			player1.draw(deck);
		} else {
			player2.draw(deck);
		}
	}
}
}