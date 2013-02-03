package model.Entity;

import java.awt.image.BufferedImage;

public abstract class Entity{
	public BufferedImage sprite;
	//player's position
	public int x, y, drawX, drawY;
	//the player's "speed" in x and y directions
	public int dx, dy;
	public int size;
	public boolean solid;
}
