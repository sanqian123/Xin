package com.bank.pojo;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String ucard;
	private String upwd;
	private String countpwd;
	private String utype;
	private Float umoney;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String ucard, String upwd, String countpwd, String utype,
			Float umoney) {
		this.ucard = ucard;
		this.upwd = upwd;
		this.countpwd = countpwd;
		this.utype = utype;
		this.umoney = umoney;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUcard() {
		return this.ucard;
	}

	public void setUcard(String ucard) {
		this.ucard = ucard;
	}

	public String getUpwd() {
		return this.upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getCountpwd() {
		return this.countpwd;
	}

	public void setCountpwd(String countpwd) {
		this.countpwd = countpwd;
	}

	public String getUtype() {
		return this.utype;
	}

	public void setUtype(String utype) {
		this.utype = utype;
	}

	public Float getUmoney() {
		return this.umoney;
	}

	public void setUmoney(Float umoney) {
		this.umoney = umoney;
	}

}