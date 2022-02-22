package gui_practice;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class practice2 {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		JButton btn = new JButton("버튼");
		JLabel label = new JLabel("Hello");
		
		label.setBounds(10, 10, 50, 20);
		btn.setBounds(50, 50, 100, 50);
		panel2.setBounds(0,0,450,450);
		panel.setBounds(0, 0, 450, 450);
		
		// 화면 전환
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				panel2.setVisible(true);
			}
		});
		
		panel.add(label);
		panel.add(btn);	
		panel.setLayout(null);
		panel.setBackground(Color.blue);
		
		panel2.setBackground(Color.orange);
		
		frame.add(panel);
		frame.add(panel2);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		
	}
}
