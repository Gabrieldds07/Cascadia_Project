package Classes;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

public class Game {
    private int turn;
    private ArrayList <Player> playerList;
    private  ArrayList <AnimalToken> allTokens;
    private  ArrayList <HabitatTile> allHabitats;
    private  HabitatDashBoard availableHabitats;
    private  Map<String, ArrayList<Card>> allCards;
    private  ArrayList <Card> scoringCards;

    public Game(int numOfPlayers){
        turn = 0;

        //player instantiation
        Player p;
        p = new Player(true);
        playerList.add(p);
        for(int i=1;i<numOfPlayers;i++){
            p = new Player(false);
            playerList.add(p);
        }

        //animal instantiation
        for(int i=1;i<=5;i++){
            //add images
            AnimalToken a = new AnimalToken(i, null);
            allTokens.add(a);
        }

        //card instantiation

        //scoring cards instantiation
        for(int i=1;i<5;i++){
            Random = new Random();
            scoringCards = ;
        }
    }

    public ArrayList<AnimalToken> getAllTokens() {
        return allTokens;
    }

    public ArrayList<Card> getScoringCards() {
        return scoringCards;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public ArrayList<HabitatTile> getAllHabitats() {
        return allHabitats;
    }

    public HabitatDashBoard getAvailableHabitats() {
        return availableHabitats;
    }
}
