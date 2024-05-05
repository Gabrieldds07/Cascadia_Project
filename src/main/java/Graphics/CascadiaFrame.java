package Graphics;

import java.awt.*;
import java.util.*;
import javax.swing.*;
public class CascadiaFrame extends JFrame{
	private static final int WIDTH = 1920;
	private static final int HEIGHT = 1080;
	
	private StartPanel start;
	private GamePanel mainGame;
	private EndPanel endGame;
	private int playerCount;
	
	public CascadiaFrame(String framename) {
		super(framename);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH,HEIGHT);
		start = new StartPanel(this);
		add(start);
		setVisible(true);
	}
	
	public void switchToGame() {
		setVisible(false);
		remove(start);
		playerCount = start.getNumPlayers();
		mainGame = new GamePanel(playerCount, this);
		add(mainGame);
		setVisible(true);
	}
	public void switchToEnd() {
		setVisible(false);
		remove(mainGame);
		endGame = new EndPanel(this);
		add(endGame);
		setVisible(true);
	}
	public void endToGame() {
		
	}
}