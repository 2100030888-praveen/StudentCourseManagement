package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.Department;


public interface DepartmentService {
	public List<Department> viewalldepartments();
	
	public Department getDepartmentById(int id);
	 public void deleteDepartmentById(int id) ;

	public String getdepartmentnamebyid(int did);

	public void updateDeppartment(Department updatedDepartment);
	
	public String adddepartment(Department department);
}
