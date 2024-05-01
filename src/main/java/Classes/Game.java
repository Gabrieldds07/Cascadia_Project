package Classes;

import Graphics.GamePanel;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Game {
    //Things needed to place files into
    private int turn;
    private ArrayList <Player> playerList = new ArrayList();
    private  ArrayList <AnimalToken> allTokens = new ArrayList();
    private  ArrayList <HabitatTile> allHabitats = new ArrayList();
    private  ArrayList <HabitatTile> startingTiles = new ArrayList();
    private  HabitatDashBoard availableHabitats;


    //Initializes All images and image objects
    public void initializeImages() {
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


        startingTiles.add(new HabitatTile("1", 3, 2, true, GamePanel.st1IndividualTop));
        startingTiles.add(new HabitatTile("1", 2, 5, 5, 3, false, GamePanel.st1IndividualRight));
        startingTiles.add(new HabitatTile("1", 1, 4, 4, 2, 1, false, GamePanel.st1IndividualLeft));
        startingTiles.add(new HabitatTile("2", 5,5, true, GamePanel.st2IndividualTop));
        startingTiles.add(new HabitatTile("2", 3, 4, 1, 2, false, GamePanel.st2IndividualRight));
        startingTiles.add(new HabitatTile("2", 4, 2, 3, 4, 5, false, GamePanel.st2IndividualLeft));
        startingTiles.add(new HabitatTile("3", 2,4, true, GamePanel.st3IndividualTop));
        startingTiles.add(new HabitatTile("3", 5, 4, 1, 5, false, GamePanel.st3IndividualRight));
        startingTiles.add(new HabitatTile("3", 3, 1, 3, 2, 4, false, GamePanel.st3IndividualLeft));
        startingTiles.add(new HabitatTile("4", 4,1, true, GamePanel.st4IndividualTop));
        startingTiles.add(new HabitatTile("4", 1, 5, 3, 1, false, GamePanel.st4IndividualRight));
        startingTiles.add(new HabitatTile("4", 2, 3, 4, 2, 5, false, GamePanel.st4IndividualLeft));
        startingTiles.add(new HabitatTile("5", 1,3, true, GamePanel.st5IndividualTop));
        startingTiles.add(new HabitatTile("5", 4, 2, 5, 4, false, GamePanel.st5IndividualRight));
        startingTiles.add(new HabitatTile("5", 3, 5, 3, 2, 1, false, GamePanel.st5IndividualLeft));


        allHabitats.add(new HabitatTile("1", 5, 2, true, GamePanel.keyStoneTile1));
        allHabitats.add(new HabitatTile("2", 5, 3, true, GamePanel.keyStoneTile2));
        allHabitats.add(new HabitatTile("3", 5, 5, true, GamePanel.keyStoneTile3));
        allHabitats.add(new HabitatTile("4", 5, 3, true, GamePanel.keyStoneTile4));
        allHabitats.add(new HabitatTile("5", 5, 2, true, GamePanel.keyStoneTile5));
        allHabitats.add(new HabitatTile("6", 1, 1, true, GamePanel.keyStoneTile6));
        allHabitats.add(new HabitatTile("7", 1, 3, true, GamePanel.keyStoneTile7));
        allHabitats.add(new HabitatTile("8", 1, 4, true, GamePanel.keyStoneTile8));
        allHabitats.add(new HabitatTile("9", 1, 4, true, GamePanel.keyStoneTile9));
        allHabitats.add(new HabitatTile("10", 1, 1, true, GamePanel.keyStoneTile10));
        allHabitats.add(new HabitatTile("11", 2, 5, true, GamePanel.keyStoneTile11));
        allHabitats.add(new HabitatTile("12", 2, 3, true, GamePanel.keyStoneTile12));
        allHabitats.add(new HabitatTile("13", 2, 5, true, GamePanel.keyStoneTile13));
        allHabitats.add(new HabitatTile("14", 2, 4, true, GamePanel.keyStoneTile14));
        allHabitats.add(new HabitatTile("15", 2, 3, true, GamePanel.keyStoneTile15));
        allHabitats.add(new HabitatTile("16", 3, 2, true, GamePanel.keyStoneTile16));
        allHabitats.add(new HabitatTile("17", 3, 5, true, GamePanel.keyStoneTile17));
        allHabitats.add(new HabitatTile("18", 3, 5, true, GamePanel.keyStoneTile18));
        allHabitats.add(new HabitatTile("19", 3, 1, true, GamePanel.keyStoneTile19));
        allHabitats.add(new HabitatTile("20", 3, 1, true, GamePanel.keyStoneTile20));
        allHabitats.add(new HabitatTile("21", 4, 2, true, GamePanel.keyStoneTile21));
        allHabitats.add(new HabitatTile("22", 4, 2, true, GamePanel.keyStoneTile22));
        allHabitats.add(new HabitatTile("23", 4, 4, true, GamePanel.keyStoneTile23));
        allHabitats.add(new HabitatTile("24", 4, 4, true, GamePanel.keyStoneTile24));
        allHabitats.add(new HabitatTile("25", 4, 1, true, GamePanel.keyStoneTile25));


        allTokens.add(new AnimalToken(1, GamePanel.bearAnimalToken));
        allTokens.add(new AnimalToken(2, GamePanel.elkAnimalToken));
        allTokens.add(new AnimalToken(3, GamePanel.salmonAnimalToken));
        allTokens.add(new AnimalToken(4, GamePanel.hawkAnimalToken));
        allTokens.add(new AnimalToken(5, GamePanel.foxAnimalToken));
    }

    public Game(int numOfPlayers){
        initializeImages();
        turn = 0;
        //player instantiation
        Player p;
        for(int i=0;i<3;i++){
            if(i == 0){
                p = new Player(true);
            } else{
                p = new Player(false);
            }
            playerList.add(p);
            p.getPlayerBoard().getBoard()[9][9].setHabitatTile(startingTiles.get(0));
            startingTiles.remove(0);
            p.getPlayerBoard().getBoard()[10][10].setHabitatTile(startingTiles.get(0));
            startingTiles.remove(0);
            p.getPlayerBoard().getBoard()[10][9].setHabitatTile(startingTiles.get(0));
            startingTiles.remove(0);
        }

        //availableHabitats instantiation
        ArrayList<HabitatTile> h = new ArrayList<>();
        for(int i=0;i<4;i++){
            int num = (int)(Math.random() *(allHabitats.size()));
            h.add(allHabitats.get(num));
            int rand = (int) ((Math.random() * (4)) + 1);
            //1 Bear, 2 Elk, 3 Salmon, 4 Hawk, 5 Fox
            AnimalToken a;
            if(rand == 1){
                a = new AnimalToken(rand, GamePanel.bearAnimalToken);
            } else if(rand == 2){
                a = new AnimalToken(rand, GamePanel.elkAnimalToken);
            } else if(rand == 3){
                a = new AnimalToken(rand, GamePanel.salmonAnimalToken);
            } else if(rand == 4){
                a = new AnimalToken(rand, GamePanel.hawkAnimalToken);
            } else {
                a = new AnimalToken(rand, GamePanel.foxAnimalToken);
            }
            h.get(i).setCorrespondingToken(a);
        }
        availableHabitats = new HabitatDashBoard(h);
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

    public ArrayList<Player> getPlayerList() {return playerList;}

    public ArrayList<HabitatTile> getAllHabitats() {
        return allHabitats;
    }

    public HabitatDashBoard getAvailableHabitats() {
        return availableHabitats;
    }

    public HabitatDashBoard clickedHabitatTile(int n){
        for(HabitatTile h: allHabitats){
            h.setClicked(false);
        }
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

    public void placedHabitat (int num, int row, int col, Player p) {
        if(p.getTurnsLeft() > 0) {
            //placing habitat in board
            Hexagon[][] b = p.getPlayerBoard().getBoard();
            b[row][col].setHabitatTile(availableHabitats.get(num));
        }
    }

    public boolean habitatCanBePlaced(int row, int col, Player p) {
        PlayerBoard pb = playerList.get(turn).getPlayerBoard();
        ArrayList<Hexagon> surrounding = pb.getAdjacentHexagons(row, col);
        if(pb.getBoard()[row][col].getHabitatTile() == null){
            for(Hexagon h : surrounding){
                if(!h.getGray() || h.getHabitatTile() != null){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean animalCanBePlaced(int num, int row, int col, Player p) {
        PlayerBoard pb = playerList.get(turn).getPlayerBoard();
        ArrayList<AnimalToken> token = pb.getBoard()[row][col].getHabitatTile().getTokens();
        if(pb.getBoard()[row][col].getHabitatTile() != null){
            for(AnimalToken a : token){
                if(a.getType() == availableHabitats.getDashboard().get(num).getCorrespondingToken().getType()){
                    return true;
                }
            }
        }
        return false;
    }

    public void placedAnimalToken(int num, int row, int col, Player p) {
        if(p.getTurnsLeft() > 0) {
            availableHabitats.get(num).setClicked(false);
            p.getPlayerBoard().getBoard()[row][col].setGray(false);
            availableHabitats.get(num).getCorrespondingToken().setClicked(false);

            p.getPlayerBoard().getBoard()[row][col].getHabitatTile().setTokenPlaced(availableHabitats.get(num).getCorrespondingToken());
        }

        //updating habitatDashboard
        availableHabitats.get(num).setPlaced(true);
        availableHabitats.removeHabitat(num);
        int rand = (int) (Math.random() * (allHabitats.size()));
        availableHabitats.addHabitat(allHabitats.get(rand));
        rand = (int) ((Math.random() * (4)) + 1);
        AnimalToken a;
        if(rand == 1){
            a = new AnimalToken(rand, GamePanel.bearAnimalToken);
        } else if(rand == 2){
            a = new AnimalToken(rand, GamePanel.elkAnimalToken);
        } else if(rand == 3){
            a = new AnimalToken(rand, GamePanel.salmonAnimalToken);
        } else if(rand == 4){
            a = new AnimalToken(rand, GamePanel.hawkAnimalToken);
        } else {
            a = new AnimalToken(rand, GamePanel.foxAnimalToken);
        }
        availableHabitats.get(availableHabitats.getDashboard().size()- 1).setCorrespondingToken(a);
        //updating player turn
        p.setTurnsLeft(p.getTurnsLeft() - 1);
        turn++;
        if (turn == 3) {
            turn = 0;
        }
    }

    public void replaceFourSameTokens(){
        int num1 = -1;
        for(int i = 0; i < 4; i++){
            int num = (int)(Math.random() *(allTokens.size()));
            availableHabitats.replaceToken(i, allTokens.get(num));
        }
        if(checkFourSameToken()){
            replaceFourSameTokens();
        }
    }

    public boolean checkFourSameToken(){
        boolean same = true;
        int type = availableHabitats.get(0).getCorrespondingToken().getType();
        for(int i = 0; i < 4; i++){
            if(availableHabitats.get(i).getCorrespondingToken().getType() != type){
                same = false;
            }
        }
        return same;
    }

    public int checkThreeSameToken(){
        int same = -1;
        int j1 = 0;
        int type = availableHabitats.get(0).getCorrespondingToken().getType();
        int j2 = 0;
        int type2 = availableHabitats.get(1).getCorrespondingToken().getType();
        for(int i = 0; i < 4; i++){
            if(availableHabitats.get(i).getCorrespondingToken().getType() == type){
                j1++;
            }
            if(availableHabitats.get(i).getCorrespondingToken().getType() == type2){
                j2++;
            }
        }
        if(j1 == 3){
            same = type;
        }
        if(j2 == 3){
            same = type2;
        }
        return same;
    }

    public void replaceThreeSameTokens(int type){
        for(int i = 0; i < 4; i++){
            if(availableHabitats.get(i).getCorrespondingToken().getType() == type){
                int num = (int)(Math.random() *(allTokens.size()));
                availableHabitats.replaceToken(i, allTokens.get(num));
            }
        }

        int number = checkThreeSameToken();
        if(number != -1){
            replaceThreeSameTokens(number);
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

    public ArrayList<Integer> calculatePlacePointsForBiome(int biome){
        ArrayList<Integer> points = new ArrayList<>();
        //1 river, 2 wetland, 3 forest, 4 mountain, 5 prairie
        int player1Max = playerList.get(0).getPlayerBoard().calculateBiomes(biome);
        int player2Max = playerList.get(1).getPlayerBoard().calculateBiomes(biome);
        int player3Max = playerList.get(2).getPlayerBoard().calculateBiomes(biome);

        boolean p1p2tie = (player1Max == player2Max);
        boolean p1p3tie = (player1Max == player3Max);
        boolean p2p3tie = (player2Max == player3Max);
        boolean p1p2p3tie = (player1Max == player3Max) && (player2Max == player3Max);

        //3 way tie
        if(p1p2p3tie){
            points.add(1);
            points.add(1);
            points.add(1);
        }

        if(p1p2tie || p2p3tie || p1p3tie){
            if(p1p2tie){
                points.add(2);
                points.add(2);
                points.add(0);
            }
            else if(p1p3tie){
                points.add(2);
                points.add(0);
                points.add(2);
            }
            else if(p2p3tie){
                points.add(0);
                points.add(2);
                points.add(2);
            }
        }

        //one player has most
        if(player1Max > player2Max && player1Max > player3Max){
            points.add(3);
            if(p2p3tie){
                points.add(0);
                points.add(0);
            } else if (player2Max > player3Max){
                points.add(1);
                points.add(0);
            } else {
                points.add(0);
                points.add(1);
            }
        }

        if(player2Max > player1Max && player2Max > player3Max){
            if(p1p3tie){
                points.add(0);
                points.add(3);
                points.add(0);
            } else if (player1Max > player3Max){
                points.add(1);
                points.add(3);
                points.add(0);
            } else {
                points.add(0);
                points.add(3);
                points.add(1);
            }
        }

        if(player3Max > player2Max && player3Max > player1Max){
            if(p1p2tie){
                points.add(0);
                points.add(0);
            } else if (player1Max > player2Max){
                points.add(1);
                points.add(0);
            } else {
                points.add(0);
                points.add(1);
            }
            points.add(3);
        }
        return points;
    }

    public ArrayList<Integer> totalBiome(){
        ArrayList<Integer> points = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            Player p = playerList.get(i);
            int total = 0;
            for(int j = 1; j < 6; j++){
                total += p.getPlayerBoard().calculateBiomes(j);
                total += calculatePlacePointsForBiome(j).get(i);
            }
            points.add(total);
        }
        return points;
    }

    public ArrayList<Integer> totalAnimalTokens(){
        ArrayList<Integer> points = new ArrayList<>();

        for(int i = 0; i < 4; i++) {
            Player p = playerList.get(i);
            int total = 0;
            total += p.getPlayerBoard().calculateBear();
            total += p.getPlayerBoard().calculateFox();
            total += p.getPlayerBoard().calculateHawk();
            total += p.getPlayerBoard().calculateElk();
            total += p.getPlayerBoard().calculateSalmon();

            points.add(total);
        }
        return points;
    }

    public ArrayList<Integer> totalNatureTokens(){
        ArrayList<Integer> points = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            points.add(playerList.get(i).getPlayerBoard().getNatureTokens());
        }
        return points;
    }

    public ArrayList<Integer> getFinalScore(){
        ArrayList<Integer> points = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            int total = 0;
            total += totalNatureTokens().get(i);
            total += totalAnimalTokens().get(i);
            total += totalBiome().get(i);

            points.add(total);
        }
        return points;
    }

}
