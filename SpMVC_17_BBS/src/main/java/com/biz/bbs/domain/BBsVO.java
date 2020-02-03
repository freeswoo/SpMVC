package com.biz.bbs.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BBsVO {

	private long bbs_id;		//	bigint
	private String bbs_p_id;	//	bigint
	private String bbs_writer;	//	varchar(50)
	private String bbs_date;	//	varchar(10)
	private String bbs_time;	//	varchar(10)
	private String bbs_subject;	//	varchar(125)
	private String bbs_content;	//	varchar(1000)
	private int bbs_count;		//	int

}
