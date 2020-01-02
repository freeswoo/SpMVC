package com.biz.travel.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
/*
 * 로그인 기능에 필요한 DB에 User table 애트리뷰트들
 */
public class UserDTO {
	private String user_seq;//	varchar2(5 byte)
	private String user_id;//	nvarchar2(20 char)
	private String user_pass;//	nvarchar2(20 char)
	private String re_pass;// 유효성검사에 활용
	private String user_name;//	nvarchar2(10 char)
	private String user_del;//	nvarchar2(1 char)
}