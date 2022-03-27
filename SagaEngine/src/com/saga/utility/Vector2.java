package com.saga.utility;

public class Vector2 {
	
	private int x;
	private int y;
	
	public Vector2 (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void add(Vector2 other) {
		this.x += other.x;
		this.y += other.y;
	}
	
	public void scale(int magnitude) {
		this.x *= magnitude;
		this.y *= magnitude;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		return x + ", " + y;
	}
	
	public double getMagnitude() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	

}
