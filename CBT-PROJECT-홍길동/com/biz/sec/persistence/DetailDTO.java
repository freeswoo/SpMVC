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
public class DetailDTO {

	private long d_seq;
	private long d_m_seq; // Master table과 연계(Replation)을 수행하는 Key
	private String d_subject;
	private String d_ok;
	
}
