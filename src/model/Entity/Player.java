package model.Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import engine.Engine;

public class Player{
	public int x, y, dx, dy, size; 
	
	public BufferedImage sprite;
	public int spellCooldown;
	public char direction;
	

	public Player(){
		this.x=0;
		this.y=0;
		size=25;
		sprite = new BufferedImage(this.size, this.size, 
				BufferedImage.TYPE_INT_RGB);
		Graphics g = sprite.getGraphics();
		g.setColor(Color.blue);
		g.fillRect(0, 0, this.size, this.size);
		spellCooldown = 0;
		direction = 'd';
	}
	
}
