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
public class ContentDTO {
	private String travel_seq; //	varchar2(5 byte)
	private String travel_name; //	nvarchar2(30 char)
	private String travel_addr; //	nvarchar2(80 char)
	private String travel_tel; //	nvarchar2(13 char)
	private int travel_season; //	number
	private int travel_unit; //	number
	private String travel_devide; //	nvarchar2(5 char)
	private String travel_imgurl; //	nvarchar2(500 char)
}
