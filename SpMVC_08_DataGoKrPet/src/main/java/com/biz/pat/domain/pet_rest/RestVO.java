package com.biz.pat.domain.pet_rest;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * java 1.7 이상에서만 작동된다
 * java dependency(pom.xml) 에 추가해주면 된다
 */
@XmlRootElement(name="rfcOpenApi")
public class RestVO {
	
	public RestBody body;
	
}
