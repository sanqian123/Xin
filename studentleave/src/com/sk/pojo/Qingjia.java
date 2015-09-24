package com.sk.pojo;

public class Qingjia {
	private int lid;
	private int uid;
	private String name;
	private String reason;
	private String starttime;
	private String endtime;
	private String daoyuan;
	private String director;
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
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
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getDaoyuan() {
		return daoyuan;
	}
	public void setDaoyuan(String daoyuan) {
		this.daoyuan = daoyuan;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Qingjia(int lid, int uid, String name, String reason,
			String starttime, String endtime, String daoyuan, String director) {
		super();
		this.lid = lid;
		this.uid = uid;
		this.name = name;
		this.reason = reason;
		this.starttime = starttime;
		this.endtime = endtime;
		this.daoyuan = daoyuan;
		this.director = director;
	}
	public Qingjia() {
		super();
	}

}
