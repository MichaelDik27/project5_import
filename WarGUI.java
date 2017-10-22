import javax.swing.JFrame;
/**
 * Creates the War GUI window
 * @author Trevor Stalnaker
 *
 */
public class WarGUI{

    public static void main(String[] args){
        final WarGame game = new WarGame();
        final JFrame view = new WarView(game);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(600, 300);
        view.setTitle("The Game of War");
        view.setResizable(false);
        view.setVisible(true);
    }
}
