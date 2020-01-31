package com.biz.ems.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NaverReturnAuth {
	
	private String code;
	private String state;
	private String error;
	private String error_description;
	
}
