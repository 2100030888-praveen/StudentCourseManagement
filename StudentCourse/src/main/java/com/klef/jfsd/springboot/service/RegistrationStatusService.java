package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.RegistrationStatus;

public interface RegistrationStatusService {
	public int updatestatus(int rid, boolean status);

	public List<RegistrationStatus> getallstatus();

	public boolean getstatusbyyearsem(int sy, int ss);
}
