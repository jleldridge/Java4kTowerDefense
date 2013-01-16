package model.Effect;

import model.Viewable;

/**
 * generic effect object (i.e.: a spell) 
 */
public abstract class Effect implements Viewable {
	// fields
	private int x, y;
	
	// setters/getters
	public int getX() { return this.x; }
	public void setX(int x) { this.x = x; }
	public int getY() { return this.y; }
	public void setY(int y) { this.y = y; }	
}


