package com.saga.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
	private boolean pause; 
	private boolean debug;
	private boolean space;
	private boolean enter;

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();		
		
		if (code == KeyEvent.VK_W) { up = true; }
		if (code == KeyEvent.VK_S) { down = true; }
		if (code == KeyEvent.VK_A) { left = true; }
		if (code == KeyEvent.VK_D) { right = true; }
		if (code == KeyEvent.VK_P) { pause = !pause; }
		if (code == KeyEvent.VK_B) { debug = !debug; }
		if (code == KeyEvent.VK_SPACE) { space = true; }
		if (code == KeyEvent.VK_ENTER) { enter = true; }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_W) { up = false; }
		if (code == KeyEvent.VK_S) { down = false; }
		if (code == KeyEvent.VK_A) { left = false; }
		if (code == KeyEvent.VK_D) { right = false; }
	}

	public boolean upPressed() {
		return up;
	}

	public boolean downPressed() {
		return down;
	}

	public boolean leftPressed() {
		return left;
	}

	public boolean rightPressed() {
		return right;
	}

	public boolean pausePressed() {
		return pause;
	}

	public boolean debugPressed() {
		return debug;
	}

	public boolean spacePressed() {
		return space;
	}

	public boolean enterPressed() {
		return enter;
	}
	
	
	
	

}
