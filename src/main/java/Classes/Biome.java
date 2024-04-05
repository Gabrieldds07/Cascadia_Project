package Classes;

public class Biome {
    private final int type;
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
