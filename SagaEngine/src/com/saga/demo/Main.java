package com.saga.demo;

import javax.swing.JFrame;

import com.saga.game.GamePanel;

public class Main {
	
	public static void main(String[] args) {
		JFrame window = new JFrame();
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Demo Game");
		
		MyGame myGame = new MyGame();
		GamePanel gamePanel = new GamePanel(myGame);
		window.add(gamePanel);
		window.pack();
		
		gamePanel.start();
		
		window.setVisible(true);
	}

}