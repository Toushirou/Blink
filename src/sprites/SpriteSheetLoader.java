package sprites;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Game.Game;

public class SpriteSheetLoader {

	public int[] sheetPixels;
	public int[] pixels;
	
	public SpriteSheetLoader() {

	}

	public static Sprite[][] cutTiles(String filename, int width, int height) {
		return cutTiles(filename, width, height, 0, 0);
	}
	
	public static Sprite[][] cutTiles(String filename, int width, int height, int xOffs, int yOffs) {
		
		try {
			BufferedImage image = ImageIO.read(Game.class.getResource(filename));
			
			int xTiles = (image.getWidth() - xOffs) / width;
			int yTiles = (image.getHeight() - yOffs) / height;
			
			Sprite[][] result = new Sprite[xTiles][yTiles];
			
			for (int x = 0; x < xTiles; x++) {
				for (int y = 0; y < yTiles; y++) {
					result[x][y] = new Sprite(width , height);
					image.getRGB(xOffs + x * width, yOffs + y * height, width, height, result[x][y].getPixels(), 0, width); 
						// Fill all pixels at the image to -> result
				}
			}	
			return result;
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
		}
		
		return null;
	}
	
}
