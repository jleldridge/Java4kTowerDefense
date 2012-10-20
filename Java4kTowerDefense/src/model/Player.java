package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import engine.Engine;

public class Player implements Entity{
	private BufferedImage sprite;
	private int x, y;
	//the player's "speed" in x and y directions
	private int dx, dy;
	
	public Player(){
		x = 0;
		y = 0;
		sprite = new BufferedImage(Engine.SQUARE_DIMENSION, Engine.SQUARE_DIMENSION, BufferedImage.TYPE_INT_RGB);
		Graphics g = sprite.getGraphics();
		g.setColor(Color.blue);
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

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}
}
