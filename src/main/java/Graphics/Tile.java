package Graphics;
import java.awt.*;
import javax.swing.*;
import java.awt.Polygon;

public class Tile {
    private int r;
    private int c;

    public Tile(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getR(){return r;}

    public int getC(){return c;}
}
