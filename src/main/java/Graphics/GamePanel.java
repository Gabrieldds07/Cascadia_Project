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
import java.util.Objects;


public class GamePanel extends JPanel implements MouseListener{
	private BufferedImage background, ntButtons, scoreCards, test;
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
	private BufferedImage close, scoringCardsBackground;
	private boolean scoringCardsPressed = false;
	// 0 = game instantiation, 1 = pick habitat Tile & animal token, place habitat, 2 = place animalToken
	private int gameState = 0;
	//0 = pick habitat Tile & animal token, 1=  place habitat
	private int gameState2 = 0;
	// num is the habitatTile + animal token selected
	private int habitatNum = -1;
	private Hexagon[][] tempboard;

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

			keyStoneTile1 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/KeyStone Tile 1.png")));
			keyStoneTile2 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/KeyStone Tile 2.png")));
			keyStoneTile3 = ImageIO.read(Objects.requireNonNull(GamePanel.class.getResource("/Images/Tiles/KeyStone Tile 3.png")));
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
		g.drawImage(test, 800,460,100,116,null);
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
			else if(gameState == 2){
				if(gameState2 == 0){
					drawPlayerBoard(g, game.getPlayerList().get(turn).getPlayerBoard().getBoard());
				}
				if(gameState2 == 1){
					drawPlayerBoard(g, tempboard);
				}
			}
			drawPlayerInfo(g);
			drawHabitatDashboard(g);
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
							g.drawImage(b[r][c].getHabitatTile().getImg(), 515 + 100 * x, 176 + 83 * y, 100, 110, null);
						}
						if (!even) {
							g.drawImage(b[r][c].getHabitatTile().getImg(), 480 + 100 * x, 176 + 83 * y, 100, 110, null);
						}
						//System.out.println("row " + b[r][c].getRow());
						//System.out.println("col " + b[r][c].getColumn());
					} else {
						if (even) {
							g.drawImage(b[r][c].getHabitatTile().getImg(), 413 + 99 * x, 166 + 83 * y, 140, 140, null);
						}
						if (!even) {
							g.drawImage(b[r][c].getHabitatTile().getImg(), 375 + 99 * x, 166 + 83 * y, 140, 140, null);
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

	public void drawBackground(Graphics g) {
		g.drawImage(background, 0, 0, 1920, 1080, null);
		g.drawImage(ntButtons, 34, 917, 281, 123, null);
	}

	public void drawNatureTokenMenu(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(100,100,1720,880);
	}

	public void drawPlayerInfo(Graphics g) {
		g.drawString("Player " + (turn + 1), 50,65);
		g.drawString("Turns Left: " + game.getPlayerList().get(turn).getTurnsLeft(), 50,95);
		g.drawString("Nature Tokes: " + game.getPlayerList().get(turn).getPlayerBoard().getNatureTokens(), 50,125);
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
		if (x >= 1305 && x <= 1910 && y >= 55 && y <= 385) {

		}
		if (x >= 1305 && x <= 1910 && y >= 435 && y <= 755) {

		}

		if(gameState == 1) {
			//picking habitat Tile and animal token
			if(gameState2 == 0){
				tempboard = game.getPlayerList().get(turn).getPlayerBoard().getBoard();
			}

			//get Nature Token & replace tokens
			if (x >= 33 && x <= 315 && y >= 915 && y <= 965 && canUseToken) {
				repaint();
			}
			if (x >= 33 && x <= 315 && y >= 995 && y <= 1045) {
				canUseToken = true;
			}

			//pick habitatTile and animalToken
			if((y > 198 && y < 272 && x > 90 && x < 164)|| (x > 251 && x < 325 && y < 270 && y > 198)){
				habitatNum = 0;
				game.clickedHabitatTile(habitatNum);
				gameState2 = 1;
				repaint();
			}
			if((y > 374 && y < 446 && x > 90 && x < 164)|| (x > 251 && x < 325 && y < 444 && y > 378)){
				habitatNum = 1;
				game.clickedHabitatTile(habitatNum);
				gameState2 = 1;
				repaint();
			}
			if((y > 550 && y < 622 && x > 90 && x < 164)|| (x > 251 && x < 325 && y < 614 && y > 550)){
				habitatNum = 2;
				game.clickedHabitatTile(habitatNum);
				gameState2 = 1;
				repaint();
			}
			if((y > 725 && y < 795 && x > 90 && x < 164)|| (x > 251 && x < 325 && y < 788 && y > 725)){
				habitatNum = 3;
				game.clickedHabitatTile(habitatNum);
				gameState2 = 1;
				repaint();
			}

			//placing on board
			if(gameState2 == 1){
				//rotate cw, ccw, place, cancel
				if (x >= 990 && x <= 1240 && y >= 925 && y <= 950) {
					repaint();
				}
				if (x >= 720 && x <= 970 && y >= 925 && y <= 950) {
					rotateRight = true;
					repaint();
				}
				if (x >= 990 && x <= 1240 && y >= 925 && y <= 950) {

				}
				if (x >= 720 && x <= 970 && y >= 965 && y <= 990) {
					polygonContains(true, x, y);
					repaint();
				}
				if (x >= 990 && x <= 1240 && y >= 965 && y <= 990) {

				}
				polygonContains(false, x, y);
				repaint();
			}
		}
		if(gameState == 2) {

		}
	}

	public void setTempBoard(int r, int c){
		tempboard = game.getPlayerList().get(turn).getPlayerBoard().getBoard();
		tempboard[r][c].setHabitatTile(game.getAvailableHabitats().getDashboard().get(habitatNum));
	}

	public void polygonContains(boolean place, int x, int y){
		//add all
		if(x > 700 && x < 766 && y > 440 && y < 520){
			//r3c3
			if (place) {
				place(top + 3, left + 2);
			} else {
				setTempBoard(top + 3, left + 2);
			}
			repaint();
		}
	}

	public void place (int row, int col) {
		if(gameState == 1){
			System.out.println(game.habitatCanBePlaced(row, col, game.getPlayerList().get(turn)));
			if(game.habitatCanBePlaced(row, col, game.getPlayerList().get(turn))){
				game.placedHabitat(habitatNum, row, col, game.getPlayerList().get(turn));
				gameState = 2;
				gameState2 = 0;
			}
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
				habitatNum = -1;
				gameState = 1;
				System.out.println("DONE");
			}
		}
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
	public boolean canUseToken() {
        canUseToken = game.getPlayerList().get(turn).getPlayerBoard().getNatureTokens() > 0;
		return canUseToken;
	}
}

