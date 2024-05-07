package com.klef.jfsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Department;
import com.klef.jfsd.springboot.model.Faculty;
import com.klef.jfsd.springboot.repository.FacultyRepository;

@Service
public class FacultyServiceImpl implements FacultyService {
		
	@Autowired
	public FacultyRepository facultyRepository;

	@Override
	public String addfaculty(Faculty emp) {
		facultyRepository.save(emp);
		return "Employee Added Successfully";
	}

	@Override
	public String updatefaculty(Faculty emp)
	{
		Faculty e  = facultyRepository.findById(emp.getId()).get(); 
		   e.setId(emp.getId());
		  e.setName(emp.getName()); 
		  e.setDateofbirth(emp.getDateofbirth()); 
		  e.setDepartment_id(emp.getDepartment_id()); 
		  e.setSalary(emp.getSalary()); 
		  e.setEmail(emp.getEmail()); 
		  e.setPassword(emp.getPassword()); 
		  e.setLocation(emp.getLocation()); 
		  e.setContact(emp.getContact()); 
		   
		  facultyRepository.save(e); 
		   
		  return "Employee Updated Successfully";
	}

	@Override
	public Faculty viewfacultybyid(int eid) {
		
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
	  public Faculty checkfacultylogin(String email, String password) 
	  {
	    
	    return facultyRepository.checkfacultylogin(email, password);
	  }

	@Override
	public List<Faculty> viewfacultybydept(int id) {
		
		return facultyRepository.facultyofdepartment(id);
	}

	@Override
	public String getfacultynamebyid(int course_cc_id) {
		Optional<Faculty> obj =  facultyRepository.findById(course_cc_id);
	       
	       if(obj.isPresent())
	       {
	         Faculty fac = obj.get();
	         
	         return fac.getName();
	       }
	       return "null";
	}

	@Override
	public List<Faculty> viewallfaculty() {
		return facultyRepository.findAll();
	}

	@Override
	public void deletefacultybyid(int id) {
		Optional<Faculty> optionalDepartment = facultyRepository.findById(id);
        if (optionalDepartment.isPresent()) {
            facultyRepository.delete(optionalDepartment.get());
        } 
	}
}

