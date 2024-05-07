package com.klef.jfsd.springboot.service;


import java.util.List;

import com.klef.jfsd.springboot.model.Courses;
import com.klef.jfsd.springboot.model.Student;
import com.klef.jfsd.springboot.model.StudentCourseMapping;

public interface StudentService {
  
  public String addstudent(Student emp);
  public Student updatestudent(Student emp);
  public Student viewstudentbyid(int eid);
  public Student checkstudentlogin(String email,String password);
  public List<Student> viewallstudents();
public void deletestudentbyid(int id);
  

public List<Courses> viewallcoursesofthatyearsem(int year, int sem);

public String studentCourseMapping(StudentCourseMapping s);

public int checkStudentCoursemapping(Courses c, Student s);
public List<StudentCourseMapping> noofcoursesmappedtoStudent(Student s);
public String unenrollcoursetostudentmapped(Student s, Courses c);
}