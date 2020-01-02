package com.biz.travel.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.travel.dao.UserDao2;
import com.biz.travel.domain.UserDTO2;

// SpMVC 05 참조

@Service
public class UserService2 {
	
	@Autowired
	SqlSession sqlSession;
	UserDao2 uDao;
	
	@Autowired
	public void getUserDaoMapper() {
		uDao = sqlSession.getMapper(UserDao2.class);
	}

	public int insert(UserDTO2 uDTO) {
		String strMaxUserSeq = uDao.getMaxSeq();
		int maxUserSeq = 0;
		maxUserSeq = Integer.valueOf(strMaxUserSeq);
		maxUserSeq++;
		uDTO.setUser_seq(maxUserSeq);
		return uDao.insert(uDTO);
	}

	public boolean userIdCheck(String u_id) {
		UserDTO2 userDTO = uDao.findById(u_id);

		/*
		 * if 문 조건에 else가 꼭 있어야 하는 코드
		if(userDTO == null) {
			return false;
		} else {
			return true;
		}
		return false;
		*/
		
		
		// else가 없어도 되는 코드
		// if 비교문에서 else가 없어도 되는 코드를 만들수 있으면
		// 가급적 else 를 없이 사용하자
		if(userDTO != null && 
				userDTO.getUser_id().equalsIgnoreCase(u_id) ) {
			return true;
		}
		return false;
	}
}
