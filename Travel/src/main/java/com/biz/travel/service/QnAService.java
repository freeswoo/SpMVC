package com.biz.travel.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.travel.dao.QnADao;
import com.biz.travel.domain.QnADTO;

@Service
public class QnAService {
	
	@Autowired
	SqlSession sqlSession;
	QnADao qnaDao;
	
	@Autowired
	public void getQnADao() {
		qnaDao = sqlSession.getMapper(QnADao.class);
	}
	
	public List<QnADTO> getAllList(){ // 게시판에 있는 전체 내용을 가져와서 Controller에서 가져다 쓰기 위한 메소드
		return qnaDao.selectAll();
	}

	public List<QnADTO> getSearchList(String search) {
		QnADTO qnaDTO = QnADTO.builder()
				.qna_subject(search)
				.build();
		return qnaDao.findBySubject(qnaDTO);
	}

	public int insert(QnADTO qnaDTO) {
		String qnaSeq = qnaDao.getMaxSeq();
		if(qnaSeq == null) {
			qnaSeq = "qa001";
		}
		else {
			String strQnaSeq = qnaSeq.substring(0, 2);
			String intQnaSeq = qnaSeq.substring(2);
			intQnaSeq = String.format("%03d", Integer.valueOf(intQnaSeq + 1));
			qnaSeq = strQnaSeq + intQnaSeq;
		}
		qnaDTO.setQna_seq(qnaSeq);
		return qnaDao.insert(qnaDTO);
	}

	public QnADTO findBySeq(String str_seq) {
		return qnaDao.findBySeq(str_seq);
	}
}
