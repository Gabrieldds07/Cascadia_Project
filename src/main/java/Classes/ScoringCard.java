package Classes;

import java.util.TreeMap;

public class ScoringCard {
    private int type;
    //1 bear, 2 elk, 3 salmon, 4 hawk, 5 fox
    private TreeMap<Integer, Integer> scoring;

    public ScoringCard(int t, TreeMap<Integer, Integer> s) {
        type = t;
        scoring = s;
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
