package Classes;

import javax.smartcardio.Card;
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

public class Game {
    private int turn;
    BufferedImage Tile1, Tile2, Tile3, Tile4, Tile5, Tile6, Tile7, Tile8, Tile9, Tile10, Tile11, Tile12, Tile13, Tile14, Tile15, Tile16, Tile17, Tile18, Tile19, Tile20, Tile21, Tile22, Tile23, Tile24, Tile25, Tile26, Tile27, Tile28, Tile29, Tile30, Tile31, Tile32, Tile33, Tile34, Tile35, Tile36, Tile37, Tile38, Tile39, Tile40, Tile41, Tile42, Tile43, Tile44, Tile45, Tile46, Tile47, Tile48, Tile49, Tile50, Tile51, Tile52, Tile53, Tile54, Tile55, Tile56, Tile57;
    BufferedImage keyStoneTile1, keyStoneTile2, keyStoneTile3, keyStoneTile4, keyStoneTile5, keyStoneTile6, keyStoneTile7, keyStoneTile8, keyStoneTile9, keyStoneTile10, keyStoneTile11, keyStoneTile12, keyStoneTile13, keyStoneTile14, keyStoneTile15, keyStoneTile16, keyStoneTile17, keyStoneTile18, keyStoneTile19, keyStoneTile20, keyStoneTile21, keyStoneTile22, keyStoneTile23, keyStoneTile24, keyStoneTile25;
    BufferedImage starterTile1, starterTile2, starterTile3, starterTile4, starterTile5;
    private ArrayList <Player> playerList = new ArrayList();;
    private  ArrayList <AnimalToken> allTokens = new ArrayList();;
    private  ArrayList <HabitatTile> allHabitats = new ArrayList();;
    private  HabitatDashBoard availableHabitats;;
    //private  Map<String, ArrayList<ScoringCard>> allCards;
    private  ArrayList <ScoringCard> scoringCards = new ArrayList();;

    public Game(int numOfPlayers) {
        initializeImages();
        turn = 0;

        //player instantiation
        Player p;
        p = new Player(true);
        playerList.add(p);
        for(int i=1;i<numOfPlayers;i++){
            p = new Player(false);
            playerList.add(p);
        }

        //animal instantiation
        for(int i=1;i<=5;i++){
            //add images
            AnimalToken a = new AnimalToken(i, null);
            allTokens.add(a);
        }

        //habitat instantiation

        //starting habitat

        //available habitat instantiation
        for(int i=1;i<=5;i++){
            int num = (int)(Math.random() *(allHabitats.size()));
            availableHabitats.addHabitat(allHabitats.get(num));
        }

        //card instantiation
        //1 bear, 2 elk, 3 salmon, 4 hawk, 5 fox
        TreeMap<Integer, Integer> s = new TreeMap<>();

        //bear
        s.put(1,4);
        s.put(2,11);
        s.put(3,15);
        s.put(4,27);
        scoringCards.add(new ScoringCard(1, s));

        //elk


        //scoring cards instantiation
        /*
        String s = "Bear";
        int num = (int)(Math.random() *(allCards.get(s).size()));
        scoringCards.add(allCards.get(s, num));

        s = "Fox";
        num = (int)(Math.random() *(allCards.get(s).size()));
        scoringCards.add(allCards.get(s, num));

        s = "Salmon";
        num = (int)(Math.random() *(allCards.get(s).size()));
        scoringCards.add(allCards.get(s, num));

        s = "Hawk";
        num = (int)(Math.random() *(allCards.get(s).size()));
        scoringCards.add(allCards.get(s, num));

        s = "Elk";
        num = (int)(Math.random() *(allCards.get(s).size()));
        scoringCards.add(allCards.get(s, num));
        */
    }

        public void initializeImages(){
            try {
                Tile1 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile1.png")));
                Tile2 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile2.png")));
                Tile3 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile3.png")));
                Tile4 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile4.png")));
                Tile5 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile5.png")));
                Tile6 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile6.png")));
                Tile7 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile7.png")));
                Tile8 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile8.png")));
                Tile9 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile9.png")));
                Tile10 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile10.png")));
                Tile11 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile11.png")));
                Tile12 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile12.png")));
                Tile13 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile13.png")));
                Tile14 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile14.png")));
                Tile15 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile15.png")));
                Tile16 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile16.png")));
                Tile17 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile17.png")));
                Tile18 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile18.png")));
                Tile19 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile19.png")));
                Tile20 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile20.png")));
                Tile21 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile21.png")));
                Tile22 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile22.png")));
                Tile23 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile23.png")));
                Tile24 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile24.png")));
                Tile25 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile25.png")));
                Tile26 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile26.png")));
                Tile27 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile27.png")));
                Tile28 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile28.png")));
                Tile29 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile29.png")));
                Tile30 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile30.png")));
                Tile31 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile31.png")));
                Tile32 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile32.png")));
                Tile33 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile33.png")));
                Tile34 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile34.png")));
                Tile35 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile35.png")));
                Tile36 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile36.png")));
                Tile37 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile37.png")));
                Tile38 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile38.png")));
                Tile39 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile39.png")));
                Tile40 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile40.png")));
                Tile41 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile41.png")));
                Tile42 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile42.png")));
                Tile43 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile43.png")));
                Tile44 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile44.png")));
                Tile45 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile45.png")));
                Tile46 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile46.png")));
                Tile47 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile47.png")));
                Tile48 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile48.png")));
                Tile49 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile49.png")));
                Tile50 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile50.png")));
                Tile51 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile51.png")));
                Tile52 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile52.png")));
                Tile53 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile53.png")));
                Tile54 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile54.png")));
                Tile55 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile55.png")));
                Tile56 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile56.png")));
                Tile57 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile57.png")));

                keyStoneTile1 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 1.png")));
                keyStoneTile2 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 2.png")));
                keyStoneTile3 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 3.png")));
                keyStoneTile4 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 4.png")));
                keyStoneTile5 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 5.png")));
                keyStoneTile6 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 6.png")));
                keyStoneTile7 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 7.png")));
                keyStoneTile8 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 8.png")));
                keyStoneTile9 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 9.png")));
                keyStoneTile10 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 10.png")));
                keyStoneTile11 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 11.png")));
                keyStoneTile12 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 12.png")));
                keyStoneTile13 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 13.png")));
                keyStoneTile14 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 14.png")));
                keyStoneTile15 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 15.png")));
                keyStoneTile16 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 16.png")));
                keyStoneTile17 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 17.png")));
                keyStoneTile18 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 18.png")));
                keyStoneTile19 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 19.png")));
                keyStoneTile20 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 20.png")));
                keyStoneTile21 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 21.png")));
                keyStoneTile22 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 22.png")));
                keyStoneTile23 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 23.png")));
                keyStoneTile24 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 24.png")));
                keyStoneTile25 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 25.png")));

                starterTile1 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Starter Tile 1.png")));
                starterTile2 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Starter Tile 2.png")));
                starterTile3 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Starter Tile 3.png")));
                starterTile4 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Starter Tile 4.png")));
                starterTile5 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Starter Tile 5.png")));

            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        public ArrayList<AnimalToken> getAllTokens () {
            return allTokens;
        }

    public ArrayList<Card> getScoringCards() {
        return scoringCards;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public ArrayList<HabitatTile> getAllHabitats() {
        return allHabitats;
    }

    public HabitatDashBoard getAvailableHabitats() {
        return availableHabitats;
    }
}
