package com.biz.ems.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biz.ems.domain.EmailVO;

@Repository
public interface EmailDao extends CrudRepository<EmailVO, Long> {

	
	
}
