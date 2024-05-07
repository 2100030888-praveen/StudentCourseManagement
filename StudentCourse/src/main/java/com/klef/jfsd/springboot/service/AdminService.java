package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Courses;
import com.klef.jfsd.springboot.model.Faculty;

public interface AdminService {
	
	public List<Faculty> viewallemps();
	public Faculty viewempbyid(int eid);
	public String deleteemp(int eid);
	public Admin checkadminlogin(String uname,String pwd);
	public String addcourse(Courses c);
}
