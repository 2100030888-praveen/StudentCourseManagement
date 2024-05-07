package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.jfsd.springboot.model.Courses;

public interface CourseRepository extends JpaRepository<Courses, Integer>
{
	
}
