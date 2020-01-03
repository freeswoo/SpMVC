package com.biz.todo.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import lombok.extern.slf4j.Slf4j;

/*
 * req가 이루어지면 Dipatcher가 값을 수신하고
 * 적절한 path를 찾아서 controller에게 전달을 하는데
 * 그 전에 req에 담겨오는 parameter를 가로채서 뭔가 처리를 하고자 할때
 * 사용하는 Resolver 선언
 */
@Slf4j
public class TodoHandlerResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

		String td_date = webRequest.getParameter("td_date");
		String td_time = webRequest.getParameter("td_time");
		String td_complete = webRequest.getParameter("td_complete");
		String td_alarm = webRequest.getParameter("td_alarm");
		
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss");

		if(td_date == null || td_date.isEmpty()) {
			td_date = sd.format(date); // 문자열형 날짜 생성
		}
		if(td_time == null || td_time.isEmpty()) {
			td_time = st.format(date); // 문자열형 시간 생성
		}

		if(td_complete == null || td_complete.isEmpty()) td_complete = "N";
		if(td_alarm == null || td_alarm.isEmpty()) td_alarm = "N";

		log.debug("Resolver" + td_date);

		Map<String,String> ret = new HashMap<String,String>();
		ret.put("td_date", td_date);
		ret.put("td_time", td_time);
		ret.put("td_complete", td_complete);
		ret.put("td_alarm", td_alarm);
		
		return ret;
		
	}
}
