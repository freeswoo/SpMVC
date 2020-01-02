package com.biz.memo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.biz.memo.domain.UserDTO;
import com.biz.memo.persistence.UserDao;

/*
 * interface를 imp하여 생성한 클래스에 @Service를 붙여주면
 * @Autowired를 수행할때
 * 
 * Interface 객체 형식으로 코드를 작성하면
 * 자동으로 해당 객체를 가져와서 객체를 초기화 하여준다.
 */
@Service
public class UserServiceImp implements UserService {

	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	BCryptPasswordEncoder PasswordEncoder;
	
	UserDao uDao;
	@Autowired
	public void newUserDao() {
		uDao = sqlSession.getMapper(UserDao.class);
	}
	
	@Override
	public int userJoin(UserDTO userDTO) {
		// TODO Auto-generated method stub
		
		// 이미 1명이라도 테이블에 정보가 저장된 상태라면
		// grade = "U"
		if(uDao.userCount() > 0 ) {
			userDTO.setU_grade("U");
		
		// 아니면 grade = "A"
		} else {
			userDTO.setU_grade("A");
		}
		
		String cryptText 
			= PasswordEncoder.encode(userDTO.getRe_password());
		userDTO.setU_password(cryptText);
		
		return uDao.userInsert(userDTO);
		
		
	
	}

	@Override
	public boolean userIdCheck(String u_id) {
		
		UserDTO userDTO = uDao.findById(u_id);

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
				userDTO.getU_id().equalsIgnoreCase(u_id) ) {
			return true;
		}
		return false;
	
	}

	@Override
	public boolean userLoginCheck(UserDTO userDTO) {
		// TODO Auto-generated method stub
		
		String inU_id = userDTO.getU_id();
		
		// 사용자가 로그인 하면서 입력한 비번
		// 평문인 상태의 비번
		String inU_pass = userDTO.getU_password();
		
		// 암호화를 대비한 코드로 작성
		// id를 매개변수로 보내고
		// id로 조회를 하여 회원정보를 받기
		UserDTO userRDTO = uDao.findById(inU_id);
		
		// 회원정보가 없을 경우
		if(userRDTO == null) {
			return false;
		}
		
		String sU_id = userRDTO.getU_id();
		// String sU_pass = userRDTO.getU_password();
		
		String cryptU_pass = userRDTO.getU_password();

		// 회원id는 존재를 하는데 비번이 틀렸을 경우
		if(sU_id.equalsIgnoreCase(inU_id) && 
				
				// Bcrypt로 암호화된 문자열은 equal()등의 method로
				// match 되는지 비교가 불가능하고
				// BCrypt에서 지원하는 matches() method를 사용하여
				// match 되는지 비교를 한다
				PasswordEncoder.matches(inU_pass, cryptU_pass)) {
			
			/*
			 * java method에서 객체를 매개변수로 받은 후
			 * 각 필드변수들을 개별적으로 변경을 하면
			 * 파라메터로 주입한 원본의 변수값들이 변경 된다.
			 * 
			 * 하지만
			 * 객체 = 다른객체
			 * 또는 객체 = new 클래스() 형식으로
			 * 자체를 변경해 버리면
			 * 파라메터로 주입한 원본은 변경이 되지 않는다.
			 * 
			 * 그래서 이경우 
			 * 		각 필드변수 요소들을 
			 * 		모두 주입해 주어야 한다.
			 */
			// userDTO = userRDTO;
			// userDTO.setU_grade(userRDTO.getU_grade());
			// "
			return true;
		} else {
			return false;
		}
	}

	@Override
	public UserDTO getUser(String u_id) {
		return uDao.findById(u_id);
	}

}
