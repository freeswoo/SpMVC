package com.biz.friend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.biz.friend.domain.FriendVO;

public interface FriendDao {

	@Select("SELECT * FROM tbl_friend")
	public List<FriendVO> selectAll();
	
	public void update(FriendVO friendVO);
	public void insert(FriendVO friendVO);
	
	@Delete("DELETE FROM tbl_friend WHERE friend_id = #{friend_id}")
	public int delete(long friend_id);
	
	@Select("SELECT * FROM tbl_friend WHERE friend_name LIKE CONCAT ('%', #{friend_name}, '%') ")
	public FriendVO findByName(String friend_name);
	
	@Select("SELECT * FROM tbl_friend WHERE friend_tel LIKE CONCAT ('%', #{friend_tel}, '%')"
			+ " OR friend_hp LIKE CONCAT ('%', #{friend_tel}, '%'")
	public FriendVO findByTel(String friend_tel);

	@Select("SELECT * FROM tbl_friend WHERE friend_id = #{friend_id}")
	public FriendVO findById(long friend_id);
	
}
