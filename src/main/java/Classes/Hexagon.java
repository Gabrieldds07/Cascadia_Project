package Classes;

public class Hexagon {
    private HabitatTile habitatTile;
    private boolean gray;
    //empty or not
    private int r;
    private int c;

    public Hexagon(int row, int column){
        this.r = row;
        this.c = column;
        this.gray = true;
    }

    public Hexagon(HabitatTile habitatTile, int r, int c) {
        this.habitatTile = habitatTile;
        this.r = r;
        this.c = c;
        gray = false;
    }

    public int getRow() {
        return r;
    }

    public int getColumn() {
        return c;
    }

    public void setRandC(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public boolean getGray() {
        return gray;
    }

    public void setGray(boolean gray) {
        this.gray = gray;
    }

    public HabitatTile getHabitatTile() {
        return habitatTile;
    }

    public void setHabitatTile(HabitatTile habitatTile) {
        this.habitatTile = habitatTile;
    }
}
