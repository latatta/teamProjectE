package gui_practice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MusicPractice {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JButton btn = new JButton();
		JButton btn1 = new JButton();
		
		String m = "C:\\dev1228\\java_workspace\\teamProject\\music_file\\미쓰에이 1집-Good-bye Baby.wav";
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PlaySound(m);
			}
		});
		
		frame.add(btn);
		frame.setVisible(true);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	static void PlaySound(String musicLocation) {
		try {
			File musicPath = new File(musicLocation);
			
			if (musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				
				JOptionPane.showMessageDialog(null, "Hit OK to pause");
				long clipTimePosition = clip.getMicrosecondPosition();
				clip.stop();
				
				JOptionPane.showMessageDialog(null, "Hit OK to resume");
				clip.setMicrosecondPosition(clipTimePosition);
				clip.start();
				
				JOptionPane.showMessageDialog(null, "Press OK to stop playing");
			}
			
			else System.out.println("Can't find file");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	static void PauseSound(File Sound) {
		
	}

}
