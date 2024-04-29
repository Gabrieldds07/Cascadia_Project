package Graphics;
import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.event.MouseListener;
public class StartPanel extends JPanel implements MouseListener	{
    private StartPanel start;
    private CascadiaFrame frame;
    private BufferedImage startScreen, playerScreen, rules, close;
    private int numPlayers;
    private boolean changeScreen;
    private boolean rulesPressed = false;
    public StartPanel(CascadiaFrame frame) {
        try {
            startScreen = ImageIO.read(StartPanel.class.getResource("/Images/Screens/StartScreen.png"));

            close = ImageIO.read(StartPanel.class.getResource("/Images/Screens/close.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        addMouseListener(this);
        this.frame = frame;
        
    }
    public void paint(Graphics g) {
        super.paint(g);
        drawBackground(g);

        if(rulesPressed == true) {
        	drawRules(g);
        }else {
        	rulesPressed = false;
        }
    }

    public void drawBackground(Graphics g) {
        g.drawImage(startScreen, 0, 0, 1920, 1080, null);
    }

    public void drawPlayerScreen(Graphics g) {
        g.drawImage(playerScreen, 0, 0, 1366, 768, null);
    }
    
    public void drawRules(Graphics g) {
    	g.setColor(Color.WHITE);
    	g.fillRect(100, 100, 1720, 880);
    	g.drawImage(close, 1740, 120,60,60, null);
    }


    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        System.out.println(x +", "+ y);
        
        if(x>= 709 && x<=1212 && y>=538 && y <= 736) {
	         frame.switchToGame();
        }
        if(x>=750 && x<=1168 && y>=789 && y <= 927) {
	         rulesPressed = true;
	         repaint();
        }
        
        if(x>=1740 && x<=1800 && y>=120 && y <= 180 && rulesPressed == true) {
	        rulesPressed = false;
	        repaint();
        }
    }
    public void mousePressed(MouseEvent e) {

    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }

    public int getNumPlayers() {
        return numPlayers;
    }

 
}





