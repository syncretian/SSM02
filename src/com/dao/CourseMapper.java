package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Select;

import com.model.Course;
import com.model.Teacher;

public interface CourseMapper {


	public List<Course> selectAll();


	public int insert(Course c);


	public int delete(Integer cid);

}
