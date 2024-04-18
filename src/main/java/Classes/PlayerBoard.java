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
    private ArrayList<Integer> firstTileBiomeScoring = new ArrayList<>();
    private ArrayList<Integer> biomeScoring = new ArrayList<>();
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
        boolean firstTile = true;
        //1 river, 2 wetland, 3 forest, 4 mountain, 5 prairie
        int maxRiver = 0;
        int maxWetland = 0;
        int maxForest = 0;
        int maxMountain = 0;
        int maxPrairie = 0;
        firstTileBiomeScoring.add(3);
        firstTileBiomeScoring.add(1);
        firstTileBiomeScoring.add(2);
        biomeScoring.add(1);
        biomeScoring.add(2);
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                if(board[i][j].getHabitatTile() != null){
                    if(firstTile == true){
                        int biomeCount =0;
                        for(int z = 1; z < 4; z++){
                            biomeCount = biomeRecurssion(i, j, firstTile);
                            if(biomeCount > maxRiver){
                                maxRiver = biomeCount;
                            }
                        }
                        firstTile = false;
                    } else {
                        for(int z = 0; z < 2; z++){
                            biomeRecurssion(i, j, firstTile);
                        }
                        if(j == 19){
                            firstTile = true;
                        }
                    }
                }
            }
        }
        return maxRiver + maxWetland + maxForest + maxMountain + maxPrairie;
    }

    public int biomeRecurssion(int i, int j, boolean firstTile){
        if(firstTile){
            if() {// call recursion
            }
        } else {
            board[i][j].getHabitatTile().getBiomes().get(1); // call recursion
            board[i][j].getHabitatTile().getBiomes().get(2); // call recursion
        }
    }

    public int calculateElk(int rC, int cC){}

    public int calculateSalmon(int rC, int cC){}

    public int hawkHelper(int rC, int cC){
        ArrayList<Hexagon> hexes = getAdjacentHexagons(rC, cC);

        for(Hexagon h : hexes){
            if(h.getHabitatTile() != null){
                if(h.getHabitatTile().getTokenPlaced().getType() == 4){
                    return 0;
                }
            }
        }
        return 1;
    }

    public int calculateHawk(){
        int hawkCnt = 0;
        for(int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if(board[i][j].getHabitatTile() != null){
                    if(board[i][j].getHabitatTile().getTokenPlaced().getType() == 4){
                        hawkCnt += hawkHelper(i, j);
                    }
                }
            }
        }
        if(hawkCnt == 0){
            return 0;
        } else if(hawkCnt == 1){
            return 2;
        } else if(hawkCnt == 2){
            return 5;
        } else if(hawkCnt == 3){
            return 8;
        } else if(hawkCnt == 4){
            return 11;
        } else if(hawkCnt == 5){
            return 14;
        } else if(hawkCnt == 6){
            return 18;
        } else if(hawkCnt == 7){
            return 22;
        } else{
            return 28;
        }
    }

    public int calculateBear(){
        int pairs = 0;
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                Hexagon h = board[i][j];
                if(h.getHabitatTile() != null && h.getHabitatTile().getTokenPlaced().getType() == 1 && !h.getHabitatTile().getTokenPlaced().getScored()){
                    boolean pair = bearPair(i, j);
                    if(pair){
                        board[i][j].getHabitatTile().getTokenPlaced().setScored(true);
                        pairs++;
                    }
                }
            }
        }
        if(pairs < 1) {
            return 0;
        } else if (pairs < 2) {
            return 4;
        } else if (pairs < 3) {
            return 11;
        } else if (pairs < 4) {
            return 19;
        } else {
            return 27;
        }
    }

    public boolean bearPair(int rC, int cC){
        ArrayList<Hexagon> hexes = getAdjacentHexagons(rC, cC);
        int numOfAdjacentBears = 0;
        ArrayList<Hexagon> match = new ArrayList<>();
        for(Hexagon h : hexes){
            if(h.getHabitatTile() != null){
                if(h.getHabitatTile().getTokenPlaced().getType() == 1){
                    if(!h.getHabitatTile().getTokenPlaced().getScored()){
                        numOfAdjacentBears++;
                        match.add(h);
                    }
                }
            }
            if(numOfAdjacentBears == 0){
                Hexagon hex = match.get(0);
                ArrayList<Hexagon> match2 = getAdjacentHexagons(hex.getRow(), hex.getColumn());
                int numAdjacentBearstoMatchingBear = 0;
                for(Hexagon h2 : match2){
                    if(h2.getHabitatTile() != null){
                        if(h2.getHabitatTile().getTokenPlaced().getType() == 1){
                            numAdjacentBearstoMatchingBear++;
                        }
                    }
                }
                if(numAdjacentBearstoMatchingBear == 1){
                    return true;
                }
            }
        }
        return false;
    }

    public int calculateFox(int rC, int cC){
        int FoxCnt = 0;
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                if(board[i][j].getHabitatTile() != null && board[i][j].getHabitatTile().getTokenPlaced().getType() == 5){
                    FoxCnt = surroundingFox(i, j);
                }
            }
        }
        return FoxCnt;
    }

    public int surroundingFox(int rC, int cC){
        ArrayList<Hexagon> hexes = getAdjacentHexagons(rC, cC);

        boolean elk = false;
        boolean salmon = false;
        boolean hawk = false;
        boolean bear = false;
        boolean fox = false;
        //1 Bear, 2 Elk, 3 Salmon, 4 Hawk, 5 Fox
        for(Hexagon h : hexes){
            if(h.getHabitatTile() != null){
                if(h.getHabitatTile().getTokenPlaced().getType() == 1){
                    bear = true;
                }
                if(h.getHabitatTile().getTokenPlaced().getType() == 2){
                    elk = true;
                }
                if(h.getHabitatTile().getTokenPlaced().getType() == 3){
                    salmon = true;
                }
                if(h.getHabitatTile().getTokenPlaced().getType() == 4){
                    hawk = true;
                }
                if(h.getHabitatTile().getTokenPlaced().getType() == 5){
                    fox = true;
                    h.getHabitatTile().getTokenPlaced().setScored(true);
                }
            }
        }
        int num = 0;
        if(bear){
            num += 1;
        }
        if(fox){
            num += 1;
        }
        if(hawk){
            num += 1;
        }
        if(elk){
            num += 1;
        }
        if(salmon){
            num += 1;
        }
        return num;
    }
    //public int tokenLineOfSight(){}

    //public int getTokenPairs(){}

    //public int getTokenShape(){}
}
