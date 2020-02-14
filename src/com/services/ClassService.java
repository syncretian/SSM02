package com.services;

import com.model.Grade;

import java.util.List;


public interface ClassService {

	
	public void insert(Grade cla);
	
	public void update(Grade cla);
	public void delete(Integer cid);
	public List<Grade> selectAll();
	public List<Grade> selectAll1();
	
	public Grade selectGradeById(Integer cid);

	public Grade selectClassInfoById( int cid ) ;
	
}
