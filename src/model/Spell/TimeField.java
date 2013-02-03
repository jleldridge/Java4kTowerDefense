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
		
		BufferedImage sprite = new BufferedImage(75, 75, BufferedImage.TYPE_INT_ARGB);
		Graphics g = sprite.getGraphics();
		g.setColor(new Color(0, 0, 0, 0));
		g.fillRect(0, 0, 75, 75);
		g.setColor(new Color(200, 0, 90, 150));
		g.fillOval(0, 0, 75, 75);
		this.sprite = sprite;
	}
}
