package com.saga.game;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import com.saga.entity.Camera;
import com.saga.entity.Entity;
import com.saga.entity.Tile;
import com.saga.entity.TileMap;
import com.saga.system.AISystem;
import com.saga.system.AnimationSystem;
import com.saga.system.KeyboardSystem;
import com.saga.system.MovementSystem;
import com.saga.system.RenderSystem;

public class Scene {
	
	private Camera camera;
	private List<Entity> entities;
	private boolean running;
	
	public Scene(Game game) {
		entities = new ArrayList<Entity>();
		running = false;
	}
	
	public void update(KeyHandler kh) {
		if (!running) { 	
			return;
		}
		for (Entity e : entities) {
			e.update();
			MovementSystem.update(e);
			KeyboardSystem.update(e, kh);
			AnimationSystem.update(e);
			AISystem.update(e);
		}
	}
	
	public void draw(Graphics2D g2) {
		if (running) {
			RenderSystem.draw(g2, this);
		}
	}
	
	public void start() {
		running = true;
	}
	
	public void stop() {
		running = false;
	}
	
	public void addEntity(Entity entity) {
		if (entity instanceof TileMap) {
			addTileMap((TileMap)entity);
		}
		else {
			entities.add(entity);
		}
	}
	
	public Camera getCamera() {
		return camera;
	}
	
	public void setCamera(Camera camera) {
		this.camera = camera;
	}
	
	public List<Entity> getEntities() {
		return entities;
	}

	public void addTileMap(TileMap tileMap) {
	    for (List<Tile> row : tileMap.getTiles()) {
	    	for (Tile tile : row) {
	    		addEntity(tile);
	    	}
	    }
	}

}
