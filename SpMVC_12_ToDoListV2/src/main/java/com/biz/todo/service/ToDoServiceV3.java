package com.biz.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.todo.domain.ToDoList;

@Service("todoV3")
public class ToDoServiceV3 extends ToDoServiceV2 {

	@Override
	public ToDoList findBySeq(long tdSeq) {
		return toDao.findBySeq(tdSeq);
	}

	@Override
	public List<ToDoList> findBySubject(String tdSubject) {
		return toDao.findBySubject(tdSubject);
	}
	
}




