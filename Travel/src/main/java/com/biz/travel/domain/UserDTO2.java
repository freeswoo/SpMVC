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
public class UserDTO2 {
	private int user_seq;// NUMBER PRIMARY KEY,
	private String user_id;// VARCHAR2(20) NOT NULL UNIQUE,
	private String user_pass;// VARCHAR2(20) NOT NULL,
	private String re_pass; // 유효성 검사에만 쓰인다
	private String user_name;// nVARCHAR2(10) NOT NULL,
	private String user_tel;// VARCHAR2(12),
	private String user_birth;// VARCHAR2(8),
	private String user_email;// nVARCHAR2(30),
	private int user_status;// NUMBER,
	private String user_delete;// VARCHAR2(1)
}