package com.klef.jfsd.springboot.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "studentcoursemapping_table")
public class StudentCourseMapping {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "course_id")
	private Courses course;
	
	@Column(nullable = false)

	private int year;
	
	@Column(nullable = false)

	private int sem;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Courses getCourse() {
		return course;
	}

	public void setCourse(Courses course) {
		this.course = course;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSem() {
		return sem;
	}

	public void setSem(int sem) {
		this.sem = sem;
	}

	@Override
	public String toString() {
		return "StudentCourseMapping [id=" + id + ", student=" + student + ", course=" + course + ", year=" + year
				+ ", sem=" + sem + "]";
	}
	
	
}
