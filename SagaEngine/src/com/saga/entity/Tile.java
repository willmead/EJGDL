package com.saga.entity;

import java.awt.image.BufferedImage;

import com.saga.component.Sprite;
import com.saga.component.Transform;
import com.saga.utility.Vector2;

public class Tile extends Entity {
	
	private static int tileSize = 48;
	
	public Tile(BufferedImage texture, int x, int y) {
		addComponent(new Transform());
		getComponent(Transform.class).setPosition(new Vector2(x * tileSize, y * tileSize));
	
		addComponent(new Sprite(texture));
	}
	
	public static int getTileSize() {
		return tileSize;
	}
}
