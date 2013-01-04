package model.Spell;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Fireball extends Spell{
	public Fireball(int x, int y, int dx, int dy, int duration){
		setX(x);
		setY(y);
		setDx(dx);
		setDy(dy);
		setDuration(duration);
		
		BufferedImage sprite = new BufferedImage(15, 15, BufferedImage.TYPE_INT_RGB);
		Graphics g = sprite.getGraphics();
		g.setColor(Color.red);
		g.fillOval(0, 0, 15, 15);
		setSprite(sprite);
	}
}
