package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import engine.Engine;
// test - hrybacki -- testing github
public class Wall implements Entity {

	//fields
	private int x, y;
	private BufferedImage sprite;
	
	public Wall() {
		x = 0;
		y = 0;
		sprite = new BufferedImage(Engine.SQUARE_DIMENSION, Engine.SQUARE_DIMENSION, BufferedImage.TYPE_INT_RGB);
		Graphics g = sprite.getGraphics();
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, Engine.SQUARE_DIMENSION, Engine.SQUARE_DIMENSION);
	}
	
	public Wall(int x, int y) {
		this.x = x;
		this.y = y;
		sprite = new BufferedImage(Engine.SQUARE_DIMENSION, Engine.SQUARE_DIMENSION, BufferedImage.TYPE_INT_RGB);
		Graphics g = sprite.getGraphics();
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, Engine.SQUARE_DIMENSION, Engine.SQUARE_DIMENSION);
	}
	
	@Override
	public BufferedImage getImage() {
		return sprite;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setX(int x) {
		this.x = x;
		
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

}
