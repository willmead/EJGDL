package com.saga.demo;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.saga.demo.entities.Chest;
import com.saga.demo.entities.DemoNPC;
import com.saga.demo.entities.MyPlayer;
import com.saga.entity.Camera;
import com.saga.entity.Entity;
import com.saga.entity.TileMap;
import com.saga.game.Game;
import com.saga.game.Scene;
import com.saga.utility.Texture;

public class MyGame extends Game {
	
	public MyGame() {
		setScreenWidth(768);
		setScreenHeight(576);
	}
	
	public void setup(){
		
		// LOAD ASSETS
		BufferedImage floorTexture = Texture.loadTexture("res/tiles/floorTile.png");
		BufferedImage cornerTexture = Texture.loadTexture("res/tiles/cornerTile.png");
		BufferedImage horizontalWallTexture = Texture.loadTexture("res/tiles/horizontalWallTile.png");
		BufferedImage verticalWallTexture = Texture.loadTexture("res/tiles/verticalWallTile.png");
		
		ArrayList<BufferedImage> textures = new ArrayList<BufferedImage>();
		textures.add(floorTexture);
		textures.add(verticalWallTexture);
		textures.add(horizontalWallTexture);
		textures.add(cornerTexture);
		
		// CREATE ENTITIES
	    Entity player = new MyPlayer();
	    Entity npc = new DemoNPC();
	    Entity chest = new Chest();
	    TileMap tileMap = new TileMap("res/maps/map01.txt", textures);
	    Camera demoCamera = new Camera(npc);	  

	    // CREATE SCENE AND ADD ENTITIES
	    Scene demoScene = new Scene(this);
	    
	    demoScene.setCamera(demoCamera);
	    demoScene.addEntity(tileMap);
	    demoScene.addEntity(demoCamera);
	    demoScene.addEntity(npc);
	    demoScene.addEntity(player);
	    demoScene.addEntity(chest);
	    
	    addScene("DEMO", demoScene);
	    setScene("DEMO");
	    demoScene.start();
	}

}
