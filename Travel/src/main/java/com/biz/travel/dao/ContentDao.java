package com.biz.travel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.travel.domain.ContentDTO;

public interface ContentDao {
	List<ContentDTO> getBySeasonAndDevide(@Param("travel_season")int travel_season, @Param("travel_devide") String travel_devide);

	List<ContentDTO> getBySeason(int travel_season);
}
