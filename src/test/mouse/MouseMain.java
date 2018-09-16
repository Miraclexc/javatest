package test.mouse;

import java.awt.AWTException;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MouseMain {
	public static void main(String[] args) throws AWTException {
		Thread t = new Thread(MouseClicker.startClick(100));
		t.start();
	}
}
