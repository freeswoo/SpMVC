package com.biz.ems.controller;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


// @RequiredArgsConstructor
@RequestMapping(value="/props")
@RestController
public class PropsRestController {

	/*
	 * properties는 프로젝트의 여러 클래스들이
	 * 공통적으로 사용하고자 특별히 저장해 놓은 변수들
	 * 
	 * properties로 등록한 프로젝트 변수를
	 * 프로젝트에서 참조하여 사용하는 방법
	 * 
	 * @Value(문자열)
	 * String 변수명
	 * ==> 프로젝트에 등록된 properties를 참조하여 해당 문자열을 검색하고
	 * 		문자열이 검색되면 문자열=값 형식으로 저장된 곳에서 
	 * 		값을 가져와서 변수명에 저장하여 
	 * 		일반 문자열 변수처럼 사용할수 있도록 해 준다
	 */
	@Value("${naver.username}")
	private String naver_username;
	
	@Value("${mysql.user}")
	private String mysql_username;
	
//	@Value("#{app_pros['app.name']}")
//	private String app_name;
//	
//	@Value("#{app_pros['app.since']}")
//	private String app_since;
	
	@RequestMapping(value="/system",method=RequestMethod.GET)
	public Properties system() {
		
		Properties props = System.getProperties();
		return props;
		
	}
	
	@RequestMapping(value="/enc",method=RequestMethod.GET)
	public String enc() {
		
		String ret = String.format("naver : %s, mysql : %s",
				naver_username,mysql_username);
		
		return ret;
	}
	
//	@RequestMapping(value="/app",method=RequestMethod.GET)
//	public String app() {
//		String app = String.format("name:%s, since:%s", app_name,app_since);
//		return app;
//	}
	
}
