package com.lab.aspect;

/**
 * @author Tenerife
 * Su san
 * @date 2026/1/10 22:11
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    // 考点：环绕通知 (最强大，控制目标方法执行)
    @Around("execution(* com.lab.service.UserService.processUser(..))")
    public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        // 执行目标方法
        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();
        System.out.println("====== [AOP @Around] Execution Time: " + (end - start) + "ms");

        return result;
    }

    // 考点：异常通知 + 获取异常信息 (throwing 属性)
    @AfterThrowing(pointcut = "execution(* com.lab.service.UserService.*(..))", throwing = "ex")
    public void handleException(Exception ex) {
        System.out.println("====== [AOP @AfterThrowing] ALERT! Exception caught: " + ex.getMessage());
    }
}