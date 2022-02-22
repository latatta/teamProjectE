package gui_practice;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class VolumeControl {
	public static void main(String[] args) {

		JFrame f = new JFrame();
		f.setSize(200,240);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		f.setVisible(true);
		
		JLabel l = new JLabel();
		l.setText("슬라이더를 움직이세요.");
		l.setBounds(20,20,150,40);
		f.add(l);
		
		JFXPanel panel = new JFXPanel();
		
		Media m = new Media("C:\\dev1228\\java_workspace\\teamProject\\music_file\\미쓰에이 1집-Good-bye Baby.wav");
		MediaPlayer p = new MediaPlayer(m);
		p.play();		
		
		JSlider s = new JSlider();
		s.setBounds(20, 100, 150, 40);
		f.add(s);
		
		s.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent e) {
//				l.setText(""+s.getValue());
				p.setVolume((double)s.getValue()/100);
			}
		});
		
	}
}
