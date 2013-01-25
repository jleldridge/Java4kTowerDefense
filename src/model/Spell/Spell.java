package model.Spell;

import java.awt.image.BufferedImage;

public abstract class Spell {
	public int duration;
	public int size;
	//position
	public int x, y;
	//speed
	public int dx, dy;
	//sprite
	public BufferedImage sprite;
}
