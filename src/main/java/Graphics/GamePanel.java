import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class GamePanel extends JPanel implements MouseListener{
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
