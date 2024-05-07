package com.klef.jfsd.springboot.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Announcements;
import com.klef.jfsd.springboot.model.Courses;
import com.klef.jfsd.springboot.model.Department;
import com.klef.jfsd.springboot.model.Faculty;
import com.klef.jfsd.springboot.model.Student;
import com.klef.jfsd.springboot.service.AdminService;
import com.klef.jfsd.springboot.service.AnnouncementService;
import com.klef.jfsd.springboot.service.CourseService;
import com.klef.jfsd.springboot.service.DepartmentService;
import com.klef.jfsd.springboot.service.EmailManager;
import com.klef.jfsd.springboot.service.FacultyService;
import com.klef.jfsd.springboot.service.PasswordGenaraterService;
import com.klef.jfsd.springboot.service.RegistrationStatusService;
import com.klef.jfsd.springboot.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminClientController
{
	  @Autowired
	  private AdminService adminService;
	  
	  @Autowired
	  private FacultyService facultyService;
	  
	  @Autowired
	  private StudentService studentService;
	  
	  @Autowired
	  private DepartmentService departmentService;
	  
	  @Autowired
	  private CourseService courseService;
	  
	  @Autowired
	  private AnnouncementService announcementService;
	  
	  @Autowired
	  EmailManager em;

	  @Autowired
	  private PasswordGenaraterService passwordGenaraterService;
	  
	  @Autowired
	  private RegistrationStatusService registrationStatusService;
	  
	 
	  
	  @GetMapping("insertstudent")
	  public ModelAndView inserstudent(HttpServletRequest request)
	  {
		  ModelAndView mv =  new ModelAndView("studentreg");
		  mv.addObject("departments", departmentService.viewalldepartments());
		  String pwd1 = passwordGenaraterService.generateRandomString(8);
		    System.out.println("Generated Password: " + pwd1); 
		    mv.addObject("pwd", pwd1);
		  return mv;
	  }
	  
	  @PostMapping("insertstudent")
	  public ModelAndView insertstudent(HttpServletRequest request)
	  {
	    ModelAndView mv = new ModelAndView();
	    
	    String msg=null;
	    try
	    {
	    	int id = Integer.parseInt(request.getParameter("id"));
	    	 String fname = request.getParameter("fname");
		      String lname= request.getParameter("lname");
	      String gender = request.getParameter("gender");
	      String dob = request.getParameter("dob");
	      int dept = Integer.parseInt(request.getParameter("dept"));
	      
	      String email = request.getParameter("email");
	      String pwd = request.getParameter("pwd");
	      
	      String contact = request.getParameter("contact");
	      String name = fname+lname;
	      Student student = new Student();
	      student.setId(id);
	      student.setName(name);
	      student.setGender(gender);
	      student.setDateofbirth(dob);
	      student.setDepartment(dept);
	      
	      student.setYear(1);
	      student.setSem(1);
	      
	      student.setEmail(email);
	      student.setPassword(pwd);
	      student.setContact(contact);
	           
	     msg= studentService.addstudent(student);
	     mailsender(email,student);
	     mv.setViewName("viewallstudents");
	     mv.addObject("message",msg);
	    }
	    catch (Exception e)
	    {
	      mv.setViewName("viewallstudents");
	      
	      msg=e.getMessage();
	      
	      mv.addObject("messgae",msg);
	    }
	    return mv;
	  }
	  
	  private void mailsender(String email, Student student) {
		  String frommail="viswatejaperla@gmail.com";
	      String toemail=email;
	      String subject="Welcome To SimleEdu";
	      String text= getmailcontent(student);
	      String mail= em.sendEmail(frommail, toemail, subject, text);
		
	}

	private String getmailcontent(Student student) {
		String name = student.getName();
	    String gender = student.getGender();
	    String dateOfBirth = student.getDateofbirth();
	    int departmentId = student.getDepartment();
	    int year = student.getYear();
	    int sem = student.getSem();
	    String email = student.getEmail();
	    String password = student.getPassword();
	    String contact = student.getContact();

	    // Create the email content
	    String emailContent = " Welcome to SimpleEdu University!\n\n";
	    emailContent += "Dear " + name + ",\n\n";
	    emailContent += "We are thrilled to welcome you to SimpleEdu University! Your journey towards higher education and personal growth begins here, and we're excited to have you as a part of our academic community.\n\n";
	    emailContent += "Here are a few important details regarding your enrollment:\n";
	    emailContent += "Name: " + name + "\n";
	    emailContent += "Gender: " + gender + "\n";
	    emailContent += "Date of Birth: " + dateOfBirth + "\n";
	    emailContent += "Department ID: " + departmentId + "\n";
	    emailContent += "Year: " + year + "\n";
	    emailContent += "Semester: " + sem + "\n";
	    emailContent += "Email: " + email + "\n";
	    emailContent += "Password: " + password + "\n";
	    emailContent += "Contact: " + contact + "\n\n";
	    emailContent += "At SimpleEdu, we are committed to providing you with a world-class education and a supportive learning environment. Whether you're a student or a faculty member, we're here to guide you every step of the way.\n\n";
	    emailContent += "Should you have any questions or need assistance, please don't hesitate to reach out to our Student Services team at [Student Services Contact Email/Phone]. We're here to help you succeed.\n\n";
	    emailContent += "We look forward to the contributions that " + name + " will make as a valued member of our student community.\n\n";
	    emailContent += "Best regards,\n\n";
	    emailContent += "[S.L.S.M.BABITHA]\n";
	    emailContent += "[CEO]\n";
	    emailContent += "SimpleEdu University\n";
	    emailContent += "[9866972935]";
	    
	    return emailContent;
	}

	@GetMapping("viewallstudents")
	  public ModelAndView viewallstudents()
	  {
		  ModelAndView mv = new ModelAndView("viewallstudents");
		  List<Student> studentList = studentService.viewallstudents();
		  mv.addObject("studentList", studentList);
		  return mv;
	  }
	  
	  @GetMapping("/editStudent")
	  public ModelAndView editStudent(@RequestParam("id") int studentId,@RequestParam("sdeptid") int studentdepartmentid) {
	      Student student = studentService.viewstudentbyid(studentId);

	      if (student != null) {
	          ModelAndView mv = new ModelAndView("editStudent"); 
	          mv.addObject("student", student);
	          mv.addObject("departmentname", departmentService.getdepartmentnamebyid(studentdepartmentid));
	          return mv;
	      } else {
	          return new ModelAndView("errorPage");
	      }
	  }

	    @PostMapping("updatestudent")
	    public ModelAndView updateStudent(@ModelAttribute Student updatedStudent) {
	        studentService.updatestudent(updatedStudent);
	        return new ModelAndView("redirect:/viewallstudents");
	    }
	  
	    @GetMapping("deleteStudent")
		  public ModelAndView deleteStudent(@RequestParam int id) {
			  studentService.deletestudentbyid(id);
		        return new ModelAndView("redirect:/viewallstudents");
		   
		  }
	    
	  @GetMapping("facultyreg")
	  public ModelAndView inserfaculty()
	  {
		  ModelAndView mv =  new ModelAndView("facultyreg"); 
		  List<Department> departments = departmentService.viewalldepartments();
		  mv.addObject("departments", departments);
		  String pwd1 = passwordGenaraterService.generateRandomString(8);
		    System.out.println("Generated Password: " + pwd1); 
		    mv.addObject("pwd", pwd1);
		  return mv;
	  }
	  
	  
	  
	  
	  @PostMapping("insertfaculty")
	  public ModelAndView insertaction(HttpServletRequest request)
	  {
	    ModelAndView mv = new ModelAndView();
	    
	    
	    String msg=null;
	    try
	    {
	    	
	      int id = Integer.parseInt(request.getParameter("id"));
	      String fname = request.getParameter("fname");
	      String lname= request.getParameter("lname");
	      String gender = request.getParameter("gender");
	      String dob = request.getParameter("dob");
	      int dept = Integer.parseInt(request.getParameter("dept"));
	      String sal = request.getParameter("salary");
	      double salary = Double.parseDouble(sal);
	      String email = request.getParameter("email");
	      String pwd = request.getParameter("pwd");
	      String location = request.getParameter("location");
	      String contact = request.getParameter("contact");
	      String name = fname+lname;
	      Faculty faculty = new Faculty();
	      		faculty.setId(id);
	           faculty.setName(name);
	           faculty.setGender(gender);
	           faculty.setDateofbirth(dob);
	           faculty.setDepartment_id(dept);
	           faculty.setSalary(salary);
	           faculty.setEmail(email);
	           faculty.setPassword(pwd);
	           faculty.setLocation(location);
	           faculty.setContact(contact);
	           faculty.setIshod(false);
	           
	     msg= facultyService.addfaculty(faculty);
	     mailsender(email,faculty);
	     mv.setViewName("redirect:/viewallfaculty");
	     mv.addObject("message",msg);
	     
	    }
	    catch (Exception e)
	    {
	      mv.setViewName("viewallfaculty");
	      
	      msg=e.getMessage();
	      e.printStackTrace();
	      
	      mv.addObject("messgae",msg);
	    }
	    return mv;
	  }
	  
	  private void mailsender(String email,Faculty faculty) {
		  String frommail="viswatejaperla@gmail.com";
	      String toemail=email;
	      String subject="Welcome To SimleEdu";
	      String text= getmailcontent(faculty);
	      String mail= em.sendEmail(frommail, toemail, subject, text);
	}

	private String getmailcontent(Faculty faculty) {
		String name = faculty.getName();
	    String gender = faculty.getGender();
	    String dateOfBirth = faculty.getDateofbirth();
	    int departmentId = faculty.getDepartment_id();
	    double salary = faculty.getSalary();
	    String email = faculty.getEmail();
	    String password = faculty.getPassword();
	    String location = faculty.getLocation();
	    String contact = faculty.getContact();
	    boolean isHod = faculty.isIshod();
	    boolean isCC = faculty.isIscc();

	    // Create the email content
	    String emailContent = "Welcome to SimpleEdu University!\n\n";
	    emailContent += "Dear " + name + ",\n\n";
	    emailContent += "We are thrilled to welcome you to SimpleEdu University! Your journey towards higher education and personal growth begins here, and we're excited to have you as a part of our academic community.\n\n";
	    emailContent += "Here are a few important details regarding your enrollment:\n";
	    emailContent += "Name: " + name + "\n";
	    emailContent += "Gender: " + gender + "\n";
	    emailContent += "Date of Birth: " + dateOfBirth + "\n";
	    emailContent += "Department ID: " + departmentId + "\n";
	    emailContent += "Salary: " + salary + "\n";
	    emailContent += "Email: " + email + "\n";
	    emailContent += "Password: " + password + "\n";
	    emailContent += "Location: " + location + "\n";
	    emailContent += "Contact: " + contact + "\n";
	   
	    emailContent += "At SimpleEdu, we are committed to providing you with a world-class education and a supportive learning environment. Whether you're a faculty member or a student, we're here to guide you every step of the way.\n\n";
	    emailContent += "Should you have any questions or need assistance, please don't hesitate to reach out to our Faculty Services team at [Faculty Services Contact Email/Phone]. We're here to help you succeed.\n\n";
	    emailContent += "We look forward to the contributions that " + name + " will make as a valued member of our faculty.\n\n";
	    emailContent += "Best regards,\n\n";
	    emailContent += "[S.L.S.M.BABITHA]\n";
	    emailContent += "[CEO]\n";
	    emailContent += "SimpleEdu University\n";
	    emailContent += "[9866972935]";

	    return emailContent;
	}
	@GetMapping("viewallfaculty")
	  public ModelAndView viewallfaculty() {
	      ModelAndView mv = new ModelAndView("viewallfaculty");
	      List<Faculty> facultieslist = facultyService.viewallfaculty();
	      mv.addObject("facultyList", facultieslist);
	      return mv;
	  }
	  
	@GetMapping("/editFaculty")
	  public ModelAndView editFaculty(@RequestParam("id") int id) {
	      Faculty f = facultyService.viewfacultybyid(id);

	      if (f != null) {
	          ModelAndView mv = new ModelAndView("editStudent"); 
	          mv.addObject("faculty", f);
	          mv.addObject("departmentname", departmentService.getdepartmentnamebyid(f.getDepartment_id()));
	          return mv;
	      } else {
	          return new ModelAndView("errorPage");
	      }
	  }
	
	 @GetMapping("deleteFaculty")
	  public ModelAndView deleteFaculty(@RequestParam int id) {
		  facultyService.deletefacultybyid(id);
	        return new ModelAndView("redirect:/viewallfaculty");
	   
	  }
	
	  @GetMapping("adddept")
	  public ModelAndView adddept()
	  {
		  return new ModelAndView("adddept");
	  }
	  
	  @PostMapping("adddept1")
	  public ModelAndView adddept1(HttpServletRequest request)
	  {
		  ModelAndView mv = new ModelAndView();
		  Department d = new Department();
		  d.setDepartment_id(Integer.parseInt(request.getParameter("department_id")));
		  d.setDepartment_name(request.getParameter("department_name"));
		  departmentService.adddepartment(d);
		  
		  
		  mv.setViewName("redirect:/viewalldept");
		  
		  return mv;
	  }
	  
	  @GetMapping("viewalldept")
	  public ModelAndView viewAllDepartments() {
	      ModelAndView mv = new ModelAndView("viewalldept");
	      List<Department> departmentsList = departmentService.viewalldepartments();
	      mv.addObject("departmentsList", departmentsList);
	      return mv;
	  }

	  @GetMapping("editDepartment")
	  public ModelAndView editDepartment(@RequestParam("id") int id) {
		  ModelAndView mv = new ModelAndView("editDepartment"); 
		  System.out.println(id);
	        Department department = departmentService.getDepartmentById(id);
	        mv.addObject("department", department);
	        return mv;
	     }
	  
	  @PostMapping("/updateDepartment")
	  public String updateDepartment(@ModelAttribute Department updatedDepartment) {
	      departmentService.updateDeppartment(updatedDepartment);
	      
	      return "redirect:/viewalldept"; 
	  }

	  @GetMapping("deleteDepartment")
	  public ModelAndView deleteDepartment(@RequestParam int id) {
		  departmentService.deleteDepartmentById(id);
	        return new ModelAndView("redirect:/viewalldept");
	   
	  }

	    
//	  @GetMapping("addcourse")
//	  public ModelAndView addcourse1(HttpServletRequest request)
//	  {
//		  ModelAndView mv =  new ModelAndView("addcourse"); 
//		  List<Department> departments = departmentService.viewalldepartments();
//		  mv.addObject("departments", departments);
//		  List<Faculty> faculty  = facultyService.viewfacultybydept(0);
//		  return mv;
//	  }
	  
	  
	  @GetMapping("addannouncement")
	  public ModelAndView addannouncement()
	  {
		  ModelAndView mv = new ModelAndView();
		  mv.setViewName("deptannoun");
		  List<Department> departments = departmentService.viewalldepartments();
		  mv.addObject("departments", departments);
		  return mv;
	  }
	  
	  @PostMapping("addannouncement1")
	  public ModelAndView addannouncement1(HttpServletRequest request)
	  {
		  ModelAndView mv = new ModelAndView();
		  mv.setViewName("addannouncement");
		  List<Department> departments = departmentService.viewalldepartments();
		  mv.addObject("dept", Integer.parseInt(request.getParameter("dept")));
		  return mv;
	  }
	  
	  @PostMapping("addannouncement")
	  public ModelAndView addannouncement(HttpServletRequest request)
	  {
		  ModelAndView mv = new ModelAndView("addannouncement");
		  
		 int did = Integer.parseInt(request.getParameter("dept"));
		  //int did = 101;
		  String announcement = request.getParameter("announcement");
		  
		  
		  String startDateTimeStr = request.getParameter("startDateTime");
		    String endDateTimeStr = request.getParameter("endDateTime");
		    String who = request.getParameter("who");
		    
		    
		    if (startDateTimeStr != null && endDateTimeStr != null) {
		        try {
//		            long sd = Long.parseLong(startDateTimeStr);
//		            Date sd1 = new Date(sd);
//		            long ed = Long.parseLong(endDateTimeStr);
//		            Date ed1 = new Date(ed);
		        	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		            Date sd1 = format.parse(startDateTimeStr);
		            Date ed1 = format.parse(endDateTimeStr);

		            Announcements a = new Announcements();
		            a.setAnnouncement(announcement);
		            a.setAnnouncement_start_time(sd1);
		            a.setAnnouncement_end_time(ed1);
		  a.setDepartment_id_to_be_announcement(did);
		  a.setDepartment_name_to_be_announcement(departmentService.getdepartmentnamebyid(did));
		  if(who.equals("both"))
		  {
			  a.setIs_for_both(true);
			  a.setIs_for_faculty(true);
			  a.setIs_for_students(true);
		  }
		  else if(who.equals("student"))
		  {
			  a.setIs_for_both(false);
			  a.setIs_for_faculty(false);
			  a.setIs_for_students(true);
		  }
		  else {
			  a.setIs_for_both(false);
			  a.setIs_for_faculty(true);
			  a.setIs_for_students(false);
		  }
		  mv.setViewName("addannouncement");
		 String msg =  announcementService.addannouncement(a);
		 mv.addObject("message", msg);
		        } catch (NumberFormatException | ParseException e) {
		            // Handle the case where the date parameters cannot be parsed
		            mv.addObject("message", "Invalid date format.");
		        }
		    } else {
		        // Handle the case where startDateTime or endDateTime is null
		        mv.addObject("message", "Date and time parameters are missing.");
		    }
		  return mv;
	  }
	  
	  @GetMapping("selectdept")
	  public ModelAndView selectdept()
	  {
		  ModelAndView mv = new ModelAndView();
		  mv.setViewName("selectdept");
		  List<Department> departments = departmentService.viewalldepartments();
		  mv.addObject("departments", departments);
		  return mv;
	  }
	  	
	  @PostMapping("add1")
	  public ModelAndView getCC(HttpServletRequest request)
	  {
		  ModelAndView mv = new ModelAndView();
		  mv.setViewName("addcourse");
		  int did = Integer.parseInt(request.getParameter("dept"));
		  List<Faculty> f = facultyService.viewfacultybydept(did);
		  mv.addObject("faculty", f);
		  mv.addObject("dept", did);
		  
		  return mv;
	  }
	  
	  @PostMapping("addcourse")
	  public ModelAndView addcourse(HttpServletRequest request)
	  {
		  ModelAndView mv = new ModelAndView("addcourse");
		  int did = Integer.parseInt(request.getParameter("dept"));
		  
		  System.out.println(did);System.out.println(did);
		  System.out.println(did);
		  System.out.println(did);
		  System.out.println(did);
		  System.out.println(did);
		  System.out.println(did);
		  System.out.println(did);
		  List<Faculty> f = facultyService.viewfacultybydept(did);
		  mv.addObject("faculty", f);
		  String msg=null;
		    try
		    {
		    	int id = Integer.parseInt(request.getParameter("id"));
		      String name = request.getParameter("name");
		      String code = request.getParameter("code");
		      double credits = Double.parseDouble(request.getParameter("credits"));
		      //int dept = Integer.parseInt(request.getParameter("dept"));
		      int cc = Integer.parseInt(request.getParameter("cc"));
		      int year = Integer.parseInt(request.getParameter("year"));
		      int sem = Integer.parseInt(request.getParameter("sem"));
		      int enrollments = Integer.parseInt(request.getParameter("enrollments"));
		      String desc = request.getParameter("description");
		      
		      Courses c = new Courses();
		      c.setCourse_id(id);
		      c.setCourse_name(name);
		      c.setCourse_code(code);
		      c.setCourse_departement_id(did);
		      c.setCourse_cc_id(cc);
		      c.setCourse_year(year);
		      c.setCourse_sem(sem);
		      c.setLimit_number_enrollments(enrollments);
		      c.setCourse_description(desc);
		           
		    msg= adminService.addcourse(c);
		     
		     mv.setViewName("addcourse");
		     mv.addObject("message",msg);
		    }
		    catch (Exception e)
		    {
		      mv.setViewName("displayerror");
		      
		      msg=e.getMessage();
		      
		      mv.addObject("message",msg);
		    }
		    return new ModelAndView("redirect:/viewallcourses");
	  }
	  
	  @GetMapping("viewallcourses")
	  public ModelAndView viewallcourses()
	  {
		  ModelAndView mv = new ModelAndView("viewallcourses");
		  List<Courses> coursesList = courseService.viewallcourses();
		  mv.addObject("coursesList", coursesList);
		  return mv;
	  }
	  
	  @GetMapping("editCourse")
	  public ModelAndView editCourse(@RequestParam("cid") int cid, @RequestParam("did") int did) {
		  ModelAndView mv = new ModelAndView("editCourse"); 
	      //mv.addObject("dlist", departmentService.viewalldepartments());
	      // now i need to get dept id as well in the url 
	      mv.addObject("clist", courseService.viewallcourses());
	     Courses clist = courseService.getCourseById(cid);
	      mv.addObject("course", clist);
	      String ccnameofthatcourse = facultyService.getfacultynamebyid(clist.getCourse_cc_id());
	      mv.addObject("ccnameofthatcourse", ccnameofthatcourse);
	      List<Faculty> faculty = facultyService.viewfacultybydept(did);
	      mv.addObject("faculty", faculty);
	      String departmentnamebyid = departmentService.getdepartmentnamebyid(did);
	      mv.addObject("departmentnamebyid", departmentnamebyid);
	      return mv;
	  }

	  @GetMapping("deleteCourse")
	  public ModelAndView deleteCourse(@RequestParam int id) {
	      courseService.deleteCourseById(id);
	      return new ModelAndView("redirect:viewallcourses"); 
	  }
	  
	  @PostMapping("/updateCourse")
	  public String updateCourse(@ModelAttribute Courses updatedCourse) {
	      courseService.updateCourse(updatedCourse);
	      
	      return "redirect:/viewallcourses"; 
	  }
	  
	  
	  @GetMapping("registrationstatus")
	  public ModelAndView registrationstatus(HttpServletRequest request) {
		  ModelAndView mv = new ModelAndView("registrationstatus");
		  mv.addObject("registrationList", registrationStatusService.getallstatus());
		    
		  return mv;
	  }
	  
	  @GetMapping("setstatus") 
	  public ModelAndView setstatus(@RequestParam("id") int eid, @RequestParam("status") boolean status) 
	  { 
		  
		  int n = registrationStatusService.updatestatus(eid, status);
		  return  new ModelAndView("redirect:/registrationstatus");
	  }

}
