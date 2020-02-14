package com.services.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.stereotype.Service;

import com.dao.AddressMapper;
import com.dao.CourseMapper;
import com.dao.MyFileMapper;
import com.dao.ScoreMapper;
import com.dao.TeacherMapper;
import com.dao.UserMapper;
import com.model.Address;
import com.model.Course;
import com.model.MyFile;
import com.model.Score;
import com.model.Teacher;
import com.services.CommonService;

@Service("commonService")
public class CommonServiceImpl implements CommonService {

	@Resource
	CourseMapper coursemapper ;
	@Resource
	ScoreMapper scoremapper ;
	@Resource
	AddressMapper addressmapper ;
	@Resource
	TeacherMapper teachermapper ;
	@Resource
	MyFileMapper myfilemapper ;
	public List<Course> selectAllCourse(){
		
		 List<Course> cc = coursemapper.selectAll();
		 System.out.println(cc);
		return cc;
	}
	
	public List<Score> selectAllScore(){
		
		
		return scoremapper.selectAll();
	}

	public List<Address> selectAllAddress() {
		
		return addressmapper.selectAllAddress();
	}

	public List<Teacher> selectAllTeacher() {
		
		return teachermapper.selectAll();
	}

	public boolean insertCourse(Course c) {
		
		if( coursemapper.insert(c) > 0 ) {
			
			return true;
		}else{
			return false;
		}
	}

	public boolean addFile(MyFile file) {
		
		if(myfilemapper.addFile(file) > 0 ) {
		
			return true;
		}else {
			return false;
		}
	}

	public boolean insertScore(Score s) {
		
		if(scoremapper.insert(s) >0 ) {
			
			return true;
		}else{
			return false;
		}
	}

	public boolean deletScore(Integer sid , Integer cid) {
	
		if(scoremapper.delete(sid,cid) >0 ) {
		
			return true;
		}else{
			return false;
		}
	}

	public boolean deleteCourse(Integer cid) {
		
		if(coursemapper.delete(cid) >0 ) {
		
			return true;
		}else{
			return false;
		}
	}
	
	@Test
	public void test () {
		Teacher t = teachermapper.selectById(1);
		System.out.println(t);
	}
}
