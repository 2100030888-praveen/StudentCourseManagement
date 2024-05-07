package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.RegistrationStatus;
import com.klef.jfsd.springboot.repository.RegistrationStatusRepository;

@Service
public class RegistrationStatusServiceImpl implements RegistrationStatusService
{
	@Autowired
	public RegistrationStatusRepository registrationStatusRepository;

	@Override
	public int updatestatus(int rid, boolean status) {
		return registrationStatusRepository.updatestatus(rid, status);
	}

	@Override
	public List<RegistrationStatus> getallstatus() {
		
		return registrationStatusRepository.findAll();
	}

	@Override
	public boolean getstatusbyyearsem(int sy, int ss) {
		
		return registrationStatusRepository.getstatusbyyearsem(sy,ss);
	}
	

}
