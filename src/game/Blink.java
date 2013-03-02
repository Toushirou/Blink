package game;

import info.constants.Communs;
import info.constants.Images;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

import background.BackGroundLoop;

public class Blink extends JFrame {

	
	private BackGroundLoop bgl ;
	
	public Blink() {
		
		setTitle(Communs.title);
		setSize(getPreferredSize());
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		init();

	}

	public Dimension getPreferredSize() {
		return new Dimension(Images.bglImg.getWidth(null), Images.bglImg.getHeight(null));
	}
	
	public void init() {

		bgl = new BackGroundLoop();
		
		setLayout(new GridLayout(1, 1, 0, 0));

		Screen screen = new Screen(this, bgl);

		Thread screenThread = new Thread(screen);
		
		add(screen);
		setVisible(true);
		
		screenThread.start();
		
	}

	public static void main(String[] args) {
		Blink start = new Blink();
	}

}
