package com.biz.sec.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class DBConnectionSEC {

	private static SqlSessionFactory sqlSessionFactory = null;
	static {
		
		// 전체 환경변수 읽어오기
		Map<String,String> envList = System.getenv();
		
		// 전체 환경변수중 BIZ 키 변수값 추출
		String saltPass = System.getenv().get("BIZ");
		
		// 환경변수중 BIZ 키값만 가져오기
		saltPass = System.getenv("BIZ");
		
		String configFile = "com/biz/sec/config/mybatis-config.xml";
		InputStream is = null;
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(saltPass);
		
		String userName = "7fdHKwBMqCaXo6BrKPzUxA==";
		String password = "l4lnLOlYvnuL7fNc0B3evQ==";
		
		/*
		 * 
		 * java에서 
		 * 어떤 setting 값들을 모아서 어떤 설정을 하는 용도로 사용한다.
		 * setting 값들을 쉽게 관리할수 있도록 도와주는 class
		 * 
		 */
		Properties pros = new Properties();
		pros.put("username",pbEnc.decrypt(userName));
		pros.put("password",pbEnc.decrypt(password));
		
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
