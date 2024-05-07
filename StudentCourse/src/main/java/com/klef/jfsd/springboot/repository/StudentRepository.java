package com.klef.jfsd.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.Courses;
import com.klef.jfsd.springboot.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	@Query("select s from Student s where (s.email=?1 and s.password=?2) or (s.id=?1 and s.password=?2)")
	  public Student checkstudentlogin(String email,String password);

	@Query("from Courses c where c.course_year=?1 and c.course_sem=?2")
	public List<Courses> viewallcoursesofthatyearsem(int id, int sem);
}
