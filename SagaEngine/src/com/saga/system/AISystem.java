package com.saga.system;

import java.util.Random;

import com.saga.component.AI;
import com.saga.component.Animation;
import com.saga.component.Movement;
import com.saga.entity.Entity;
import com.saga.utility.Vector2;

public class AISystem extends AbstractSystem {
	
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
	
	public static void update(Entity entity) {
		if (!entity.hasComponent(AI.class)) {
			return;
		}
		if (entity.getComponent(Movement.class).isMoving()) {
			return;
		}

		Random random = new Random();
		int i = random.nextInt(100) + 1;
		
		if (i <= 20) {
			updateAnimation(entity, "up");
			updateMovement(entity, new Vector2(0, -1));
		}
		else if (i <= 40) {
			updateAnimation(entity, "down");
			updateMovement(entity, new Vector2(0, 1));
		}
		else if (i <= 60) {
			updateAnimation(entity, "left");
			updateMovement(entity, new Vector2(-1, 0));
		}
		else if (i <= 80) {
			updateAnimation(entity, "right");
			updateMovement(entity, new Vector2(1, 0));
		}
		else if (i <= 100) {
			updateMovement(entity, new Vector2(0, 0));
		}
		
	}

}
