package com.klef.jfsd.springboot.service;


import java.util.List;

import com.klef.jfsd.springboot.model.Faculty;

public interface FacultyService {
  
  public String addfaculty(Faculty emp);
  public String updatefaculty(Faculty emp);
  public Faculty viewfacultybyid(int eid);
  public Faculty checkfacultylogin(String email,String password);
  public List<Faculty> viewfacultybydept(int id);
public String getfacultynamebyid(int course_cc_id);
public List<Faculty> viewallfaculty();
public void deletefacultybyid(int id);
  
}