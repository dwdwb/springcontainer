package com.mycompany.springcontainer.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.springcontainer.interceptor.Auth.Role;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch02InterceptorB implements HandlerInterceptor {
	//컨트롤러 실행 전 처리
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info("실행");
		
		//요청 처리 메소드가 @Auth가 붙어 있는지
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		if(auth == null) {
			//@Auth가 안붙어있음
			return true;
		} else {
			//@Auth가 붙어있음
			//ADMIN인지
			if(auth.value() == Role.ADMIN) {
				//로그인 사용자가 ADMIN을 가졌는지
				boolean isAdmin = true;
				if(isAdmin) {
					return true;
				} else {
					log.info("관리자 권한이 필요합니다.");
					response.sendRedirect(request.getContextPath());
				}
			} else {
				return true;
			}
			return true;
		}
	}
}
