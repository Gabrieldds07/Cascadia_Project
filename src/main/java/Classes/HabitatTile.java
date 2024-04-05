package Classes;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
public class HabitatTile {
    ArrayList<AnimalToken> tokens;
    ArrayList<Biome> biomes;
    AnimalToken tokenPlaced;
    AnimalToken correspondingToken;
    Boolean clicked;
    Boolean placed;
    Boolean keyStone;
    BufferedImage img;

    public HabitatTile(ArrayList<AnimalToken> t, ArrayList<Biome>b, boolean k, BufferedImage i){
        tokens = t;
        biomes = b;
        tokenPlaced = null;
        correspondingToken = null;
        clicked = false;
        placed = false;
        keyStone = k;
        img = i;
    }

    public void rotateClockwise(){
        Biome temp = biomes.remove(biomes.size()-1);
        biomes.add(0, temp);
    }

    public void rotateCounterClockwise(){
        Biome temp = biomes.remove(0);
        biomes.add(biomes.size()-1, temp);
    }

    //set methods
    public void setPlaced(Boolean placed) {
        this.placed = placed;
    }

    public void setClicked(Boolean clicked) {
        this.clicked = clicked;
    }

    public void setTokenPlaced(AnimalToken tokenPlaced) {
        this.tokenPlaced = tokenPlaced;
    }

    public void setCorrespondingToken(AnimalToken correspondingToken) {
        this.correspondingToken = correspondingToken;
    }

    //get methods
    public ArrayList<Biome> getBiomes() {
        return biomes;
    }

    public ArrayList<AnimalToken> getTokens() {
        return tokens;
    }

    public Biome getNeighbourBiome(int side) {
        return biomes.get(side);
    }

    public Boolean getClicked() {
        return clicked;
    }

    public Boolean getKeyStone() {
        return keyStone;
    }

    public AnimalToken getTokenPlaced() {
        return tokenPlaced;
    }

    public Boolean getPlaced() {
        return placed;
    }

    public BufferedImage getImg() {
        return img;
    }

    public AnimalToken getCorrespondingToken() {
        return correspondingToken;
    }
}
