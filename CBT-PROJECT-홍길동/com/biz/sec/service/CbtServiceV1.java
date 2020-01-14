package com.biz.sec.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.biz.sec.config.DBConnectionSEC;
import com.biz.sec.mapper.CbtDao;
import com.biz.sec.persistence.CbtDTO;
import com.biz.sec.persistence.CbtVO;

public class CbtServiceV1 {

	
	CbtDao cbtDao;
	{
		cbtDao = DBConnectionSEC
				.getInstance()
				.openSession(true)
				.getMapper(CbtDao.class);
	}
	
	public void viewAllList() {
		List<CbtDTO> cbtList = cbtDao.selectAll();
		for(CbtDTO dto : cbtList) {
			System.out.println(dto);
		}
	}
	
	public void viewQandA() {
		
		List<CbtDTO> cbtList = cbtDao.selectAll();
		List<CbtVO> qandAList = new ArrayList<CbtVO>();
		
		for(CbtDTO dto : cbtList) {
			
			CbtVO cbtVO = CbtVO.builder()
					.cb_questions(dto.getCb_questions())
					.cb_seq(dto.getCb_seq())
					.cb_qnums(new ArrayList<String>()).build();
			
			cbtVO.getCb_qnums().add(dto.getCb_qnum1());
			cbtVO.getCb_qnums().add(dto.getCb_qnum2());
			cbtVO.getCb_qnums().add(dto.getCb_qnum3());
			cbtVO.getCb_qnums().add(dto.getCb_qnum4());
			
			qandAList.add(cbtVO);
		}
		
		Collections.shuffle(qandAList);

		int nums = 1;
		for(CbtVO vo : qandAList) {
			System.out.print(nums++ + " : ");
			System.out.println(vo.getCb_questions());
			
			Collections.shuffle(vo.getCb_qnums());
			
			int aNums = 1;
			for(String s : vo.getCb_qnums()) {
				System.out.print(aNums++ + ":");
				System.out.println(s);
			}
		}
	}
}
