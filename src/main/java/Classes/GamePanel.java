package Classes;

public class GamePanel {
    public void play() {
        resetMouseClickEvents();
        resetVisibleFlags();
        repaint();
        if (startGameButtonClicked) {
            gameStart = true;
            currentPlayer = firstPlayer;
            repaint();
        }
    }
}
