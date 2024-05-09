package Graphics;

import Classes.Game;
import Classes.Hexagon;
import Classes.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


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
        calculatePlace();
    }

    public void paint(Graphics g) {
        super.paint(g);
        drawBackground(g);
        drawScores(g);

        if(playerboard){
            drawPlayerBoard(g, board);
        }
    }

    public void drawBackground(Graphics g) {
        g.drawImage(endBoard, 0, 0, 1920, 1050, null);
        g.setColor(Color.WHITE);
        g.setFont(new Font("DialogInput", Font.PLAIN, 20));
        g.drawString("view Player" + secondPlace + " board",445, 970);
        g.drawString("view Player" + firstPlace + " board",855, 970);
        g.drawString("view Player" + thirdPlace + " board",1265, 970);
    }

    public void calculatePlace(){
        ArrayList<Integer> num = new ArrayList<>();
        for(int i = 0; i < 3; i ++){
            num.add(game.totalAnimalTokens().get(i));
        }
        int player = 0;
        for(int i = 0; i < 3; i ++){
            int max = num.get(0);
            int number = num.get(i);
            if(number > max){
                max = number;
                player = i;

            }
        }
        firstPlace = player;
        num.set(player, -1);

        player = 0;
        for(int i = 0; i < 3; i ++){
            int max = num.get(0);
            int number = num.get(i);
            if(number > max){
                max = number;
                player = i;

            }
        }
        secondPlace = player;
        num.set(player, -1);

        for(int i = 0; i < 3; i++){
            if(num.get(i) != -1){
                player = i;
            }
        }
        thirdPlace = player;
    }

    public void drawScores(Graphics g){
        //488, 234
        //490, 311
        g.setColor(Color.BLACK);
        g.setFont(new Font("DialogInput", Font.PLAIN, 20));
        Integer[] yPos = {240, 215, 285};
        Integer[] xPos = {490, 910, 1320};
        for(int i = 0 ; i < 3 ; i++){
            Player p;
            if(i == 0){
                 p = game.getPlayerList().get(secondPlace);
            } else if( i == 1){
                 p = game.getPlayerList().get(firstPlace);
            } else {
                 p = game.getPlayerList().get(thirdPlace);
            }
            for(int j = 0 ; j < 6 ; j++){
                g.drawString(Integer.toString(game.getBearScoring(p)), xPos[i], yPos[i] );
                g.drawString(Integer.toString(game.getElkScoring(p)), xPos[i], yPos[i] + 80);
                g.drawString(Integer.toString(game.getSalmonScoring(p)), xPos[i], yPos[i] + 80 * 2 );
                g.drawString(Integer.toString(game.getHawkScoring(p)), xPos[i], yPos[i] + 80 * 3  );
                g.drawString(Integer.toString(game.getFoxScoring(p)), xPos[i], yPos[i] + 80 * 4  );
                g.drawString(Integer.toString(game.totalNatureTokens().get(i)), xPos[i], yPos[i] + 80 * 5 );

//                g.drawString(Integer.toString(game.getMountainScoring(p)), xPos[i] + 200, yPos[i] );
//                g.drawString(Integer.toString(game.getForestScoring(p)), xPos[i] + 200, yPos[i] + 80);
//                g.drawString(Integer.toString(game.getPrairieScoring(p)), xPos[i] + 200, yPos[i] + 80 * 2 );
//                g.drawString(Integer.toString(game.getWetlandScoring(p)), xPos[i] + 200, yPos[i] + 80 * 3  );
//                g.drawString(Integer.toString(game.getRiverScoring(p)), xPos[i] + 200, yPos[i] + 80 * 4  );
//                g.drawString(Integer.toString(game.getFinalScore().get(i)), xPos[i] + 200, yPos[i] + 80 * 5 );

            }
        }

    }

    public void drawPlayerBoard(Graphics g, Hexagon[][] b ){
        g.drawImage(GamePanel.scoringCardsBackground, 100, 100, 1720, 880, null);
        g.drawImage(GamePanel.close, 1760, 100,60,60, null);
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
                            g.drawImage(b[r][c].getHabitatTile().getTokenPlaced().getImg(), 500 + 100 * x, 200 + 83 * y, 50, 50, null);
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
