package Graphics.Panels;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

public class StartScreen extends JPanel implements MouseListener{
    private BufferedImage start;
    private int choice;
    public StartScreen() {
        try {
            start = ImageIO.read(Objects.requireNonNull(StartScreen.class.getResource("/Images/Screens/StartScreen.png")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        addMouseListener(this);
    }
    public void paint(Graphics g) {
        super.paint(g);
        //switch(choice){
        /*case 1: */
        g.drawImage(start, 0, 0, 1366, 768, null);
        // }
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
