package gui_practice;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class practice {

	private JFrame frame;

	public practice() {
		init();
	}
	
	
	private void init() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		
		JPanel panel_search = new JPanel();
		panel_search.setBounds(0, 0, 200, 100);
		panel_search.setVisible(true);
		frame.add(panel_search);
		
		JLabel search_title = new JLabel();
		search_title.setBounds(80, 50, 40, 50);
		panel_search.add(search_title);
		
		
	}

	public static void main(String[] args) {
		new practice();
	}

}
