package com.klef.jfsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Courses;
import com.klef.jfsd.springboot.model.Student;
import com.klef.jfsd.springboot.model.StudentCourseMapping;
import com.klef.jfsd.springboot.repository.StudentCourseMappingRepository;
import com.klef.jfsd.springboot.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
		
	@Autowired
	public StudentRepository studentRepository;
	
	@Autowired
	private StudentCourseMappingRepository studentCourseMappingRepository;

	@Override
	public String addstudent(Student stu) {
		studentRepository.save(stu);
		return "Student Added Successfully";
	}

//	@Override
//	public String updatestudent(Student stu)
//	{
//		Student s  = studentRepository.findById(stu.getId()).get(); 
//		   
//			s.setId(stu.getId());
//		  s.setName(stu.getName()); 
//		  s.setDateofbirth(stu.getDateofbirth()); 
//		  s.setDepartment(stu.getDepartment());
//		  s.setEmail(stu.getEmail()); 
//		  s.setPassword(stu.getPassword());  
//		  s.setContact(stu.getContact()); 
//		   
//		  studentRepository.save(s); 
//		   
//		  return "Employee Updated Successfully";
//	}
	 public Student updatestudent(Student updatedStudent) 
	 {
	        Student existingStudent = studentRepository.findById(updatedStudent.getId()).get();
	       existingStudent.setName(updatedStudent.getName());
	       existingStudent.setGender(updatedStudent.getGender());
	        existingStudent.setDateofbirth(updatedStudent.getDateofbirth());
	        existingStudent.setDepartment(updatedStudent.getDepartment());
	        existingStudent.setYear(updatedStudent.getYear());
	        existingStudent.setSem(updatedStudent.getSem());
	       // existingStudent.setEmail(updatedStudent.getEmail());
	        existingStudent.setPassword(updatedStudent.getPassword());
	        existingStudent.setContact(updatedStudent.getContact());

	   
	        return studentRepository.save(existingStudent);
	    }

	@Override
	public Student viewstudentbyid(int eid) {
		
		   Optional<Student> obj =  studentRepository.findById(eid);
	       
	       if(obj.isPresent())
	       {
	         Student s = obj.get();
	         
	         return s;
	       }
	       else
	       {
	         return null;
	       }

	}

	@Override
	  public Student checkstudentlogin(String email, String password) 
	  {
	    
	    return studentRepository.checkstudentlogin(email, password);
	  }

	@Override
	public List<Student> viewallstudents() {
		
		return studentRepository.findAll();
	}

	@Override
	public void deletestudentbyid(int id) {
		 Optional<Student> optionalDepartment = studentRepository.findById(id);
	        if (optionalDepartment.isPresent()) {
	            studentRepository.delete(optionalDepartment.get());
	        }
	}

	@Override
	public List<Courses> viewallcoursesofthatyearsem(int year, int sem) {
		
		return studentRepository.viewallcoursesofthatyearsem(year,sem);
	}

	@Override
	public String studentCourseMapping(StudentCourseMapping s) {
		studentCourseMappingRepository.save(s);
		return "done";
	}

	@Override
	public int checkStudentCoursemapping(Courses c, Student s) {
		return (int) studentCourseMappingRepository.checkStudentCoursemapping(c,s);
	}

	@Override
	public List<StudentCourseMapping> noofcoursesmappedtoStudent(Student s) {
		return  studentCourseMappingRepository.noofcoursesmappedtoStudent(s);
	}

	@Override
	public String unenrollcoursetostudentmapped(Student s, Courses c) {
		StudentCourseMapping scm = studentCourseMappingRepository.getofSCmobject(s,c);
		studentCourseMappingRepository.delete(scm);
		return "done";
	}

	
	
	

}

