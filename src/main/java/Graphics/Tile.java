package Graphics;
import java.awt.*;
import javax.swing.*;
import java.awt.Polygon

public class Tile {
    private Polygon hexgaon;
    private int r;
    private int c;

    public Tile(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public void instantiateHex(int x, int y){
        hexgaon = new Polygon();
        for(int i =0; i < 6; i++){
            hexgaon.addPoint((int) (x + 50 * Math.cos(i * 2 * Math.PI / 6)), (int)( y + 50 * Math.sin(i * 2 * Math.PI / 6)));
        }
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
