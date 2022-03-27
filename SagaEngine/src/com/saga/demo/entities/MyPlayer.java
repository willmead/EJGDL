package com.saga.demo.entities;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.saga.component.Animation;
import com.saga.component.Keyboard;
import com.saga.component.Movement;
import com.saga.component.Sprite;
import com.saga.component.Transform;
import com.saga.entity.Entity;
import com.saga.entity.Tile;
import com.saga.utility.Texture;
import com.saga.utility.Vector2;

public class MyPlayer extends Entity {

	public MyPlayer() {
		
		Map<String, List<BufferedImage>> sprites = loadSprites();
		
		addComponent(new Sprite());
		
		addComponent(new Animation(sprites));
		getComponent(Animation.class).setState("down");
		
		addComponent(new Transform());
		getComponent(Transform.class).setPosition(new Vector2(9 * Tile.getTileSize(), 6 * Tile.getTileSize()));

		addComponent(new Movement());
		addComponent(new Keyboard());
	}
	
	public Map<String, List<BufferedImage>> loadSprites() {
		Map<String, List<BufferedImage>> textures = new HashMap<String, List<BufferedImage>>();
		
		List<BufferedImage> up = new ArrayList<BufferedImage>();
		up.add(Texture.loadTexture("res/sprites/player/tile000.png"));
		up.add(Texture.loadTexture("res/sprites/player/tile001.png"));
		up.add(Texture.loadTexture("res/sprites/player/tile002.png"));

		List<BufferedImage> right = new ArrayList<BufferedImage>();
		right.add(Texture.loadTexture("res/sprites/player/tile003.png"));
		right.add(Texture.loadTexture("res/sprites/player/tile004.png"));
		right.add(Texture.loadTexture("res/sprites/player/tile005.png"));

		List<BufferedImage> down = new ArrayList<BufferedImage>();
		down.add(Texture.loadTexture("res/sprites/player/tile006.png"));
		down.add(Texture.loadTexture("res/sprites/player/tile007.png"));
		down.add(Texture.loadTexture("res/sprites/player/tile008.png"));
		
		List<BufferedImage> left = new ArrayList<BufferedImage>();
		left.add(Texture.loadTexture("res/sprites/player/tile009.png"));
		left.add(Texture.loadTexture("res/sprites/player/tile010.png"));
		left.add(Texture.loadTexture("res/sprites/player/tile011.png"));

		textures.put("up", up);
		textures.put("down", down);
		textures.put("left", left);
		textures.put("right", right);
		
		return textures;
	}

}
