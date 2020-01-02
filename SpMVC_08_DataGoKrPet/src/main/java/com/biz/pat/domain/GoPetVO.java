package com.biz.pat.domain;

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
public class GoPetVO {
	
	private String apiSid;		//	데이터번호
	private String apiDongName;	//	동물병원의 이름
	private String apiNewAddress;//	도로명주소
	private String apiOldAddress;//	지번주소
	private String apiTel;		//	대행업소의 연락처
	private String apiLat;		//	위도
	private String apiLng;		//	경도
	private String apiRegDate;	//	데이터기준일
}
