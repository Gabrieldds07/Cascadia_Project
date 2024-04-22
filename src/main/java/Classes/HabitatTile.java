package Classes;
import Classes.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.nio.Buffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.*;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.TreeMap;

public class HabitatTile {
    private ArrayList<AnimalToken> tokens = new ArrayList<>();
    private ArrayList<Biome> biomes = new ArrayList<>();
    private AnimalToken tokenPlaced;
    private AnimalToken correspondingToken;
    private Boolean clicked;
    private Boolean placed;
    private Boolean keyStone;
    private int animal1, animal2, animal3;
    private int side0, side1, side2, side3, side4, side5;
    private BufferedImage image;
    private ArrayList <BufferedImage> tiles = new ArrayList<BufferedImage>();
    private String tileNumber;
    private BufferedImage img;

    public HabitatTile(ArrayList<AnimalToken> t, ArrayList<Biome> b, boolean k, BufferedImage i) {
        tokens = t;
        biomes = b;
        tokenPlaced = null;
        correspondingToken = null;
        clicked = false;
        placed = false;
        keyStone = k;
        img = i;
    }

    public HabitatTile(String tileNumber, int type1, int type2, int animal1, int animal2, int animal3, BufferedImage image){
        //1 Bear, 2 Elk, 3 Salmon, 4 Hawk, 5 Fox
        //1 river, 2 wetland, 3 forest, 4 mountain, 5 prairie
        this.tileNumber=tileNumber;
        Biome b = new Biome(type1);
        for(int i =0; i < 3; i++){
            biomes.add(b);
        }
        b = new Biome(type2);
        for(int i =0; i < 3; i++){
            biomes.add(b);
        }
        AnimalToken a = new AnimalToken(animal1);
        tokens.add(a);
        a = new AnimalToken(animal2);
        tokens.add(a);
        a = new AnimalToken(animal3);
        tokens.add(a);
        this.image=image;
        keyStone=false;
    }
    public HabitatTile(String tileNumber, int type1, int type2, int animal1, int animal2, BufferedImage image){
        //1 Bear, 2 Elk, 3 Salmon, 4 Hawk, 5 Fox
        //1 river, 2 wetland, 3 forest, 4 mountain, 5 prairie
        this.tileNumber=tileNumber;
        Biome b = new Biome(type1);
        for(int i =0; i < 3; i++){
            biomes.add(b);
        }
        b = new Biome(type2);
        for(int i =0; i < 3; i++){
            biomes.add(b);
        }
        AnimalToken a = new AnimalToken(animal1);
        tokens.add(a);
        a = new AnimalToken(animal2);
        tokens.add(a);
        this.image=image;
        keyStone=false;
    }

    //Instantiates tiles that have 1 animal type and have a keystone
    public HabitatTile(String keyStoneTileNumber, int type1, int animal1, Boolean keyStone, BufferedImage image){
        //1 Bear, 2 Elk, 3 Salmon, 4 Hawk, 5 Fox
        //1 river, 2 wetland, 3 forest, 4 mountain, 5 prairie
        this.tileNumber=keyStoneTileNumber;
        Biome b = new Biome(type1);
        for(int i =0; i < 6; i++){
            biomes.add(b);
        }
        AnimalToken a = new AnimalToken(animal1);
        tokens.add(a);
        this.keyStone=keyStone;
        this.image=image;
    }
    //Instantiates starter tiles that have 2 animal types
    public HabitatTile(String habitatTileNumber, int type1, int type2, int animal1, int animal2, Boolean keyStone, BufferedImage image){
        //1 Bear, 2 Elk, 3 Salmon, 4 Hawk, 5 Fox
        //1 river, 2 wetland, 3 forest, 4 mountain, 5 prairie
        this.tileNumber=habitatTileNumber;
        //adds sides 0 and 1 for the 2nd starter tile habitat tile into the arraylist
        Biome b = new Biome(type1);
        for(int i =0; i < 2; i++){
            biomes.add(b);
        }
        //adds sides 2, 3 and 4 for the 2nd starter tile habitat tile into the arraylist
        b = new Biome(type2);
        for(int i =2; i <5 ; i++){
            biomes.add(b);
        }
        //adds side 4 for the 2nd starter tile habitat tile into the arraylist
        b = new Biome(type1);
        biomes.add(b);

        AnimalToken a = new AnimalToken(animal1);
        tokens.add(a);
        a = new AnimalToken(animal2);
        tokens.add(a);
        this.keyStone=keyStone;
        this.image=image;
    }
    //Instantiates starter tiles that have 3 animal types
    public HabitatTile(String habitatTileNumber, int type1, int type2, int animal1, int animal2, int animal3, Boolean keyStone, BufferedImage image){
        //1 Bear, 2 Elk, 3 Salmon, 4 Hawk, 5 Fox
        //1 river, 2 wetland, 3 forest, 4 mountain, 5 prairie
        this.tileNumber=habitatTileNumber;
        Biome b = new Biome(type2);
        biomes.add(b);
        b = new Biome(type1);
        for(int i =1; i < 4; i++) {
            biomes.add(b);
        }
        b = new Biome(type2);
        for(int i =4; i <6 ; i++){
            biomes.add(b);
        }
        AnimalToken a = new AnimalToken(animal1);
        tokens.add(a);
        a = new AnimalToken(animal2);
        tokens.add(a);
        a = new AnimalToken(animal3);
        tokens.add(a);
        this.keyStone=keyStone;
        this.image=image;
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
