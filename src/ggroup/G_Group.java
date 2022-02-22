package ggroup;

import java.sql.Date;

public class G_Group {
	
	private int ent_code;
	private String team_name;
	private int member_cnt;
	private String d_song;
	private Date d_date;
	private String f_name;
	private String leader;
	
	public G_Group(int ent_code, String team_name, int member_cnt, String d_song, Date d_date, String f_name,
			String leader) {
		this.ent_code = ent_code;
		this.team_name = team_name;
		this.member_cnt = member_cnt;
		this.d_song = d_song;
		this.d_date = d_date;
		this.f_name = f_name;
		this.leader = leader;
	}
	public G_Group() { }
	
	@Override
	public String toString() {
		return String.format("%5d", ent_code)+
				String.format("%20s", team_name)+
				String.format("%5d", member_cnt)+
				String.format("%20s", d_song)+
				String.format("%20s", d_date)+
				String.format("%15s", f_name)+
				String.format("%40d", leader);
	}
	
	public int getEnt_code() {
		return ent_code;
	}
	public void setEnt_code(int ent_code) {
		this.ent_code = ent_code;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public int getMember_cnt() {
		return member_cnt;
	}
	public void setMember_cnt(int member_cnt) {
		this.member_cnt = member_cnt;
	}
	public String getD_song() {
		return d_song;
	}
	public void setD_song(String d_song) {
		this.d_song = d_song;
	}
	public Date getD_date() {
		return d_date;
	}
	public void setD_date(Date d_date) {
		this.d_date = d_date;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	
}
