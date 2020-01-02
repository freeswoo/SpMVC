package com.biz.todo.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.biz.todo.domain.ToDoList;

/*
 * req가 이루어지면 Dipatcher가 값을 수신하고
 * 적절한 path를 찾아서 controller에게 전달을 하는데
 * 그 전에 req에 담겨오는 parameter를 가로채서 뭔가 처리를 하고자 할때
 * 사용하는 Resolver 선언
 */
public class TodoHandlerResolver implements HandlerMethodArgumentResolver{

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
		String td_seq = webRequest.getParameter("td_seq");
		String td_subject = webRequest.getParameter("td_subject");
		String td_complete = webRequest.getParameter("td_complete");
		String td_alarm = webRequest.getParameter("td_alarm");
		String td_flag = webRequest.getParameter("td_flag");
		
		
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss");
		
		if(td_date == null || td_date.isEmpty()) {
			td_date = sd.format(date); // 문자열형 날짜 생성
		}
		if(td_time == null || td_time.isEmpty()) {
			td_time = st.format(date); // 문자열형 시간 생성
		}
		if(td_complete == null) td_complete = "N";
		if(td_alarm == null) td_alarm = "N";
		
		return ToDoList.builder()
				.td_alarm(td_alarm)
				.td_complete(td_complete)
				.td_date(td_date)
				.td_time(td_time)
				.td_flag(td_flag)
				.td_seq(Long.valueOf(td_seq))
				.td_subject(td_subject)
				.build();
		
	}

}
