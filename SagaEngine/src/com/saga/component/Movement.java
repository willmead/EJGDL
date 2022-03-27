package com.saga.component;

import com.saga.utility.Vector2;

public class Movement extends Component {
	
	private Vector2 velocity = new Vector2(0, 0);
	
	public Vector2 getVelocity() {
		return velocity;
	}
	
	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}
	
	public boolean isMoving() {		
		return velocity.getMagnitude() > 0;
		
	}
	
}
