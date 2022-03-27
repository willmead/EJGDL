package com.saga.game;

import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

public class Game {
	
	private int screenWidth; 
	private int screenHeight;

	private KeyHandler keyHandler;
	
	private Map<String, Scene> scenes;
	private String sceneName;
		
	public Game() {
		scenes = new HashMap<String, Scene>();
	}
	
	public void setup() {
		
	}
	
	public void update() {
		scenes.get(sceneName).update(keyHandler);
	}
	
	public void draw(Graphics2D g2) {
		scenes.get(sceneName).draw(g2);
	}
	
	public KeyHandler getKeyHandler() {
		return keyHandler;
	}
	
	public void setKeyHandler(KeyHandler keyHandler) {
		this.keyHandler = keyHandler;
	}
	
	public int getScreenWidth() {
		return screenWidth;
	}
	
	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}

	public int getScreenHeight() {
		return screenHeight;
	}

	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}

	public void addScene(String name, Scene scene) {
		this.scenes.put(name, scene);
	}
	
	public void setScene(String sceneName) {
		this.sceneName = sceneName;
	}
}
