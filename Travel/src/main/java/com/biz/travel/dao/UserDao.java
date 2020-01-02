package com.biz.travel.dao;

import com.biz.travel.domain.UserDTO;

public interface UserDao {

	String getMaxSeq();

	int insert(UserDTO uDTO);

	UserDTO findById(String u_id);

}
