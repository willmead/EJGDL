package com.saga.component;

import java.awt.image.BufferedImage;

public class Sprite extends Component {
	
	private BufferedImage texture;
	
	public Sprite() {
		
	}
	
	public Sprite(BufferedImage texture) {
		this.texture = texture;
	}
	
	public BufferedImage getTexture() {
		return texture;
	}
	
	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

}
