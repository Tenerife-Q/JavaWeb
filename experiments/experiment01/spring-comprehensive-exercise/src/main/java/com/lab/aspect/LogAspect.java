package com.lab.aspect;

/**
 * @author Tenerife
 * Su san
 * @date 2026/1/10 22:11
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    // 考点：前置通知 + 获取参数
    @Before("execution(* com.lab.service.UserService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("====== [AOP @Before] Method: " + methodName + ", Args: " + Arrays.toString(args));
    }

    // 考点：返回后通知 + 获取返回值 (returning 属性)
    @AfterReturning(pointcut = "execution(* com.lab.service.UserService.processUser(..))",
            returning = "result")
    // 上下返回的都一样 returning = 参数
    public void logResult(Object result) {
        System.out.println("====== [AOP @AfterReturning] User processed. Result ID: " + result);
    }
}
