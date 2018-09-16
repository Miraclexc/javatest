package test.jframetest;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageGUI extends JFrame {
	private static final long serialVersionUID = 1L;

	public ImageGUI(Image image) {
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		JPanel p = new JPanel() {
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics arg0) {
				super.paintComponent(arg0);
				arg0.drawImage(image, 0, 0, null);
			}
		};
		this.setContentPane(p);
		this.setVisible(true);
	}
}
