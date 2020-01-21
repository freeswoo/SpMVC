package com.biz.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.ems.domain.EmailVO;
import com.biz.ems.repository.EmailDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MailService {
	
	private final EmailDao emsDao;
	
	public int insert(EmailVO emailVO) {
		
		emsDao.save(emailVO);
		return 0;
	}
	
	public List<EmailVO> selectAll() {
		
		List<EmailVO> mailList = (List<EmailVO>) emsDao.findAll();
		return mailList;
	}

}
