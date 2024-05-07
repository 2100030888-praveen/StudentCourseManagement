package com.klef.jfsd.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.klef.jfsd.springboot.model.RegistrationStatus;



@Repository
public interface RegistrationStatusRepository extends JpaRepository<RegistrationStatus, Integer> 
{
	@Modifying
	@Transactional
	@Query(" update RegistrationStatus r set r.status=?2 where r.id=?1 ")
	public int updatestatus(int eid,boolean status);

	 @Query("SELECT r.status FROM RegistrationStatus r WHERE r.year = :year AND r.sem = :sem")
	    boolean getstatusbyyearsem(@Param("year") int year, @Param("sem") int sem);


	
}
