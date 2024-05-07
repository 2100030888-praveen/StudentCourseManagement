package com.klef.jfsd.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Courses;
import com.klef.jfsd.springboot.model.Student;
import com.klef.jfsd.springboot.model.StudentCourseMapping;
import com.klef.jfsd.springboot.model.StudentToDoList;
import com.klef.jfsd.springboot.service.CourseService;
import com.klef.jfsd.springboot.service.RegistrationStatusService;
import com.klef.jfsd.springboot.service.StudentService;
import com.klef.jfsd.springboot.service.StudentToDoListService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class StudentClientController 
{
	  @Autowired
	  private StudentService studentService;	
	  
	  @Autowired
	  private CourseService courseService;
	  
	  @Autowired
	  private RegistrationStatusService registrationStatusService;
	  
	  @Autowired
	  private StudentToDoListService studentToDoListService;
	  
//	  @Autowired
//	  private StudentCourseMapping studentCourseMapping;
	  
	  @GetMapping("/studenthome")
	  public String studenthome()
	  {
		  return "student/studentdashboard";
	  }
	  
	 
	  
	  @GetMapping("/studentaddcourses")
	  public ModelAndView studentaddcourses(HttpServletRequest request)
	  {
		  ModelAndView mv = new ModelAndView();
		  Student s = studentService.viewstudentbyid(((int) request.getSession().getAttribute("session_id")));
		  int sy= s.getYear();
		  int ss = s.getSem();
		  boolean flag = registrationStatusService.getstatusbyyearsem(sy,ss);
		  System.out.println(flag);
		  if(flag)
		  {
		  try {
		  mv.setViewName("student/studentaddcourses");
		  mv.addObject("courselist", studentService.viewallcoursesofthatyearsem(s.getYear(),s.getSem()));
		  mv.addObject("msg", "");
		  }
		  catch (Exception e) {
			mv.setViewName("login");
		}
		  }
		  else {
			  mv.setViewName("student/studentaddcourses");
			  mv.addObject("msg", "administrater is not opened please contact the admintrater");
		  }
		  return mv;
	  }
	  
	  @GetMapping("/mapcoursetostudent/{cid}")
	  public ModelAndView mapcoursetostudent(HttpServletRequest request,@PathVariable int cid)
	  {
		  int student_id = ((int) request.getSession().getAttribute("session_id"));
		  
		  Student s = studentService.viewstudentbyid(student_id);
		  Courses c = courseService.getCourseById(cid);
		 
		  int l = studentService.checkStudentCoursemapping(c,s);
		  if(l==0)
		  {
		  StudentCourseMapping scm = new StudentCourseMapping();
		  scm.setStudent(s);
		  scm.setCourse(c);
		  scm.setYear(s.getYear());
		  scm.setSem(s.getSem());
		  studentService.studentCourseMapping(scm);
				  
		  return new ModelAndView("redirect:/studentviewcourses");
		  }
		  else {
			  ModelAndView mv = new ModelAndView("student/studentdisplayreg");
			  mv.addObject("msg", "already enrolled select other one");
			  return mv;
		  }
	  }
	  
	  @GetMapping("/unmapcoursetostudent/{cid}")
	  public ModelAndView unmapcoursetostudent(HttpServletRequest request,@PathVariable int cid)
	  {
		  int student_id = ((int) request.getSession().getAttribute("session_id"));
		  
		  Student s = studentService.viewstudentbyid(student_id);
		  Courses c = courseService.getCourseById(cid);
		 
		  int l = studentService.checkStudentCoursemapping(c,s);
		  if(l==0)
		  {
//		  StudentCourseMapping scm = new StudentCourseMapping();
//		  scm.setStudent(s);
//		  scm.setCourse(c);
//		  scm.setYear(s.getYear());
//		  scm.setSem(s.getSem());
//		  studentService.studentCourseMapping(scm);
//				  
//		  return new ModelAndView("redirect:/studentviewcourses");
			  ModelAndView mv = new ModelAndView("student/studentunregistercourse");
			  mv.addObject("msg", "");
			  
			  return mv;
		  }
		  else {
			  ModelAndView mv = new ModelAndView("student/studentunregistercourse");
			  studentService.unenrollcoursetostudentmapped(s,c);
			  mv.addObject("msg", "unenrolled");
			  return mv;
		  }
		
	  }
	  
	  @GetMapping("/studentunregistercourse")
	  public ModelAndView studentunregistercourse(HttpServletRequest request)
	  {
		  ModelAndView mv = new ModelAndView();
		  int student_id = ((int) request.getSession().getAttribute("session_id"));
  		  Student s = studentService.viewstudentbyid(student_id);
  		  List<StudentCourseMapping> l= studentService.noofcoursesmappedtoStudent(s);
  		  if(l.size()==0)
  		  {
  			  mv.setViewName("student/studentunregistercourse");
  			  mv.addObject("msg", "no courses");
  		  }
  		  else {
  			  List<Courses> lis1 = new ArrayList<>();
  			  for(StudentCourseMapping i:l)
  			  {
  				  lis1.add(i.getCourse());
  			  }
  			  mv.setViewName("student/studentunregistercourse");
  			  mv.addObject("courselist", lis1);
  			  mv.addObject("msg", "");
  			  
  		  }
		return mv;
	  }

	  @GetMapping("/studentviewcourses")
	  public ModelAndView studentviewcourses(HttpServletRequest request)
	  {
		  ModelAndView mv = new ModelAndView()
;		  int student_id = ((int) request.getSession().getAttribute("session_id"));
		  Student s = studentService.viewstudentbyid(student_id);
		  List<StudentCourseMapping> l= studentService.noofcoursesmappedtoStudent(s);
		  if(l.size()==0)
		  {
			  mv.setViewName("student/studentviewcourses");
			  mv.addObject("msg", "no courses");
		  }
		  else {
			  List<Courses> lis1 = new ArrayList<>();
			  for(StudentCourseMapping i:l)
			  {
				  lis1.add(i.getCourse());
			  }
			  mv.setViewName("student/studentviewcourses");
			  mv.addObject("courselist", lis1);
			  mv.addObject("msg", "");
			  
		  }
//		  List<Courses> lis1 = new ArrayList<>();
//		  for(StudentCourseMapping i:l)
//		  {
//			  System.out.println(i);
//			  lis1.add(i.getCourse());
//		  }
//		  System.out.println(lis1);
//		  mv.setViewName("student/studentviewcourses");
//		  mv.addObject("courselist", lis1);
		  return mv;
	  }
	  
	  @GetMapping("studenttodolist")
	  public ModelAndView studenttodolist(HttpServletRequest request)
	  {
		  ModelAndView mv = new ModelAndView("student/studenttodolist");
		  List<StudentToDoList> l = studentToDoListService.gettodolistofastudent((int) request.getSession().getAttribute("session_id"));
		  for(StudentToDoList i: l)
		  {
			  System.out.println(i);
		  }
		  mv.addObject("todolist", l);
		  return mv;
	  }
	  
	  @PostMapping("addstudenttodolist1")
	  public ModelAndView studenttodolist1(HttpServletRequest request)
	  {
		  ModelAndView mv = new ModelAndView("student/addstudenttodolist");
		  mv.addObject("sid", ((int) request.getSession().getAttribute("session_id")));
		  return mv;
	  }
	  
//	  @GetMapping("/addstudenttodolist1")
//	    public String showTodoForm(Model model,HttpServletRequest request) {
//	        model.addAttribute("todo", new StudentToDoList());
//		  model.addAttribute("sid", ((int) request.getSession().getAttribute("session_id")));
//	        return "addTodo";
//	    }
	  
//	  @PostMapping("/addstudenttodolist")
//	    public String addTodo(@ModelAttribute StudentToDoList todo) {
//	        studentToDoListService.saveTodo(todo); // Implement a service method to save the task
//	        return "redirect:/studenttodolist";
//	    }
	  
	  @PostMapping("addstudenttodolist")
	  public ModelAndView addstudenttodolist(HttpServletRequest request)
	  {
		  ModelAndView mv = new ModelAndView("student/studenttodolist");
		  StudentToDoList std = new StudentToDoList();
		  std.setStudent_id((int) request.getSession().getAttribute("session_id"));
		  std.setTodotask(request.getParameter("todoTask"));
//		  std.setDuedate(new Date(request.getParameter("dueDate")));
		  try {
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		        Date dueDate = dateFormat.parse(request.getParameter("dueDate"));
		        std.setDuedate(dueDate);
		    } catch (Exception e) {
		        // Handle date parsing error
		        e.printStackTrace();
		    }

		  String flag = request.getParameter("todoStatus");
		  if(flag.equalsIgnoreCase("true"))
			  std.setTodostatus(true);
		  else
			  std.setTodostatus(false);
		  studentToDoListService.addstudenttodolist(std);
		  return new ModelAndView("redirect:/studenttodolist");
	  }
	  
	  @GetMapping("studentprofile")
	  public String studentprofile()
	  {
		  return "student/studentprofile";
	  }
	  
	  
}
