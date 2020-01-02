package com.biz.todo.service;

import org.springframework.stereotype.Service;

import com.biz.todo.domain.ToDoList;

@Service("toServiceV2")
public class ToDoServiceV2 extends ToDoServiceV1{

	@Override
	public int complete(String strSeq,String tdComplete) {
		long tdSeq = Long.valueOf(strSeq);
		return toDao.complete(tdSeq);
	}

	@Override
	public int alarm(String strSeq, String tdAlarm) {
		long tdSeq = Long.valueOf(strSeq);
		return toDao.alarm(tdSeq);
	}

	@Override
	public int update(ToDoList toDolist) {
		
		if(toDolist.getTd_alarm() == null) {
			toDolist.setTd_alarm("N");
		}
		if(toDolist.getTd_complete() == null) {
			toDolist.setTd_complete("N");
		}
		return toDao.update(toDolist);
	}

	@Override
	public int delete(long tdSeq) {
		return toDao.delete(tdSeq);
	}
	
	
}
