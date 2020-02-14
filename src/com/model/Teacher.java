package com.model;

public class Teacher {
	private Integer tid;
	private String tname;
	private String title;
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(Integer tid, String tname, String title) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.title = title;
	}
	@Override
	public String toString() {
		return tname;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
