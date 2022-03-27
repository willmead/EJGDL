package com.saga.utility;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.saga.entity.Tile;

public class Texture {
	
	public static BufferedImage loadTexture(String path) {
		try {
			BufferedImage originalImage = ImageIO.read(new File(path));
			return resizeTexture(originalImage, Tile.getTileSize(), Tile.getTileSize());
		} catch (IOException e) {
			System.out.println("Couldn't load " + path);
		}
		return null;
	}
	
	public static BufferedImage resizeTexture(BufferedImage image, int width, int height) {
		Image temp = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	    BufferedImage scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2d = scaledImage.createGraphics();
	    g2d.drawImage(temp, 0, 0, null);
	    g2d.dispose();
	    return scaledImage;
	}

}
