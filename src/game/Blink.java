package game;

import javax.swing.JFrame;

public class Blink extends JFrame {

	public Blink() {
		setTitle(Constants.title);
		setSize(Constants.windowSize);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		init();
	}

	public void init() {
		setLayout(new GridLayout(1, 1, 0, 0));

		Screen screen = new Screen(this);
		add(screen);
		setVisible(true);

	}

	public static void main(String[] args) {
		Blink frame = new Blink();
	}

}
