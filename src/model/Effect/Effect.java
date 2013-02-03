package model.Effect;

import java.awt.image.BufferedImage;

/**
 * generic effect object (i.e.: a spell) 
 */
public abstract class Effect{
	// fields
	public int x, y;
	public BufferedImage sprite;

	// setters/getters
	public int getX() { return this.x; }
	public void setX(int x) { this.x = x; }
	public int getY() { return this.y; }
	public void setY(int y) { this.y = y; }	
}


