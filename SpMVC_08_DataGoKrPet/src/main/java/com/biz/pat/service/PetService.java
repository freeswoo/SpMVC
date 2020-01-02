package com.biz.pat.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.biz.pat.config.DataGoConfig;
import com.biz.pat.domain.GoPetVO;
import com.biz.pat.domain.pet_rest.RestVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PetService {
	
	private final String go_pet_url = "http://openapi.jeonju.go.kr/rest/dongmulhospitalservice";
	
	public String getQueryHeader() {
		
		String queryString = go_pet_url;
		queryString += "/getDongMulHospital";
		queryString += "?ServiceKey=" + DataGoConfig.DATA_GO_AUTH;
		
		queryString += "&pageNo=1";
		queryString += "&numOfRows=100";
		return queryString;
	}
	
	public List<GoPetVO> getRestVOList(String s_cat, String s_text) {
		
		String queryString = this.getQueryHeader();
		try {
			if(s_cat.equalsIgnoreCase("ADDR")) {
				queryString += "&address="
							+ URLEncoder.encode(s_text,"UTF-8");
			} else {
				queryString += "&dongName=" 
							+ URLEncoder.encode(s_text,"UTF-8");
			}
			
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// HttpRequest Header 설정하기
		HttpHeaders header = new HttpHeaders();
		
		// XML 수신하기
		header.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
		
		// JSON 수신하기
		//header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON_UTF8));
		
		HttpEntity<String> entity = new HttpEntity<String>("parameters",header);
		
		// Spring 3.2에서 도입된 새로운 HttpConnection 추상화된 객체
		RestTemplate restTemp = new RestTemplate();
		
		URI restURI = null;
		ResponseEntity<RestVO> result = null;
		
		try {
			restURI = new URI(queryString);
			result = restTemp.exchange(restURI, HttpMethod.GET, entity, RestVO.class);
			RestVO rVO = (RestVO)result.getBody();
			List<GoPetVO> goPetList = rVO.body.data.list;
			return goPetList;
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
