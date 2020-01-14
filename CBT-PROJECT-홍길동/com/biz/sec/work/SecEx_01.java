package com.biz.sec.work;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/*
 * 
 * jasypt 도구를 사용하여 문자열을 암호화 하는 Test 수행
 * 
 * 평문문자열(planText) : 읽을수 있는 문자열
 * 암호화된 문자열(cryptText) : 읽을수는 있지만 무슨 내용인지 알수 없는 형태 
 * 
 */
public class SecEx_01 {

	public static void main(String[] args) {
		
		/*
		 * java에서 쉽게 사용할수 있는 암호화, 복호화를 수행하는 클래스
		 * 암호화와 복호화를 동시에 수행할수 있다.
		 * 
		 * 1. 암호화의 종류 : 단방향, 양방향 암호화
		 *   가. 단방향 암호화 : 
		 *   		평문 >> 암호문으로 변경은 가능,'
		 *   		암호문 >> 평문으로 변경은 불가능한 구조
		 *   		보안성은 유리하지만, 사용에 제약이 따른다.
		 *   
		 *   나. 양방향 암호화
		 *   		평문 >> 암호문, 암호문 >> 평문 변경이 가능
		 *   		보안성은 다소 떨어지지만
		 *   		사용에 다소 편리성이 있다.
		 *   		만약 salt Key가 노출되면 의미 없는 암호화가 된다.
		 *   
		 *  jasypt는 양방향 암호화를 수행하고 쉽게 사용할수 있는 형태
		 *  java에서 DBMS에 접근하기 위해 userID와 password를 사용해야 하는데
		 *  jdbc Connection 코드에 userid와 password가 노출되어
		 *  보안에 매우 취약하다.
		 *  
		 *  최소한 소스코드차원에서만이라도 userid와 password를 암호화하여
		 *  보안을 유지하기 위한 방법을 사용한다.
		 *  그런데 이방법으로 단방향 암호화 기법은 사용이 불가능하다. 
		 *  jdbc에서 DBMS로 userid와 password를 전송하는 과정에서
		 *  평문으로 해당 데이터를 보내야 하기 때문에
		 *  암호화된 문자열을 다시 평문으로 복호화해야 한다.
		 *  이런 용도로 주로 사용하는 도구가 jasypt이고
		 *  그중에서 StandardPBEStringEnryptor를 많이 사용한다.
		 */
		StandardPBEStringEncryptor pbEnc 
			= new StandardPBEStringEncryptor();
		
		// 암호화와 복호화를 수행할때 사용할 Key
		String saltPass = "com.biz";
		
		String planText1 = "java";
		String planText2 = "Republic of Korea";
		
		String encText1 = "";
		String encText2 = "";
		
		/*
		 * 암호화를 수행하는 코드
		 */
		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(saltPass);
		
		// 암호화
		encText1 = pbEnc.encrypt(planText1);
		encText2 = pbEnc.encrypt(planText2);

		System.out.printf("plan : %s, enc : %s\n",planText1,encText1);
		System.out.printf("plan : %s, enc : %s\n",planText2,encText2);
		
		// 복호화
		String decText1 = pbEnc.decrypt(encText1);
		String decText2 = pbEnc.decrypt(encText2);

		System.out.printf("enc : %s, dec : %s\n",encText1, decText1);
		System.out.printf("enc : %s, dec : %s\n",encText2, decText2);
		
	}
}
