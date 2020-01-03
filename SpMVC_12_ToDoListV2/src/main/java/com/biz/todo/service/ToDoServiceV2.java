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
		return toDao.update(toDolist);
	
	}

	@Override
	public int delete(long tdSeq) {
		return toDao.delete(tdSeq);
	}
	
	
}
