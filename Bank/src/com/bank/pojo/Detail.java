package com.bank.pojo;

/**
 * Detail entity. @author MyEclipse Persistence Tools
 */

public class Detail implements java.io.Serializable {

	// Fields

	private Integer did;
	private Integer uid;
	private String udetail;

	// Constructors

	/** default constructor */
	public Detail() {
	}

	/** full constructor */
	public Detail(Integer uid, String udetail) {
		this.uid = uid;
		this.udetail = udetail;
	}

	// Property accessors

	public Integer getDid() {
		return this.did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUdetail() {
		return this.udetail;
	}

	public void setUdetail(String udetail) {
		this.udetail = udetail;
	}

}