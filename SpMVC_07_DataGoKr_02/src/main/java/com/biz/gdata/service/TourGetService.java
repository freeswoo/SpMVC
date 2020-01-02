package com.biz.gdata.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class TourGetService {

	/*
	 * query 문자열을 공공DB에 request하고
	 * response된 문자열을 return
	 */
	public String getDataString(String queryString) throws IOException {

		URL url = new URL(queryString);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

		httpConn.setRequestMethod("GET");

		int resCode = httpConn.getResponseCode();

		BufferedReader buffer = null;
		if (resCode == 200) {
			InputStreamReader is = new InputStreamReader(httpConn.getInputStream());
			buffer = new BufferedReader(is);
		} else {
			InputStreamReader is = new InputStreamReader(httpConn.getErrorStream());
			buffer = new BufferedReader(is);
		}
		String retString = "";
		String reader = "";
		while (true) {
			reader = buffer.readLine();
			if (reader == null)
				break;
			retString += reader;
		}
		buffer.close();
		return retString;
	}

	
	
}
