package Graphics;
import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;
import Classes.Game;
import Classes.Hexagon;
import Classes.PlayerBoard;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.event.MouseEvent;
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
	private Tile[][] tileMatrix = new Tile[20][20];
	public static BufferedImage Tile1, Tile2, Tile3, Tile4, Tile5, Tile6, Tile7, Tile8, Tile9, Tile10, Tile11, Tile12, Tile13, Tile14, Tile15, Tile16, Tile17, Tile18, Tile19, Tile20, Tile21, Tile22, Tile23, Tile24, Tile25, Tile26, Tile27, Tile28, Tile29, Tile30, Tile31, Tile32, Tile33, Tile34, Tile35, Tile36, Tile37, Tile38, Tile39, Tile40, Tile41, Tile42, Tile43, Tile44, Tile45, Tile46, Tile47, Tile48, Tile49, Tile50, Tile51, Tile52, Tile53, Tile54, Tile55, Tile56, Tile57;
	public static BufferedImage keyStoneTile1, keyStoneTile2, keyStoneTile3, keyStoneTile4, keyStoneTile5, keyStoneTile6, keyStoneTile7, keyStoneTile8, keyStoneTile9, keyStoneTile10, keyStoneTile11, keyStoneTile12, keyStoneTile13, keyStoneTile14, keyStoneTile15, keyStoneTile16, keyStoneTile17, keyStoneTile18, keyStoneTile19, keyStoneTile20, keyStoneTile21, keyStoneTile22, keyStoneTile23, keyStoneTile24, keyStoneTile25;
	public static BufferedImage starterTile1, starterTile2, starterTile3, starterTile4, starterTile5;
	public static BufferedImage elkScoringCard, foxScoringCard, salmonScoringCard, bearScoringCard, hawkScoringCard;
	public static BufferedImage elkAnimalToken, foxAnimalToken, salmonAnimalToken, bearAnimalToken, hawkAnimalToken;
	public static BufferedImage st1IndividualTop, st1IndividualRight, st1IndividualLeft, st2IndividualTop, st2IndividualRight, st2IndividualLeft, st3IndividualTop, st3IndividualRight, st3IndividualLeft, st4IndividualTop, st4IndividualRight, st4IndividualLeft, st5IndividualTop, st5IndividualRight, st5IndividualLeft;

	public GamePanel(int playerCount, CascadiaFrame frame) {
		try {
			background = ImageIO.read(GamePanel.class.getResource("/Images/Screens/GameBoard.png"));
			ntButtons = ImageIO.read(GamePanel.class.getResource("/Images/Screens/buttons.png"));

			Tile1 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile1.png")));
			Tile2 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile2.png")));
			Tile3 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile3.png")));
			Tile4 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile4.png")));
			Tile5 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile5.png")));
			Tile6 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile6.png")));
			Tile7 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile7.png")));
			Tile8 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile8.png")));
			Tile9 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile9.png")));
			Tile10 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile10.png")));
			Tile11 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile11.png")));
			Tile12 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile12.png")));
			Tile13 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile13.png")));
			Tile14 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile14.png")));
			Tile15 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile15.png")));
			Tile16 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile16.png")));
			Tile17 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile17.png")));
			Tile18 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile18.png")));
			Tile19 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile19.png")));
			Tile20 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile20.png")));
			Tile21 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile21.png")));
			Tile22 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile22.png")));
			Tile23 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile23.png")));
			Tile24 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile24.png")));
			Tile25 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile25.png")));
			Tile26 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile26.png")));
			Tile27 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile27.png")));
			Tile28 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile28.png")));
			Tile29 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile29.png")));
			Tile30 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile30.png")));
			Tile31 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile31.png")));
			Tile32 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile32.png")));
			Tile33 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile33.png")));
			Tile34 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile34.png")));
			Tile35 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile35.png")));
			Tile36 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile36.png")));
			Tile37 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile37.png")));
			Tile38 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile38.png")));
			Tile39 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile39.png")));
			Tile40 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile40.png")));
			Tile41 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile41.png")));
			Tile42 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile42.png")));
			Tile43 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile43.png")));
			Tile44 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile44.png")));
			Tile45 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile45.png")));
			Tile46 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile46.png")));
			Tile47 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile47.png")));
			Tile48 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile48.png")));
			Tile49 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile49.png")));
			Tile50 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile50.png")));
			Tile51 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile51.png")));
			Tile52 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile52.png")));
			Tile53 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile53.png")));
			Tile54 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile54.png")));
			Tile55 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile55.png")));
			Tile56 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile56.png")));
			Tile57 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Tile57.png")));




			keyStoneTile1 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 1.png")));
			keyStoneTile2 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 2.png")));
			keyStoneTile3 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 3.png")));
			keyStoneTile4 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 4.png")));
			keyStoneTile5 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 5.png")));
			keyStoneTile6 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 6.png")));
			keyStoneTile7 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 7.png")));
			keyStoneTile8 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 8.png")));
			keyStoneTile9 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 9.png")));
			keyStoneTile10 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 10.png")));
			keyStoneTile11 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 11.png")));
			keyStoneTile12 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 12.png")));
			keyStoneTile13 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 13.png")));
			keyStoneTile14 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 14.png")));
			keyStoneTile15 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 15.png")));
			keyStoneTile16 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 16.png")));
			keyStoneTile17 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 17.png")));
			keyStoneTile18 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 18.png")));
			keyStoneTile19 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 19.png")));
			keyStoneTile20 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 20.png")));
			keyStoneTile21 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 21.png")));
			keyStoneTile22 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 22.png")));
			keyStoneTile23 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 23.png")));
			keyStoneTile24 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 24.png")));
			keyStoneTile25 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/KeyStone Tile 25.png")));




			starterTile1 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Starter Tile 1.png")));
			starterTile2 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Starter Tile 2.png")));
			starterTile3 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Starter Tile 3.png")));
			starterTile4 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Starter Tile 4.png")));
			starterTile5 = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/Starter Tile 5.png")));




			elkScoringCard = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Scoring Cards/elk-large.png")));
			salmonScoringCard = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Scoring Cards/salmon-large.png")));
			foxScoringCard = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Scoring Cards/fox-large.png")));
			hawkScoringCard = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Scoring Cards/hawk-large.png")));
			bearScoringCard = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Scoring Cards/bear-large.png")));




			elkAnimalToken = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Animal Tokens/elk.png")));
			salmonAnimalToken = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Animal Tokens/salmon.png")));
			foxAnimalToken = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Animal Tokens/fox.png")));
			hawkAnimalToken = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Animal Tokens/hawk.png")));
			bearAnimalToken = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Animal Tokens/bear.png")));

			st1IndividualTop = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 1 Individual Top.png")));
			st1IndividualRight = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 1 Individual Right.png")));
			st1IndividualLeft = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 1 Individual Left.png")));
			st2IndividualTop = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 2 Individual Top.png")));
			st2IndividualRight = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 2 Individual Left.png")));
			st2IndividualLeft = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 2 Individual Right.png")));
			st3IndividualTop = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 3 Individual Top.png")));
			st3IndividualRight = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 3 Individual Right.png")));
			st3IndividualLeft = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 3 Individual Left.png")));
			st4IndividualTop = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 4 Individual Top.png")));
			st4IndividualRight = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 4 Individual Right.png")));
			st4IndividualLeft = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 4 Individual Left.png")));
			st5IndividualTop = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 5 Individual Top.png")));
			st5IndividualRight = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 5 Individual Right.png")));
			st5IndividualLeft = ImageIO.read(Objects.requireNonNull(Game.class.getResource("/Images/Tiles/ST Tiles Individual/ST 5 Individual Left.png")));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		addMouseListener(this);
		this.frame = frame;

		game = new Game(3);
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 20; j++) {
				Tile t = new Tile(i, j);
			}
		}
	}

	//figure out tiles
	public void drawTiles(Graphics g) {
		//coordinates
		tileMatrix[0][0].instantiateHex(870, 612);

		Hexagon[][] h = game.getPlayerList().get(turn).getPlayerBoard().getBoard();
		g.drawImage(h[0][0].getHabitatTile().getImg(), 870, 612, 20, 20, null);
	}


	public void paint(Graphics g) {
		drawBackground(g);
		//drawTiles(g);
		g.drawImage(test, 800,460,100,116,null);
		if(canUseToken == true) {
			drawNatureTokenMenu(g);
		}
		drawPlayerBoard(g, turn);

		if(rotateRight == true) {
			rotateImage(g, test, 800, 460, 100, 116, 180);
			rotateRight = false;
		}
	}
	public void drawBackground(Graphics g) {
		g.drawImage(background, 0, 0, 1920, 1080, null);
		g.drawImage(ntButtons, 34, 917, 281, 123, null);
	}

	public void drawNatureTokenMenu(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(100,100,1720,880);
		//g.set
	}

	public void drawPlayerBoard(Graphics g, int i) {
		g.drawString("xd", 100,100);

	}


	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		System.out.println(x +", "+ y);
		//arrows(up,right,down,left)
		if(x>= 430 && x<=460 && y>=900 && y <= 945) {

		}
		if(x>= 430 && x<=460 && y>=970 && y <= 1015) {

		}
		if(x>= 460 && x<=505 && y>=945 && y <= 975) {

		}
		if(x>= 385 && x<=430 && y>=945 && y <= 975) {

		}
		//rotate cw, ccw, place, cancel
		if(x>= 720 && x<= 970 && y>= 925 && y <= 950) {
			rotateRight = true;
			repaint();
			//rotateImage(, ntButtons, 50, 50, 100, 100, 60);
		}
		if(x>= 990 && x<= 1240 && y>= 925 && y <= 950) {

		}

		if(x>= 720 && x<= 970 && y>= 965 && y <= 990) {

		}
		if(x>= 990 && x<= 1240 && y>= 965 && y <= 990) {

		}

		//get Nature Token & replace tokens
		if(x>= 33 && x <= 315  && y >= 915 && y <= 965 && canUseToken == true) {
			repaint();
		}

		if(x>= 33 && x <= 315  && y >= 995 && y <= 1045) {
			canUseToken = true;
		}
		//player boards
		if(x>= 1305 && x <= 1910  && y >= 55 && y <= 385) {

		}
		if(x>= 1305 && x <= 1910  && y >= 435 && y <= 755) {

		}

	}

	public void rotateImage(Graphics g, BufferedImage image, int x, int y , int w, int h, int degree) {
		Graphics2D g2 = (Graphics2D)g;
		double rotationRequired = Math.toRadians(degree);
		double xCor = image.getWidth()/2;
		double yCor = image.getHeight()/2;
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

		if(game.getPlayerList().get(turn).getPlayerBoard().getNatureTokens() > 0) {
			canUseToken = true;
		}else {
			canUseToken = false;
		}

		return canUseToken;
	}
}


