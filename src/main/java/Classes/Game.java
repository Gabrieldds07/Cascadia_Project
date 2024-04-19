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
    BufferedImage elkScoringCard, foxScoringCard, salmonScoringCard, bearScoringCard, hawkScoringCard;
    BufferedImage elkAnimalToken, foxAnimalToken, salmonAnimalToken, bearAnimalToken, hawkAnimalToken;
    private ArrayList <Player> playerList = new ArrayList();;
    private  ArrayList <AnimalToken> allTokens = new ArrayList();;
    private  ArrayList <HabitatTile> allHabitats = new ArrayList();;
    private  HabitatDashBoard availableHabitats;;
    //private  Map<String, ArrayList<ScoringCard>> allCards;
    private  ArrayList <ScoringCard> scoringCards = new ArrayList();;
    private Stack<HabitatTile> tiles;
    private Stack<HabitatTile> starterTiles;
    private Stack<HabitatTile> keyStoneTiles;
    private Stack<AnimalToken> animalTokens;

    public Game(int numOfPlayers) throws IOException{
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
        s = new TreeMap<>();
        s.put(1,2);
        s.put(2,5);
        s.put(3,9);
        s.put(4,13);
        scoringCards.add(new ScoringCard(2, s));

        //salmon
        s = new TreeMap<>();
        s.put(1,2);
        s.put(2,5);
        s.put(3,8);
        s.put(4,12);
        s.put(5,16);
        s.put(6,20);
        s.put(7,25);
        // 7+ is all 25
        scoringCards.add(new ScoringCard(3, s));

        //hawk
        s = new TreeMap<>();
        s.put(1,2);
        s.put(2,5);
        s.put(3,8);
        s.put(4,11);
        s.put(5,14);
        s.put(6,18);
        s.put(7,22);
        s.put(8,26);
        scoringCards.add(new ScoringCard(4, s));

        //fox
        s = new TreeMap<>();
        s.put(1,2);
        s.put(2,5);
        s.put(3,8);
        s.put(4,11);
        s.put(5,14);
        s.put(6,18);
        s.put(7,22);
        s.put(8,26);
        scoringCards.add(new ScoringCard(4, s));

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

        public void initializeImages() throws IOException{
            //1 Bear, 2 Elk, 3 Salmon, 4 Hawk, 5 Fox
            //1 river, 2 wetland, 3 forest, 4 mountain, 5 prairie
            tiles.push(new HabitatTile("1", 5, 2, 3, 2, 5, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile1.png")))));
            tiles.push(new HabitatTile("2", 5, 3, 3, 2, 5, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile2.png")))));
            tiles.push(new HabitatTile("3", 2, 4, 3, 2, 1, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile3.png")))));
            tiles.push(new HabitatTile("4", 2, 3, 3, 2, 4, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile4.png")))));
            tiles.push(new HabitatTile("5", 5, 4, 3, 1, 5, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile5.png")))));
            tiles.push(new HabitatTile("6", 4, 1, 3, 1, 4, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile6.png")))));
            tiles.push(new HabitatTile("7", 1, 5, 3, 1, 5, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile7.png")))));
            tiles.push(new HabitatTile("8", 1, 2, 3, 1, 4, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile8.png")))));
            tiles.push(new HabitatTile("9", 5, 3, 3, 2, 5, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile9.png")))));
            tiles.push(new HabitatTile("10",3, 4, 4, 2, 1, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile10.png")))));
            tiles.push(new HabitatTile("11",1, 3, 4, 2, 5, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile11.png")))));
            tiles.push(new HabitatTile("12",1, 5, 5, 1, 4, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile12.png")))));
            tiles.push(new HabitatTile("13",2, 4, 5, 1, 4, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile13.png")))));
            tiles.push(new HabitatTile("14",5, 4, 5, 2, 1, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile14.png")))));
            tiles.push(new HabitatTile("15",3, 4, 5, 2, 1, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile15.png")))));
            tiles.push(new HabitatTile("16",5, 3, 2, 5,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile16.png")))));
            tiles.push(new HabitatTile("17",5, 4, 4, 5,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile17.png")))));
            tiles.push(new HabitatTile("18",1, 3, 5, 1,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile18.png")))));
            tiles.push(new HabitatTile("19",2, 3, 5, 4,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile19.png")))));
            tiles.push(new HabitatTile("20",2, 5, 5, 4,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile20.png")))));
            tiles.push(new HabitatTile("21",5, 3, 1, 5,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile21.png")))));
            tiles.push(new HabitatTile("22",2, 3, 1, 5,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile22.png")))));
            tiles.push(new HabitatTile("23",1, 2, 5, 4,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile23.png")))));
            tiles.push(new HabitatTile("24",1, 5, 5, 1,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile24.png")))));
            tiles.push(new HabitatTile("25",3, 4, 1, 5,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile25.png")))));
            tiles.push(new HabitatTile("26",2, 5, 2, 5,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile26.png")))));
            tiles.push(new HabitatTile("27",3, 4, 4, 1,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile27.png")))));
            tiles.push(new HabitatTile("28",4, 1, 1, 2,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile28.png")))));
            tiles.push(new HabitatTile("29",4, 1, 4, 1,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile29.png")))));
            tiles.push(new HabitatTile("30",5, 3, 1, 2,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile30.png")))));
            tiles.push(new HabitatTile("31",1, 2, 4, 1,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile31.png")))));
            tiles.push(new HabitatTile("32",1, 3, 1, 2,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile32.png")))));
            tiles.push(new HabitatTile("33",3, 4, 4, 2,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile33.png")))));
            tiles.push(new HabitatTile("34",2, 3, 2, 4,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile34.png")))));
            tiles.push(new HabitatTile("35",5, 4, 4, 2,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile35.png")))));
            tiles.push(new HabitatTile("36",1, 5, 2, 4,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile36.png")))));
            tiles.push(new HabitatTile("37",4, 1, 4, 2,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile37.png")))));
            tiles.push(new HabitatTile("38",2, 4, 2, 4,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile38.png")))));
            tiles.push(new HabitatTile("39",1, 3, 2, 4,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile39.png")))));
            tiles.push(new HabitatTile("40",2, 5, 2, 3,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile40.png")))));
            tiles.push(new HabitatTile("41",2, 4, 1, 3,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile41.png")))));
            tiles.push(new HabitatTile("42",1, 2, 5, 3,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile42.png")))));
            tiles.push(new HabitatTile("43",1, 2, 3, 1,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile43.png")))));
            tiles.push(new HabitatTile("44",2, 3, 2, 3,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile44.png")))));
            tiles.push(new HabitatTile("45",1, 2, 3, 4,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile45.png")))));
            tiles.push(new HabitatTile("46",5, 3, 5, 3,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile46.png")))));
            tiles.push(new HabitatTile("47",1, 3, 1, 3,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile47.png")))));
            tiles.push(new HabitatTile("48",2, 3, 1, 3,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile48.png")))));
            tiles.push(new HabitatTile("49",5, 3, 2, 3,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile49.png")))));
            tiles.push(new HabitatTile("50",2, 5, 3, 4,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile50.png")))));
            tiles.push(new HabitatTile("51",1, 5, 2, 3,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile51.png")))));
            tiles.push(new HabitatTile("52",4, 1, 3, 1,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile52.png")))));
            tiles.push(new HabitatTile("53",1, 3, 5, 3,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile53.png")))));
            tiles.push(new HabitatTile("54",5, 4, 2, 3,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile54.png")))));
            tiles.push(new HabitatTile("55",4, 1, 3, 4,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile55.png")))));
            tiles.push(new HabitatTile("56",5, 4, 1, 3,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile56.png")))));

            starterTiles.push(new HabitatTile("1", 3, 2, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 1 Individual Top.png")))));
            starterTiles.push(new HabitatTile("1", 2, 5, 5, 3, false, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 1 Individual Right.png")))));
            starterTiles.push(new HabitatTile("1", 1, 4, 4, 2, 1, false, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 1 Individual Left.png")))));
            starterTiles.push(new HabitatTile("2", 5,5, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 2 Individual Top.png")))));
            starterTiles.push(new HabitatTile("2", 3, 4, 1, 2, false, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 2 Individual Left.png")))));
            starterTiles.push(new HabitatTile("2", 4, 2, 3, 4, 5, false, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 2 Individual Right.png")))));
            starterTiles.push(new HabitatTile("3", 2,4, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 3 Individual Top.png")))));
            starterTiles.push(new HabitatTile("3", 5, 4, 1, 5, false, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 3 Individual Left.png")))));
            starterTiles.push(new HabitatTile("3", 3, 1, 3, 2, 4, false, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 3 Individual Right.png")))));
            starterTiles.push(new HabitatTile("4", 4,1, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 4 Individual Top.png")))));
            starterTiles.push(new HabitatTile("4", 1, 5, 3, 1, false, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 4 Individual Left.png")))));
            starterTiles.push(new HabitatTile("4", 2, 3, 4, 2, 5, false, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 4 Individual Right.png")))));
            starterTiles.push(new HabitatTile("5", 1,3, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 5 Individual Top.png")))));
            starterTiles.push(new HabitatTile("5", 4, 2, 5, 4, false, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 5 Individual Left.png")))));
            starterTiles.push(new HabitatTile("5", 3, 5, 3, 2, 1, false, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 5 Individual Right.png")))));

            keyStoneTiles.push(new HabitatTile("1", 5, 2, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 1.png")))));
            keyStoneTiles.push(new HabitatTile("2", 5, 3, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 2.png")))));
            keyStoneTiles.push(new HabitatTile("3", 5, 5, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 3.png")))));
            keyStoneTiles.push(new HabitatTile("4", 5, 3, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 4.png")))));
            keyStoneTiles.push(new HabitatTile("5", 5, 2, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 5.png")))));
            keyStoneTiles.push(new HabitatTile("6", 1, 1, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 6.png")))));
            keyStoneTiles.push(new HabitatTile("7", 1, 3, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 7.png")))));
            keyStoneTiles.push(new HabitatTile("8", 1, 4, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 8.png")))));
            keyStoneTiles.push(new HabitatTile("9", 1, 4, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 9.png")))));
            keyStoneTiles.push(new HabitatTile("10", 1, 1, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 10.png")))));
            keyStoneTiles.push(new HabitatTile("11", 2, 5, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 11.png")))));
            keyStoneTiles.push(new HabitatTile("12", 2, 3, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 12.png")))));
            keyStoneTiles.push(new HabitatTile("13", 2, 5, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 13.png")))));
            keyStoneTiles.push(new HabitatTile("14", 2, 4, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 14.png")))));
            keyStoneTiles.push(new HabitatTile("15", 2, 3, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 15.png")))));
            keyStoneTiles.push(new HabitatTile("16", 3, 2, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 16.png")))));
            keyStoneTiles.push(new HabitatTile("17", 3, 5, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 17.png")))));
            keyStoneTiles.push(new HabitatTile("18", 3, 5, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 18.png")))));
            keyStoneTiles.push(new HabitatTile("19", 3, 1, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 19.png")))));
            keyStoneTiles.push(new HabitatTile("20", 3, 1, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 20.png")))));
            keyStoneTiles.push(new HabitatTile("21", 4, 2, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 21.png")))));
            keyStoneTiles.push(new HabitatTile("22", 4, 2, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 22.png")))));
            keyStoneTiles.push(new HabitatTile("23", 4, 4, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 23.png")))));
            keyStoneTiles.push(new HabitatTile("24", 4, 4, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 24.png")))));
            keyStoneTiles.push(new HabitatTile("25", 4, 1, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 25.png")))));

            animalTokens.push(new AnimalToken(1, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Animal Tokens/bear.png")))));
            animalTokens.push(new AnimalToken(2, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Animal Tokens/elk.png")))));
            animalTokens.push(new AnimalToken(3, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Animal Tokens/salmon.png")))));
            animalTokens.push(new AnimalToken(4, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Animal Tokens/hawk.png")))));
            animalTokens.push(new AnimalToken(5, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Animal Tokens/fox.png")))));

            //1 Bear, 2 Elk, 3 Salmon, 4 Hawk, 5 Fox
            //1 river, 2 wetland, 3 forest, 4 mountain, 5 prairie
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

                elkScoringCard = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Scoring Cards/elk-large.png")));
                salmonScoringCard = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Scoring Cards/salmon-large.png")));
                foxScoringCard = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Scoring Cards/fox-large.png")));
                hawkScoringCard = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Scoring Cards/hawk-large.png")));
                bearScoringCard = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Scoring Cards/bear-large.png")));

                elkAnimalToken = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Animal Tokens/elk.png")));
                salmonAnimalToken = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Animal Tokens/salmon.png")));
                foxAnimalToken = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Animal Tokens/fox.png")));
                hawkAnimalToken = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Animal Tokens/hawk.png")));
                bearAnimalToken = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Animal Tokens/bear.png")));

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
