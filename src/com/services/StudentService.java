package com.services;

import java.util.List;

import com.model.Student;

public interface StudentService {

	public boolean insert(Student stu) ;
	
	public void update(Student stu) ;
	
	public boolean delete(Integer sid) ;
	
	public List<Student> selectAll();
	
	public Student selectById(Integer sid);


}
