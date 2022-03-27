package com.saga.system;

import java.awt.Graphics2D;

import com.saga.component.Sprite;
import com.saga.component.Transform;
import com.saga.entity.Camera;
import com.saga.entity.Entity;
import com.saga.game.Scene;
import com.saga.utility.Vector2;

public class RenderSystem {
	
	public static Vector2 getScreenPosition(Vector2 worldPosition, Camera camera) {
		int x = worldPosition.getX() - camera.getComponent(Transform.class).getX();
    	int y = worldPosition.getY() - camera.getComponent(Transform.class).getY();
    	
		return new Vector2(x,  y);
	}
		
	public static void draw(Graphics2D g2, Scene scene) {		
		
		for (Entity e : scene.getEntities()) {
			Sprite sprite = e.getComponent(Sprite.class);
			if (sprite != null) {
				Vector2 position = getScreenPosition(e.getComponent(Transform.class).getPosition(), scene.getCamera());
				g2.drawImage(sprite.getTexture(), position.getX(), position.getY(), null);
			}
		}
		
	}

}
