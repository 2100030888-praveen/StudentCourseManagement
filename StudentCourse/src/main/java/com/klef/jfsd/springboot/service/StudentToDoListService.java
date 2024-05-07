package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.StudentToDoList;

public interface StudentToDoListService {

	List<StudentToDoList> gettodolistofastudent(int attribute);

	void addstudenttodolist(StudentToDoList std);
	public void saveTodo(StudentToDoList todo);
}
