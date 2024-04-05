package Classes;

public class Biome {
    private final int type;
    //1 river, 2 wetland, 3 forest, 4 mountain, 5 prairie
    private boolean scored;

    public Biome(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public boolean isScored() {
        return scored;
    }

    public void setScored(boolean scored) {
        this.scored = scored;
    }
}
