package sprites;

public class Sprite {

	private int width;
	private int height;
	private int[] pixels;
	
	public Sprite(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int [width * height];
	}

	public void clear(int colour){
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = colour;
		}
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public int[] getPixels(){
		return pixels;
	}
}
