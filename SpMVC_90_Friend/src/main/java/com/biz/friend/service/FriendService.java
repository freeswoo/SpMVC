package com.biz.friend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.friend.domain.FriendVO;
import com.biz.friend.mapper.FriendDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("fService")
public class FriendService {

	protected final FriendDao friendDao;
	
	public List<FriendVO> selectAll() {
		return friendDao.selectAll();
	}
	
	public FriendVO findById(long friend_id) {
		return friendDao.findById(friend_id);
	}
	
	public FriendVO findByName(String name) {
		return friendDao.findByName(name);
	}
	
	public FriendVO findByTel(String tel) {
		return friendDao.findByTel(tel);
	}
	
	public int save(FriendVO friendVO) {
		
		long friend_id = friendVO.getFriend_id();
		if(friend_id > 0) {
			friendDao.update(friendVO);
		} else {
			friendDao.insert(friendVO);
		}
		return 0;
	}
	
	public int delete(long friend_id) {
		return friendDao.delete(friend_id);
	}
}
