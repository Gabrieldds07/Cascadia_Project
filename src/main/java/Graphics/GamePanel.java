package Graphics;
//import Classes.Game;

import Classes.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.*;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.TreeMap;


public class GamePanel extends JPanel implements MouseListener{

	private BufferedImage background, ntButtons;
	private CascadiaFrame frame;
	private BufferedImage elkScoringCard;
	private BufferedImage salmonScoringCard;
	private BufferedImage foxScoringCard;
	private BufferedImage hawkScoringCard;
	private BufferedImage bearScoringCard;
	
	public GamePanel(int playerCount, CascadiaFrame frame) {
        try {
            background = ImageIO.read(GamePanel.class.getResource("/Images/Screens/GameBoard.png"));
            ntButtons = ImageIO.read(GamePanel.class.getResource("/Images/Screens/buttons.png"));
			elkScoringCard = ImageIO.read(Objects.requireNonNull(GamePanel .class.getResource("/Images/Scoring Cards/elk-large.jpg")));
			salmonScoringCard = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Scoring Cards/salmon-large.jpg")));
			foxScoringCard = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Scoring Cards/fox-large.jpg")));
			hawkScoringCard = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Scoring Cards/hawk-large.jpg")));
			bearScoringCard = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Scoring Cards/bear-large.jpg")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        addMouseListener(this);
        this.frame = frame;
       
    }
	
	public void paint(Graphics g) {
		drawBackground(g);
		
	}
	
	public void drawBackground(Graphics g) {
		//g.drawImage(Game.elkScoringCard, )
		g.drawImage(background, 0, 0, 1920, 1080, null);
		g.drawImage(ntButtons, 34, 917, 281, 123, null);
		g.drawImage(elkScoringCard, 1300, 800, 150, 150, null);
		g.drawImage(foxScoringCard, 1450, 800, 150, 150, null);
		g.drawImage(hawkScoringCard, 1600, 800, 150, 150, null);
		g.drawImage(bearScoringCard, 1750, 800, 150, 150, null);
		g.drawImage(salmonScoringCard, 1900, 800, 150, 150, null);
	}
	
	public void drawNatureTokenMenu(Graphics g) {
		
	}
	
	public void drawPlayerBoard(Graphics g, int i) {
		
	}
	
	 public void mouseClicked(MouseEvent e) {
	        int x = e.getX();
	        int y = e.getY();
	
	        System.out.println(x +", "+ y);
	        //arrows(up,right,down,left)
	        if(x>= 430 && x<=460 && y>=900 && y <= 945) {
	         
	        }
	        if(x>= 430 && x<=460 && y>=970 && y <= 1015) {
		         
	        }
	        if(x>= 460 && x<=505 && y>=945 && y <= 975) {
		         
	        }
	        if(x>= 385 && x<=430 && y>=945 && y <= 975) {
		         
	        }

	        //rotate cw, ccw, place, cancel
	        if(x>= 720 && x<= 970 && y>= 925 && y <= 950) {
		         
	        }
	        if(x>= 990 && x<= 1240 && y>= 925 && y <= 950) {
		         
	        }
	        
	        if(x>= 720 && x<= 970 && y>= 965 && y <= 990) {
		         
	        }
	        if(x>= 990 && x<= 1240 && y>= 965 && y <= 990) {
		         
	        }
	        
	       // if(x>=)
	        
	        
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