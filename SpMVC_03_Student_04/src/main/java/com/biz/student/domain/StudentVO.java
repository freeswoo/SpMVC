package com.biz.student.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentVO {

	private String st_num;//	varchar2(3 byte)
	private String st_name;//	nvarchar2(50 char)
	private String st_tel;//	varchar2(20 byte)
	private String st_addr;//	nvarchar2(125 char)
	private int st_grade;//	number(1,0)
	private String st_dept;//	varchar2(3 byte)
	
}
