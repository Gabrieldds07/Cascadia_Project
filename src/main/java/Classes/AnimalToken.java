package Classes;

import java.awt.image.BufferedImage;

public class AnimalToken {
    private int type;
    //1 Bear, 2 Elk, 3 Salmon, 4 Hawk, 5 Fox
    private boolean clicked;
    private boolean scored;
    private BufferedImage img;

    public AnimalToken(int type, BufferedImage img) {
        this.type = type;
        clicked = false;
        scored = false;
        this.img = img;
    }

    //get and set methods
    public int getType() {
        return type;
    }

    public boolean getScored(){
        return scored;
    }

    public BufferedImage getImg() {
        return img;
    }

    public boolean getClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public void setScored(boolean scored) {
        this.scored = scored;
    }
}
