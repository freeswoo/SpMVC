package com.biz.travel.dao;

import java.util.List;

import com.biz.travel.domain.QnADTO;

public interface QnADao {

	List<QnADTO> selectAll();
	List<QnADTO> findBySubject(QnADTO qnaDTO);
	int insert(QnADTO qnaDTO);
	String getMaxSeq();
	QnADTO findBySeq(String str_seq);
}
