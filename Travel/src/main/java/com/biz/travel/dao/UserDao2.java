package com.biz.travel.dao;

import com.biz.travel.domain.UserDTO;
import com.biz.travel.domain.UserDTO2;

public interface UserDao2 {

	String getMaxSeq();

	int insert(UserDTO2 uDTO);

	UserDTO2 findById(String u_id);

}
