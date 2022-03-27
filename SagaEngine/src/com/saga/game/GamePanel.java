package com.saga.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 2350141776490647533L;
	
	private Thread gameThread = new Thread(this);
	private KeyHandler keyHandler = new KeyHandler();
	private Game game;
	
	public GamePanel(Game game) {
		this.setPreferredSize(new Dimension(game.getScreenWidth(), game.getScreenHeight()));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.setFocusable(true);
		
		this.addKeyListener(keyHandler);
		this.game = game;
		this.game.setKeyHandler(keyHandler);
		this.game.setup();
	}

	public void start() {
		gameThread.start();
	}

	@Override
	public void run() {
		final int FPS = 60;
		final double drawInterval = 1_000_000_000 / FPS;
		long lastTime = System.nanoTime();
		long currentTime;
		double deltaTime = 0;
				
		while (gameThread != null) {
			currentTime = System.nanoTime();
			deltaTime += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			
			if (deltaTime >= 1) {
				update();
				repaint();
				deltaTime --;
			}
		}
	}
	
	public void update() {
		game.update();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.translate(game.getScreenWidth()/2, game.getScreenHeight()/2);
		game.draw(g2);
		
		g2.dispose();
	}

}
