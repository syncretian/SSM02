package com.model;

public class Student {
	private Integer sid;
	private String sname;
	private Integer cid;


	private Grade class_id;
	private String sex;
	
	private Integer age;
	
	private Integer aid;
	private Address address;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}



	
	

	public Student(Integer sid, String sname, Integer cid, Grade class_id, String sex, Integer age, Integer aid,
			Address address) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.cid = cid;
		this.class_id = class_id;
		this.sex = sex;
		this.age = age;
		this.aid = aid;
		this.address = address;
	}






	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", cid=" + cid + ", class_id=" + class_id + ", sex=" + sex
				+ ", age=" + age + ", aid=" + aid + ", address=" + address + "]";
	}

	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Grade getClass_id() {
		return class_id;
	}
	public void setClass_id(Grade class_id) {
		this.class_id = class_id;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}
	
	public Integer getCid() {
		return cid;
	}






	public void setCid(Integer cid) {
		this.cid = cid;
	}

}
