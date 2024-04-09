package Classes;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.TreeMap;

public class Game {
    private int turn;
    private ArrayList <Player> playerList = new ArrayList();;
    private  ArrayList <AnimalToken> allTokens = new ArrayList();;
    private  ArrayList <HabitatTile> allHabitats = new ArrayList();;
    private  HabitatDashBoard availableHabitats;;
    //private  Map<String, ArrayList<ScoringCard>> allCards;
    private  ArrayList <ScoringCard> scoringCards = new ArrayList();;

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

        //habitat instantiation

        //starting habitat

        //available habitat instantiation
        for(int i=1;i<=5;i++){
            int num = (int)(Math.random() *(allHabitats.size()));
            availableHabitats.addHabitat(allHabitats.get(num));
        }

        //card instantiation
        //1 bear, 2 elk, 3 salmon, 4 hawk, 5 fox
        TreeMap<Integer, Integer> s = new TreeMap<>();

        //bear
        s.put(1,4);
        s.put(2,11);
        s.put(3,15);
        s.put(4,27);
        scoringCards.add(new ScoringCard(1, s));

        //elk


        //scoring cards instantiation
        /*
        String s = "Bear";
        int num = (int)(Math.random() *(allCards.get(s).size()));
        scoringCards.add(allCards.get(s, num));

        s = "Fox";
        num = (int)(Math.random() *(allCards.get(s).size()));
        scoringCards.add(allCards.get(s, num));

        s = "Salmon";
        num = (int)(Math.random() *(allCards.get(s).size()));
        scoringCards.add(allCards.get(s, num));

        s = "Hawk";
        num = (int)(Math.random() *(allCards.get(s).size()));
        scoringCards.add(allCards.get(s, num));

        s = "Elk";
        num = (int)(Math.random() *(allCards.get(s).size()));
        scoringCards.add(allCards.get(s, num));
        */
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
