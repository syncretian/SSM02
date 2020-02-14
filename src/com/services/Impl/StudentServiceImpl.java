package com.services.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.StudentMapper;
import com.model.Student;
import com.services.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService{
	@Resource
	StudentMapper studentmapper;

	public boolean insert(Student stu) {
		
		if(studentmapper.insert(stu)>0) {
			return true;
		}else {
			return false;
		}
		
			
	}
	
	public void update(Student stu) {
		studentmapper.update(stu);
	
	}
	
	public boolean delete(Integer sid) {
		if(studentmapper.delete(sid)>0) {
		
			return true;
		}else {
			return false;
		}
	}
	public List<Student> selectAll(){
		List<Student> list = studentmapper.selectAll();
		
		if(list == null) {
			System.out.println("查询结果为空");
		}
		
		return list;
	}
	
	public Student selectById(Integer sid){
		Student stu = studentmapper.selectById(sid);
		
		if(stu == null) {
			System.out.println("查询结果为空");
		}
		
		return stu;
	}
	
	

}
