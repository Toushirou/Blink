package game;

import info.constants.Background;

import java.awt.Graphics;

import javax.swing.JPanel;

import background.BackGroundLoop;

public class Screen extends JPanel implements Runnable {

	private BackGroundLoop bgl;
	private int vertical = 0;
	private boolean pause = true;

	public Screen(Blink blink, BackGroundLoop bgl) {
		this.bgl = bgl;
		bgl.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Desenha Background loop

		if (vertical == 10000) {
			bgl.setNX2(bgl.getImg().getWidth(null));
			bgl.setNX(bgl.getImg().getWidth(null) * 2);
			if (Background.loop == 0) {
				Background.loop = 1;
				vertical = 0;
			} else {
				Background.loop = 0;
				vertical = 0;
			}
			
		} else {
			vertical++;
		}
		
		switch (Background.loop) {

		case 0:
			
			if ((bgl.getNX()) <= 0) {
				bgl.setNX(bgl.getWidth() * 2);
			}
			if ((bgl.getNX2()) <= 0) {
				bgl.setNX2(bgl.getWidth());
			}
			if (bgl.getNX2() == bgl.getNX()) {
				bgl.setNX(bgl.getWidth() + bgl.getNX2());
			}

			g.drawImage(bgl.getImg(), (int) (bgl.getNX2() - (bgl.getWidth())),
					0, null);

			if ((bgl.getNX() > bgl.getWidth())) {
				g.drawImage(bgl.getImg(),
						(int) ((bgl.getNX() - bgl.getWidth())), 0, null);
			}

			if ((bgl.getNX() > bgl.getWidth())
					&& (bgl.getNX() - bgl.getWidth()) == bgl.getNX2()) {
				g.drawImage(bgl.getImg(), (int) ((bgl.getNX())), 0, null);
			}
			break;

		case 1:
			if ((bgl.getNY2() - bgl.getHeight()) % (4 * bgl.getHeight()) == bgl
					.getHeight()) {
				bgl.setNY(0);
			}
			if ((bgl.getNY2() - bgl.getHeight() + bgl.getHeight())
					% (4 * bgl.getHeight()) == (2 * bgl.getHeight())) {
				bgl.setNY2(bgl.getHeight());
			}

			g.drawImage(bgl.getImg(), 0,
					(int) (bgl.getNY2() - (bgl.getHeight())), null);
			if ((bgl.getNY2() - bgl.getHeight()) >= 0) {
				g.drawImage(bgl.getImg(), 0,
						(int) ((bgl.getNY() - bgl.getHeight())), null);
			}
			break;

		}

	}

	@Override
	public void run() {
		while (pause) {
			repaint();
		}
	}
}
