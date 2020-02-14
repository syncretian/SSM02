package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.model.Teacher;

public interface TeacherMapper {


	List<Teacher> selectAll();

	
	Teacher selectById(@Param("tid")Integer tid);
}
