package com.dao;

import com.model.Grade;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GradeMapper {
	public int insert(Grade cla);
	public int update(Grade cla);
	public int delete(Integer gid);
	
	public Grade selectGradeById(@Param("gid")Integer gid);
	public List<Grade> selectAll();
	public Grade selectClassInfoById(int gid);
	public List<Grade> selectAll1();
}
