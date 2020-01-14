package com.biz.sec.persistence;

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
public class CbtDTO {

	private long cb_seq;		//	number
	private String cb_questions;//	nvarchar2(1000 char)
	private String cb_qnum1;	//	nvarchar2(1000 char)
	private String cb_qnum2;	//	nvarchar2(1000 char)
	private String cb_qnum3;	//	nvarchar2(1000 char)
	private String cb_qnum4;	//	nvarchar2(1000 char)
	private String cb_answer;	//	nvarchar2(1000 char)
	
}
