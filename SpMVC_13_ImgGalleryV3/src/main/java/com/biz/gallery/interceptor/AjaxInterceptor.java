package com.biz.gallery.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

/*
 * req를 가로채기를 실시하도록 
 */
@Slf4j
public class AjaxInterceptor extends HandlerInterceptorAdapter {

	/*
	 * Dispatcher에서 Controller로 가는 도중 가로채기를 수행할 method
	 */
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
				HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession httpSession = request.getSession();
		Object memberVO = httpSession.getAttribute("MEMBER");
		if(memberVO == null) {
			
			response.setStatus(403);
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			
			return false;
			
		}
		
		return super.preHandle(request, response, handler);
	
	}
	

}
