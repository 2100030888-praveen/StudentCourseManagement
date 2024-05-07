package com.klef.jfsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Courses;
import com.klef.jfsd.springboot.model.Faculty;
import com.klef.jfsd.springboot.repository.AdminRepository;
import com.klef.jfsd.springboot.repository.AnnouncementRepository;
import com.klef.jfsd.springboot.repository.CourseRepository;
import com.klef.jfsd.springboot.repository.FacultyRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
    private FacultyRepository facultyRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private AnnouncementRepository announcementRepository;

	@Override
	public List<Faculty> viewallemps() {
		return facultyRepository.findAll();
	}

	@Override
	public Faculty viewempbyid(int eid) {
		Optional<Faculty> obj =  facultyRepository.findById(eid);
        
        if(obj.isPresent())
        {
          Faculty emp = obj.get();
          
          return emp;
        }
        else
        {
          return null;
        }
	}

	@Override
	public String deleteemp(int eid) {
		Optional<Faculty> obj =  facultyRepository.findById(eid);
	       
	    String msg = null;
	       
	    if(obj.isPresent())
	    {
	       Faculty emp = obj.get();
	         
	       facultyRepository.delete(emp);
	         
	       msg = "Employee Deleted Successfully";
	    }
	    else
	    {
	       msg = "Employee Not Found";
	    }
	       
	    return msg;
	}

	@Override
	public Admin checkadminlogin(String uname, String pwd) 
	{
		return adminRepository.checkadminlogin(uname, pwd);
	}

	@Override
	public String addcourse(Courses c) {
		courseRepository.save(c);
		return "Course added successfully";
	}

}
