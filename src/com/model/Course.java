package com.model;

public class Course {
	private Integer cid;
	private String cname;
	private Integer teacher_id;
	private String term;
	
	private Teacher tea;
	public Teacher getTea() {
		return tea;
	}
	public void setTea(Teacher tea) {
		this.tea = tea;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(int cid, String cname, int teacher_id, String term) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.teacher_id = teacher_id;
		this.term = term;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", teacher_id=" + teacher_id + ", term=" + term + ", tea="
				+ tea + "]";
	}

	
	

}
