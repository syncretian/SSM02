package com.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.Address;
import com.model.Course;
import com.model.Grade;
import com.model.Score;
import com.model.Student;
import com.model.Teacher;
import com.model.User;
import com.services.ClassService;
import com.services.CommonService;
import com.services.StudentService;
import com.services.UserService;


@Controller
public class UserServlet {
	@Resource
	UserService userService;
	@Resource
	StudentService studentService;
	@Resource
	CommonService commonService;
	@Resource
	ClassService gradeService;
	
	@RequestMapping("login")
	public String UserLogin(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login...");
		ModelAndView model = new ModelAndView();
		
		String uname = request.getParameter("loginUsername");
		String psd = request.getParameter("loginPassword");
		User user = new User(uname,psd);
		System.out.println("user:"+user);
		
		User user1 = null;
		
		user1 = userService.selectOne(user);
		
		if(user1 != null) {
			request.setAttribute("user", user1);
			return "/index.jsp";
			
		}else {
			return "redirect:/login.html";
		}
		
	}


	@RequestMapping("Studentfind")
	public ModelAndView showStudent(HttpServletRequest request,HttpServletResponse response) {
		List<Student> students = studentService.selectAll();

		ModelAndView mav = new  ModelAndView();
		mav.addObject("students", students);
		mav.setViewName("student.jsp");
		return  mav;
		
	}

	@RequestMapping("Coursefind")
	public ModelAndView showCourse(HttpServletRequest request,HttpServletResponse response) {
	
		List<Course> courses = commonService.selectAllCourse();
	
		ModelAndView mav = new  ModelAndView();
		mav.addObject("courses", courses);
		mav.setViewName("course.jsp");
		return  mav;
		
	}
	
	@RequestMapping("Scorefind")
	public ModelAndView showScore(HttpServletRequest request,HttpServletResponse response) {
	
		List<Score> scores = commonService.selectAllScore();
	
		System.out.println(scores);
		
		ModelAndView mav = new  ModelAndView();
		mav.addObject("scores", scores);
		mav.setViewName("score.jsp");
		return  mav;
		
	}

	@RequestMapping("addPage")
	public ModelAndView addPage(HttpServletRequest request,HttpServletResponse response) {
	
		List<Address> address = commonService.selectAllAddress();
		List<Grade> grade= gradeService.selectAll();
		System.out.println(grade);
		
		ModelAndView mav = new  ModelAndView();
		mav.addObject("address", address);
		mav.addObject("grade", grade);
		mav.setViewName("student_add.jsp");
		return  mav;
		
	}
	
	@RequestMapping("addStudent")
	public void aadStudent(Student s,HttpServletResponse response) throws IOException {
		System.out.println("添加学生："+s);
		
		if(studentService.insert(s)) {
			response.getWriter().write("true");
			System.out.println("新增成功");
		}else {
			response.getWriter().write("false");
			System.out.println("新增失败");
		}
		
	}
	
	@RequestMapping("deleteStudent")
	public void deleteStudent(Integer sid,HttpServletResponse response) throws IOException {
		System.out.println("删除："+sid);
		
		if(studentService.delete(sid)) {
			response.getWriter().write("true");
			System.out.println("删除成功");
		}else {
			response.getWriter().write("false");
			System.out.println("删除失败");
		}
		
	}
	
	@RequestMapping("addCoursePage")
	public ModelAndView addCoursePage(HttpServletRequest request,HttpServletResponse response) {
		
		List<Teacher> teacher = commonService.selectAllTeacher();

		ModelAndView mav = new  ModelAndView();
		
		mav.addObject("teacher", teacher);
		mav.setViewName("course_add.jsp");
		return  mav;
		
	}
	
	
	@RequestMapping("addCourse")
	public void addCourse(Course c) throws IOException {

		System.out.println("添加课程："+c);
		
		if(commonService.insertCourse(c)) {
			
			System.out.println("新增成功");
		}else {
		
			System.out.println("新增失败");
		}
		
		
	}
	@RequestMapping("deleteCourse")
	public void deleteCourse(Integer cid , HttpServletResponse response) throws IOException {
		if ( commonService.deleteCourse(cid) ) {
			response.getWriter().write("true");
			System.out.println("删除成绩信息成功");
		}else {
			response.getWriter().write("true");
			System.out.println("删除成绩信息成功");
		}
		
		
	}
	
	@RequestMapping("addScorePage")
	public ModelAndView addScorePage() {
		//查找所有学生，所有课程，，所有老师

		List<Teacher> allteacher = commonService.selectAllTeacher();
		List<Course> allcourse = commonService.selectAllCourse();
		List<Student> allstudent = studentService.selectAll();
		
		ModelAndView mav = new  ModelAndView();
		
		mav.addObject("allteacher", allteacher);
		mav.addObject("allcourse", allcourse);
		mav.addObject("allstudent", allstudent);
		
		mav.setViewName("score_add.jsp");
		return  mav;
		
	}
	
	@RequestMapping("addScore")
	public void addScore(Score s , HttpServletResponse response) throws IOException {
		System.out.println("新增： "+s);
		
		if( commonService.insertScore(s)) {
			response.getWriter().write("true");
			System.out.println("添加成绩信息成功");
		}else {
			response.getWriter().write("true");
			System.out.println("添加成绩信息失败");
		}
	}
	
	
	@RequestMapping("deleteScore" )
	public void deleteScore(Integer sid , Integer cid , HttpServletResponse response) throws IOException {
		System.out.println(sid+"---"+cid);
		
		if ( commonService.deletScore(sid,cid) ) {
			response.getWriter().write("true");
			System.out.println("删除成绩信息成功");
		}else {
			response.getWriter().write("true");
			System.out.println("删除成绩信息成功");
		}
		
		
	}
	
	
}
