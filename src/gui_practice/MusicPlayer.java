package gui_practice;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class MusicPlayer {
	//  오디오 변환기 : https://audio-convert.com/ko

	static void playMusic(String musicLocation) {
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
	public static void main(String[] args) {
		playMusic("C:\\\\dev1228\\\\java_workspace\\\\teamProject\\\\music_file\\\\미쓰에이 1집-Good-bye Baby.wav");
	}
}
