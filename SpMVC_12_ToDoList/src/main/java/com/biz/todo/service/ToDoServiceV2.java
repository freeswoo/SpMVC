package com.biz.todo.service;

import org.springframework.stereotype.Service;

@Service("toServiceV2")
public class ToDoServiceV2 extends ToDoServiceV1{

	@Override
	public int complete(String strSeq,String tdComplete) {
		long tdSeq = Long.valueOf(strSeq);
		
		tdComplete = tdComplete.equalsIgnoreCase("Y") ? "N" : "Y";
		return toDao.complete(tdSeq,tdComplete);
	}

	@Override
	public int alarm(String strSeq, String tdAlarm) {
	
		long tdSeq = Long.valueOf(strSeq);
		
		tdAlarm = tdAlarm.equalsIgnoreCase("Y") ? "N" : "Y";
		return toDao.alarm(tdSeq,tdAlarm);

	
	}
	
	
	
	
}
