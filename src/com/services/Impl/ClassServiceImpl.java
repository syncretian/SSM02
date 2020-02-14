package com.services.Impl;

import com.dao.GradeMapper;
import com.model.Grade;
import com.services.ClassService;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("gradeService")
public class ClassServiceImpl implements ClassService {

	@Resource
	GradeMapper grademapper;
	
	public void insert(Grade cla) {
		
		grademapper.insert(cla);	
				
	}
	
	public void update(Grade cla) {
		grademapper.update(cla);
	}
	
	public void delete(Integer cid) {
		grademapper.delete(cid);
	}
	public List<Grade> selectAll(){
		List<Grade> list = grademapper.selectAll();
		
		if(list == null) {
			System.out.println("查询结果为空");
		}
		
		return list;
	}
	public List<Grade> selectAll1(){
		List<Grade> list = grademapper.selectAll1();
		
		if(list == null) {
			System.out.println("查询结果为空");
		}
		
		return list;
	}
	
	public Grade selectGradeById(Integer cid){
		Grade cla = grademapper.selectGradeById(cid);
		
		if(cla == null) {
			System.out.println("查询结果为空");
		}
		
		return cla;
	}

	@Override
	public Grade selectClassInfoById(int cid) {
		
			Grade cla = grademapper.selectClassInfoById(cid);
			
			if(cla == null) {
				System.out.println("查询结果为空");
			}
			
			return cla;
		
	}
	


}
