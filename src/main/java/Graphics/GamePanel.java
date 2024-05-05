package Graphics;
import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;
import Classes.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Objects;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GamePanel extends JPanel implements MouseListener{
	private BufferedImage background, ntButtons, scoreCards, test, discard;
	private CascadiaFrame frame;
	private boolean canUseToken;
	private Game game;
	private int turn;
	private boolean rotateRight;
	public static BufferedImage Tile1, Tile2, Tile3, Tile4, Tile5, Tile6, Tile7, Tile8, Tile9, Tile10, Tile11, Tile12, Tile13, Tile14, Tile15, Tile16, Tile17, Tile18, Tile19, Tile20, Tile21, Tile22, Tile23, Tile24, Tile25, Tile26, Tile27, Tile28, Tile29, Tile30, Tile31, Tile32, Tile33, Tile34, Tile35, Tile36, Tile37, Tile38, Tile39, Tile40, Tile41, Tile42, Tile43, Tile44, Tile45, Tile46, Tile47, Tile48, Tile49, Tile50, Tile51, Tile52, Tile53, Tile54, Tile55, Tile56;
	public static BufferedImage keyStoneTile1, keyStoneTile2, keyStoneTile3, keyStoneTile4, keyStoneTile5, keyStoneTile6, keyStoneTile7, keyStoneTile8, keyStoneTile9, keyStoneTile10, keyStoneTile11, keyStoneTile12, keyStoneTile13, keyStoneTile14, keyStoneTile15, keyStoneTile16, keyStoneTile17, keyStoneTile18, keyStoneTile19, keyStoneTile20, keyStoneTile21, keyStoneTile22, keyStoneTile23, keyStoneTile24, keyStoneTile25;
	public static BufferedImage starterTile1, starterTile2, starterTile3, starterTile4, starterTile5;
	public static BufferedImage elkScoringCard, foxScoringCard, salmonScoringCard, bearScoringCard, hawkScoringCard;
	public static BufferedImage elkAnimalToken, foxAnimalToken, salmonAnimalToken, bearAnimalToken, hawkAnimalToken;
	public static BufferedImage st1IndividualTop, st1IndividualRight, st1IndividualLeft, st2IndividualTop, st2IndividualRight, st2IndividualLeft, st3IndividualTop, st3IndividualRight, st3IndividualLeft, st4IndividualTop, st4IndividualRight, st4IndividualLeft, st5IndividualTop, st5IndividualRight, st5IndividualLeft;
	public static BufferedImage close, scoringCardsBackground;
	private boolean scoringCardsPressed = false;
	private boolean topPlayerPressed = false;
	private boolean bottomPlayerPressed = false;
	// 0 = game instantiation, 1 = pick habitat Tile & animal token, place habitat, 2 = place animalToken
	private int gameState = 0;
	//0 = pick habitat Tile & animal token, 1=  place habitat
	private int gameState2 = 0;
	// num is the habitatTile + animal token selected
	private int habitatNum = -1;
	private Hexagon[][] tempboard;
	private int rowTemp;
	private int colTemp;
	private int num = 0;

	//board vars
	private int left = 6;
	private int right = 14;
	private int top = 6;
	private int bottom = 14;

	public GamePanel(int playerCount, CascadiaFrame frame) {
		try {
			close = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Screens/close.png")));
			background = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Screens/GameBoard.png")));
			ntButtons = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Screens/buttons.png")));
			scoringCardsBackground = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Screens/Scoring Cards Background.png")));
			discard = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Screens/Discard.png")));

			Tile1 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 1.png")));
			Tile2 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 2.png")));
			Tile3 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 3.png")));
			Tile4 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 4.png")));
			Tile5 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 5.png")));
			Tile6 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 6.png")));
			Tile7 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 7.png")));
			Tile8 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 8.png")));
			Tile9 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 9.png")));
			Tile10 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 10.png")));
			Tile11 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 11.png")));
			Tile12 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 12.png")));
			Tile13 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 13.png")));
			Tile14 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 14.png")));
			Tile15 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 15.png")));
			Tile16 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 16.png")));
			Tile17 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 17.png")));
			Tile18 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 18.png")));
			Tile19 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 19.png")));
			Tile20 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 20.png")));
			Tile21 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 21.png")));
			Tile22 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 22.png")));
			Tile23 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 23.png")));
			Tile24 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 24.png")));
			Tile25 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 25.png")));
			Tile26 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 26.png")));
			Tile27 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 27.png")));
			Tile28 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 28.png")));
			Tile29 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 29.png")));
			Tile30 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 30.png")));
			Tile31 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 31.png")));
			Tile32 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 32.png")));
			Tile33 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 33.png")));
			Tile34 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 34.png")));
			Tile35 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 35.png")));
			Tile36 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 36.png")));
			Tile37 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 37.png")));
			Tile38 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 38.png")));
			Tile39 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 39.png")));
			Tile40 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 40.png")));
			Tile41 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 41.png")));
			Tile42 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 42.png")));
			Tile43 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 43.png")));
			Tile44 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 44.png")));
			Tile45 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 45.png")));
			Tile46 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 46.png")));
			Tile47 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 47.png")));
			Tile48 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 48.png")));
			Tile49 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 49.png")));
			Tile50 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 50.png")));
			Tile51 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 51.png")));
			Tile52 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 52.png")));
			Tile53 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 53.png")));
			Tile54 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 54.png")));
			Tile55 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 55.png")));
			Tile56 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Tile 56.png")));

			keyStoneTile1 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Keystone Tile 1.png")));
			keyStoneTile2 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Keystone Tile 2.png")));
			keyStoneTile3 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Keystone Tile 3.png")));
			keyStoneTile4 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/KeyStone Tile 4.png")));
			keyStoneTile5 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/KeyStone Tile 5.png")));
			keyStoneTile6 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/KeyStone Tile 6.png")));
			keyStoneTile7 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/KeyStone Tile 7.png")));
			keyStoneTile8 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/KeyStone Tile 8.png")));
			keyStoneTile9 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/KeyStone Tile 9.png")));
			keyStoneTile10 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/KeyStone Tile 10.png")));
			keyStoneTile11 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/KeyStone Tile 11.png")));
			keyStoneTile12 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/KeyStone Tile 12.png")));
			keyStoneTile13 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/KeyStone Tile 13.png")));
			keyStoneTile14 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/KeyStone Tile 14.png")));
			keyStoneTile15 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/KeyStone Tile 15.png")));
			keyStoneTile16 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/KeyStone Tile 16.png")));
			keyStoneTile17 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/KeyStone Tile 17.png")));
			keyStoneTile18 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/KeyStone Tile 18.png")));
			keyStoneTile19 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/KeyStone Tile 19.png")));
			keyStoneTile20 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/KeyStone Tile 20.png")));
			keyStoneTile21 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/KeyStone Tile 21.png")));
			keyStoneTile22 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/KeyStone Tile 22.png")));
			keyStoneTile23 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/KeyStone Tile 23.png")));
			keyStoneTile24 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/KeyStone Tile 24.png")));
			keyStoneTile25 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/KeyStone Tile 25.png")));

			starterTile1 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Starter Tile 1.png")));
			starterTile2 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Starter Tile 2.png")));
			starterTile3 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Starter Tile 3.png")));
			starterTile4 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Starter Tile 4.png")));
			starterTile5 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/Starter Tile 5.png")));

			elkScoringCard = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Scoring Cards/elk-large.jpg")));
			salmonScoringCard = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Scoring Cards/salmon-large.jpg")));
			foxScoringCard = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Scoring Cards/fox-large.jpg")));
			hawkScoringCard = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Scoring Cards/hawk-large.jpg")));
			bearScoringCard = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Scoring Cards/bear-large.jpg")));

			elkAnimalToken = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Animal Tokens/elk.png")));
			salmonAnimalToken = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Animal Tokens/salmon.png")));
			foxAnimalToken = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Animal Tokens/fox.png")));
			hawkAnimalToken = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Animal Tokens/hawk.png")));
			bearAnimalToken = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Animal Tokens/bear.png")));

			st1IndividualTop = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/ST Tiles Individual/ST 1 Individual Top.png")));
			st1IndividualRight = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/ST Tiles Individual/ST 1 Individual Right.png")));
			st1IndividualLeft = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/ST Tiles Individual/ST 1 Individual Left.png")));
			st2IndividualTop = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/ST Tiles Individual/ST 2 Individual Top.png")));
			st2IndividualRight = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/ST Tiles Individual/ST 2 Individual Left.png")));
			st2IndividualLeft = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/ST Tiles Individual/ST 2 Individual Right.png")));
			st3IndividualTop = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/ST Tiles Individual/ST 3 Individual Top.png")));
			st3IndividualRight = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/ST Tiles Individual/ST 3 Individual Right.png")));
			st3IndividualLeft = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/ST Tiles Individual/ST 3 Individual Left.png")));
			st4IndividualTop = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/ST Tiles Individual/ST 4 Individual Top.png")));
			st4IndividualRight = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/ST Tiles Individual/ST 4 Individual Right.png")));
			st4IndividualLeft = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/ST Tiles Individual/ST 4 Individual Left.png")));
			st5IndividualTop = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/ST Tiles Individual/ST 5 Individual Top.png")));
			st5IndividualRight = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/ST Tiles Individual/ST 5 Individual Right.png")));
			st5IndividualLeft = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/ST Tiles Individual/ST 5 Individual Left.png")));

		} catch (Exception e) {
			System.out.println(e.getMessage() + " panel error ");
			return;
		}
		addMouseListener(this);
		this.frame = frame;

		game = new Game(3);
		gameState = 1;
	}

	public void paint(Graphics g) {
		drawBackground(g);
		if(canUseToken) {
			drawNatureTokenMenu(g);
		}
		if(gameState != 0){
			if(gameState == 1){
				if(gameState2 == 0){
					drawPlayerBoard(g, game.getPlayerList().get(turn).getPlayerBoard().getBoard());
				}
				if(gameState2 == 1){
					drawPlayerBoard(g, tempboard);
				}
			}
			if(gameState == 2){
				if(gameState2 == 0){
					drawPlayerBoard(g, tempboard);
				}
			}
			drawPlayerInfo(g);
			drawHabitatDashboard(g);
			drawPrompt(g);
			drawAnimalTokenCount(g);
			drawTopPlayerBoard(g);
			drawBottomPlayerBoard(g);
		}
		if(rotateRight) {
			rotateImage(g, game.getAvailableHabitats().getDashboard().get(habitatNum).getImg(), 800, 460, 100, 116, 180);
			rotateRight = false;
		}
		if(scoringCardsPressed){
			drawScoringCards(g);
		}
	}

	public void drawScoringCards(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawImage(scoringCardsBackground, 100, 100, 1720, 880, null);
		g.drawImage(close, 1760, 100,60,60, null);
		g.drawImage(elkScoringCard, 180, 180, 350, 350, null);
		g.drawImage(foxScoringCard, 480, 580, 350, 350, null);
		g.drawImage(hawkScoringCard, 780, 180, 350, 350, null);
		g.drawImage(bearScoringCard, 1080, 580, 350, 350, null);
		g.drawImage(salmonScoringCard, 1380, 180, 350, 350, null);
	}
	public void drawTopPlayerBoard(Graphics g){
		int temp = 0;
		if(turn == 0){
			g.drawString("Player 2 board", 1350,50);
			temp = 1;
		}
		if(turn == 1 || turn == 2){
			g.drawString("Player 1 board", 1350,50);
		}
		drawSmallBoard(g, game.getPlayerList().get(temp).getPlayerBoard().getBoard(), 1370, 70);
//		g.drawImage(scoringCardsBackground, 100, 100, 1720, 880, null);
//		drawPlayerBoard(g, game.getPlayerList().get(temp).getPlayerBoard().getBoard());
	}
	public void drawBottomPlayerBoard(Graphics g){
		int temp = 1;
		if(turn == 0 || turn == 1){
			g.drawString("Player 3 board", 1350,400);
			temp = 2;
		}
		if(turn == 2){
			g.drawString("Player 2 board", 1350,400);
		}
		drawSmallBoard(g, game.getPlayerList().get(temp).getPlayerBoard().getBoard(), 1320, 420);

	}

	public void drawAnimalTokenCount(Graphics g){
		g.setFont(new Font("DialogInput", Font.PLAIN, 20));
		ArrayList<Integer> a = game.getTokenCount();
		//1 Bear, 2 Elk, 3 Salmon, 4 Hawk, 5 Fox
		g.drawString(a.get(4).toString(), 35, 100);
		g.drawString(a.get(1).toString(), 95, 100);
		g.drawString(a.get(0).toString(), 155, 100);
		g.drawString(a.get(3).toString(), 215, 100);
		g.drawString(a.get(2).toString(), 275, 100);
	}

	public void drawSmallBoard(Graphics g, Hexagon[][] b , int startX, int startY){
		boolean even;
		int x = 0;
		int y = 0;
		for(int r = top; r < bottom; r++){
			even = (y % 2 == 0);
			for(int c = left; c < right; c++){
				if(b[r][c].getHabitatTile() != null) {
					if(notStarterTileLeftorRight(b[r][c].getHabitatTile())) {
						if (even) {
							g.drawImage(b[r][c].getHabitatTile().getImg(), startX + 30 * x, startY + 30 * y, 40, 40, null);
//							if(b[r][c].getHabitatTile().getTokenPlaced() != null){
//								g.drawImage(b[r][c].getHabitatTile().getTokenPlaced().getImg(), 430 + 100 * x, 176 + 83 * y, 5, 5, null);
//							}
						}
						if (!even) {
							g.drawImage(b[r][c].getHabitatTile().getImg(), startX + 10 + 30 * x, startY + 30 * y, 40, 40, null);
//							if(b[r][c].getHabitatTile().getTokenPlaced() != null){
//								g.drawImage(b[r][c].getHabitatTile().getTokenPlaced().getImg(), 480 + 100 * x, 176 + 83 * y, 5, 5, null);
//							}
						}
					} else {
						if (even) {
							g.drawImage(b[r][c].getHabitatTile().getImg(), startX - 3 + 30 * x, startY + 30 * y, 43, 43, null);
//							if(b[r][c].getHabitatTile().getTokenPlaced() != null){
//								g.drawImage(b[r][c].getHabitatTile().getTokenPlaced().getImg(), 413 + 99 * x, 166 + 83 * y, 5, 5, null);
//							}
						}
						if (!even) {
							g.drawImage(b[r][c].getHabitatTile().getImg(), startX - 3  + 10 + 30 * x, startY + 30 * y, 43, 43, null);
//							if(b[r][c].getHabitatTile().getTokenPlaced() != null){
//								g.drawImage(b[r][c].getHabitatTile().getTokenPlaced().getImg(), 365 + 99 * x, 166 + 83 * y, 5, 5, null);
//							}
						}
					}
				}
				x++;
				if(x == 8){
					x = 0;
				}
			}
			y++;
		}
	}

	public void drawPlayerBoard(Graphics g, Hexagon[][] b ){
		boolean even;
		int x = 0;
		int y = 0;
		for(int r = top; r < bottom; r++){
			even = (y % 2 == 0);
			for(int c = left; c < right; c++){
				if(b[r][c].getHabitatTile() != null) {
					if(notStarterTileLeftorRight(b[r][c].getHabitatTile())) {
						if (even) {
							g.drawImage(b[r][c].getHabitatTile().getImg(), 430 + 100 * x, 175 + 84 * y, 100, 110, null);
							if(b[r][c].getHabitatTile().getTokenPlaced() != null){
								g.drawImage(b[r][c].getHabitatTile().getTokenPlaced().getImg(), 463 + 100 * x, 200 + 83 * y, 50, 50, null);
							}
						}
						if (!even) {
							g.drawImage(b[r][c].getHabitatTile().getImg(), 480 + 100 * x, 175 + 84 * y, 100, 110, null);
							if(b[r][c].getHabitatTile().getTokenPlaced() != null){
								g.drawImage(b[r][c].getHabitatTile().getTokenPlaced().getImg(), 415 + 100 * x, 200 + 83 * y, 50, 50, null);
							}
						}
					} else {
						if (even) {
							g.drawImage(b[r][c].getHabitatTile().getImg(), 413 + 99 * x, 166 + 83 * y, 140, 140, null);
							if(b[r][c].getHabitatTile().getTokenPlaced() != null){ //480
								g.drawImage(b[r][c].getHabitatTile().getTokenPlaced().getImg(), 463 + 99 * x, 190 + 83 * y, 50, 50, null);
							}
						}
						if (!even) {
							g.drawImage(b[r][c].getHabitatTile().getImg(), 365 + 99 * x, 166 + 83 * y, 140, 140, null);
							if(b[r][c].getHabitatTile().getTokenPlaced() != null){ //530
								g.drawImage(b[r][c].getHabitatTile().getTokenPlaced().getImg(), 415 + 99 * x, 190 + 83 * y, 50, 50, null);
							}
						}
					}
				}
				x++;
				if(x == 8){
					x = 0;
				}
			}
			y++;
		}
	}

	public boolean notStarterTileLeftorRight (HabitatTile h){
		BufferedImage img = h.getImg();
		if(img == st1IndividualRight){
			return false;
		}
		if(img == st1IndividualLeft){
			return false;
		}
		if(img == st2IndividualLeft){
			return false;
		}
		if(img == st2IndividualRight){
			return false;
		}
		if(img == st3IndividualLeft){
			return false;
		}
        return img != st3IndividualRight;
    }

	public void drawPrompt(Graphics g){
		g.setFont(new Font("DialogInput", Font.PLAIN, 20));
		if(gameState == 1){
			if(gameState2 == 0){
				g.drawString("Player " + (turn + 1) + " pick a habitat tile and wildlife token", 500, 100);
			}
			if(gameState2 == 1){
				g.drawString("Player " + (turn + 1) + " place habitat tile ", 500, 100);
			}
		}
		if(gameState == 2){
			g.drawString("Player " + (turn + 1) + " place wildlife token", 500, 100);
		}
	}

	public void drawBackground(Graphics g) {
		g.drawImage(background, 0, 0, 1920, 1080, null);
		g.drawImage(ntButtons, 35, 840, 281, 101, null);
		g.drawImage(discard, 35, 946, 281, 48, null);
		g.drawImage(foxAnimalToken, 27, 38, 45, 45, null);
		g.drawImage(elkAnimalToken, 90, 38, 45, 45, null);
		g.drawImage(bearAnimalToken, 153, 38, 45, 45, null);
		g.drawImage(hawkAnimalToken, 216, 38, 45, 45, null);
		g.drawImage(salmonAnimalToken, 279, 38, 45, 45, null);
	}

	public void drawNatureTokenMenu(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(100,100,1720,880);
	}

	public void drawPlayerInfo(Graphics g) {
		g.setFont(new Font("DialogInput", Font.PLAIN, 20));
		g.drawString("Player " + (turn + 1) + "            Turns Left: " + game.getPlayerList().get(turn).getTurnsLeft() + "            Nature Tokens: " + game.getPlayerList().get(turn).getPlayerBoard().getNatureTokens(), 423,35);
		/*g.drawString("Turns Left: " + game.getPlayerList().get(turn).getTurnsLeft(), 50,95);
		g.drawString("Nature Tokens: " + game.getPlayerList().get(turn).getPlayerBoard().getNatureTokens(), 50,125);*/
	}

	public void drawHabitatDashboard(Graphics g){
		for(int i = 0; i < 4; i++){
			HabitatTile h = game.getAvailableHabitats().get(i);
			AnimalToken a = h.getCorrespondingToken();
			if(h.getClicked()){
				g.drawRect(80, 190 + i * 175, 250, 95);
			}
			g.drawImage(h.getImg(), 250, 200 + i * 175, 75, 75, null);
			g.drawImage(a.getImg(), 90, 200 + i * 175, 75, 75, null);
		}
	}

	//mouse methods w gamestate
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println(x +", "+ y);
		System.out.println(gameState);
		System.out.println(gameState2);

		//arrows
		//up
		if(x>= 430 && x<=460 && y>=900 && y <= 945) {
			if(bottom < 19){
				bottom += 2;
			}
			if(top < 11){
				top += 2;
			}
			repaint();
		}
		//down
		if(x>= 430 && x<=460 && y>=970 && y <= 1015) {
			if(bottom > 8){
				bottom -= 2;
			}
			if(top > 0){
				top -= 2;
			}
			repaint();
		}
		//left
		if(x>= 460 && x<=505 && y>=945 && y <= 975) {
			if(right < 19){
				right -=1;
			}
			if(left < 11){
				left -=1;
			}
			repaint();
		}
		//right
		if(x>= 385 && x<=430 && y>=945 && y <= 975) {
			if(right > 8){
				right += 1;
			}
			if(left > 0){
				left += 1;
			}
			repaint();
		}

		//view scoring cards
		if (x >= 1400 && x <= 1805 && y >= 690 && y <= 720) {
			scoringCardsPressed = true;
			repaint();
		}
		if (x >= 1760 && x <= 1820 && y >= 100 && y <= 160 && scoringCardsPressed) {
			scoringCardsPressed = false;
			repaint();
		}

		//viewing other player boards
		if (x >= 1305 && x <= 1910 && y >= 15 && y <= 340) {
			topPlayerPressed=true;
			repaint();
		}
		if (x >= 1305 && x <= 1910 && y >= 355 && y <= 680) {
			bottomPlayerPressed=true;
			repaint();
		}

		if(gameState == 1) {
			tempboard = game.getPlayerList().get(turn).getPlayerBoard().getBoard().clone();
			//pick habitatTile and animalToken
			if((y > 198 && y < 272 && x > 90 && x < 164)|| (x > 251 && x < 325 && y < 270 && y > 198)){
				if(habitatNum != 0 && habitatNum != -1){
					game.getAvailableHabitats().get(habitatNum).setClicked(false);
				}
				habitatNum = 0;
				game.clickedHabitatTile(habitatNum);
				gameState2 = 1;
				repaint();
			}
			if((y > 374 && y < 446 && x > 90 && x < 164)|| (x > 251 && x < 325 && y < 444 && y > 378)){
				if(habitatNum != 1&& habitatNum != -1){
					game.getAvailableHabitats().get(habitatNum).setClicked(false);
				}
				habitatNum = 1;
				game.clickedHabitatTile(habitatNum);
				gameState2 = 1;
				repaint();
			}
			if((y > 550 && y < 622 && x > 90 && x < 164)|| (x > 251 && x < 325 && y < 614 && y > 550)){
				if(habitatNum != 2&& habitatNum != -1){
					game.getAvailableHabitats().get(habitatNum).setClicked(false);
				}
				habitatNum = 2;
				game.clickedHabitatTile(habitatNum);
				gameState2 = 1;
				repaint();
			}
			if((y > 725 && y < 795 && x > 90 && x < 164)|| (x > 251 && x < 325 && y < 788 && y > 725)){
				if(habitatNum != 3&& habitatNum != -1){
					game.getAvailableHabitats().get(habitatNum).setClicked(false);
				}
				habitatNum = 3;
				game.clickedHabitatTile(habitatNum);
				gameState2 = 1;
				repaint();
			}

			//picking habitat Tile and animal token
			if(gameState2 == 0){
				//use Nature Token
				if (x >= 33 && x <= 315 && y >= 840 && y <= 875 && canUseToken()) {
					canUseToken = true;
					repaint();
				}
				//replace same wildlife token
				if (x >= 33 && x <= 315 && y >= 894 && y <= 935) {
					if(game.checkThreeSameToken() != -1){
						game.replaceThreeSameTokens(game.checkThreeSameToken());
					}
					repaint();
				}
			}

			//placing on board
			if(gameState2 == 1){
				//rotate cw, ccw, place, cancel
				if (x >= 990 && x <= 1240 && y >= 925 && y <= 950) {
					rotateRight = false;
					repaint();
				}
				else if (x >= 720 && x <= 970 && y >= 925 && y <= 950) {
					rotateRight = true;
					repaint();
				}
				else if (x >= 720 && x <= 970 && y >= 965 && y <= 990) {
					polygonContains(true, x, y);
					repaint();
				}
				else if (x >= 990 && x <= 1240 && y >= 965 && y <= 990) {
					num = 0;
					repaint();
				}
				else if ((y > 175 && y < 866 && x > 394 && x < 1200)){
					if (num == 0) {
						tempboard = game.getPlayerList().get(turn).getPlayerBoard().getBoard().clone();
						polygonContains(false, x, y);
						repaint();
					}
				}
			}
		}
		if(gameState == 2) {
			//disgard token
			if (x >= 33 && x <= 315 && y >= 945 && y <= 985) {
				num = 0;
				game.getAvailableHabitats().get(habitatNum).setClicked(false);
				Player p = game.getPlayerList().get(turn);
				p.setTurnsLeft( p.getTurnsLeft()- 1);
				turn++;
				if(turn == 3){
					turn = 0;
				}
				num = 0;
				habitatNum = -1;
				gameState = 1;
				if(game.getPlayerList().get(2).getTurnsLeft() == 0){
					gameState = 3;
				}
				repaint();
			}

			if (x >= 720 && x <= 970 && y >= 965 && y <= 990) {
				polygonContains(true, x, y);
				repaint();
			} else if ((y > 175 && y < 866 && x > 394 && x < 1200)){
				if (num == 0) {
					tempboard = game.getPlayerList().get(turn).getPlayerBoard().getBoard().clone();
					polygonContains(false, x, y);
					repaint();
				}
			}
		}
		gameState = 3;
		if(gameState == 3){
			frame.switchToEnd(game);
		}
	}

	public int getRow(int x, int y){
		if(y > 175 && y < 260){
			return top;
		}
		if(y > 265 && y < 345){
			return top + 1;
		}
		if(y > 349 && y < 434){
			return top + 2;
		}
		if(y > 442 && y < 515){
			return top + 3;
		}
		if(y > 526 && y < 598){
			return top + 4;
		}
		if(y > 606 && y < 695){
			return top + 5;
		}
		if(y > 695 && y < 785){
			return top + 6;
		}
		if(y > 785 && y < 866){
			return top + 7;
		}
		return -1;
	}


	public int getColumn(int x, int y, boolean even){
		if(even){
			if(x > 450 && x < 500){
				return left;
			}
			if(x > 555 && x < 605){
				return left + 1;
			}
			if(x > 654 && x < 715 ){
				return left + 2;
			}
			if(x > 753 && x < 806){
				return left + 3;
			}
			if(x > 853 && x < 904 ){
				return left + 4;
			}
			if(x > 949 && x < 999){
				return left + 5;
			}
			if(x > 1048 && x < 1102){
				return left + 6;
			}
			if(x > 1148 && x < 1199){
				return left + 7;
			}
		}else{
			if(x > 394 && x < 467){
				return left - 1;
			}
			if(x > 507 && x < 559){
				return left;
			}
			if(x > 602 && x < 654 ){
				return left + 1;
			}
			if(x > 704 && x < 761){
				return left + 2;
			}
			if(x > 796 && x < 860 ){
				return left + 3;
			}
			if(x > 893 && x < 956){
				return left + 4;
			}
			if(x > 995 && x < 1055){
				return left + 5;
			}
			if(x > 1090 && x < 1159){
				return left + 6;
			}
		}
		return -1;
	}

	public void polygonContains(boolean place, int x, int y){
		if (place) {
			System.out.println("placing habitat");
			place(rowTemp, colTemp);
		}
		if(getRow(x, y) != -1){
			boolean even = ((getRow(x, y) % 2 ==0));
			System.out.println("row" + getRow(x, y));
			System.out.println("col" + getColumn(x, y, even));
			if(getColumn(x, y, even) != -1){
				rowTemp = getRow(x, y);
				colTemp = getColumn(x, y, even);
				setTempBoard(getRow(x, y), getColumn(x, y, even));
			}
		}
		repaint();
	}

	public void setTempBoard(int r, int c){
		if(gameState == 1) {
			if (game.habitatCanBePlaced(r, c, game.getPlayerList().get(turn))) {
				System.out.println("habitat placed on temp");
				tempboard[r][c].setHabitatTile(game.getAvailableHabitats().getDashboard().get(habitatNum));
				num++;
			}
		}
		if(gameState == 2) {
			System.out.println(game.animalCanBePlaced(habitatNum, r, c, game.getPlayerList().get(turn)) + " animal can be placed on temp");
			if(game.animalCanBePlaced(habitatNum, r, c, game.getPlayerList().get(turn))) {
				System.out.println("animal placed on temp");
				tempboard[r][c].getHabitatTile().setTokenPlaced(game.getAvailableHabitats().getDashboard().get(habitatNum).getCorrespondingToken());
				num++;
			}
		}
	}

	public void place (int row, int col) {
		if(gameState == 1){
			game.placedHabitat(habitatNum, row, col, game.getPlayerList().get(turn));
			gameState = 2;
			gameState2 = 0;
			num = 0;
//			if(game.habitatCanBePlaced(row, col, game.getPlayerList().get(turn))){
//				System.out.println("placed");
//			}
			System.out.println("placed habitat");
		}
		if(gameState == 2){
			if(game.animalCanBePlaced(habitatNum, row, col, game.getPlayerList().get(turn))){
				game.placedAnimalToken(habitatNum, row, col, game.getPlayerList().get(turn));
				Player p = game.getPlayerList().get(turn);
				p.setTurnsLeft( p.getTurnsLeft()- 1);
				turn++;
				if(turn == 3){
					turn = 0;
				}
				num = 0;
				habitatNum = -1;
				gameState = 1;
				if(game.getPlayerList().get(2).getTurnsLeft() == 0){
					gameState = 3;
				}
				System.out.println("placed animal token");
			}
		}
	}

	public boolean canUseToken() {
		canUseToken = game.getPlayerList().get(turn).getPlayerBoard().getNatureTokens() > 0;
		return canUseToken;
	}

	public void rotateImage(Graphics g, BufferedImage image, int x, int y , int w, int h, int degree) {
		Graphics2D g2 = (Graphics2D)g;
		double rotationRequired = Math.toRadians(degree);
		double xCor = (double) image.getWidth() /2;
		double yCor = (double) image.getHeight() /2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, xCor, yCor);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		g2.drawImage(op.filter(image, null), x, y, w, h, null);
	}

	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
}

