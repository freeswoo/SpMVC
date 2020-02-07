package com.biz.friend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class FriendVO {

	private long friend_id;			//	bigint	not null	primary key
	private String friend_name;		//	varchar(5)	not null	
	private String friend_tel;		//	varchar(13)		
	private String friend_hp;		//	varchar(13)	not null	
	private String friend_addr;		//	varchar(100)		
	private String friend_hobby;	//	varchar(20)		
	private String friend_relation;	//	varchar(10)	not null	

}
