package com.saga.system;

import com.saga.component.Movement;
import com.saga.component.Transform;
import com.saga.entity.Entity;
import com.saga.entity.Tile;
import com.saga.utility.Vector2;

public class MovementSystem extends AbstractSystem {
	
	public static void update(Entity entity) {
		if (!entity.hasComponent(Movement.class)) {
			return;
		}
				
		if (entity.getComponent(Movement.class).isMoving()) {	
			Vector2 currentPosition = entity.getComponent(Transform.class).getPosition();
			currentPosition.add(entity.getComponent(Movement.class).getVelocity());
			entity.getComponent(Transform.class).setPosition(currentPosition);
			
			if ((entity.getComponent(Transform.class).getX() % Tile.getTileSize() == 0)
			 && (entity.getComponent(Transform.class).getY() % Tile.getTileSize() == 0)) {
				entity.getComponent(Movement.class).setVelocity(new Vector2(0, 0));
			}
		}
		
	}
}
