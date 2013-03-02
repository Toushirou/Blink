package player;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Player extends Applet implements Runnable {

	private static Player player = null;
	private int x;
	private int y;

	private Image playerImg = new ImageIcon("").getImage();
	private Graphics second;

	private Player() {
		
	}

	public void update(Graphics g) {
		
		if (playerImg == null) {
			playerImg = createImage(getWidth(), getHeight());
			second = playerImg.getGraphics();
		}
		second.setColor(getBackground());
		second.fillRect(0, 0, getWidth(), getHeight());
		second.setColor(getForeground());
		paint(second);

		g.drawImage(playerImg, 0, 0, this);
		
	}

	public static Player getInstance() {

		if (player == null) {
			player = new Player();
		}

		return Player.player;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
