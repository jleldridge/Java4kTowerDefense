package model.Spell;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class TimeField extends Spell{
	public TimeField(int x, int y, int duration){
		setX(x);
		setY(y);
		setDuration(duration);
		setSize(75);
		
		BufferedImage sprite = new BufferedImage(getSize(), getSize(), BufferedImage.TYPE_INT_RGB);
		Graphics g = sprite.getGraphics();
		g.setColor(Color.magenta);
		g.fillOval(0, 0, getSize(), getSize());
		setSprite(sprite);
	}
}
