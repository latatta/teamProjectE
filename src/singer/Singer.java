package singer;

import java.sql.Date;

public class Singer {

	private String num;
	private String name;
	private Date birth;
	private String nat;
	private String team_name;
	private String part;
	private String sns;
	
	public Singer(String num, String name, Date birth, String nat, String team_name, String part, String sns) {
		this.num = num;
		this.name = name;
		this.birth = birth;
		this.nat = nat;
		this.team_name = team_name;
		this.part = part;
		this.sns = sns;
	}
	
	public Singer() { }
	
	@Override
	public String toString() {
		return String.format("%10s", num)+
				String.format("%4s", name)+
				String.format("%20s", birth)+
				String.format("%10s", nat)+
				String.format("%20s", team_name)+
				String.format("%15s", part)+
				String.format("%40d", sns);
	}
	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getNat() {
		return nat;
	}

	public void setNat(String nat) {
		this.nat = nat;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getSns() {
		return sns;
	}

	public void setSns(String sns) {
		this.sns = sns;
	}
	
	
	
	
	
}
