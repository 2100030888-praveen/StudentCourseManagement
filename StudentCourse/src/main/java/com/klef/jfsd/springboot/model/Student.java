package com.klef.jfsd.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_table")
public class Student 
{

	//int year;
	//int sem;
		 
	
	@Id
	@Column(name="student_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	@Column(name="student_name",nullable=false,length = 50)
	private String name;
	
	@Column(name="student_gender",nullable=false,length = 10)
	private String gender;
	
	@Column(name="student_dob",nullable=false,length = 20)
	private String dateofbirth;
	
	@Column(name="student_department",nullable=false,length = 20)
	private int department_id;
	
	@Column(name="student_year")
	private int year;
	
	@Column(name = "student_sem")
	private int sem;
	
	@Column(name="student_email",nullable=false,unique = true,length = 30)
	private String email;
	
	@Column(name="student_password",nullable=false,length = 30)
	private String password;
	
	@Column(name="student_contact",nullable=false,unique = true)
	private String contact;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public int getDepartment() {
		return department_id;
	}

	public void setDepartment(int department) {
		this.department_id = department;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", dateofbirth=" + dateofbirth
				+ ", department=" + department_id + ", year=" + year + ", sem=" + sem + ", email=" + email + ", password="
				+ password + ", contact=" + contact + "]";
	}

	
}
