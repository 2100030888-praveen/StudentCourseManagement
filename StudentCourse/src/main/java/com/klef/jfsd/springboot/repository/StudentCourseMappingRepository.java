package com.klef.jfsd.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.Courses;
import com.klef.jfsd.springboot.model.Student;
import com.klef.jfsd.springboot.model.StudentCourseMapping;

@Repository
public interface StudentCourseMappingRepository extends JpaRepository<StudentCourseMapping, Integer> {

	  @Query("SELECT COUNT(scm) FROM StudentCourseMapping scm where scm.course = ?1 and scm.student = ?2")
	public long checkStudentCoursemapping(Courses course_id,Student student_id);

	  @Query("FROM StudentCourseMapping scm where scm.student = ?1")
	public List<StudentCourseMapping> noofcoursesmappedtoStudent(Student s);

	  @Query("from StudentCourseMapping scm where scm.student = ?1 and scm.course = ?2 ")
	public StudentCourseMapping getofSCmobject(Student s, Courses c);

}
