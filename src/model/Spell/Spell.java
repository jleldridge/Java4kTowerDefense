package model.Spell;

import java.awt.image.BufferedImage;

public abstract class Spell {
	private int duration;
	private int size;
	//position
	private int x, y;
	//speed
	private int dx, dy;
	//sprite
	private BufferedImage sprite;
	
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
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
	public void setSize(int size){
		this.size = size;
	}
	public int getSize(){
		return size;
	}
	public BufferedImage getSprite() {
		return sprite;
	}
	public void setSprite(BufferedImage sprite) {
		this.sprite = sprite;
	}
}
