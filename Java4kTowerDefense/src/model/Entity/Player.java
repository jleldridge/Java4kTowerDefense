package model.Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import engine.Engine;

public class Player extends Entity{
	private BufferedImage sprite;
	private int movementFrame;
	private int spellCooldown;
	
	public Player(){
		setX(0);
		setY(0);
		setSize(25);
		sprite = new BufferedImage(getSize(), getSize(), BufferedImage.TYPE_INT_RGB);
		Graphics g = sprite.getGraphics();
		g.setColor(Color.blue);
		g.fillRect(0, 0, getSize(), getSize());
		movementFrame = 0;
		spellCooldown = 0;
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

	public int getSpellCooldown() {
		return spellCooldown;
	}

	public void setSpellCooldown(int spellCooldown) {
		this.spellCooldown = spellCooldown;
	}
}
