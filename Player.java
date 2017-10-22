/**
 * Model of a player object
 * @author Trevor Stalnaker
 *
 */

import java.util.*;

public class Player {
	
	private LinkedList<Card> unplayed = new LinkedList();
	private LinkedList<Card> winnings = new LinkedList();
	
	/**
	 * Adds the given card to the Unplayed Pile of the Player
	 * @param card
	 */
	public void addToUnplayedPile(Card card) {
		unplayed.add(card);	
	}
	
	/**
	 * Adds the given card to the Winnings Pile of the Player
	 * @param card
	 */
	public void addToWinningsPile(Card card) {
		winnings.add(card);
	}
	
	/**
	 * Returns the card on the top of the deck, otherwise null
	 * @return card, null
	 */
	public Card getCard() {
		if(unplayed.size() == 0){
			return null;
		}else {
			return unplayed.remove(0);
		}
	}
	
	/**
	 * Returns true or false depending on the finishing state of the Player
	 * @return booleans
	 */
	public boolean isDone() {
		if(unplayed.size() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Returns the size of the Players unplayed pile
	 * @return int - size of unplayed pile
	 */
	public int unplayedCount() {
		return unplayed.size();
	}
	
	/**
	 * Returns the size of the Players winnings pile
	 * @return int - size of the winnings pile
	 */
	public int winningsCount() {
		return winnings.size();
	}

}
