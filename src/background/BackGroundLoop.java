package background;

import java.awt.Image;

import javax.swing.ImageIcon;

public class BackGroundLoop extends Thread {

	private double ny = 0;
	private Image img;
	private double ny2;
	
	public BackGroundLoop (String img){
		this.img =  new ImageIcon(img).getImage();
	}
	
	public void run() {
		ny2 = img.getHeight(null);
		int nivel = 5000; // 1000 secs. cm tirar isto?
		try {
			for (int j = 0; j != nivel * img.getHeight(null); j++) {
				move();
				sleep(6);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void move() {
		ny2 = ny2 + 1;
		ny = ny + 1;	
	}
	
	public double getNY() {
			return ny;
	}
	public void setNY(double ny) {
			this.ny = ny;
	}
	public double getNY2() {
			return ny2;
	}
	public void setNY2(double ny2) {
			this.ny2 = ny2;
	}
	
	public double getHeight() {
		return img.getHeight(null);
	}

}