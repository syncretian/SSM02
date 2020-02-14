package com.model;

import java.util.List;

public class Grade {
	private int gid;
	private String grade;
	private String class_name;
	private List<Student> students;
	
	public Grade() {
		super();
		
	}
	
	public Grade(int gid, String grade, String class_name, List<Student> students) {
		super();
		this.gid = gid;
		this.grade = grade;
		this.class_name = class_name;
		this.students = students;
	}

	public Grade( String grade, String class_name) {
		this.grade = grade;
		this.class_name = class_name;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder( grade + class_name);
		
		if(students != null) {
			str.append("\n学生信息：");
			for(Student s : students) {
				str.append("\n"+s.toString());
			}
		}
		return str.toString();
	}

	public int getGid() {
		return gid;
	}
	public void setGid(int cid) {
		this.gid = cid;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	

}
