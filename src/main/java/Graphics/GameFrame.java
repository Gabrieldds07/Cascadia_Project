package Graphics;

import javax.swing.*;

/**
 * This holds the game in a JFrame.
 */
public class GameFrame {
    private final int WIDTH = 1366;
    private final int HEIGHT = 768;
    
    public GameFrame() {
        super("Cascadia");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePanel g = new GamePanel();
        add(g);
        setVisible(true);
        g.play();
    }
    public void switchToGame(){
        
    }
    public void switchToEnd(){
        
    }
    public void endToMain(){
        
    }
    
}
