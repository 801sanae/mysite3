package com.hanains.mysite.annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.hanains.mysite.vo.UserVo;

public class AuthUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver{

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer arg1, NativeWebRequest webRequest,
			WebDataBinderFactory arg3) throws Exception {
		
		if(this.supportsParameter(parameter)==false){
			return WebArgumentResolver.UNRESOLVED;//null이다 밑에 있는게 
		}
		
		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);//종속하지 않겟다. 톰캣에? 
		HttpSession session = request.getSession();
		
		if(session==null){
			return WebArgumentResolver.UNRESOLVED;//null이다 밑에 있는게
		}
		
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		
		return authUser;
	}

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
//		(parameter.getParameterAnnotation(AuthUser.class))!=null;//null 인지 아닌지 판단 path,
		return (parameter.getParameterAnnotation(AuthUser.class))!=null && ((parameter.getParameterType()).equals(UserVo.class) ==true);
	}

}
