package com.saga.system;

import java.util.List;

import com.saga.entity.Entity;

public class AbstractSystem {
	
	private List<Entity> entities;
	
	public static void update() {
		
	}
	
	public List<Entity> getEntities() {
		return entities;
	}

}
