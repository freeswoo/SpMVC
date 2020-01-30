package com.biz.ems.service;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.biz.ems.domain.NaverReturnAuth;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NaverLoginService {


	private final String clientId = "q_kZ1NXzIIP9gERleb2S";
	private final String loginAPI_URL = "https://nid.naver.com/oauth2.0/authorize";
	private final String tokenAPI_URL = "https://nid.naver.com/oauth2.0/token";
	
	private final String callbackLocalURL = "http://localhost:8080/ems/naver/ok";
	private final String callbackURL = "https://callor.com:12600/ems_freeswoo/member/naver/ok";

	public String oAuthLoginGet() {
		
		String redirectURI = null;
		try {
			redirectURI 
			= URLEncoder.encode(callbackURL,"UTF-8");
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SecureRandom random = new SecureRandom();
		
		// 최대값 130bit 크기 임의의 정수를 생성하여 문자열로 만들어
		String stateKey = new BigInteger(130,random).toString();
		log.debug("STATE KEY : " + stateKey);
		
		String apiURL = loginAPI_URL ;
		apiURL += "?client_id=" + this.clientId;
		apiURL += "&response_type=code";
		apiURL += "&redirect_uri="+redirectURI;
		apiURL += "&state=" + stateKey;
		
		log.debug("URL : " + apiURL);
		return apiURL;
		
	}
	/**
	 * 네이버에 정보요구를 할때 사용할 토큰을 요청
	 * token을 요청할때 GET/POST method를 사용할수 있는데
	 * 
	 * 여기서는 POST를 사용해서 요청을 하겠다.
	 * @param naverOK
	 */
	public void aAuthAccessGetToken(NaverReturnAuth naverOK) {
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.set("X-Naver-Client-Id","ClientId");
		headers.set("X-Naver-Client-Secret","ClientSec");
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();		
		
		params.add(NAVER.TOKEN.grant_type,"authorization_code");
	}
	
}
