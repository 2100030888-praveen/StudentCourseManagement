package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.jfsd.springboot.model.Announcements;

public interface AnnouncementRepository extends JpaRepository<Announcements, Integer>
{
	
}
