package Graphics;

import Classes.Game;
import Classes.Hexagon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;


public class EndPanel extends JPanel implements MouseListener {
    private BufferedImage endBoard;
    private Game game;
    private CascadiaFrame frame;
    private Hexagon[][] board;
    private boolean playerboard;
    private int firstPlace, secondPlace, thirdPlace;

    public EndPanel(Game g, CascadiaFrame frame){
        try {
            endBoard = ImageIO.read(StartPanel.class.getResource("/Images/Screens/EndPanel.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        addMouseListener(this);
        game = g;
        this.frame = frame;
    }

    public void paint(Graphics g) {
        super.paint(g);
        drawBackground(g);
        drawScores(g);

        if(playerboard){
            g.drawImage(endBoard,0,0,null);
            drawPlayerBoard(g, board);
        }
    }

    public void drawBackground(Graphics g) {
        g.drawImage(endBoard, 0, 0, 1920, 1050, null);
        g.drawString("view Player" + secondPlace + "board",410, 960);
        g.drawString("view Player" + firstPlace + "board",820, 960);
        g.drawString("view Player" + thirdPlace + "board",1220, 960);
    }

    public void drawScores(Graphics g){

    }

    public void drawPlayerBoard(Graphics g, Hexagon[][] b ){
        boolean even;
        int x = 0;
        int y = 0;
        for(int r = 6; r < 14; r++){
            even = (y % 2 == 0);
            for(int c = 6; c < 14; c++){
                if(b[r][c].getHabitatTile() != null) {
                    if (even) {
                        g.drawImage(b[r][c].getHabitatTile().getImg(), 430 + 100 * x, 175 + 84 * y, 100, 110, null);
                        if(b[r][c].getHabitatTile().getTokenPlaced() != null){
                            g.drawImage(b[r][c].getHabitatTile().getTokenPlaced().getImg(), 463 + 100 * x, 200 + 83 * y, 50, 50, null);
                        }
                    }
                    if (!even) {
                        g.drawImage(b[r][c].getHabitatTile().getImg(), 480 + 100 * x, 175 + 84 * y, 100, 110, null);
                        if(b[r][c].getHabitatTile().getTokenPlaced() != null){
                            g.drawImage(b[r][c].getHabitatTile().getTokenPlaced().getImg(), 415 + 100 * x, 200 + 83 * y, 50, 50, null);
                        }
                    }
                }
                x++;
                if(x == 8){
                    x = 0;
                }
            }
            y++;
        }
        g.drawImage(GamePanel.scoringCardsBackground, 100, 100, 1720, 880, null);
        g.drawImage(GamePanel.close, 1760, 100,60,60, null);
    }

    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println(x +", "+ y);

        if(x > 410 && x < 690 && y > 945 && y < 993){
            board = game.getPlayerList().get(0).getPlayerBoard().getBoard();
            playerboard = true;
        }
        if(x > 821 && x < 1100 && y > 945 && y < 993){
            board = game.getPlayerList().get(1).getPlayerBoard().getBoard();
            playerboard = true;
        }
        if(x > 1230 && x < 1507 && y > 945 && y < 993){
            board = game.getPlayerList().get(2).getPlayerBoard().getBoard();
            playerboard = true;
        }
        if (x >= 1760 && x <= 1820 && y >= 100 && y <= 160 && playerboard) {
            playerboard = false;
        }
        repaint();
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
