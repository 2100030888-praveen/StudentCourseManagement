package com.klef.jfsd.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.Faculty;


@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> 
{
	@Query("from Faculty f where (f.email = ?1 OR f.id = ?1) AND f.password = ?2")
	  public Faculty checkfacultylogin(String email,String password);
	
	@Query("from Faculty f where f.department_id=?1 ")
	  public List<Faculty> facultyofdepartment(int id);
}