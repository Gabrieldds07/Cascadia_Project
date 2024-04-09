package Classes;

import java.util.TreeMap;

public class Card {
    private TreeMap<Integer, Integer> scoring;

    public Card() {
        scoring = new TreeMap<>();
    }

    public TreeMap<Integer, Integer> getScoring() {
        return scoring;
    }

    public void scoreBearCards(){}

    public void scoreElkCards(){}

    public void scoreSalmonCards(){}

    public void scoreHawkCards(){}

    public void scoreFoxCards(){}
}
