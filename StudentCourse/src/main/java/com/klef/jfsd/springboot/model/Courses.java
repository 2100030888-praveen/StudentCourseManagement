package com.klef.jfsd.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "course_table")
public class Courses 
{
	@Id
	private int course_id;
	
	@Column(nullable = false)
	private String course_name;
	
	@Column(nullable = false,unique = true)
	private String course_code;
		
	@Column(nullable = false)
	private double course_credits;
	
	@Column(nullable = false)
	private int course_departement_id;
	
	@Column(nullable=false)
	private int course_cc_id;
	
	@Column(nullable = false)
	private int course_year;
	
	@Column(nullable = false)
	private int course_sem;
	
	@Column(nullable = false)
	private int limit_number_enrollments;
	
	@Column(nullable = false,length = 500)
	private String course_description;

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_code() {
		return course_code;
	}

	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}

	public double getCourse_credits() {
		return course_credits;
	}

	public void setCourse_credits(double course_credits) {
		this.course_credits = course_credits;
	}

	public int getCourse_departement_id() {
		return course_departement_id;
	}

	public void setCourse_departement_id(int course_departement_id) {
		this.course_departement_id = course_departement_id;
	}

	public int getCourse_cc_id() {
		return course_cc_id;
	}

	public void setCourse_cc_id(int course_cc_id) {
		this.course_cc_id = course_cc_id;
	}

	public int getCourse_year() {
		return course_year;
	}

	public void setCourse_year(int course_year) {
		this.course_year = course_year;
	}

	public int getCourse_sem() {
		return course_sem;
	}

	public void setCourse_sem(int course_sem) {
		this.course_sem = course_sem;
	}

	public int getLimit_number_enrollments() {
		return limit_number_enrollments;
	}

	public void setLimit_number_enrollments(int limit_number_enrollments) {
		this.limit_number_enrollments = limit_number_enrollments;
	}

	public String getCourse_description() {
		return course_description;
	}

	public void setCourse_description(String course_description) {
		this.course_description = course_description;
	}

	@Override
	public String toString() {
		return "Courses [course_id=" + course_id + ", course_name=" + course_name + ", course_code=" + course_code
				+ ", course_credits=" + course_credits + ", course_departement_id=" + course_departement_id
				+ ", course_cc_id=" + course_cc_id + ", course_year=" + course_year + ", course_sem=" + course_sem
				+ ", limit_number_enrollments=" + limit_number_enrollments + ", course_description="
				+ course_description + "]";
	}


}
