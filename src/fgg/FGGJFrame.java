package fgg;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FGGJFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public FGGJFrame() {
		setTitle("石头 剪刀 布");
		setVisible(true);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		JLabel label = new JLabel("石头 剪刀 布");
		label.setFont(new Font("宋体", Font.PLAIN, 30));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton button = new JButton("开始游戏");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent) {
				System.out.println("test");
			}
		});
		button.setBackground(UIManager.getColor("Button.disabledShadow"));
		button.setFont(new Font("楷体", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(200)
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
					.addGap(200))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(222)
					.addComponent(button, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
					.addGap(212))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(label)
					.addGap(30)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(218, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
