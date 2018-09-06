package com.springboot07;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopAspect {

	@SuppressWarnings("unchecked")
	@Around("execution (java.util.Map com.springboot07.MainController.*(..))")
	public Object invoke(ProceedingJoinPoint point) {
		Map<String, Object> result = null;
		try {
			Object[] args = point.getArgs();
			Object val = point.proceed(args);
			result = (Map<String, Object>) val;
		} catch (Throwable e) {
			e.printStackTrace();
			result = new HashMap<String, Object>();
			result.put("msg", e.toString());
		}
		result.put("aop", "拦截了一个请求！");
		return result;
	}
}
