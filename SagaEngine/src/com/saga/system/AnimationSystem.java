package com.saga.system;

import com.saga.component.Animation;
import com.saga.component.Movement;
import com.saga.component.Sprite;
import com.saga.entity.Entity;

public class AnimationSystem extends AbstractSystem {
	
	public static void update(Entity entity) {
		if (!entity.hasComponent(Movement.class)) {
			return;
		}
		
		if (!entity.hasComponent(Animation.class)) {
			return;
		}
		if (entity.getComponent(Movement.class).isMoving()) {
			entity.getComponent(Animation.class).incrementTimer();
			if (entity.getComponent(Animation.class).getTimer() > 10) {
				incrementSprite(entity);
				entity.getComponent(Animation.class).resetTimer();
			}
		}
		entity.getComponent(Sprite.class).setTexture(entity.getComponent(Animation.class).getCurrentTexture());
	}

	public static void incrementSprite(Entity entity) {
		entity.getComponent(Animation.class).incrementIndex();
		if (entity.getComponent(Animation.class).getIndex() >= entity.getComponent(Animation.class).getTextures().get(entity.getComponent(Animation.class).getState()).size()){
			entity.getComponent(Animation.class).resetIndex();
		}
	}

}
