package gui_practice;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ent.EntDao;

public class GuiPracticeMain extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	public GuiPracticeMain() {
		init();
	}
	
	private void init() {
		
		// 메인 화면
		JPanel main_p = new JPanel();
		JButton ent, group, singer, alb;

		ent = new JButton("소속사");
		group = new JButton("걸그룹");
		singer = new JButton("가수");
		alb = new JButton("앨범");
		
		ent.setBounds(50, 50, 100, 30);
		group.setBounds(50, 100, 100, 30);
		singer.setBounds(50, 150, 100, 30);
		alb.setBounds(50, 200, 100, 30);
		
		ent.addActionListener(this);
		
		main_p.add(ent);
		main_p.add(group);
		main_p.add(singer);
		main_p.add(alb);
		main_p.setLayout(null);
		
		this.add(main_p);
		this.setLayout(null);
		this.setSize(220, 320);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// -----------------------------------------------------------
		// 소속사
		JLabel ent_l = new JLabel(EntDao.selectTeamCode("01"));
		JPanel ent_p = new JPanel();
		
		
		
		
	}
	
	public static void main(String[] args) {
		new GuiPracticeMain();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
	
}
