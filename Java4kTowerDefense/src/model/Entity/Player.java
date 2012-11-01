package model.Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import engine.Engine;

public class Player extends Entity{
	private BufferedImage sprite;
	private int movementFrame;
	
	public Player(){
		setX(0);
		setY(0);
		sprite = new BufferedImage(Engine.SQUARE_DIMENSION, Engine.SQUARE_DIMENSION, BufferedImage.TYPE_INT_RGB);
		Graphics g = sprite.getGraphics();
		g.setColor(Color.blue);
		g.fillRect(12, 12, Engine.SQUARE_DIMENSION/2, Engine.SQUARE_DIMENSION/2);
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
}
