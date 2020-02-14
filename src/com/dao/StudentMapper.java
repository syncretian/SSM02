package com.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;


import com.model.Student;

public interface StudentMapper {

	public int insert(Student stu);
	
	public Student selectById(Integer sid);
	
	public List<Student> selectStudentByClass_id(Integer cid);
	public List<Student> selectAll();


	public int delete(Integer sid);

	public int update(Student stu);
	
}
