package com.klef.jfsd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Faculty;
import com.klef.jfsd.springboot.model.Student;
import com.klef.jfsd.springboot.service.AdminService;
import com.klef.jfsd.springboot.service.FacultyService;
import com.klef.jfsd.springboot.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class ClientController {
  
  @Autowired
  private AdminService adminService;
  
  @Autowired
  private FacultyService facultyService;
  
  @Autowired
  private StudentService studentService;
  
  
  @GetMapping("/")
  public String main()
  {
	  return "home";
  }
  
  @GetMapping("home")
  public String home()
  {
	  return "home";
  }
  
  @GetMapping("aboutus")
  public String about()
  {
	  return "aboutus";
  }
  
  @GetMapping("conactus")
  public String conactus()
  {
	  return "contactus";
  }
  
  @GetMapping("ourcourses")
  public String ourcourses()
  {
	  return "ourcourses";
  }
  
 
  
  @GetMapping("login")  
  public ModelAndView emplogin()
  {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("login");
    return mv;
  }
  
  @PostMapping("checklogin")
  public ModelAndView checkemplogin(HttpServletRequest request)
  {
	  ModelAndView mv = new ModelAndView();
	  String email=request.getParameter("username");
	  String pwd=request.getParameter("password");
	  
	  Faculty faculty =facultyService.checkfacultylogin(email, pwd);
	  if(faculty!=null)
	  {
		  System.out.println("Faculty ID: " + faculty.getId());
		    System.out.println("Faculty Name: " + faculty.getName());
		    System.out.println("Login email: " + email);
		  
		  HttpSession session = request.getSession();
		  
		  session.setAttribute("session_id", faculty.getId()); //eid is a session variable
		  session.setAttribute("session_name", faculty.getName()); //ename is a session variables 
		  
		
		  mv.setViewName("facultyhome");
	  }
	  else
	  {
		  Student s = studentService.checkstudentlogin(email, pwd);
		  if(s!=null)
		  {
			  HttpSession session = request.getSession();
			  
			  session.setAttribute("session_id", s.getId()); 
			  session.setAttribute("session_name", s.getName());
			  mv.setViewName("student/studentdashboard");
		  }
		  else 
		  {
			  Admin a = adminService.checkadminlogin(email, pwd);
			  if(a!=null)
			  {
				  HttpSession session = request.getSession();
				  
				  session.setAttribute("session_id", a.getId()); 
				  session.setAttribute("session_name", a.getUsername());
				  mv.setViewName("adminhome");
			  }
			  else {
			  mv.setViewName("login");
			  mv.addObject("message","Login Failed");
			  }
		  }
	  }
	  return mv;
  }
  
  @GetMapping("emphome")
  public ModelAndView emphome(HttpServletRequest request)
  {
	  ModelAndView mv = new ModelAndView("emphome");
	  
	  HttpSession session = request.getSession();
	  
	  int eid = (int)session.getAttribute("eid"); //eid is session variable 
	  String ename = (String)session.getAttribute("ename"); //ename is session variable 
	  
	  mv.addObject("eid", eid);
	  mv.addObject("ename", ename);
	  
	  return mv;
  }
  
  @GetMapping("adminlogin")  //URI & methodname can be different
  public ModelAndView adminlogin()
  {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("adminlogin");
    return mv;
  }
  @PostMapping("checkadminlogin")
  public ModelAndView checkadminlogin(HttpServletRequest request)
  {
    ModelAndView mv = new ModelAndView();
    String uname=request.getParameter("uname");
    String pwd=request.getParameter("pwd");
    
    Admin a=adminService.checkadminlogin(uname, pwd);
    if(a!=null)
    {
      mv.setViewName("adminhome");
    }
    else
    {
      mv.setViewName("adminlogin");
      mv.addObject("message","Login Failed");
    }
    return mv;
  }
  
  
  @GetMapping("viewallemps")
  public ModelAndView viewallemps()
  {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("viewallemps");
    List<Faculty> emplist=adminService.viewallemps();
    mv.addObject("empdata",emplist);
    return mv;
  }
  
  
 
  
  
  @GetMapping("adminhome")
  public ModelAndView adminhome()
  {
	  return new ModelAndView("adminhome");
  }
  
  
  @GetMapping("facultyhome")
  public ModelAndView facultyhome()
  {
	  return new ModelAndView("facultyhome");
  }
  
  
  @GetMapping("view")
  public ModelAndView viewempdemo(@RequestParam("id") int eid)
  {
	  Faculty faculty = adminService.viewempbyid(eid);
	  ModelAndView mv = new ModelAndView("viewempbyid");
	  mv.addObject("faculty", faculty);
	  return mv;
  }
  
  @GetMapping("deleteemp")
  public ModelAndView deleteemp()
  {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("deleteemp");
    
    List<Faculty> emplist =  adminService.viewallemps();
    
    mv.addObject("empdata", emplist);
    
    return mv;
  }
  
  @GetMapping("delete/{id}")
  public String delete(@PathVariable("id") int eid)
  {
	  adminService.deleteemp(eid);
	  return "redirect:/deleteemp";
  }
  
  @GetMapping("updateprofile")
  public ModelAndView updateemp(HttpServletRequest request)
  {
    ModelAndView mv = new ModelAndView();
    
    HttpSession session = request.getSession();
    
    mv.setViewName("updateprofile");
    
    mv.addObject("eid", session.getAttribute("eid"));
    mv.addObject("ename", session.getAttribute("ename"));
    
    int id = (int) session.getAttribute("eid");
    
    Faculty faculty = facultyService.viewfacultybyid(id);
    
    mv.addObject("faculty", faculty);
    
    return mv;
  }
  
  @PostMapping("update")
  public ModelAndView updateaction(HttpServletRequest request)
  {
    String msg = null;
    
    ModelAndView mv = new ModelAndView();
    
      HttpSession session = request.getSession();
    
    mv.addObject("eid", session.getAttribute("eid"));
    mv.addObject("ename", session.getAttribute("ename"));
    
    int id = (int) session.getAttribute("eid");
    
   try
   {
     String name = request.getParameter("name");
     String dob = request.getParameter("dob");
     int dept = Integer.parseInt(request.getParameter("dept"));
     String sal = request.getParameter("salary");
     double salary = Double.parseDouble(sal);
     String email = request.getParameter("email");
     String pwd = request.getParameter("pwd");
     String location = request.getParameter("location");
     String contact = request.getParameter("contact");
     
     Faculty faculty = new Faculty();
      faculty.setId(id);
      faculty.setName(name);
      faculty.setDateofbirth(dob);
      faculty.setDepartment_id(dept);
      faculty.setSalary(salary);
      faculty.setEmail(email);
      faculty.setPassword(pwd);
      faculty.setLocation(location);
      faculty.setContact(contact);
      
      
      msg = facultyService.updatefaculty(faculty);
      
      mv.setViewName("emplogin");
      mv.addObject("message",msg);
     
   }
   catch(Exception e)
   {
     msg = e.getMessage();
     
     mv.setViewName("updateerror");
      mv.addObject("message",msg);
   }
    
   
    return mv;

  }
}