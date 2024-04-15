package Classes;

import java.util.ArrayList;

public class HabitatDashBoard {
    private ArrayList<HabitatTile> dashboard;

    public HabitatDashBoard(ArrayList<HabitatTile> dashboard) {
        this.dashboard = dashboard;
    }

    public void usedNatureToken(int HabitatTile1, int HabitatTile2){
        AnimalToken temp = dashboard.get(HabitatTile1).getCorrespondingToken();
        dashboard.get(HabitatTile1).setCorrespondingToken(dashboard.get(HabitatTile2).getCorrespondingToken());
        dashboard.get(HabitatTile2).setCorrespondingToken(temp);
    }

    public HabitatTile getDashboard(int HabitatTile){
        return dashboard.get(HabitatTile);
    }

    public void addHabitat(HabitatTile h){
        dashboard.add(h);
    }

    public void removeHabitat(HabitatTile h){
        dashboard.remove(h);
    }

    public void replaceHabitat(int index, HabitatTile h){
        dashboard.set(index, h);
    }

    public void replaceFourSameTokens(){

    }

    public void generateThreeSameTokens(){

    }

    public void replaceThreeSameTokens(){

    }

    public ArrayList<HabitatTile> getDashboard() {
        return dashboard;
    }
}
