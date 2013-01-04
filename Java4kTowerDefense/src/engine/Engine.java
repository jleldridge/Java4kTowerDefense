package engine;
import model.*;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

import model.Entity.Entity;
import model.Entity.Player;
import model.Spell.Fireball;
import model.Spell.Spell;
import model.Terrain.Grass;


public class Engine {
	public final static int SQUARE_DIMENSION = 25;
	public final static int GRID_HEIGHT = 600 / 25;
	public final static int GRID_WIDTH = 800 / 25;
	// stack which holds the keys that are currently down.
	Stack<Integer> keysDown;
	//will change this to type tile when that class is created.
	Tile[][] gameArea;
	//array of all spells currently on the field
	ArrayList<Spell> spells;
	//array of all mobs currently on the field
	ArrayList<Entity> mobs;
	Player player;

	public Engine() {
		// going to fill the grid with Tile types once that class is created
		gameArea = new Tile[GRID_HEIGHT][GRID_WIDTH];
		keysDown = new Stack<Integer>();
		player = new Player();
		spells = new ArrayList<Spell>();
		mobs = new ArrayList<Entity>();
		
		for(int i = 0; i < gameArea.length; i++){
			for(int j = 0; j < gameArea[0].length; j++){
				gameArea[i][j] = new Tile();
				// testing -- Fill all game tiles with grass
				gameArea[i][j].getTile().setTerrain(new Grass(i, j));
			}
		}
		
	}

	public void update() {
		//reduce the spell cooldown timer
		if(player.getSpellCooldown() > 0){
			player.setSpellCooldown(player.getSpellCooldown()-1);
		}
		// check which key is the latest one pressed and still down and
		// modify the player's action states appropriately
		int code = 0;
		if (!keysDown.empty()) {
			code = keysDown.peek();
		}
		if (code == KeyEvent.VK_LEFT) {
			player.setDx(-12);
		} else if (code == KeyEvent.VK_RIGHT) {
			player.setDx(12);
		} else if (code == KeyEvent.VK_UP) {
			player.setDy(-12);
		} else if (code == KeyEvent.VK_DOWN) {
			player.setDy(12);
		} else if(code == KeyEvent.VK_1){
			if(player.getSpellCooldown() <= 0){
				spells.add(new Fireball(player.getX()+6, player.getY()+3, 5, 0, 120));
				player.setSpellCooldown(60);
			}
		}
		//set the player's position based on the dx and dy values and
		//only move the player if they're at the end of the movement
		//sprite
		if (player.getMovementFrame() == 9) {
			player.setX(player.getX() + player.getDx());
			player.setY(player.getY() + player.getDy());

			// reset the action states of the player
			player.setDx(0);
			player.setDy(0);
			player.nextMovementFrame();
		}	
		else if(player.getDx() != 0 || player.getDy() != 0){
			player.nextMovementFrame();
		}
		
		//change state of spells
		Iterator<Spell> iter = spells.iterator();
		while(iter.hasNext()){
			Spell spell = iter.next();
			spell.setX(spell.getX()+spell.getDx());
			spell.setY(spell.getY()+spell.getDy());
			spell.setDuration(spell.getDuration()-1);
			if(spell.getDuration() <= 0){
				iter.remove();
			}
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < GRID_HEIGHT; i++) {
			for (int j = 0; j < GRID_WIDTH; j++) {
				//testing -- Check if tile has terrain, effect, or player, and render respectively
				if (gameArea[i][j].getTerrain() != null)
					g.drawImage(gameArea[i][j].getTerrain().getImage(),
							SQUARE_DIMENSION * j, SQUARE_DIMENSION * i, null);
				if (gameArea[i][j].getEffect() != null)
					g.drawImage(gameArea[i][j].getEffect().getImage(),
							SQUARE_DIMENSION * j, SQUARE_DIMENSION * i, null);
			}
		}
		g.drawImage(player.getImage(), player.getX(), player.getY(), null);
		
		//render the spells
		for(int i = 0; i < spells.size(); i++){
			Spell spell = spells.get(i);
			g.drawImage(spell.getSprite(), spell.getX(), spell.getY(), null);
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
