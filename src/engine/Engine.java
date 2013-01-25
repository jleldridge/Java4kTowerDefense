package engine;
import model.*;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.*;

import model.Entity.*;
import model.Spell.*;
import model.Terrain.*;


public class Engine {
	public final static int SQUARE_DIMENSION = 25;
	public final static int GRID_HEIGHT = 600 / SQUARE_DIMENSION;
	public final static int GRID_WIDTH = 800 / SQUARE_DIMENSION;
	// stack which holds the keys that are currently down.
	Stack<Integer> keysDown;
	//will change this to type tile when that class is created.
	Tile[][] gameArea;
	ArrayList<Spell> spells;
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
		if(player.spellCooldown > 0){
			player.spellCooldown -= 1;
		}
		// check which key is the latest one pressed and still down and
		// modify the player's action states appropriately
		int code = 0;
		if (!keysDown.empty()) {
			code = keysDown.peek();
		}
		if (code == KeyEvent.VK_LEFT) {
			player.dx = -1;
			player.direction = 'l';
		} else if (code == KeyEvent.VK_RIGHT) {
			player.dx = 1;
			player.direction = 'r';
		} else if (code == KeyEvent.VK_UP) {
			player.dy = -1;
			player.direction = 'u';
		} else if (code == KeyEvent.VK_DOWN) {
			player.dy = 1;
			player.direction = 'd';
		} else if(code == KeyEvent.VK_1){
			if(player.spellCooldown <= 0){
				if(player.direction == 'r'){
					spells.add(new Fireball(player.x+6, player.y+3, 5, 0, 60));
				} else if(player.direction == 'l'){
					spells.add(new Fireball(player.x+6, player.y+3, -5, 0, 60));
				} else if(player.direction == 'u'){
					spells.add(new Fireball(player.x+6, player.y+3, 0, -5, 60));
				} else if(player.direction == 'd'){
					spells.add(new Fireball(player.x+6, player.y+3, 0, 5, 60));
				}
				player.spellCooldown = 60;
			}
		} else if(code == KeyEvent.VK_2){
			if(player.spellCooldown <= 0){
				spells.add(new RuneTrap(player.x, player.y, 600));
				player.spellCooldown = 60;
			}
		} else if(code == KeyEvent.VK_3){
			if(player.spellCooldown <= 0){
				spells.add(new TimeField(player.x-25, player.y-25, 600));
				player.spellCooldown = 60;
			}
		}
		//set the player's position based on the dx and dy values and
		//only move the player if they're at the end of the movement
		//sprite

		player.x += player.dx;
		player.y += player.dy;

		// reset the action states of the player
		player.dx = 0;
		player.dy = 0;
		
		//change state of spells
		Iterator iter = spells.iterator();
		while(iter.hasNext()){
			Spell spell = (Spell)iter.next();
			spell.x += spell.dx;
			spell.y += spell.dy;
			spell.duration -= 1;
			if(spell.duration <= 0){
				iter.remove();
			}
		}
		
		//check for mob collisions
		iter = mobs.iterator();
		while(iter.hasNext()){
			Entity mob = (Entity)iter.next();
			
			//check for collisions between mobs and spells
			Iterator<Spell> spellIter = spells.iterator();
			while(spellIter.hasNext()){
				Spell spell = spellIter.next();
				if(mob.x + mob.size >= spell.x && mob.x <= spell.x + spell.size){
					if(mob.y + mob.size >= spell.y && mob.y <= spell.y + spell.size){
						//handle mobs colliding with spells
					}
				}
			}
			
			//check for collisions between mobs and the player
			if(mob.x + mob.size >= player.x && mob.x <= player.x + player.size){
				if(mob.y + mob.size >= player.y && mob.y <= player.y + player.size){
					//handle mobs colliding with player
				}
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
		g.drawImage(player.sprite, player.x, player.y, null);
		
		//render the spells
		for(int i = 0; i < spells.size(); i++){
			Spell spell = spells.get(i);
			g.drawImage(spell.sprite, spell.x, spell.y, null);
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
