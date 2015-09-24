package com.sk.pojo;

public class Flow {
	private int wid;
	private int uid;
	private int lid;
	private String reply;
	public Flow() {
		super();
	}
	public Flow(int wid, int uid, int lid, String reply) {
		super();
		this.wid = wid;
		this.uid = uid;
		this.lid = lid;
		this.reply = reply;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}

}
