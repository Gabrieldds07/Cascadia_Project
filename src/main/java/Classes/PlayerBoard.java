package Classes;

import java.util.ArrayList;

public class PlayerBoard {
    private Hexagon[][] board;
    // use of odd or even array depends on hexagon row
    private int oddC[] = {0, 1, 1, 1, 0, -1};
    private int oddR[] = {-1, -1, 0, 1, 1, 0};
    private int evenC[] = {-1, 0, 1, 0, -1, -1};
    private int evenR[] = {-1, -1, 0, 1, 1, 0};
    private ArrayList<Integer> firstTileBiomeScoring = new ArrayList<>();
    private ArrayList<Integer> biomeScoring = new ArrayList<>();
    private int natureTokens = 0;
    private int max;

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

    //biome scoring

    public int calculateBiomes(int biomeType) {
        int max = 0;
        for (int r = 0; r < 42; r++) {
            for (int c = 0; c < 42; c++) {
                Hexagon h = board[r][c];
                if (!(h.getHabitatTile() == null)) {
                    if (h.getHabitatTile().getBiome1().getType()== biomeType){
                        if(!h.getHabitatTile().getBiome1().isScored()){
                            int size = 1 + getSize(r, c, 1, biomeType);
                            if (size > max) {
                                max = size;
                            }
                        }
                    }
                    if(h.getHabitatTile().getBiome2().getType()== biomeType){
                        if(!h.getHabitatTile().getBiome2().isScored()){
                            int size = 1 + getSize(r, c, 2 , biomeType);
                            if (size > max) {
                                max = size;
                            }
                        }
                    }
                }
            }
        }
        return max;
    }


    public int getSize(int r, int c, int biome, int type) {
        if(biome == 1){
            board[r][c].getHabitatTile().getBiome1().setScored(true);
        } else {
            board[r][c].getHabitatTile().getBiome2().setScored(true);
        }
        int cnt = 0;
        for (int i=0; i<6; i++) {
            int x = i+3;
            if (i==0) {
                x = 3;
            }
            if (i==1) {
                x = 4;
            }
            if (i==2) {
                x = 5;
            }
            if (i==3) {
                x = 0;
            }
            if (i==4) {
                x = 1;
            }
            if (i==5) {
                x = 2;
            }
            Hexagon hex = getAdjacentHexagon(r, c, i);
            if (hex != null) {
                if(hex.getHabitatTile() != null){
                    if(hex.getHabitatTile().getBiomes().get(x).getType() == type){
                        if(hex.getHabitatTile().getBiomes().get(x).getType() == board[r][c].getHabitatTile().getBiome1().getType()){
                            cnt += 1 + getSize(hex.getRow(), hex.getColumn(), 1, type);
                        } else if(hex.getHabitatTile().getBiomes().get(x).getType() == board[r][c].getHabitatTile().getBiome2().getType()){
                            cnt += 1 + getSize(hex.getRow(), hex.getColumn(), 2, type);
                        }
                    }
                }
            }
        }
        return cnt;
    }



    //animal scoring
    public int calculateElk(){
        int elkCnt = 0;
        //1 Bear, 2 Elk, 3 Salmon, 4 Hawk, 5 Fox
        for(int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (board[i][j].getHabitatTile() != null) {
                    if (board[i][j].getHabitatTile().getTokenPlaced().getType() == 2) {
                        if (board[i][j].getHabitatTile().getTokenPlaced().getScored() == false) {
                            elkCnt += elkHelper(i, j);
                        }
                    }
                }
            }
        }
        return elkCnt;
    }

    public int elkHelper (int r, int c){
        int s = 0;
        ArrayList<Hexagon> hexes = new ArrayList<>();
        board[r][c].getHabitatTile().getTokenPlaced().setScored(true);
        for(int i = 0; i <= 5; i++){
            Hexagon hex = getAdjacentHexagon(r, c, i);
            if(hex != null){
                if(hex.getHabitatTile() != null){
                    if(hex.getHabitatTile().getTokenPlaced().getType() == 2){
                        if(hex.getHabitatTile().getTokenPlaced().getScored() == false){
                            s = i;
                            hexes.add(hex);
                        }
                    }
                }
            }
        }
        if(hexes.isEmpty()){
            return 0;
        } else {
            int num = 0;
            for(Hexagon h : hexes){
                num += elkHelper(h.getRow(), h.getColumn());
            }
            return 1 + num;
        }
    }

    public int calculateSalmon(){
        int salmonCnt = 0;
        //1 Bear, 2 Elk, 3 Salmon, 4 Hawk, 5 Fox
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                if(board[i][j].getHabitatTile() != null){
                    if(board[i][j].getHabitatTile().getTokenPlaced().getType() == 3){
                        if(!board[i][j].getHabitatTile().getTokenPlaced().getScored()){
                            int adjacentSalmon = 0;
                            int s = 0; //side
                            ArrayList<Hexagon> hexes = new ArrayList<>();

                            for(int z = 0; z <= 5; z++){
                                Hexagon adjacentSalmonToken = getAdjacentHexagon(i, j, s);
                                if(adjacentSalmonToken != null && adjacentSalmonToken.getHabitatTile() != null){
                                    AnimalToken a = adjacentSalmonToken.getHabitatTile().getTokenPlaced();
                                    if(a.getType() == 3 && !a.getScored()){
                                        adjacentSalmon++;
                                        s = z;
                                        hexes.add(adjacentSalmonToken);
                                    }
                                }
                            }

                            if(hexes.isEmpty()){
                                salmonCnt += 2;
                                board[i][j].getHabitatTile().getTokenPlaced().setScored(true);
                            }
                            if(adjacentSalmon == 1){
                                boolean completeAdjacent = only2adjacent(i, j, s);
                                if(completeAdjacent){
                                    int size = getSizeOfSalmon(i, j) + 1;
                                    if (size < 3) {
                                        salmonCnt += 5;
                                    } else if (size < 4) {
                                        salmonCnt += 8;
                                    } else if (size < 5) {
                                        salmonCnt += 12;
                                    } else if (size < 6) {
                                        salmonCnt += 16;
                                    } else if (size < 7) {
                                        salmonCnt += 20;
                                    } else {
                                        salmonCnt += 25;
                                    }
                                }
                            }
                            if(adjacentSalmon == 2){
                                Hexagon salmon1 = hexes.get(0);
                                Hexagon salmon2 = hexes.get(1);

                                if(adjacentType(salmon1)<=2 && adjacentType(salmon2)<=2){
                                    board[i][j].getHabitatTile().getTokenPlaced().setScored(true);
                                    salmon1.getHabitatTile().getTokenPlaced().setScored(true);
                                    salmon2.getHabitatTile().getTokenPlaced().setScored(true);
                                }
                            }
                        }
                    }
                }
            }
        }
        return salmonCnt;
    }

    public int adjacentType(Hexagon h){
        int num = 0;
        HabitatTile habitat = h.getHabitatTile();
        if(habitat != null && habitat.getTokenPlaced() != null){
            ArrayList<Hexagon> adjacents = getAdjacentHexagons(h.getRow(), h.getColumn());
            for (Hexagon spot: adjacents) {
                HabitatTile h2 = spot.getHabitatTile();
                if (spot != null && h2 != null && h2.getTokenPlaced() != null) {
                    if( spot.getHabitatTile().getTokenPlaced().getType() == h.getHabitatTile().getTokenPlaced().getType()){
                        num++;
                    }
                }
            }
        }
        return num;
    }

    public boolean only2adjacent(int r, int c, int s1) {
        int s = 0; //side
        int b = 5; //blockedside
        if(s1 == 3){
            b = 0;
        }
        if(s1 == 4){
            b = 1;
        }

        ArrayList<Hexagon> hexes = new ArrayList<>();
        for(int i=0; i<= 5; i++){
            if (i != b) {
                Hexagon hex = getAdjacentHexagon(r, c, i);
                if (hex!=null && hex.getHabitatTile() != null) {
                    if(hex.getHabitatTile().getTokenPlaced().getType() == 3){
                        if(hex.getHabitatTile().getTokenPlaced().getScored() == false){
                            s = i;
                            hexes.add(hex);
                        }
                    }
                }
            }
        }
        int num = hexes.size();
        if(num == 1 || num == 0){
            if(num == 0){
                return true;
            }
            if(num == 1){
                Hexagon h = hexes.get(0);
                return only2adjacent(h.getRow(), h.getColumn(), s);
            }
        }
        return false;
    }

    public int getSizeOfSalmon(int r, int c){
        int s = 0;
        ArrayList<Hexagon> hexes = new ArrayList<>();
        board[r][c].getHabitatTile().getTokenPlaced().setScored(true);
        for(int i = 0; i < 6; i++){
            Hexagon hex = getAdjacentHexagon(r, c, i);
            if(hex != null){
                if(hex.getHabitatTile() != null){
                    if(hex.getHabitatTile().getTokenPlaced().getType() == 3){
                        if(hex.getHabitatTile().getTokenPlaced().getScored() == false){
                            s = i;
                            hexes.add(hex);
                        }
                    }
                }
            }
        }
        if(hexes.size() == 0 || hexes.isEmpty()){
            return 0;
        } else {
            Hexagon hex = hexes.get(0);
            return 1 + getSizeOfSalmon(hex.getRow(), hex.getColumn());
        }
    }

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

    public int calculateFox(){
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

}
