package model.Terrain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import engine.Engine;

public class Grass extends Terrain {
	
		
	// constructors
	public Grass() {
		x = 0;
		y = 0;
		sprite = new BufferedImage(Engine.SQUARE_DIMENSION, Engine.SQUARE_DIMENSION, BufferedImage.TYPE_INT_RGB);
		Graphics g = sprite.getGraphics();
		g.setColor(Color.GREEN);
		// testing -- start at 2,2 for 'grid' effect
		g.fillRect(2, 2, Engine.SQUARE_DIMENSION, Engine.SQUARE_DIMENSION);
		//g.fillRect(0, 0, Engine.SQUARE_DIMENSION, Engine.SQUARE_DIMENSION);
	}
	
	public Grass(int x, int y) {
		this.x = x;
		this.y = y;
		sprite = new BufferedImage(Engine.SQUARE_DIMENSION, Engine.SQUARE_DIMENSION, BufferedImage.TYPE_INT_RGB);
		Graphics g = sprite.getGraphics();
		g.setColor(Color.GREEN);
		// testing -- start at 2,2 for 'grid' effect
		g.fillRect(2, 2, Engine.SQUARE_DIMENSION, Engine.SQUARE_DIMENSION);
		//g.fillRect(0, 0, Engine.SQUARE_DIMENSION, Engine.SQUARE_DIMENSION);
	}
}
