package com.services;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

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

public interface CommonService {


	
	public List<Course> selectAllCourse();
	
	public List<Score> selectAllScore();

	public List<Address> selectAllAddress();

	public List<Teacher> selectAllTeacher();

	public boolean insertCourse(Course c) ;

	public boolean addFile(MyFile file);

	public boolean insertScore(Score s) ;

	public boolean deletScore(Integer sid , Integer cid) ;

	public boolean deleteCourse(Integer cid);
	
}
