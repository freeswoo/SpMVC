package com.biz.sec.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBConnection {

	private static SqlSessionFactory sqlSessionFactory = null;
	
	static {
		String configFile = "com/biz/sec/config/mybatis-config.xml";
		InputStream is = null;
		
		/*
		 * 
		 * java에서 
		 * 어떤 setting 값들을 모아서 어떤 설정을 하는 용도로 사용한다.
		 * setting 값들을 쉽게 관리할수 있도록 도와주는 class
		 * 
		 */
		Properties pros = new Properties();
		
		/*
		 * DBMS에 접근할 username과 passowrd를 실제 값으로 적용하고
		 * 프로젝트를 실행할 것
		 */
		pros.put("username","USERNAME");
		pros.put("password","PASSWORD");
		
		try {
			is = Resources.getResourceAsStream(configFile);
			SqlSessionFactoryBuilder builder
					= new SqlSessionFactoryBuilder();
			
			if(sqlSessionFactory == null) {
				sqlSessionFactory = builder.build(is,pros);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getInstance() {
		return sqlSessionFactory;
	}
}
