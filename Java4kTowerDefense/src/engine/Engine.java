package engine;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import model.Entity;
import model.Player;
import model.Wall;

public class Engine {
	public final static int SQUARE_DIMENSION = 25;
	public final static int GRID_HEIGHT = 600/25;
	public final static int GRID_WIDTH = 800/25;
	Entity[][] gameArea;
	Player player;
	
	public Engine(){
		gameArea = new Entity[GRID_HEIGHT][GRID_WIDTH];
		
		player = new Player();
		gameArea[player.getY()][player.getX()] = player;
		
		//for testing positioning of entities on the grid
//		gameArea[0][0] = new Wall(0, 0);
//		gameArea[1][5] = new Wall(1, 5);
//		gameArea[7][1] = new Wall(7, 1);
//		gameArea[7][8] = new Wall(7, 8);
//		gameArea[8][7] = new Wall(8, 7);
//		gameArea[GRID_HEIGHT-1][GRID_WIDTH-1] = new Wall(GRID_HEIGHT-1, GRID_WIDTH-1);
		
		
	}
	
	public void update(){
		//delete the player's old position on the grid
		gameArea[player.getY()][player.getX()] = null;
		
		//set the player's position based on the dx and dy values
		player.setX(player.getX() + player.getDx());
		player.setY(player.getY() + player.getDy());
		//this is choppy, maybe could be taken out when game loop speed is controlled
		player.setDx(0);
		player.setDy(0);
		
		//place the player onto the grid based on its new x and y values
		gameArea[player.getY()][player.getX()] = player;
	}
	
	public void render(Graphics g){
		for(int i = 0; i < GRID_HEIGHT; i++){
			for(int j = 0; j < GRID_WIDTH; j++){
				if(gameArea[i][j] != null)
					g.drawImage(gameArea[i][j].getImage(), SQUARE_DIMENSION*j, SQUARE_DIMENSION*i, null);
			}
		}
	}
	
	public void keyPressed(KeyEvent e){
		int code = e.getKeyCode();
		
		switch(code){
		case KeyEvent.VK_UP:
			player.setDy(-1);
			break;
		case KeyEvent.VK_DOWN:
			player.setDy(1);
			break;
		case KeyEvent.VK_LEFT:
			player.setDx(-1);
			break;
		case KeyEvent.VK_RIGHT:
			player.setDx(1);
			break;
		}
	}
	
	public void keyReleased(KeyEvent e){
		int code = e.getKeyCode();
		
		switch(code){
		case KeyEvent.VK_UP:
			player.setDy(0);
			break;
		case KeyEvent.VK_DOWN:
			player.setDy(0);
			break;
		case KeyEvent.VK_LEFT:
			player.setDx(0);
			break;
		case KeyEvent.VK_RIGHT:
			player.setDx(0);
			break;
		}
		
	}
}
