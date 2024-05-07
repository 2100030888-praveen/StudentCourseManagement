package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.StudentToDoList;
import com.klef.jfsd.springboot.repository.StudentToDoListRepository;

@Service
public class StudentToDoListServiceImpl implements StudentToDoListService
{

	@Autowired
	private StudentToDoListRepository studentToDoListRepository;
	
	@Override
	public List<StudentToDoList> gettodolistofastudent(int attribute) {
		
		return studentToDoListRepository.gettodolistofastudent(attribute);
	}

	@Override
	public void addstudenttodolist(StudentToDoList std) {
		studentToDoListRepository.save(std);
		
	}

	@Override
	public void saveTodo(StudentToDoList todo) {
        studentToDoListRepository.save(todo);
    }

}
