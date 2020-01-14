package com.biz.sec.mapper;

import java.util.List;
import java.util.Map;

import com.biz.sec.persistence.IolistDTO;

public interface IolistDao {
	
	/*
	 * mapper.xml에 설정된 resultMap에 각 레코드데이터를 담고
	 * resultMap의 요소를 List로 묶어서 나에게 달라
	 */
	public List<Map<String,Object>> selectAllMap();
	public List<IolistDTO> selectAll();

}
