package Graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;


public class EndPanel extends JPanel implements MouseListener {
    private BufferedImage endBoard;
    private CascadiaFrame frame;

    public EndPanel(CascadiaFrame frame){
        try {
            endBoard = ImageIO.read(StartPanel.class.getResource("/Images/Screens/EndPanel.png"));
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
    }

    public void drawBackground(Graphics g) {
        g.drawImage(endBoard, 0, 0, 1920, 1080, null);
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
