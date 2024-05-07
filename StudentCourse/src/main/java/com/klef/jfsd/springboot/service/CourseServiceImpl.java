package com.klef.jfsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Courses;
import com.klef.jfsd.springboot.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public List<Courses> viewallcourses() 
	{		
		return courseRepository.findAll();
	}
	
	public Courses getCourseById(int id) {
        Optional<Courses> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            return optionalCourse.get();
        } else {
        return null;     
        }
    }
	
	public void deleteCourseById(int id) {
        Optional<Courses> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            courseRepository.delete(optionalCourse.get());
        } 
    }

	public void updateCourse(Courses updatedCourse) {
        Courses existingCourse = courseRepository.findById(updatedCourse.getCourse_id()).orElse(null);
        
      

        existingCourse.setCourse_name(updatedCourse.getCourse_name());
        existingCourse.setCourse_code(updatedCourse.getCourse_code());
        existingCourse.setCourse_credits(updatedCourse.getCourse_credits());
        //existingCourse.setCourse_departement_id(updatedCourse.getCourse_departement_id());
        existingCourse.setCourse_cc_id(updatedCourse.getCourse_cc_id());
        existingCourse.setCourse_year(updatedCourse.getCourse_year());
        existingCourse.setCourse_sem(updatedCourse.getCourse_sem());
        existingCourse.setLimit_number_enrollments(updatedCourse.getLimit_number_enrollments());
        existingCourse.setCourse_description(updatedCourse.getCourse_description());

        courseRepository.save(existingCourse);
    }


}
