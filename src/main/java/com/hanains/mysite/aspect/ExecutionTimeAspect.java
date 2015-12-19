package com.hanains.mysite.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component//container안에 들어가기 위해!
public class ExecutionTimeAspect {
	
	
	@Around("execution( * *..dao.*.*(..)) ||execution( * *..service.*.*(..))||execution( * *..controller.*.*(..))")
	public Object around(ProceedingJoinPoint pjp)throws Throwable{
		
		String task =pjp.getTarget().getClass() +"."+pjp.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		
		stopWatch.start(task);
		
		Object res = pjp.proceed();//본 메소드 실행
		
		stopWatch.stop();
		
		System.out.println(":::[Execution Time]"+"["+task+"] = "+stopWatch.getTotalTimeMillis()+" millis");
		
		return res;
	}
}
