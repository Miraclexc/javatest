package algorithm.graph;

import java.awt.Canvas;

import javax.swing.JFrame;

public class Shower {
	protected JFrame windows;
	protected Canvas canvas;

	public Shower(Canvas canvas) {
		this(600, 400, canvas);
	}
	
	public Shower(int width, int height, Canvas canvas) {
		this.windows = new JFrame();
		this.windows.setSize(width, height);
		this.windows.setLocationRelativeTo(null);
		this.windows.setVisible(true);
		this.windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.canvas = canvas;
		this.createCanvas();
	}
	
	public void createCanvas() {
		this.canvas.setSize(this.windows.getWidth(), this.windows.getHeight());
		this.windows.add(this.canvas);
	}

	public JFrame getWindows() {
		return this.windows;
	}

	public Canvas getCanvas() {
		return this.canvas;
	}
}
