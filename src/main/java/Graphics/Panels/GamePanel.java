package Graphics.Panels;

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
    public BufferedImage start
    public boolean gameEnd, gameStart;
    public BufferedImage playerOne, playerTwo, playerThree, first, second, third;
    public ArrayList<Player> playerList;
    public Player currentPlayer;
    public Player firstPlayer;
    public boolean firstDeckCardClickable, secondDeckCardClickable, thirdDeckCardClickable, fourthDeckCardClickable, firstAnimalTokenClickable, secondAnimalTokenClickable, thirdAnimalTokenClickable, fourthAnimalTokenClickable;
    public boolean Player1BoardClickable, Player2BoardClickable, Player3BoardClickable;
    public boolean rotateClockwiseClickable, rotateCounterClockwiseClickable, placeClickable, cancelClickable, removeWildlifeTokenClickable, useNatureTokenClickable, replaceSameTokensClickable, leftArrowClickable, rightArrowClickable, upArrowClickable, downArrowClickable;
    public boolean upStarterTileClickable, leftStarterTileClickable, rightStarterTileClickable;

    public GamePanel() {

        initializeImages();

        addMouseListener(this);

        playerList = new ArrayList<>();
        
        firstPlayer = playerList.get(0);
        currentPlayer = firstPlayer;

        gameEnd = false;
        gameStart = false;
    

        resetVisibleFlags();

       
    }
    
    public void initializeImages() {
        try {
            
        } catch (Exception e) {
            System.out.println(e.getMessage() + " hello");
            return;
        }
    }
    public void resetMouseClickEvents() {
        
    }
    public void resetVisibleFlags() {
        
    }
    public void play() {
        resetMouseClickEvents();
        resetVisibleFlags();
        repaint();
        if (startGameButtonClicked) {
            gameStart = true;
            currentPlayer = firstPlayer;
            repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
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
