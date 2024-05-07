package com.klef.jfsd.springboot.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "studenttodolist_table")
public class StudentToDoList 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int student_id;
	
	private String todotask;
	
	private Date duedate;
	
	private boolean todostatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getTodotask() {
		return todotask;
	}

	public void setTodotask(String todotask) {
		this.todotask = todotask;
	}

	public Date getDuedate() {
		return duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public boolean isTodostatus() {
		return todostatus;
	}

	public void setTodostatus(boolean todostatus) {
		this.todostatus = todostatus;
	}

	@Override
	public String toString() {
		return "StudentToDoList [id=" + id + ", student_id=" + student_id + ", todotask=" + todotask + ", duedate="
				+ duedate + ", todostatus=" + todostatus + "]";
	}

	
}
