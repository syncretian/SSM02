package com.model;

public class Score {

	private int sid;
	private int cid;
	
	private String sname;
	private String cname;
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String tname) {
		this.cname = tname;
	}
	private double score;
	
	
	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Score( int sid, int cid,double score) {
		super();
	
		this.sid = sid;
		this.cid = cid;
	
		this.score = score;
	}

	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}

	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Score [sid=" + sid + ", cid=" + cid +  ", score=" + score + "]";
	}
	
	
}
