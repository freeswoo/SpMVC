package com.biz.travel.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.travel.dao.ContentDao;
import com.biz.travel.domain.ContentDTO;

@Service
public class ContentService {
	
	@Autowired
	SqlSession sqlSession;
	
	ContentDao cDao;
	
	@Autowired
	public void getContentDaoMapper() {
		cDao = sqlSession.getMapper(ContentDao.class);
	}
	
	/*
	public String recogDevide() {
		String query = "";
		// 지도에서 클릭된게 어느지역인지 파악해서 해당하는 지역에 대한 DB 리스트 긁어오기 
		return null;
	}
	*/
	/*
	public int insert(ContentDTO cDTO) {
		String mSeq = cDao.findByMaxSeq();
		String strMSeq = mSeq.substring(0, 2);
		int intMSeq = Integer.valueOf(mSeq.substring(2));
		intMSeq++;
		mSeq = strMSeq + String.format("%03d", intMSeq);
		cDTO.setTravel_seq(mSeq);
		return cDao.insert(cDTO);
	}
	
	public int update(ContentDTO cDTO) {
		
		return cDao.update(cDTO);
	}
	*/
	
	public List<ContentDTO> findBySeason(int travel_season){
		return cDao.getBySeason(travel_season);
	}

	public List<ContentDTO> findBySeasonAndDevide(int travel_season, String travel_devide) {
		return cDao.getBySeasonAndDevide(travel_season, travel_devide);
	}
}
