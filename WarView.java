/**
 * View for the GUI version of the War Game
 * @author Trevor Stalnaker
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarView extends JFrame{
	
	private WarGame game;

	/**
	 * Constructor for the WarView Class
	 * @param game
	 */
	public WarView(WarGame game){
        this.game = game;
        game.deal();
        
        CardPanel player1Panel = new CardPanel();
        CardPanel player2Panel = new CardPanel();
        JButton moveButton = new JButton("Move");
        JButton newGameButton = new JButton("New Game");
        JTextArea display = new JTextArea();
        JPanel header = new JPanel();
        JPanel buttons = new JPanel();
        JPanel centerField = new JPanel();
        JLabel player1Tag = new JLabel("Player 1", JLabel.CENTER);
        JLabel player2Tag = new JLabel("Player 2", JLabel.CENTER);
        JLabel statusTag = new JLabel("Game Status", JLabel.CENTER);
        display.setBackground(Color.WHITE);
        display.setEditable(false);
        
        moveButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (game.winner() == ""){
                    game.step();
                    display.setText(game.detailedToString());
                    Card card1 = game.getPlayer1Card();
                    Card card2 = game.getPlayer2Card();
                    card1.turn();
                    card2.turn();
                    player1Panel.setCard(card1);
                    player2Panel.setCard(card2);
                }
                else {
                	JOptionPane.showMessageDialog(null, "The game has already ended!\nThere are no more moves!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                }
            }});
        
        newGameButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	game.setGame();
            	game.deal();
            	player1Panel.setCard(null);
                player2Panel.setCard(null);
                display.setText("");
            }});
        
        
        Container c = getContentPane();
        
        centerField.setLayout(new GridLayout(1,3));
        centerField.add(player1Panel);
        centerField.add(display);
        centerField.add(player2Panel);
        c.add(centerField, BorderLayout.CENTER);
        
        buttons.add(moveButton, BorderLayout.WEST);
        buttons.add(newGameButton, BorderLayout.EAST);
        c.add(buttons, BorderLayout.SOUTH);
        
        header.setLayout(new GridLayout(1,3));
        header.add(player1Tag);
        header.add(statusTag);
        header.add(player2Tag);
        c.add(header, BorderLayout.NORTH);
        
    }
}
