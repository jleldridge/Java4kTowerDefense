package engine;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Stack;

import model.*;
import model.Entity.Entity;
import model.Entity.Player;

public class Engine {
	public final static int SQUARE_DIMENSION = 25;
	public final static int GRID_HEIGHT = 600 / 25;
	public final static int GRID_WIDTH = 800 / 25;
	// stack which holds the keys that are currently down.
	Stack<Integer> keysDown;
	//will change this to type tile when that class is created.
	Viewable[][] gameArea;
	Player player;

	public Engine() {
		// going to fill the grid with Tile types once that class is created
		gameArea = new Entity[GRID_HEIGHT][GRID_WIDTH];
		keysDown = new Stack<Integer>();
		player = new Player();
		gameArea[player.getY()][player.getX()] = player;

		// for testing positioning of entities on the grid
		// gameArea[0][0] = new Wall(0, 0);
		// gameArea[1][5] = new Wall(1, 5);
		// gameArea[7][1] = new Wall(7, 1);
		// gameArea[7][8] = new Wall(7, 8);
		// gameArea[8][7] = new Wall(8, 7);
		// gameArea[GRID_HEIGHT-1][GRID_WIDTH-1] = new Wall(GRID_HEIGHT-1,
		// GRID_WIDTH-1);

	}

	public void update() {
		// check which key is the latest one pressed and still down and
		// modify the player's action states appropriately
		int code = 0;
		if (!keysDown.empty()) {
			code = keysDown.peek();
		}
		if (code == KeyEvent.VK_LEFT) {
			player.setDx(-1);
		} else if (code == KeyEvent.VK_RIGHT) {
			player.setDx(1);
		} else if (code == KeyEvent.VK_UP) {
			player.setDy(-1);
		} else if (code == KeyEvent.VK_DOWN) {
			player.setDy(1);
		}

		//set the player's position based on the dx and dy values and
		//only move the player if they're at the end of the movement
		//sprite
		if (player.getMovementFrame() == 9) {
			// delete the player's old position on the grid
			gameArea[player.getY()][player.getX()] = null;
			
			player.setX(player.getX() + player.getDx());
			player.setY(player.getY() + player.getDy());

			// place the player onto the grid based on its new x and y values
			gameArea[player.getY()][player.getX()] = player;

			// reset the action states of the player
			player.setDx(0);
			player.setDy(0);
			player.nextMovementFrame();
		}	
		else if(player.getDx() != 0 || player.getDy() != 0){
			player.nextMovementFrame();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < GRID_HEIGHT; i++) {
			for (int j = 0; j < GRID_WIDTH; j++) {
				if (gameArea[i][j] != null)
					g.drawImage(gameArea[i][j].getImage(),
							SQUARE_DIMENSION * j, SQUARE_DIMENSION * i, null);
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (!keysDown.contains(code)) {
			keysDown.push(code);
		}
	}

	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		// have to use Integer.valueOf() so that we get the
		// stack.remove(Object o) method instead of the
		// stack.remove(int index) method
		keysDown.remove(Integer.valueOf(code));
	}
}
