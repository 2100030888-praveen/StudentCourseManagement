package com.klef.jfsd.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "faculty_table")

public class Faculty {
	
	@Id
	@Column(name="faculty_id")
	private int id;
	
	@Column(name="faculty_name",nullable=false,length = 50)
	private String name;
	
	@Column(name="faculty_gender",nullable=false,length = 10)
	private String gender;
	
	@Column(name="faculty_dob",nullable=false,length = 20)
	private String dateofbirth;
	
	@Column(name="faculty_department",nullable=false,length = 20)
	private int department_id;
	
	@Column(name="faculty_salary",nullable=false)
	private double salary;
	
	@Column(name="faculty_email",nullable=false,unique = true,length = 30)
	private String email;
	
	@Column(name="faculty_password",nullable=false,length = 30)
	private String password;
	
	@Column(name="faculty_location",nullable=false)
	private String location;
	
	@Column(name="faculty_contact",nullable=false,unique = true)
	private String contact;
	
	@Column(name="faculty_ishod",nullable=true)
	private boolean ishod;

	@Column(name="faculty_iscc",nullable=true)
	private boolean iscc;

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

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public boolean isIshod() {
		return ishod;
	}

	public void setIshod(boolean ishod) {
		this.ishod = ishod;
	}

	public boolean isIscc() {
		return iscc;
	}

	public void setIscc(boolean iscc) {
		this.iscc = iscc;
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", gender=" + gender + ", dateofbirth=" + dateofbirth
				+ ", department_id=" + department_id + ", salary=" + salary + ", email=" + email + ", password="
				+ password + ", location=" + location + ", contact=" + contact + ", ishod=" + ishod + ", iscc=" + iscc
				+ "]";
	}

}
