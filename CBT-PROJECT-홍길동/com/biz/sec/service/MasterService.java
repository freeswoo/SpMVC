package com.biz.sec.service;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.biz.sec.config.DBConnectionSEC;
import com.biz.sec.mapper.MDDao;
import com.biz.sec.persistence.DetailDTO;
import com.biz.sec.persistence.MasterDTO;
import com.biz.sec.persistence.MasterDetailVO;

public class MasterService {

	protected MDDao mdDao;
	protected Scanner scanner;
	
	{
		// .openSession(true) 
		//		auto Commit, INSERT, UPDATE, DETELE 자동 반영
		// .openSession() : hand Commit 자동 반영 안된
		mdDao = DBConnectionSEC
				.getInstance()
				.openSession(true)
				.getMapper(MDDao.class);
		
		scanner = new Scanner(System.in);
	}
	
	
	public void insertMaster() {
		
		System.out.println("문제입력(-Q:quit)");
		System.out.println(">> ");
		String strQ = scanner.nextLine();
		if(strQ.equals("-Q")) return;
		
		MasterDTO mDTO = MasterDTO.builder()
				.m_subject(strQ).build();
		
		System.out.printf("m_seq : %d",mDTO.getM_seq());
		
		int ret = mdDao.insertMaster(mDTO);
		
		System.out.printf("m_seq : %d",mDTO.getM_seq());
		
		DetailDTO dDTO = DetailDTO.builder()
				.d_m_seq(mDTO.getM_seq()).build();
		
	}

	public void masterAndDetail() {
		
		List<MasterDetailVO> mdList = mdDao.selectAll();
		Collections.shuffle(mdList);
		
		int nQNum = 1;
		for(MasterDetailVO mVO : mdList) {
			// System.out.print(mVO.getM_seq() + " : ");
			System.out.print(nQNum++ + " : ");
			System.out.println(mVO.getM_subject());
			
			List<DetailDTO> deList = mVO.getDeList();
			if(deList != null) {
				
				Collections.shuffle(deList);
				int nNum = 1;
				for(DetailDTO dto  : deList) {
					System.out.printf("%d\t",nNum++);
					System.out.printf("%s\t",dto.getD_subject());
					System.out.printf("%s\n",dto.getD_ok());
				}
			}
		}
	}
}
