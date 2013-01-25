package model.Spell;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class RuneTrap extends Spell{
	public RuneTrap(int x, int y, int duration){
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.duration = duration;
		this.size = 25;
		
		BufferedImage sprite = new BufferedImage(25, 25, BufferedImage.TYPE_INT_RGB);
		Graphics g = sprite.getGraphics();
		g.setColor(Color.yellow);
		g.fillOval(0, 0, 25, 25);
		this.sprite = sprite;
	}
}
