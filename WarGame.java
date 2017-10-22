/**
 * Models a Game of War
 * @author Trevor Stalnaker
 *
 */

import java.util.*;

public class WarGame{
	
	Player player1;
	Player player2;
	LinkedList<Card> warPile;
	String gameState;
	Deck deck;
	Card card1;
	Card card2;
	int moves;
	
	/**
	 * Constructor of the War Game
	 */
	public WarGame() {
		setGame();
	}
	
	/**
	 * Returns the game state of the War Game
	 * @return str - gameState
	 */
	public String toString() {
		return gameState;
	}
	
	/**
	 * Returns a detailed versions of the game's state
	 * @return Detailed String Representation of the Game
	 */
	public String detailedToString() {
		String tempStr = "Player One:\n"+
						 "Current Card:  " + card1 + "\n" +
						 "Unplayed Pile: " + player1.unplayedCount() + "\n" +
						 "Winnings Pile: " + player1.winningsCount() + "\n\n" +
						 "War Pile:      " + warPile.size() + "\n\n" +
						 "Player Two:\n"+
						 "Current Card:  " + card2 + "\n" +
						 "Unplayed Pile: " + player2.unplayedCount() + "\n" +
						 "Winnings Pile: " + player2.winningsCount() + "\n\n" +
						 "Moves:         " + moves;
		return tempStr;
	}
	
	/**
	 * Deals the cards to the players
	 */
	public void deal() {
		while(! deck.isEmpty()) {
			player1.addToUnplayedPile(deck.deal());
			player2.addToUnplayedPile(deck.deal());
		}
	}
	
	/**
	 * Get's player1's card
	 * @return card
	 */
	public Card getPlayer1Card() {
		return card1;
	}
	
	/**
	 * Get's player2's card
	 * @return card
	 */
	public Card getPlayer2Card() {
		return card2;
	}
	
	/**
	 * Steps through the game
	 */
	public void step() {
		card1 = player1.getCard();
		card2 = player2.getCard();
		warPile.add(card1);
		warPile.add(card2);
		gameState = "Player 1: " + card1 + "\n" + "Player 2: " + card2 + "\n";
		if(card1.getRank() == card2.getRank()) {
			gameState = "Cards added to the War Pile" + "\n";
		}else if(card1.getRank() > card2.getRank()){
			transferCards(player1);
			gameState = "Cards go to Player 1 \n";
		}else {
			transferCards(player2);
			gameState = "Cards go to Player 2 \n";
		}
		moves ++;
	}
	
	/**
	 * Transfers cards to players
	 * @param player
	 */
	private void transferCards(Player player) {
		while(warPile.size() > 0) {
			player.addToWinningsPile(warPile.remove(0));
		}
	}
	
	/**
	 * Displays winner or ""
	 * @return str - either winning text or an empty string
	 */
	public String winner() {
		if(player1.isDone() || player2.isDone()) {
			int count1 = player1.winningsCount();
			int count2 = player2.winningsCount();
			if(count1 > count2) {
				return "Player 1 wins, " + count1 + " to " + count2 + "!";
			}else if(count2 > count1) {
				return "Player 2 wins, " + count2 + " to " + count1 + "!";
			}else {
				return "The Game ends in a tie!";
			}
		}else{
			return "";
		}
	}
	
	/**
	 * Prepares the Game
	 */
	public void setGame() {
		player1 = new Player();
		player2 = new Player();
		warPile = new LinkedList();
		gameState = "";
		moves = 0;
		deck = new Deck();
		deck.shuffle();
	}

}