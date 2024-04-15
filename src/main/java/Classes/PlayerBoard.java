package Classes;

import java.util.ArrayList;

public class PlayerBoard {
    private Hexagon[][] board;
    private int natureTokens;
    // use of odd or even array depends on hexagon row
    private int oddC[] = {0, 1, 1, 1, 0, -1};
    private int oddR[] = {-1, -1, 0, 1, 1, 0};
    private int evenC[] = {-1, 0, 1, 0, -1, -1};
    private int evenR[] = {-1, -1, 0, 1, 1, 0};
    private int natureTokens = 0;

    public PlayerBoard() {
        board = new Hexagon[20][20];
        Hexagon h;
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 20; j++) {
                h = new Hexagon(i, j);
            }
        }
    }

    public Hexagon[][] getBoard() {
        return board;
    }

    public boolean placeHabitatTile(int row, int column, HabitatTile habitat) {
        Hexagon h = board[row][column];
        //if empty
        if(h.getGray()){
            h.setHabitatTile(habitat);
            return true;
        }
        return false;
    }

    public boolean putAnimalToken(AnimalToken token, int row, int column){
        ArrayList<AnimalToken> tokens = board[row][column].getHabitatTile().getTokens();
        for(AnimalToken t : tokens){
            if(t.getType() == token.getType()){
                board[row][column].getHabitatTile().setTokenPlaced(token);
                if(board[row][column].getHabitatTile().getKeyStone()){
                    natureTokens++;
                }
                return true;
            }
        }
        return false;
    }

    public Hexagon getAdjacentHexagon(int side, int rC, int cC) {
        //checking if hexagon is at
        //top
        if(rC == 0){
            if(side == 0 || side == 1){ return null;}
        }
        //bottom
        if(rC == 19){
            if(side == 3 || side == 4){ return null;}
        }
        //left
        if(cC == 0){
            //odd
            if(0 != (rC % 2)){
                if(side == 5){ return null;}
            }
            //even
            if(0 == (rC % 2)){
                if(side == 0 || side == 4 || side == 5){ return null;}
            }
        }
        //right
        if(cC == 19){
            //even
            if(0 == (rC % 2)){
                if(side == 2){ return null;}
            }
            //odd
            if(0 != (rC % 2)){
                if(side == 1 || side == 2 || side == 3){ return null;}
            }
        }

        //odd
        if(0 != (rC % 2)){
            return board[rC + oddR[side]][cC + oddC[side]];
        } else {
            //even
            return board[rC + evenR[side]][cC + evenC[side]];
        }
    }

    public ArrayList<Hexagon> getAdjacentHexagons(int rC, int cC) {
        ArrayList<Hexagon> hexes = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            hexes.add(getAdjacentHexagon(i, rC, cC));
        }
        return hexes;
    }

    public int getNatureTokens() {
        return natureTokens;
    }

    public void setNatureTokens(int i) {
        natureTokens = i ;
    }

    public int scoreBiomes(){
        boolean firstTile = false;
        //1 river, 2 wetland, 3 forest, 4 mountain, 5 prairie
        int maxRiver = 0;
        int maxWetland = 0;
        int maxForest = 0;
        int maxMountain = 0;
        int maxPrairie = 0;
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                if(board[i][j].getHabitatTile() != null){
                    if(firstTile == false){
                        board[i][j].getHabitatTile().getBiomes().get(3); // call recursion, set biome = scored
                        board[i][j].getHabitatTile().getBiomes().get(1); // call recursion
                        board[i][j].getHabitatTile().getBiomes().get(2); // call recursion
                        firstTile = true;
                    } else {
                        if(j == 19){
                            firstTile = false;
                        }
                        board[i][j].getHabitatTile().getBiomes().get(1); // call recursion
                        board[i][j].getHabitatTile().getBiomes().get(2); // call recursion
                    }
                }
            }
        }
        return maxRiver + maxWetland + maxForest + maxMountain + maxPrairie;
    }

    public void biomeRecurssion(){

    }

    public int calculateElk(int rC, int cC){}

    public int calculateSalmon(int rC, int cC){}

    public int calculateHawk(){}

    public int calculateBear(){}

    public int calculateFox(){}

    //public int tokenLineOfSight(){}

    //public int getTokenPairs(){}

    //public int getTokenShape(){}
}
