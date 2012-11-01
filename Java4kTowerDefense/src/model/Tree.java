package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import engine.Engine;

public class Tree extends Terrain {
	
	// fields
	private int x, y;
	private BufferedImage sprite;
	private boolean traversable = false;
	private boolean destroyable = true;
		
	// constructors
	public Tree() {
		x = 0;
		y = 0;
		sprite = new BufferedImage(Engine.SQUARE_DIMENSION, Engine.SQUARE_DIMENSION, BufferedImage.TYPE_INT_RGB);
		Graphics g = sprite.getGraphics();
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, Engine.SQUARE_DIMENSION, Engine.SQUARE_DIMENSION);
	}
	
	public Tree(int x, int y) {
		this.x = x;
		this.y = y;
		sprite = new BufferedImage(Engine.SQUARE_DIMENSION, Engine.SQUARE_DIMENSION, BufferedImage.TYPE_INT_RGB);
		Graphics g = sprite.getGraphics();
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, Engine.SQUARE_DIMENSION, Engine.SQUARE_DIMENSION);
	}
	
	// getters
	@Override
	public BufferedImage getImage() {
		return this.sprite;
	}
	
	
}