package Classes;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
public class Player {
    private PlayerBoard playerBoard;
    private int turnsLeft;
    private boolean isTurn;

    public Player(boolean b){
        isTurn = b;
        playerBoard = new PlayerBoard();
    }

    public PlayerBoard getPlayerBoard() {
        return playerBoard;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }

    public void setTurnsLeft(int turnsLeft) {
        this.turnsLeft = turnsLeft;
    }

    public int getTurnsLeft() {
        return turnsLeft;
    }
}
