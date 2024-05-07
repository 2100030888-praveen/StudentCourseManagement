package com.klef.jfsd.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Announcements;
import com.klef.jfsd.springboot.repository.AnnouncementRepository;

@Service
public class AnnouncementServiceImpl implements AnnouncementService
{
	@Autowired
	private AnnouncementRepository announcementRepository;
	
	
	@Override
	public String addannouncement(Announcements a) {
		announcementRepository.save(a);
		return "Announcement added successfully";
	}


}
