package com.klef.jfsd.springboot.service;


import java.util.List;

import com.klef.jfsd.springboot.model.Courses;

public interface CourseService {
	public List<Courses> viewallcourses();
	
	public Courses getCourseById(int id);
	public void deleteCourseById(int id);
	
	public void updateCourse(Courses updatedCourse);


}
