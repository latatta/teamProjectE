package ent;

import java.sql.Date;

public class Ent {
	private int ent_code;
	private String ent_name;
	private String tel;
	private String ceo;
	private String address;
	private Date f_date;
	
	// 생성자
	public Ent() {	}
	
	public Ent(int ent_code, String ent_name, String tel, String ceo, String address, Date f_date) {
		super();
		this.ent_code = ent_code;
		this.ent_name = ent_name;
		this.tel = tel;
		this.ceo = ceo;
		this.address = address;
		this.f_date = f_date;
	}

	// getter, setter
	public int getEnt_code() {
		return ent_code;
	}

	public void setEnt_code(int ent_code) {
		this.ent_code = ent_code;
	}

	public String getEnt_name() {
		return ent_name;
	}

	public void setEnt_name(String ent_name) {
		this.ent_name = ent_name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getF_date() {
		return f_date;
	}

	public void setF_date(Date f_date) {
		this.f_date = f_date;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
