package com.biz.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biz.ems.domain.EmailVO;

@Repository
public interface EmailDao extends JpaRepository<EmailVO, Long>{

	// public EmailVO findByEms_seq(long ems_seq);
	
	// select * from tbl_ems where from_email = #{from_email}
	// List<EmailVO> findAllByFromEmail(String from_email);
	// List<EmailVO> findAllByFromEmailOrderByEmsSeqAsc(String from_email);
	
	// >
	// List<EmailVO> findAllBySendDateGreaterThan(String send_date);
	
	// <
	// List<EmailVO> findAllBySendDateLessThan(String send_date);
	
	// List<EmailVO> findAllByFromEmailAndFromName(
//					@Param("from_email") String from_email, 
//					@Param("from_name") String from_name);

//	List<EmailVO> findAllByFromEmailOrFromName(
//			@Param("from_email") String from_email, 
//			@Param("from_name") String from_name);

	
}
