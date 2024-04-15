package Classes;

public class StartingHabitatTile {
    private HabitatTile tile1;
    private HabitatTile tile2;
    private HabitatTile tile3;

    public StartingHabitatTile(HabitatTile tile1, HabitatTile tile2, HabitatTile tile3) {
        this.tile1 = tile1;
        this.tile2 = tile2;
        this.tile3 = tile3;
    }
    public HabitatTile getTile1() {return tile1;}
    public HabitatTile getTile2() {return tile2;}
    public HabitatTile getTile3() {return tile3;}
}
