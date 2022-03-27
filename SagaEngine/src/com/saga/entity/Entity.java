package com.saga.entity;

import java.util.ArrayList;
import java.util.List;

import com.saga.component.Component;

public class Entity {
		
	private List<Component> components;
		
	public Entity() {
		this.components = new ArrayList<Component>();
	}
	
	public void addComponent(Component component) {
		components.add(component);
		component.setEntity(this);
	}
	
    public <T> T getComponent(Class<T> componentClass) {
        for (Component c : components) {
            if (componentClass.isInstance(c)) {
            	return componentClass.cast(c);
            }
        }
        return null;
    }
    
    public <T> boolean hasComponent(Class<T> componentClass) {
        for (Component c : components) {
            if (componentClass.isInstance(c)) {
            	return true;
            }
        }
        return false;
    }
	
	public void update() {

	}
	
}
