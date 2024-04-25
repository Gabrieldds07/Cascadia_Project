package Classes;

import Graphics.GamePanel;

import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.*;

import java.util.ArrayList;

public class Game {
    //Things needed to place files into
    private int turn;
    private ArrayList <Player> playerList = new ArrayList();
    private  ArrayList <AnimalToken> allTokens = new ArrayList();
    private  ArrayList <HabitatTile> allHabitats = new ArrayList();
    private  HabitatDashBoard availableHabitats;


    //Initializes All images and image objects
    public void initializeImages() throws IOException{
        //1 Bear, 2 Elk, 3 Salmon, 4 Hawk, 5 Fox
        //1 river, 2 wetland, 3 forest, 4 mountain, 5 prairie
        allHabitats.add(new HabitatTile("1", 5, 2, 3, 2, 5, GamePanel.Tile1));
        allHabitats.add(new HabitatTile("2", 5, 3, 3, 2, 5, GamePanel.Tile2));
        allHabitats.add(new HabitatTile("3", 2, 4, 3, 2, 1, GamePanel.Tile3));
        allHabitats.add(new HabitatTile("4", 2, 3, 3, 2, 4, GamePanel.Tile4));
        allHabitats.add(new HabitatTile("5", 5, 4, 3, 1, 5, GamePanel.Tile5));
        allHabitats.add(new HabitatTile("6", 4, 1, 3, 1, 4, GamePanel.Tile6));
        allHabitats.add(new HabitatTile("7", 1, 5, 3, 1, 5, GamePanel.Tile7));
        allHabitats.add(new HabitatTile("8", 1, 2, 3, 1, 4, GamePanel.Tile8));
        allHabitats.add(new HabitatTile("9", 5, 3, 3, 2, 5, GamePanel.Tile9));
        allHabitats.add(new HabitatTile("10",3, 4, 4, 2, 1, GamePanel.Tile10));
        allHabitats.add(new HabitatTile("11",1, 3, 4, 2, 5, GamePanel.Tile11));
        allHabitats.add(new HabitatTile("12",1, 5, 5, 1, 4, GamePanel.Tile12));
        allHabitats.add(new HabitatTile("13",2, 4, 5, 1, 4, GamePanel.Tile13));
        allHabitats.add(new HabitatTile("14",5, 4, 5, 2, 1, GamePanel.Tile14));
        allHabitats.add(new HabitatTile("15",3, 4, 5, 2, 1, GamePanel.Tile15));
        allHabitats.add(new HabitatTile("16",5, 3, 2, 5,            GamePanel.Tile16));
        allHabitats.add(new HabitatTile("17",5, 4, 4, 5,            GamePanel.Tile17));
        allHabitats.add(new HabitatTile("18",1, 3, 5, 1,            GamePanel.Tile18));
        allHabitats.add(new HabitatTile("19",2, 3, 5, 4,            GamePanel.Tile19));
        allHabitats.add(new HabitatTile("20",2, 5, 5, 4,            GamePanel.Tile20));
        allHabitats.add(new HabitatTile("21",5, 3, 1, 5,            GamePanel.Tile21));
        allHabitats.add(new HabitatTile("22",2, 3, 1, 5,            GamePanel.Tile22));
        allHabitats.add(new HabitatTile("23",1, 2, 5, 4,            GamePanel.Tile23));
        allHabitats.add(new HabitatTile("24",1, 5, 5, 1,            GamePanel.Tile24));
        allHabitats.add(new HabitatTile("25",3, 4, 1, 5,            GamePanel.Tile25));
        allHabitats.add(new HabitatTile("26",2, 5, 2, 5,            GamePanel.Tile26));
        allHabitats.add(new HabitatTile("27",3, 4, 4, 1,            GamePanel.Tile27));
        allHabitats.add(new HabitatTile("28",4, 1, 1, 2,            GamePanel.Tile28));
        allHabitats.add(new HabitatTile("29",4, 1, 4, 1,            GamePanel.Tile29));
        allHabitats.add(new HabitatTile("30",5, 3, 1, 2,            GamePanel.Tile30));
        allHabitats.add(new HabitatTile("31",1, 2, 4, 1,            GamePanel.Tile31));
        allHabitats.add(new HabitatTile("32",1, 3, 1, 2,            GamePanel.Tile32));
        allHabitats.add(new HabitatTile("33",3, 4, 4, 2,            GamePanel.Tile33));
        allHabitats.add(new HabitatTile("34",2, 3, 2, 4,            GamePanel.Tile34));
        allHabitats.add(new HabitatTile("35",5, 4, 4, 2,            GamePanel.Tile35));
        allHabitats.add(new HabitatTile("36",1, 5, 2, 4,            GamePanel.Tile36));
        allHabitats.add(new HabitatTile("37",4, 1, 4, 2,            GamePanel.Tile37));
        allHabitats.add(new HabitatTile("38",2, 4, 2, 4,            GamePanel.Tile38));
        allHabitats.add(new HabitatTile("39",1, 3, 2, 4,            GamePanel.Tile39));
        allHabitats.add(new HabitatTile("40",2, 5, 2, 3,            GamePanel.Tile40));
        allHabitats.add(new HabitatTile("41",2, 4, 1, 3,            GamePanel.Tile41));
        allHabitats.add(new HabitatTile("42",1, 2, 5, 3,            GamePanel.Tile42));
        allHabitats.add(new HabitatTile("43",1, 2, 3, 1,            GamePanel.Tile43));
        allHabitats.add(new HabitatTile("44",2, 3, 2, 3,            GamePanel.Tile44));
        allHabitats.add(new HabitatTile("45",1, 2, 3, 4,            GamePanel.Tile45));
        allHabitats.add(new HabitatTile("46",5, 3, 5, 3,            GamePanel.Tile46));
        allHabitats.add(new HabitatTile("47",1, 3, 1, 3,            GamePanel.Tile47));
        allHabitats.add(new HabitatTile("48",2, 3, 1, 3,            GamePanel.Tile48));
        allHabitats.add(new HabitatTile("49",5, 3, 2, 3,            GamePanel.Tile49));
        allHabitats.add(new HabitatTile("50",2, 5, 3, 4,            GamePanel.Tile50));
        allHabitats.add(new HabitatTile("51",1, 5, 2, 3,            GamePanel.Tile51));
        allHabitats.add(new HabitatTile("52",4, 1, 3, 1,            GamePanel.Tile52));
        allHabitats.add(new HabitatTile("53",1, 3, 5, 3,            GamePanel.Tile53));
        allHabitats.add(new HabitatTile("54",5, 4, 2, 3,            GamePanel.Tile54));
        allHabitats.add(new HabitatTile("55",4, 1, 3, 4,            GamePanel.Tile55));
        allHabitats.add(new HabitatTile("56",5, 4, 1, 3,            GamePanel.Tile56));


        allHabitats.add(new HabitatTile("1", 3, 2, true, GamePanel.st1IndividualTop));
        allHabitats.add(new HabitatTile("1", 2, 5, 5, 3, false, GamePanel.st1IndividualRight));
        allHabitats.add(new HabitatTile("1", 1, 4, 4, 2, 1, false, GamePanel.st1IndividualLeft));
        allHabitats.add(new HabitatTile("2", 5,5, true, GamePanel.st2IndividualTop));
        allHabitats.add(new HabitatTile("2", 3, 4, 1, 2, false, GamePanel.st2IndividualRight));
        allHabitats.add(new HabitatTile("2", 4, 2, 3, 4, 5, false, GamePanel.st2IndividualLeft));
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
    }

    public Game(int numOfPlayers){
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
