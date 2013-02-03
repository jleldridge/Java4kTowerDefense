package model.Terrain;

import java.awt.image.BufferedImage;

/**
 * generic terrain object (i.e.: a wall) 
 */
public abstract class Terrain{
	// fields
	// are entities able to cross a given terrain type?
	public boolean traversable;
	// are spells able to destroy a given terrain type?
	public boolean destructable;
	// grid coordinates for a given terrain type
	public int x, y;
	public BufferedImage sprite;
	
}

