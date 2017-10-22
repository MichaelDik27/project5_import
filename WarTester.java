/**
 * A tester program for the WarGame model
 * @author Trevor Stalnaker
 *
 */


public class WarTester {
	
	static WarGame game;
	
	public static void main(String[] args) {
		game = new WarGame();
		game.deal();
		while(game.winner() == "") {
			game.step();
			System.out.print(game);
		System.out.print(game.winner());
		}
		
	}
}
