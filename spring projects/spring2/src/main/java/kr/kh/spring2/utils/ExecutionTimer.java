package kr.kh.spring2.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class ExecutionTimer {

	@Pointcut("execution(* kr.kh.spring2.service.MemberService.*(..))")
	//@Pointcut("@annotation(kr.kh.spring2.controller.TimeTrace)")
    private void timer(){};
    
    @Around("timer()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis(); // 메서드 실행 전 시간 기록

        Object proceed = joinPoint.proceed(); // 메서드 실행

        long executionTime = System.currentTimeMillis() - startTime; // 메서드 실행 후 시간 차이 계산

        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");

        return proceed; // 원래 메서드의 리턴 값을 그대로 반환
    }
}