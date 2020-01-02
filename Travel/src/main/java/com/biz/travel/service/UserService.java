package com.biz.travel.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.travel.dao.UserDao;
import com.biz.travel.domain.UserDTO;

// SpMVC 05 참조

@Service
public class UserService {
	
	@Autowired
	SqlSession sqlSession;
	UserDao uDao;
	
	@Autowired
	public void getUserDaoMapper() {
		uDao = sqlSession.getMapper(UserDao.class);
	}

	public int insert(UserDTO uDTO) { // 회원가입
		String strMaxUserSeq = uDao.getMaxSeq();
		if(strMaxUserSeq == null) { // 사용자가 없으면(isEmpty가 아니라 null로 넘어온다)
			strMaxUserSeq = "0";
		}
		int maxUserSeq = Integer.valueOf(strMaxUserSeq);
		maxUserSeq++;
		uDTO.setUser_seq(String.format("%s", maxUserSeq));
		return uDao.insert(uDTO);
	}

	public boolean userIdCheck(String u_id) { // id 유효성검사시 필요한 메소드
		UserDTO userDTO = uDao.findById(u_id);
		if(userDTO != null && 
				userDTO.getUser_id().equalsIgnoreCase(u_id) ) {
			return true;
		}
		return false;
	}

	public boolean userLoginCheck(UserDTO userDTO) {
		// GET method로 로그인 input form넘어가서 입력된 id, pass를 post로 받아서 DB에 id랑 비밀번호 일치하면 로그인
		String inU_id = userDTO.getUser_id();
		// 사용자가 로그인하면서 입력한 비번
		// 평문인 상태의 비번
		String inU_pass = userDTO.getUser_pass();
		// id를 매개변수로 보내고 id로 조회를 하여 회원정보를 받기. DB에서 받은 정보
		UserDTO userRDTO = uDao.findById(inU_id);
		// 회원정보가 없을 경우
		if(userRDTO == null) {
			return false;
		}
		String sU_id = userRDTO.getUser_id();
		String sU_pass = userRDTO.getUser_pass();		
		// 회원id는 존재를 하는데 비번이 틀렸을 경우
		if(sU_id.equalsIgnoreCase(inU_id) && sU_pass.equals(inU_pass)) {
			return true;
		} else {
			return false;
		}
	}

	public UserDTO getUser(String u_id) {
		return uDao.findById(u_id);
	}
}
