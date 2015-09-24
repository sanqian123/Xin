package com.sk.pojo;

public class Uesr {
	private int uid;
	private String name;
	private String password;
	private String identity;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public Uesr(int uid, String name, String password, String identity) {
		super();
		this.uid = uid;
		this.name = name;
		this.password = password;
		this.identity = identity;
	}
	public Uesr() {
		super();
	}

}
