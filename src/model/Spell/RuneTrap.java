package model.Spell;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class RuneTrap extends Spell{
	public RuneTrap(int x, int y, int duration){
		setX(x);
		setY(y);
		setDx(0);
		setDy(0);
		setDuration(duration);
		setSize(25);
		
		BufferedImage sprite = new BufferedImage(getSize(), getSize(), BufferedImage.TYPE_INT_RGB);
		Graphics g = sprite.getGraphics();
		g.setColor(Color.yellow);
		g.fillOval(0, 0, getSize(), getSize());
		setSprite(sprite);
	}
}
