package background;

import info.constants.Background;
import info.constants.Images;

import java.awt.Image;

public class BackGroundLoop extends Thread {

	private int ny;
	private int ny2;
	private int nx;
	private int nx2;
	private Image img;

	public BackGroundLoop() {
		this.img = Images.bglImg;
		System.out.println(img.getWidth(null));
	}

	public void run() {

		int nivel = 5000; // 1000 secs. cm tirar isto?
		try {

			switch (Background.loop) {

			case 0:
				nx2 = img.getWidth(null);
				nx = img.getWidth(null)*2;
				for (int j = 0; j != nivel * img.getWidth(null); j++) {
					move();
					sleep(6);
				}
				break;

			case 1:
				ny2 = img.getHeight(null);
				for (int j = 0; j != nivel * img.getHeight(null); j++) {
					move();
					sleep(6);
				}
				break;
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void move() {

		switch (Background.loop) {

		case 0:
			nx2 -= 1;
			nx -= 1;
			break;

		case 1:
			ny2 = ny2 + 1;
			ny = ny + 1;
			break;
		}

	}

	public int getNY() {
		return ny;
	}

	public void setNY(int ny) {
		this.ny = ny;
	}

	public int getNY2() {
		return ny2;
	}

	public void setNY2(int ny2) {
		this.ny2 = ny2;
	}

	public int getNX() {
		return nx;
	}

	public void setNX(int nx) {
		this.nx = nx;
	}

	public int getNX2() {
		return nx2;
	}

	public void setNX2(int nx2) {
		this.nx2 = nx2;
	}

	public int getHeight() {
		return img.getHeight(null);
	}

	public int getWidth() {
		return img.getWidth(null);
	}

	public Image getImg() {
		return img;
	}

}