package com.klef.jfsd.springboot.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="announcement_table")
@Entity
public class Announcements 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int announcements_id;
	
	private String announcement;
	
	private Date announcement_start_time;
	
	private Date announcement_end_time;
	
	private int department_id_to_be_announcement;
	
	private String department_name_to_be_announcement;
	
	private int course_id_to_be_announcement;
	
	private String course_name_to_be_announcement;
	
	private boolean is_for_faculty;
	
	private boolean is_for_students;
	
	private boolean is_for_both;

	public int getAnnouncements_id() {
		return announcements_id;
	}

	public void setAnnouncements_id(int announcements_id) {
		this.announcements_id = announcements_id;
	}

	public String getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}

	public Date getAnnouncement_start_time() {
		return announcement_start_time;
	}

	public void setAnnouncement_start_time(Date announcement_start_time) {
		this.announcement_start_time = announcement_start_time;
	}

	public Date getAnnouncement_end_time() {
		return announcement_end_time;
	}

	public void setAnnouncement_end_time(Date announcement_end_time) {
		this.announcement_end_time = announcement_end_time;
	}

	public int getDepartment_id_to_be_announcement() {
		return department_id_to_be_announcement;
	}

	public void setDepartment_id_to_be_announcement(int department_id_to_be_announcement) {
		this.department_id_to_be_announcement = department_id_to_be_announcement;
	}

	public String getDepartment_name_to_be_announcement() {
		return department_name_to_be_announcement;
	}

	public void setDepartment_name_to_be_announcement(String department_name_to_be_announcement) {
		this.department_name_to_be_announcement = department_name_to_be_announcement;
	}

	public int getCourse_id_to_be_announcement() {
		return course_id_to_be_announcement;
	}

	public void setCourse_id_to_be_announcement(int course_id_to_be_announcement) {
		this.course_id_to_be_announcement = course_id_to_be_announcement;
	}

	public String getCourse_name_to_be_announcement() {
		return course_name_to_be_announcement;
	}

	public void setCourse_name_to_be_announcement(String course_name_to_be_announcement) {
		this.course_name_to_be_announcement = course_name_to_be_announcement;
	}

	public boolean isIs_for_faculty() {
		return is_for_faculty;
	}

	public void setIs_for_faculty(boolean is_for_faculty) {
		this.is_for_faculty = is_for_faculty;
	}

	public boolean isIs_for_students() {
		return is_for_students;
	}

	public void setIs_for_students(boolean is_for_students) {
		this.is_for_students = is_for_students;
	}

	@Override
	public String toString() {
		return "Announcements [announcements_id=" + announcements_id + ", announcement=" + announcement
				+ ", announcement_start_time=" + announcement_start_time + ", announcement_end_time="
				+ announcement_end_time + ", department_id_to_be_announcement=" + department_id_to_be_announcement
				+ ", department_name_to_be_announcement=" + department_name_to_be_announcement
				+ ", course_id_to_be_announcement=" + course_id_to_be_announcement + ", course_name_to_be_announcement="
				+ course_name_to_be_announcement + ", is_for_faculty=" + is_for_faculty + ", is_for_students="
				+ is_for_students + ", is_for_both=" + is_for_both + "]";
	}

	public boolean isIs_for_both() {
		return is_for_both;
	}

	public void setIs_for_both(boolean is_for_both) {
		this.is_for_both = is_for_both;
	}
}
