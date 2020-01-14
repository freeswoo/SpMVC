package com.biz.sec.mapper;

import java.util.List;

import com.biz.sec.persistence.CbtDTO;

public interface CbtDao {
	
	public List<CbtDTO> selectAll();

}
