package com.saga.system;

import com.saga.component.Animation;
import com.saga.component.Keyboard;
import com.saga.component.Movement;
import com.saga.entity.Entity;
import com.saga.game.KeyHandler;
import com.saga.utility.Vector2;

public class KeyboardSystem extends AbstractSystem {
	
	public static void updateAnimation(Entity entity, String state) {
		if (entity.hasComponent(Animation.class)) {
			entity.getComponent(Animation.class).setState(state);
		}
	}
	
	public static void updateMovement(Entity entity, Vector2 velocity) {
		if (entity.hasComponent(Movement.class)) {
			entity.getComponent(Movement.class).setVelocity(velocity);
		}
	}
	
	public static void update(Entity entity, KeyHandler kh) {
		if (!entity.hasComponent(Keyboard.class)) {
			return;
		}
		if (entity.getComponent(Movement.class).isMoving()) {
			return;
		}
		if (kh.upPressed()) {
			updateAnimation(entity, "up");
			updateMovement(entity, new Vector2(0, -3));
		}
		if (kh.downPressed()) {
			updateAnimation(entity, "down");
			updateMovement(entity, new Vector2(0, 3));
		}
		if (kh.leftPressed()) {
			updateAnimation(entity, "left");
			updateMovement(entity, new Vector2(-3, 0));
		}
		if (kh.rightPressed()) {
			updateAnimation(entity, "right");
			updateMovement(entity, new Vector2(3, 0));
		}	
		
	}
	
}
