package com.saga.component;

import com.saga.utility.Vector2;

public class Transform extends Component {
	
	private Vector2 position;
	
	public Vector2 getPosition() {
		return position;
	}
	
	public void setPosition (Vector2 position){
		this.position = position;
	}
	
	public int getX() {
		return position.getX();
	}
	
	public int getY() {
		return position.getY();
	}

}
