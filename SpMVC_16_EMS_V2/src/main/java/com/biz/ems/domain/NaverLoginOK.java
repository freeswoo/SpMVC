package com.biz.ems.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NaverLoginOK {

	private String code;
	private String state;
	private String email;
	private String nackname;
	private String name;
}
