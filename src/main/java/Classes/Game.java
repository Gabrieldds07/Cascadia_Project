package Classes;

import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.*;

import java.util.ArrayList;

public class Game {
    //Things needed to place files into
    private int turn;
    public static BufferedImage Tile1, Tile2, Tile3, Tile4, Tile5, Tile6, Tile7, Tile8, Tile9, Tile10, Tile11, Tile12, Tile13, Tile14, Tile15, Tile16, Tile17, Tile18, Tile19, Tile20, Tile21, Tile22, Tile23, Tile24, Tile25, Tile26, Tile27, Tile28, Tile29, Tile30, Tile31, Tile32, Tile33, Tile34, Tile35, Tile36, Tile37, Tile38, Tile39, Tile40, Tile41, Tile42, Tile43, Tile44, Tile45, Tile46, Tile47, Tile48, Tile49, Tile50, Tile51, Tile52, Tile53, Tile54, Tile55, Tile56, Tile57;
    public static BufferedImage keyStoneTile1, keyStoneTile2, keyStoneTile3, keyStoneTile4, keyStoneTile5, keyStoneTile6, keyStoneTile7, keyStoneTile8, keyStoneTile9, keyStoneTile10, keyStoneTile11, keyStoneTile12, keyStoneTile13, keyStoneTile14, keyStoneTile15, keyStoneTile16, keyStoneTile17, keyStoneTile18, keyStoneTile19, keyStoneTile20, keyStoneTile21, keyStoneTile22, keyStoneTile23, keyStoneTile24, keyStoneTile25;
    public static BufferedImage starterTile1, starterTile2, starterTile3, starterTile4, starterTile5;
    public static BufferedImage elkScoringCard, foxScoringCard, salmonScoringCard, bearScoringCard, hawkScoringCard;
    public static BufferedImage elkAnimalToken, foxAnimalToken, salmonAnimalToken, bearAnimalToken, hawkAnimalToken;
    private ArrayList <Player> playerList = new ArrayList();
    private  ArrayList <AnimalToken> allTokens = new ArrayList();
    private  ArrayList <HabitatTile> allHabitats = new ArrayList();
    private  HabitatDashBoard availableHabitats;


    //Initializes All images and image objects
    public void initializeImages() throws IOException{
        //1 Bear, 2 Elk, 3 Salmon, 4 Hawk, 5 Fox
        //1 river, 2 wetland, 3 forest, 4 mountain, 5 prairie
        allHabitats.add(new HabitatTile("1", 5, 2, 3, 2, 5, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile1.png")))));
        allHabitats.add(new HabitatTile("2", 5, 3, 3, 2, 5, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile2.png")))));
        allHabitats.add(new HabitatTile("3", 2, 4, 3, 2, 1, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile3.png")))));
        allHabitats.add(new HabitatTile("4", 2, 3, 3, 2, 4, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile4.png")))));
        allHabitats.add(new HabitatTile("5", 5, 4, 3, 1, 5, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile5.png")))));
        allHabitats.add(new HabitatTile("6", 4, 1, 3, 1, 4, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile6.png")))));
        allHabitats.add(new HabitatTile("7", 1, 5, 3, 1, 5, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile7.png")))));
        allHabitats.add(new HabitatTile("8", 1, 2, 3, 1, 4, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile8.png")))));
        allHabitats.add(new HabitatTile("9", 5, 3, 3, 2, 5, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile9.png")))));
        allHabitats.add(new HabitatTile("10",3, 4, 4, 2, 1, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile10.png")))));
        allHabitats.add(new HabitatTile("11",1, 3, 4, 2, 5, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile11.png")))));
        allHabitats.add(new HabitatTile("12",1, 5, 5, 1, 4, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile12.png")))));
        allHabitats.add(new HabitatTile("13",2, 4, 5, 1, 4, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile13.png")))));
        allHabitats.add(new HabitatTile("14",5, 4, 5, 2, 1, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile14.png")))));
        allHabitats.add(new HabitatTile("15",3, 4, 5, 2, 1, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile15.png")))));
        allHabitats.add(new HabitatTile("16",5, 3, 2, 5,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile16.png")))));
        allHabitats.add(new HabitatTile("17",5, 4, 4, 5,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile17.png")))));
        allHabitats.add(new HabitatTile("18",1, 3, 5, 1,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile18.png")))));
        allHabitats.add(new HabitatTile("19",2, 3, 5, 4,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile19.png")))));
        allHabitats.add(new HabitatTile("20",2, 5, 5, 4,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile20.png")))));
        allHabitats.add(new HabitatTile("21",5, 3, 1, 5,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile21.png")))));
        allHabitats.add(new HabitatTile("22",2, 3, 1, 5,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile22.png")))));
        allHabitats.add(new HabitatTile("23",1, 2, 5, 4,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile23.png")))));
        allHabitats.add(new HabitatTile("24",1, 5, 5, 1,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile24.png")))));
        allHabitats.add(new HabitatTile("25",3, 4, 1, 5,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile25.png")))));
        allHabitats.add(new HabitatTile("26",2, 5, 2, 5,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile26.png")))));
        allHabitats.add(new HabitatTile("27",3, 4, 4, 1,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile27.png")))));
        allHabitats.add(new HabitatTile("28",4, 1, 1, 2,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile28.png")))));
        allHabitats.add(new HabitatTile("29",4, 1, 4, 1,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile29.png")))));
        allHabitats.add(new HabitatTile("30",5, 3, 1, 2,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile30.png")))));
        allHabitats.add(new HabitatTile("31",1, 2, 4, 1,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile31.png")))));
        allHabitats.add(new HabitatTile("32",1, 3, 1, 2,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile32.png")))));
        allHabitats.add(new HabitatTile("33",3, 4, 4, 2,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile33.png")))));
        allHabitats.add(new HabitatTile("34",2, 3, 2, 4,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile34.png")))));
        allHabitats.add(new HabitatTile("35",5, 4, 4, 2,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile35.png")))));
        allHabitats.add(new HabitatTile("36",1, 5, 2, 4,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile36.png")))));
        allHabitats.add(new HabitatTile("37",4, 1, 4, 2,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile37.png")))));
        allHabitats.add(new HabitatTile("38",2, 4, 2, 4,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile38.png")))));
        allHabitats.add(new HabitatTile("39",1, 3, 2, 4,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile39.png")))));
        allHabitats.add(new HabitatTile("40",2, 5, 2, 3,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile40.png")))));
        allHabitats.add(new HabitatTile("41",2, 4, 1, 3,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile41.png")))));
        allHabitats.add(new HabitatTile("42",1, 2, 5, 3,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile42.png")))));
        allHabitats.add(new HabitatTile("43",1, 2, 3, 1,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile43.png")))));
        allHabitats.add(new HabitatTile("44",2, 3, 2, 3,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile44.png")))));
        allHabitats.add(new HabitatTile("45",1, 2, 3, 4,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile45.png")))));
        allHabitats.add(new HabitatTile("46",5, 3, 5, 3,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile46.png")))));
        allHabitats.add(new HabitatTile("47",1, 3, 1, 3,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile47.png")))));
        allHabitats.add(new HabitatTile("48",2, 3, 1, 3,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile48.png")))));
        allHabitats.add(new HabitatTile("49",5, 3, 2, 3,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile49.png")))));
        allHabitats.add(new HabitatTile("50",2, 5, 3, 4,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile50.png")))));
        allHabitats.add(new HabitatTile("51",1, 5, 2, 3,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile51.png")))));
        allHabitats.add(new HabitatTile("52",4, 1, 3, 1,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile52.png")))));
        allHabitats.add(new HabitatTile("53",1, 3, 5, 3,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile53.png")))));
        allHabitats.add(new HabitatTile("54",5, 4, 2, 3,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile54.png")))));
        allHabitats.add(new HabitatTile("55",4, 1, 3, 4,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile55.png")))));
        allHabitats.add(new HabitatTile("56",5, 4, 1, 3,            ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile56.png")))));


        allHabitats.add(new HabitatTile("1", 3, 2, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 1 Individual Top.png")))));
        allHabitats.add(new HabitatTile("1", 2, 5, 5, 3, false, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 1 Individual Right.png")))));
        allHabitats.add(new HabitatTile("1", 1, 4, 4, 2, 1, false, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 1 Individual Left.png")))));
        allHabitats.add(new HabitatTile("2", 5,5, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 2 Individual Top.png")))));
        allHabitats.add(new HabitatTile("2", 3, 4, 1, 2, false, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 2 Individual Left.png")))));
        allHabitats.add(new HabitatTile("2", 4, 2, 3, 4, 5, false, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 2 Individual Right.png")))));
        allHabitats.add(new HabitatTile("3", 2,4, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 3 Individual Top.png")))));
        allHabitats.add(new HabitatTile("3", 5, 4, 1, 5, false, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 3 Individual Left.png")))));
        allHabitats.add(new HabitatTile("3", 3, 1, 3, 2, 4, false, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 3 Individual Right.png")))));
        allHabitats.add(new HabitatTile("4", 4,1, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 4 Individual Top.png")))));
        allHabitats.add(new HabitatTile("4", 1, 5, 3, 1, false, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 4 Individual Left.png")))));
        allHabitats.add(new HabitatTile("4", 2, 3, 4, 2, 5, false, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 4 Individual Right.png")))));
        allHabitats.add(new HabitatTile("5", 1,3, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 5 Individual Top.png")))));
        allHabitats.add(new HabitatTile("5", 4, 2, 5, 4, false, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 5 Individual Left.png")))));
        allHabitats.add(new HabitatTile("5", 3, 5, 3, 2, 1, false, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 5 Individual Right.png")))));


        allHabitats.add(new HabitatTile("1", 5, 2, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 1.png")))));
        allHabitats.add(new HabitatTile("2", 5, 3, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 2.png")))));
        allHabitats.add(new HabitatTile("3", 5, 5, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 3.png")))));
        allHabitats.add(new HabitatTile("4", 5, 3, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 4.png")))));
        allHabitats.add(new HabitatTile("5", 5, 2, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 5.png")))));
        allHabitats.add(new HabitatTile("6", 1, 1, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 6.png")))));
        allHabitats.add(new HabitatTile("7", 1, 3, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 7.png")))));
        allHabitats.add(new HabitatTile("8", 1, 4, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 8.png")))));
        allHabitats.add(new HabitatTile("9", 1, 4, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 9.png")))));
        allHabitats.add(new HabitatTile("10", 1, 1, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 10.png")))));
        allHabitats.add(new HabitatTile("11", 2, 5, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 11.png")))));
        allHabitats.add(new HabitatTile("12", 2, 3, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 12.png")))));
        allHabitats.add(new HabitatTile("13", 2, 5, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 13.png")))));
        allHabitats.add(new HabitatTile("14", 2, 4, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 14.png")))));
        allHabitats.add(new HabitatTile("15", 2, 3, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 15.png")))));
        allHabitats.add(new HabitatTile("16", 3, 2, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 16.png")))));
        allHabitats.add(new HabitatTile("17", 3, 5, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 17.png")))));
        allHabitats.add(new HabitatTile("18", 3, 5, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 18.png")))));
        allHabitats.add(new HabitatTile("19", 3, 1, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 19.png")))));
        allHabitats.add(new HabitatTile("20", 3, 1, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 20.png")))));
        allHabitats.add(new HabitatTile("21", 4, 2, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 21.png")))));
        allHabitats.add(new HabitatTile("22", 4, 2, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 22.png")))));
        allHabitats.add(new HabitatTile("23", 4, 4, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 23.png")))));
        allHabitats.add(new HabitatTile("24", 4, 4, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 24.png")))));
        allHabitats.add(new HabitatTile("25", 4, 1, true, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 25.png")))));


        allTokens.add(new AnimalToken(1, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Animal Tokens/bear.png")))));
        allTokens.add(new AnimalToken(2, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Animal Tokens/elk.png")))));
        allTokens.add(new AnimalToken(3, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Animal Tokens/salmon.png")))));
        allTokens.add(new AnimalToken(4, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Animal Tokens/hawk.png")))));
        allTokens.add(new AnimalToken(5, ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Animal Tokens/fox.png")))));


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

        //availableHabitats instantiation
        for(int i=0;i<4;i++){
            int num = (int)(Math.random() *(allHabitats.size()));
            availableHabitats.addHabitat(allHabitats.get(num));
        }
    }

    public ArrayList<AnimalToken> getAllTokens () {
        return allTokens;
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

    public HabitatDashBoard clickedAnimalToken(int n){
        AnimalToken a = availableHabitats.get(n).getCorrespondingToken();
        a.setClicked(true);
        availableHabitats.get(n).setClicked(true);
        return availableHabitats;
    }

    public HabitatDashBoard clickedHabitatTile(int n){
        AnimalToken a = availableHabitats.get(n).getCorrespondingToken();
        a.setClicked(true);
        availableHabitats.get(n).setClicked(true);
        return availableHabitats;
    }

    public HabitatDashBoard usedNatureToken(int animalToken, int habitatTile){
        PlayerBoard p = playerList.get(turn).getPlayerBoard();
        if(p.getNatureTokens() > 0){
            p.setNatureTokens(p.getNatureTokens()- 1);
            availableHabitats.get(habitatTile).setClicked(true);
            AnimalToken a = availableHabitats.get(habitatTile).getCorrespondingToken();
            AnimalToken b = availableHabitats.get(animalToken).getCorrespondingToken();
            b.setClicked(true);
            availableHabitats.get(habitatTile).setCorrespondingToken(b);
            availableHabitats.get(animalToken).setCorrespondingToken(a);
        }
        return availableHabitats;
    }

    public HabitatDashBoard placedHabitat (int num, int row, int col, Player p, boolean usedCorrespondingToken) {
        if(p.getTurnsLeft() > 0) {
            availableHabitats.get(num).setClicked(false);
            availableHabitats.get(num).getCorrespondingToken().setClicked(false);

            //if they used the corresponding animal token and didn't discard it
            if (usedCorrespondingToken) {
                availableHabitats.get(num).setTokenPlaced(availableHabitats.get(num).getCorrespondingToken());
            }

            //placing habitat in board
            Hexagon[][] b = p.getPlayerBoard().getBoard();
            b[row][col].setHabitatTile(availableHabitats.get(num));

            //updating habitatDashboard
            availableHabitats.get(num).setPlaced(true);
            availableHabitats.removeHabitat(num);
            int rand = (int) (Math.random() * (allHabitats.size()));
            availableHabitats.addHabitat(allHabitats.get(rand));
        }
            //updating player turn
            p.setTurnsLeft(p.getTurnsLeft() - 1);
            p.setTurn(false);
            turn++;
            if (turn == playerList.size()) {
                turn = 0;
            }
            playerList.get(turn).setTurn(true);
    public HabitatDashBoard placedHabitat (int num, int row, int col, Player p) {
        if(p.getTurnsLeft() > 0){ // if they have turns left
            availableHabitats.get(num).setClicked(false);
            availableHabitats.get(num).getCorrespondingToken().setClicked(false);
            availableHabitats.get(num).setTokenPlaced(availableHabitats.get(num).getCorrespondingToken());
            Hexagon[][] b = p.getPlayerBoard().getBoard();
            b[row][col].setHabitatTile(availableHabitats.get(num));
            availableHabitats.removeHabitat(num);
            int rand = (int)(Math.random() *(allHabitats.size()));
            availableHabitats.addHabitat(allHabitats.get(rand));

            //decreases turn left by one
            p.setTurnsLeft(p.getTurnsLeft() - 1);
            p.setTurn(false);

            //set next player turn
            if(turn == playerList.size() -1){
                turn = 0;
            }
            playerList.get(turn + 1);
        }
        return availableHabitats;
    }

    public void replaceFourSameTokens(){
        //checks if all animal tokens are the same
        boolean same = true;
        int type = availableHabitats.get(0).getCorrespondingToken().getType();
        for(int i = 0; i < 4; i++){
            if(availableHabitats.get(i).getCorrespondingToken().getType() != type){
                same = false;
            }
        }
        if(same){
            for(int i = 0; i < 4; i++){
                int num = (int)(Math.random() *(allTokens.size()));
                availableHabitats.replaceToken(i, allTokens.get(num));
            }
        }
    }

    public void replaceThreeSameTokens(){
        boolean same = true;
        int j = 0;
        int type = availableHabitats.get(0).getCorrespondingToken().getType();
        for(int i = 0; i < 4; i++){
            if(availableHabitats.get(i).getCorrespondingToken().getType() != type){
                j++;
                if(j > 1){
                    same = false;
                }
            }
        }
        if(same){
            for(int i = 0; i < 4; i++){
                if(availableHabitats.get(i).getCorrespondingToken().getType() == type){
                    int num = (int)(Math.random() *(allTokens.size()));
                    availableHabitats.replaceToken(i, allTokens.get(num));
                }
            }
        }
    }

    //1 river, 2 wetland, 3 forest, 4 mountain, 5 prairie
    public int getRiverScoring(Player p){
        return p.getPlayerBoard().calculateBiomes(1);
    }

    public int getWetlandScoring(Player p){
        return p.getPlayerBoard().calculateBiomes(2);
    }

    public int getForestScoring(Player p){
        return p.getPlayerBoard().calculateBiomes(3);
    }

    public int getMountainScoring(Player p){
        return p.getPlayerBoard().calculateBiomes(4);
    }

    public int getPrairieScoring(Player p){
        return p.getPlayerBoard().calculateBiomes(5);
    }

    //1 Bear, 2 Elk, 3 Salmon, 4 Hawk, 5 Fox
    public int getSalmonScoring(Player p){
        return p.getPlayerBoard().calculateSalmon();
    }

    public int getElkScoring(Player p){
        return p.getPlayerBoard().calculateElk();
    }

    public int getBearScoring(Player p){
        return p.getPlayerBoard().calculateBear();
    }

    public int getHawkScoring(Player p){
        return p.getPlayerBoard().calculateHawk();
    }

    public int getFoxScoring(Player p){
        return p.getPlayerBoard().calculateFox();
    }


}
