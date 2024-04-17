package Graphics;
import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.event.MouseListener;
public class StartPanel extends JPanel implements MouseListener	{
    private StartPanel start;
    private BufferedImage startScreen, playerScreen, rules;
    private int numPlayers;
    private boolean changeScreen;

    public StartPanel(CascadiaFrame frame) {
        try {
            startScreen = ImageIO.read(StartPanel.class.getResource("/Images/Screens/StartScreen.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        addMouseListener(this);
    }
    public void paint(Graphics g) {
        super.paint(g);
        drawBackground(g);

    }

    public void drawBackground(Graphics g) {
        g.drawImage(startScreen, 0, 0, 1366, 768, null);
    }

    public void drawPlayerScreen(Graphics g) {
        g.drawImage(playerScreen, 0, 0, 1366, 768, null);


    }


    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();



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

    public static class GamePanel extends JPanel implements MouseListener{
        private BufferedImage background;
        public GamePanel(int playerCount, CascadiaFrame frame) {
            try {
                background = ImageIO.read(StartPanel.class.getResource("/Images/background.png"));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
            addMouseListener(this);
        }


        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();

        }
        public void mousePressed(MouseEvent e) {

        }
        public void mouseReleased(MouseEvent e) {
        }
        public void mouseEntered(MouseEvent e) {
        }
        public void mouseExited(MouseEvent e) {
        }
    }
}





