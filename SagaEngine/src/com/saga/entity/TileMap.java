package com.saga.entity;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TileMap extends Entity {
	
	private ArrayList<ArrayList<Tile>> tiles;
	
	public TileMap(String path, ArrayList<BufferedImage> textures) {
		tiles = new ArrayList<ArrayList<Tile>>();
		load(path, textures);
	}
	
//	public Tile createTile(BufferedImage texture, int x, int y) {
//		try {
//			Tile tile = new Tile(x, y, texture);
//			return tile;
//		} catch (Exception e) {
//			System.out.println("Couldn't create tile of type: " + index);
//		}
//		return null;
//	}
	
	public void load(String path, ArrayList<BufferedImage> textures) {
		try {
			List<String> lines = Files.readAllLines(Paths.get(path));
			for (int y = 0; y < lines.size(); y++) {
				tiles.add(new ArrayList<Tile>());
				String line = lines.get(y);
				for (int x = 0; x < line.length(); x++) {
					int tileIndex = Character.getNumericValue(line.charAt(x));
					Tile tile = new Tile(textures.get(tileIndex), x, y);
					tiles.get(y).add(tile);
				}
			}
		} catch (IOException e) {
			System.out.println("Couldn't load file: " + path.toString());
		}
	}
	
	public Tile getTile(int x, int y) {
		return tiles.get(y).get(x);
	}
	
	public void setTile(int x, int y, Tile tile) {
		tiles.get(y).set(x, tile);
	}
	
	public ArrayList<ArrayList<Tile>> getTiles() {
		return tiles;
	}

}
