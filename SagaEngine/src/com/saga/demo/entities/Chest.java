package com.saga.demo.entities;

import com.saga.component.Sprite;
import com.saga.component.Transform;
import com.saga.entity.Entity;
import com.saga.entity.Tile;
import com.saga.utility.Texture;
import com.saga.utility.Vector2;

public class Chest extends Entity {
	
	public Chest() {
		addComponent(new Transform());
		addComponent(new Sprite(Texture.loadTexture("res/sprites/items/chest.png")));
		
		getComponent(Transform.class).setPosition(new Vector2(5 * Tile.getTileSize(), 5 * Tile.getTileSize()));
	}
}
