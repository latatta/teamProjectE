package album;

import java.sql.Date;

public class Album {
	private String alb_code;
	private String team_name;
	private String alb_name;
	private int song_cnt;
	private String t_song;
	private Date s_date;
	
	// 생성자
	public Album() {	}
	
	public Album(String alb_code, String team_name, String alb_name, int song_cnt, String t_song, Date s_date) {
		super();
		this.alb_code = alb_code;
		this.team_name = team_name;
		this.alb_name = alb_name;
		this.song_cnt = song_cnt;
		this.t_song = t_song;
		this.s_date = s_date;
	}

	// getter, setter
	public String getAlb_code() {
		return alb_code;
	}

	public void setAlb_code(String alb_code) {
		this.alb_code = alb_code;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getAlb_name() {
		return alb_name;
	}

	public void setAlb_name(String alb_name) {
		this.alb_name = alb_name;
	}

	public int getSong_cnt() {
		return song_cnt;
	}

	public void setSong_cnt(int song_cnt) {
		this.song_cnt = song_cnt;
	}

	public String getT_song() {
		return t_song;
	}

	public void setT_song(String t_song) {
		this.t_song = t_song;
	}

	public Date getS_date() {
		return s_date;
	}

	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
