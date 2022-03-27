package com.saga.entity;

import com.saga.component.Transform;
import com.saga.utility.Vector2;

public class Camera extends Entity {
	
	private Entity target = null;
	
	public Camera(Vector2 position) {
		addComponent(new Transform());
		getComponent(Transform.class).setPosition(position);
	}
	
	public Camera(Entity target) {
		addComponent(new Transform());
		this.target = target;
	}
	
	public Entity getTarget() {
		return target;
	}
	
	public void setTarget(Entity target) {
		this.target = target;
	}
	
	public void update() {
		if (target != null) {
			Vector2 targetPosition = target.getComponent(Transform.class).getPosition();
			getComponent(Transform.class).setPosition(targetPosition);
		}
	}

}
