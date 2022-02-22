package gui;

import java.awt.Color;
import java.awt.Font;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import album.Album;
import album.AlbumDao;

@SuppressWarnings("serial")
public class JM01 extends JFrame{
	
	public JM01() {
		init();
	}
	
	private void init() {
		Album jm01 = AlbumDao.selectAlbum("미쓰에이", "JM01");
		File music = new File("C:\\dev1228\\java_workspace\\teamProject\\music_file\\미쓰에이 1집-Good-bye Baby.wav");

		// 재생 음악 타이틀
		JLabel title = new JLabel(jm01.getT_song());
		title.setFont(new Font("맑은 고딕", Font.BOLD, 30));
//		title.setForeground(Color.WHITE);
		title.setBounds(590, 130, 400, 40);
		
		// 음악 재생
		JButton play = new JButton();
		ImageIcon play_pic = new ImageIcon(JM01.class.getResource("../image_files/playpause.png"));
		play.setIcon(play_pic);
		play.setBackground(Color.white);
		play.setBounds(550,  230, 90, 90);

		// 음악 일시정지
		JButton pause = new JButton();
		ImageIcon pause_pic = new ImageIcon(JM01.class.getResource("../image_files/stop.png"));
		pause.setIcon(pause_pic);
		pause.setBackground(Color.white);
		pause.setBounds(750,  230, 90, 90);
		
		// 앨범 사진
		JLabel image = new JLabel();	
		ImageIcon alb_pic = new ImageIcon(JM01.class.getResource("../image_files/Miss_1.jpg"));
		image.setIcon(alb_pic);
		image.setBounds(100, 50, 350, 350);
		
		// 정보란
		// 그룹 이름
		JLabel team_name_l = new JLabel("그룹 :");
		team_name_l.setBounds(220, 430, 800, 100);
		team_name_l.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		
		JLabel team_name = new JLabel(jm01.getTeam_name());
		team_name.setBounds(600, 430, 800, 100);
		team_name.setFont(new Font("맑은 고딕", Font.BOLD, 25));
//		team_name.setForeground(Color.WHITE);

		// 앨범명
		JLabel alb_name_l = new JLabel("앨범명 :");
		alb_name_l.setBounds(220,  500,  800, 100);
		alb_name_l.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		
		JLabel alb_name = new JLabel(jm01.getAlb_name());
		alb_name.setBounds(600,  500,  800, 100);
		alb_name.setFont(new Font("맑은 고딕", Font.BOLD, 25));
//		alb_name.setForeground(Color.WHITE);

		// 곡 수
		JLabel song_cnt_l = new JLabel(String.format("곡 수 :"));
		song_cnt_l.setBounds(220,  570,  800, 100);
		song_cnt_l.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		
		JLabel song_cnt = new JLabel(String.format("%d", jm01.getSong_cnt()));
		song_cnt.setBounds(600,  570,  800, 100);
		song_cnt.setFont(new Font("맑은 고딕", Font.BOLD, 25));
//		song_cnt.setForeground(Color.WHITE);

		// 타이틀 곡
		JLabel t_song_l = new JLabel(String.format("타이틀 곡 :"));
		t_song_l.setBounds(220,  640,  800, 100);
		t_song_l.setFont(new Font("맑은 고딕", Font.BOLD, 25));

		JLabel t_song = new JLabel( jm01.getT_song());
		t_song.setBounds(600,  640,  800, 100);
		t_song.setFont(new Font("맑은 고딕", Font.BOLD, 25));
//		t_song.setForeground(Color.WHITE);

		// 발매일
		JLabel s_date_l = new JLabel("발매일 :");
		s_date_l.setBounds(220,  710,  800, 100);
		s_date_l.setFont(new Font("맑은 고딕", Font.BOLD, 25));

		JLabel s_date = new JLabel(String.format("%s", jm01.getS_date()));
		s_date.setBounds(600,  710,  800, 100);
		s_date.setFont(new Font("맑은 고딕", Font.BOLD, 25));
//		s_date.setForeground(Color.WHITE);
		
		// 뒤로가기 버튼
		JButton back = new JButton();
		ImageIcon back_pic = new ImageIcon(JM01.class.getResource("../image_files/back.png"));
		back.setIcon(back_pic);
		back.setBackground(Color.white);
		back.setBounds(200,  830, 70, 70);

		// 홈버튼
		JButton home = new JButton();
		ImageIcon home_pic = new ImageIcon(JM01.class.getResource("../image_files/home.png"));
		home.setIcon(home_pic);
		home.setBackground(Color.white);
		home.setBounds(400,  830, 70, 70);
		
		JPanel info = new JPanel();
		info.add(image);
		info.add(team_name_l);
		info.add(team_name);
		info.add(alb_name_l);
		info.add(alb_name);
		info.add(song_cnt_l);
		info.add(song_cnt);
		info.add(t_song_l);
		info.add(t_song);
		info.add(s_date_l);
		info.add(s_date);
		info.add(play);
		info.add(pause);
		info.add(title);
		info.add(back);
		info.add(home);
		info.setBounds(0, 0, 1000, 1000);
		info.setLayout(null);
//		info.setBackground(Color.BLACK);
		
		this.setLayout(null);
		this.add(info);
		this.setSize(1000, 1000);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {	
		new JM01();
	}

}
