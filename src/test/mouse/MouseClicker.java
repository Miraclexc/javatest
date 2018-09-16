package test.mouse;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class MouseClicker {
	public static Clicker startClick(long interval) throws AWTException {
		Robot robot = new Robot();
		return new Clicker(robot, interval);
	}
	
	public static class Clicker implements Runnable {
		protected Robot robot;
		protected long interval;
		protected boolean state;
		
		public Clicker(Robot robot, long interval) {
			this.robot = robot;
			this.interval = interval;
			this.state = true;
		}
		
		@Override
		public void run() {
			int time = 0;
			while(this.state || time > 100) {
				this.robot.mousePress(InputEvent.BUTTON1_MASK);
				this.robot.delay(10);
				this.robot.mouseRelease(InputEvent.BUTTON1_MASK);
				time++;
				try {
					Thread.sleep(this.interval);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		public void stop() {
			this.state = false;
		}
	}
}
