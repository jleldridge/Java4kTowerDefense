package main;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import engine.Engine;

public class GameApplet extends Applet implements Runnable, KeyListener {
	Engine engine;

	@Override
	public void keyPressed(KeyEvent e) {
		engine.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		engine.keyReleased(e);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		//not used
	}
	
	@Override
	public void start(){
		new Thread(this).start();
		addKeyListener(this);
	}
	
	@Override
	public void init(){
		engine = new Engine();
	}
	
	@Override
	public void run() {
		//TODO: for applet viewer, remove later
		setSize(800, 600);
		
		//create a bufferedImage object to act as the screen
		//get the graphics object for the screen
		BufferedImage screen = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
		Graphics g = screen.getGraphics();
		
		//get the graphics object for the applet itself
		Graphics ag = this.getGraphics();
		
		while(true){
			//blank out the screen
			g.setColor(Color.white);
			g.fillRect(0, 0, 800, 600);
			//call the engine's update and render methods with g
			engine.update();
			engine.render(g);
			//draw the screen to the applet
			ag.drawImage(screen, 0, 0, null);
		}

	}

}
