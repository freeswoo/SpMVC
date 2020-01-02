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
public class QnADTO {
	private String qna_seq;//	varchar2(5 byte)
	private String qna_date;//	nvarchar2(20 char)
	private String qna_subject;//	nvarchar2(20 char)
	private String qna_content;//	nvarchar2(1000 char)
	private String qna_id;//	varchar2(50 byte)
	private String qna_delete;//	varchar2(1 byte)
}
