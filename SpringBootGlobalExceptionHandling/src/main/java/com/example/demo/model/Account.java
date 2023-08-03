package com.example.demo.model;

public class Account {
	
	private int aid;
	
	private String aname;
	
	private String atype;
	
	private String email;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAtype() {
		return atype;
	}

	public void setAtype(String atype) {
		this.atype = atype;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Account [aid=" + aid + ", aname=" + aname + ", atype=" + atype + ", email=" + email + "]";
	}
	
	

}
