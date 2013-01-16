package model;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import engine.Engine;


public interface Viewable {
	//start out with blue squares for the player, green for terrain objects, red for enemies
	//squares should be 10x10 pixels
	//for getting the current frame of an animation
	public BufferedImage getImage();
	
	//for getting the position on the grid
	public int getX();
	public void setX(int x);
	public int getY();
	public void setY(int y);
	
}


