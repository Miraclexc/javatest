package windows.jframe;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JframeMain extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -978324884294745660L;
	public JFrame windows = new JFrame("Hello world");
	public JframeMain() {
		windows.setVisible(true);
		windows.setSize(600, 500);
		JLabel label = new JLabel("qwqwq", JLabel.CENTER);
		windows.add(label);
		windows.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent paramWindowEvent) {
				System.out.println("qwq");
			}

			@Override
			public void windowClosing(WindowEvent paramWindowEvent) {
				System.out.println("233");
			}

			@Override
			public void windowClosed(WindowEvent paramWindowEvent) {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public void windowIconified(WindowEvent paramWindowEvent) {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public void windowDeiconified(WindowEvent paramWindowEvent) {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public void windowActivated(WindowEvent paramWindowEvent) {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public void windowDeactivated(WindowEvent paramWindowEvent) {
				// TODO 自动生成的方法存根
				
			}
			
		});
	}
}
