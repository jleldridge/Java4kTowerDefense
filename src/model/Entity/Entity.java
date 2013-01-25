package model.Entity;

import java.awt.image.BufferedImage;

import model.Viewable;

public abstract class Entity implements Viewable {
	//player's position
	public int x, y;
	//the player's "speed" in x and y directions
	public int dx, dy;
	public int size;
	
}
