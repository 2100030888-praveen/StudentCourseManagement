package com.klef.jfsd.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.StudentToDoList;

@Repository
public interface StudentToDoListRepository extends JpaRepository<StudentToDoList, Integer>{

	@Query("from StudentToDoList std where std.student_id=?1")
	List<StudentToDoList> gettodolistofastudent(int attribute);

}
