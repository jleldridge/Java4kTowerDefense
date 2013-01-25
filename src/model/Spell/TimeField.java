package model.Spell;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class TimeField extends Spell{
	public TimeField(int x, int y, int duration){
		this.x = x;
		this.y = y;
		this.duration = duration;
		this.size = 75;
		
		BufferedImage sprite = new BufferedImage(75, 75, BufferedImage.TYPE_INT_RGB);
		Graphics g = sprite.getGraphics();
		g.setColor(Color.magenta);
		g.fillOval(0, 0, 75, 75);
		this.sprite = sprite;
	}
}
