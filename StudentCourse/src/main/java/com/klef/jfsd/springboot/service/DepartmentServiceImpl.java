package com.klef.jfsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Courses;
import com.klef.jfsd.springboot.model.Department;
import com.klef.jfsd.springboot.repository.DepartmentRepository;
import com.klef.jfsd.springboot.repository.FacultyRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService
{
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private FacultyRepository facultyRepository;

	@Override
	public List<Department> viewalldepartments() {
		
		return departmentRepository.findAll();
	}

	 
	 public Department getDepartmentById(int id) {
	        Optional<Department> optionalDepartment = departmentRepository.findById(id);
	        if (optionalDepartment.isPresent()) {
	            return optionalDepartment.get();
	        } else {
	           return optionalDepartment.get();
	        }
	    }

	 public void deleteDepartmentById(int id) {
	        Optional<Department> optionalDepartment = departmentRepository.findById(id);
	        if (optionalDepartment.isPresent()) {
	            departmentRepository.delete(optionalDepartment.get());
	        } 
	 }


	@Override
	public String getdepartmentnamebyid(int did) {
		 Optional<Department> optionalDepartment = departmentRepository.findById(did);
	        if (optionalDepartment.isPresent()) {
	            return optionalDepartment.get().getDepartment_name();
	        } else {
	            return null;
	        }
	}


	@Override
	public void updateDeppartment(Department updatedDepartment) {
		Department department = departmentRepository.findById(updatedDepartment.getDepartment_id()).orElse(null);
		department.setDepartment_name(updatedDepartment.getDepartment_name());
		
		departmentRepository.save(department);
		
	}


	@Override
	public String adddepartment(Department department) {
		departmentRepository.save(department);
		return "dept added succefully";
	}
}
