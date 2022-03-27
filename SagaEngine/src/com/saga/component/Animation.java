package com.saga.component;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

public class Animation extends Component {
	
	private Map<String, List<BufferedImage>> textures;
	private String state;
	private int index;
	private int timer;

	public Animation(Map<String, List<BufferedImage>> textures) {
		this.textures = textures;
		this.timer = 0;
		this.index = 0;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void incrementTimer() {
		timer++;
	}
	
	public void resetTimer() {
		timer = 0;
	}
	
	public int getTimer() {
		return timer;
	}
	
	public BufferedImage getCurrentTexture() {
		return textures.get(state).get(index);
	}

	public void incrementIndex() {
		index++;
	}

	public int getIndex() {
		return index;
	}

	public Map<String, List<BufferedImage>> getTextures() {
		return textures;
	}

	public String getState() {
		return state;
	}

	public void resetIndex() {
		index = 0;
	}

}
