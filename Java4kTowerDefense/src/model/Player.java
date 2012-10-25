package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import engine.Engine;

public class Player extends Entity{
	private BufferedImage sprite;
	private int x, y;
	//the player's "speed" in x and y directions
	private int dx, dy;
	private int movementFrame;
	
	public Player(){
		x = 0;
		y = 0;
		sprite = new BufferedImage(Engine.SQUARE_DIMENSION, Engine.SQUARE_DIMENSION, BufferedImage.TYPE_INT_RGB);
		Graphics g = sprite.getGraphics();
		g.setColor(Color.blue);
		g.fillRect(0, 0, Engine.SQUARE_DIMENSION, Engine.SQUARE_DIMENSION);
		movementFrame = 0;
	}
	
	public int getMovementFrame(){
		return movementFrame;
	}
	
	public void nextMovementFrame(){
		movementFrame = movementFrame < 9 ? movementFrame+1 : 0;
	}
	
	@Override
	public BufferedImage getImage() {
		//return some array[movementFrame], where some array is the
		//array holding the frames for this direction of movement.
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
