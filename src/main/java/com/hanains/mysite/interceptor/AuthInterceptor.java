package com.hanains.mysite.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hanains.mysite.annotation.Auth;
import com.hanains.mysite.vo.UserVo;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
																					//annotation 달려잇는 메소드?
		System.out.println("::"+this.getClass()+".preHandle()");
		
		if(handler instanceof HandlerMethod == false){//이미지 CSS 요청
			return true;// 이미지 CSS요청이므로 Controller에 있는 handler가 아니다.
		}
		
		Auth auth = ((HandlerMethod) handler).getMethodAnnotation(Auth.class);
		
		//@auth가 달려있는 메소드를 읽어라? 
		if(auth == null){//auth annotation이 안달려 있다.
			return true;
		}
		
		HttpSession session = request.getSession();
		if(session == null){
			response.sendRedirect(request.getContextPath() +"/user/loginform");//path
			return false;
		}
		
		UserVo vo =(UserVo)session.getAttribute("authUser");
		if(vo==null){
			response.sendRedirect(request.getContextPath() +"/user/loginform");//path
			return false;
		}
		
		return true;
	}
}
